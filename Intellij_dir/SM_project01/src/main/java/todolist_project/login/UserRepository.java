package todolist_project.login;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final SqlSessionTemplate sql;

    // ################# 회원가입 mapper ################# //
    public int save(UserDTO userDTO) {
        System.out.println("usrDTO = " + userDTO);
        // User.save Mapper 랑 연결
        return sql.insert("User.save", userDTO);
    }

    // ################# 로그인 mapper ################# //
    public UserDTO login(UserDTO userDTO) {
        // User.login Mapper 랑 연결
        return sql.selectOne("User.login", userDTO);
    }



}
