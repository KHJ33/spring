package todolist_project.main;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoListRepository {

    private final SqlSessionTemplate sql;

    // ################# 리스트 Mapper ################# //
    public List<TodoListDTO> todolist(String id) {
        return sql.selectList("TodoList.findById", id);
    }

    // ################# 삭제 Mapper ################# //
    public void delete(Long num) {
        sql.delete("TodoList.delete", num);
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
}
