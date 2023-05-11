package todolist_project.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TodoListService {

    private final TodoListRepository todoListRepository;

    // ################# 리스트 출력 Service ################# //
    public List<TodoListDTO> todolist(String id) {
        return todoListRepository.todolist(id);
    }

    public List<TodoListDTO> todolist(String id, String check_filter) {
        String filter = "";
        System.out.println("서비스 overloading check_filter = " + check_filter);
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);

        if (check_filter.equals("pending")) {
            map.put("filter", "0");
        } else if (check_filter.equals("completed")) {
            map.put("filter", "1");
        } else {
            return todoListRepository.todolist(id);
        }
        return todoListRepository.todolist(map);
    }

    // ################# 삭제 Service ################# //
    public void delete(Long num) { todoListRepository.delete(num); }

    // ################# 업데이트(변경) Service ################# //
    public void update(TodoListDTO todoListDTO) { todoListRepository.update(todoListDTO); }

    // ################# 추가 Service ################# //
    public void insert(TodoListDTO todoListDTO) { todoListRepository.insert(todoListDTO); }

    // ################# CheckBox 변경 Service ################# //
    public void changebox(Long num) {
        TodoListDTO todoListDTO = todoListRepository.FindByNum(num);

        System.out.println("FindByNum = " + todoListDTO.toString());

        if (todoListDTO.getDone() == 0) {
            todoListDTO.setDone(1);
        } else {
            todoListDTO.setDone(0);
        }

        todoListRepository.changebox(todoListDTO);
    }

    // ################# edit 변경 Service ################# //
    public void edit(Long num, String todo) {
        TodoListDTO todoListDTO = todoListRepository.FindByNum(num);
        System.out.println("FindByNum = " + todoListDTO.toString());

        todoListDTO.setTodo(todo);

        todoListRepository.update(todoListDTO);
    }

    // ################# clear (다중 삭제) Service ################# //
    public void select_clear(List<Integer> num_Arr) {
        todoListRepository.select_clear(num_Arr);

    }

    // ################# 체크박스 선택 Service ################# //
    public void updateStatus(TodoListDTO todoListDTO) {
        if (todoListDTO.getDone() == 1) {
            System.out.println("체크박스 service 1부분들어옴");
            todoListRepository.delete_date(todoListDTO);
        } else {
            System.out.println("체크박스 service 0부분들어옴");
            todoListRepository.update_date(todoListDTO);
        }
    }

    public Object[] todolist_period(String id, String start_date, String end_date) {

        Map<String, String> map = new HashMap<String, String>();

        if (start_date.equals("")) {
            start_date = "1900-01-01";
        }

        if (end_date.equals("")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            String nowTime = simpleDateFormat.format(now);

            System.out.println(nowTime);
            end_date = nowTime;
        }

        map.put("id", id);
        map.put("start_date", start_date);
        map.put("end_date", end_date);

        System.out.println("최종 start_date = " + start_date + " end_date = " + end_date);
        return new Object[] {todoListRepository.todolist_period(map), start_date, end_date};
    }



}
