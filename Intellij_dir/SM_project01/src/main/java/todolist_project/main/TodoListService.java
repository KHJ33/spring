package todolist_project.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    // ##################################################### //
    // ############### 필터값에 따른 Service ################# //
    // ### 필더 값에 따라서 map 변수를 다르게 설정
    // ##################################################### //
    public List<TodoListDTO> todolist(String id, String check_filter) {
        String filter = "";
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

    // ################# 추가 Service ################# //
    public void insert(TodoListDTO todoListDTO) { todoListRepository.insert(todoListDTO); }


    // ################# edit 변경 Service ################# //
    public void edit(Long num, String todo) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("num", Long.toString(num));
        map.put("todo", todo);

        todoListRepository.update(map);
    }

    // ################# clear (다중 삭제) Service ################# //
    public void select_clear(List<Integer> num_Arr) {
        todoListRepository.select_clear(num_Arr);

    }

    // ################# 체크박스 선택 Service ################# //
    public void updateStatus(TodoListDTO todoListDTO) {
        if (todoListDTO.getDone() == 1) {
            todoListRepository.delete_date(todoListDTO);
        } else {
            todoListRepository.update_date(todoListDTO);
        }
    }

    // #################################################### //
    // ################# 기간 입력 Service ################# //
    // ### 시작 날짜가 입력으로 들어오지 않으면 1900-01-01 로 설정
    // ### 종료 날짜가 입력으로 들어오지 않으면 금일 날짜로 설정
    // #################################################### //
    public Object[] todolist_period(String id, String start_date, String end_date) {

        Map<String, String> map = new HashMap<String, String>();

        if (start_date.equals("")) {
            start_date = "1900-01-01";
        }

        if (end_date.equals("")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            String nowTime = simpleDateFormat.format(now);

            end_date = nowTime;
        }

        map.put("id", id);
        map.put("start_date", start_date);
        map.put("end_date", end_date);

        return new Object[] {todoListRepository.todolist_period(map), start_date, end_date};
    }

    // ########################################################### //
    // ################# 이미지 파일 업로드 Service ################# //
    // ### target 경로로 이미지 저장
    // ### 저장되는 이미지 파일명은 db 내 StoredFileName 으로 저장
    // ########################################################### //
    public void insert_img(TodoListDTO todoListDTO, UploadDTO uploadDTO, MultipartFile file) {

        todoListRepository.insert_img(todoListDTO);
        uploadDTO.setNum(todoListDTO.getNum());

        todoListRepository.insert_img(uploadDTO);

        File target = new File(uploadDTO.getUploadPath(), uploadDTO.getStoredFileName() + "." + uploadDTO.getContentType().split("/")[1]);
        todoListDTO.setImg_fileName(uploadDTO.getStoredFileName() + "." + uploadDTO.getContentType().split("/")[1]);

        todoListRepository.update_img_fileName(todoListDTO);

        if ( ! new File(uploadDTO.getUploadPath()).exists()) {
            new File(uploadDTO.getUploadPath()).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
