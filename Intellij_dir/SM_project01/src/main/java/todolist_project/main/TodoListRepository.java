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

        System.out.println("map 확인 id = "+ map.get("id") + " filter = " + map.get("filter"));

        return sql.selectList("TodoList.findBy_Map", map);
    }

    // ################# 삭제 Mapper ################# //
    public void delete(Long num) {

        int result = sql.delete("TodoList.delete", num);
        System.out.println("하나 삭제 결과 = " + result);
    }

    // ################# 업데이트 Mapper ################# //
    public void update(TodoListDTO todoListDTO) {
        sql.update("TodoList.update", todoListDTO);
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
        System.out.println("result = " + result);
    }

    public void delete_date(TodoListDTO todoListDTO) {
        sql.update("TodoList.delete_date", todoListDTO);
    }

    public void update_date(TodoListDTO todoListDTO) {
        sql.update("TodoList.update_date", todoListDTO);
    }

    public Object todolist_period(Map<String, String> map) {
        return sql.selectList("TodoList.findBy_period", map);
    }
}
