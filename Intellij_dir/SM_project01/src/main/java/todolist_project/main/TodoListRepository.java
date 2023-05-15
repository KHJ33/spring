package todolist_project.main;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class TodoListRepository {

    private final SqlSessionTemplate sql;

    // ################# 리스트 Mapper ################# //
    public List<TodoListDTO> todolist(String id) {
        return sql.selectList("TodoList.findById", id);
    }

//    public List<TodoListDTO> todolist(String id, String filter) {
//        return sql.selectList("TodoList.findById"+filter, id);
//    }

    public List<TodoListDTO> todolist(Map<String, String> map) {

        return sql.selectList("TodoList.findBy_Map", map);
    }

    // ################# 삭제 Mapper ################# //
    public void delete(Long num) {

        int result = sql.delete("TodoList.delete", num);

    }

    // ################# 업데이트 Mapper ################# //
    public void update(Map<String, String> map) {
        sql.update("TodoList.update", map);
    }

    // ################# 추가 Mapper ################# //
    public void insert(TodoListDTO todoListDTO) {
        sql.insert("TodoList.insert", todoListDTO);
    }

    // ################# Num을 이용한 찾기 Mapper ################# //
    public TodoListDTO FindByNum(Long num) { return sql.selectOne("TodoList.findByNum", num); }

    // ################# Done 변경 Mapper ################# //
    public void changebox(TodoListDTO todoListDTO) { sql.update("TodoList.changebox", todoListDTO); }

    // ################# clear (다중삭제) Mapper ################# //
    public void select_clear(List<Integer> num_Arr) {
        int result = sql.delete("TodoList.select_clear", num_Arr);
    }
    // ###################################################### //
    // ################# 체크박스 수정 Mapper ################# //
    // ### 체크박스 선택시 완료된 금일 날짜를 입력
    // ### 체크박스 선택 해지시 완료 날짜 삭제
    // ###################################################### //
    public void delete_date(TodoListDTO todoListDTO) {
        sql.update("TodoList.delete_date", todoListDTO);
    }
    public void update_date(TodoListDTO todoListDTO) {
        sql.update("TodoList.update_date", todoListDTO);
    }

    // ########################################################################### //
    // ################# 시작 날짜와 종료날짜로 todolist 호출 Mapper ################# //
    // ### 반환을 객체로 받는다
    // ########################################################################### //
    public Object todolist_period(Map<String, String> map) {
        return sql.selectList("TodoList.findBy_period", map);
    }

    // ###################################################### //
    // ################# 이미지 업로드 Mapper ################# //
    // ### imgUpload db 테이블 수정
    // ### todolist db 테이블 수정
    // ### todolist file name 수정 - 이미지가 한개라면 primary key 로 설정했어도 좋았을거 같음
    // ###################################################### //
    public void insert_img(UploadDTO uploadDTO) { sql.insert("ImgUpload.img_upload", uploadDTO); }
    public void insert_img(TodoListDTO todoListDTO) {
        sql.insert("ImgUpload.img_todolist", todoListDTO);
    }
    public void update_img_fileName(TodoListDTO todoListDTO) {
        sql.update("ImgUpload.img_fileName", todoListDTO);
    }
}
