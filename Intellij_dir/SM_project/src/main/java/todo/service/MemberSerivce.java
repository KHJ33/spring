package todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.dto.MemberDTO;
import todo.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberSerivce {

    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);

        System.out.println("loginMember = " + loginMember.toString());

        if (loginMember != null) {
            return true;
        } else {
            return false;
        }
//        return true;
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        // 삭제가 되면 1 이상의 값을 삭제가 되지 않으면 0을 준다.
        memberRepository.delete(id);
    }


//    @Autowired
//    public MemberSerivce(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
}
