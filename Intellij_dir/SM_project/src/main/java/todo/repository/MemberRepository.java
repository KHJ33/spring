package todo.repository;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import todo.dto.MemberDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
//        return 0;
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        // 조회 결과가 하나라면 selectOne, 조회 결과가 여러개라면 selectlist 형식으로 진행
        return sql.selectOne("Member.login", memberDTO);
    }


    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }
}
