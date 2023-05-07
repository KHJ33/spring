package todolist_project.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoListService {

    private final TodoListRepository todoListRepository;

    // ################# 리스트 출력 Service ################# //
    public List<TodoListDTO> todolist(String id) {
        return todoListRepository.todolist(id);
    }

    // ################# 삭제 Service ################# //
    public void delete(Long num) { todoListRepository.delete(num); }

    // ################# 업데이트 Service ################# //
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
}
