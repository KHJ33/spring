package todolist_project.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // ################# 회원가입 서비스 ################# //
    public int save(UserDTO userDTO) {
        return userRepository.save(userDTO);
    }

    // ################# 로그인 서비스 ################# //
    public UserDTO login(UserDTO userDTO) {
        UserDTO loginInfo = userRepository.login(userDTO);

//        System.out.println("서비스내 정보 = " + loginInfo.toString());

        if (loginInfo != null) {
            return loginInfo;
        } else {
            return null;
        }
    }



}
