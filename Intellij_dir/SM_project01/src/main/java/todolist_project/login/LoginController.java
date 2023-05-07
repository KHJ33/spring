package todolist_project.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    // ################# 회원가입 ################# //

    // 기본 /user/save controller
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    // 입력이 들어왔을때 /user/save controller
    @PostMapping("/save")
    public String save(@ModelAttribute UserDTO userDTO ) {
        int saveResult = userService.save(userDTO);
        if (saveResult > 0) {
            return "login";
        } else {
            return "save";
        }
    }

    // ################# 로그인 ################# //

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        boolean loginResult = userService.login(userDTO);

        if (loginResult) {
            session.setAttribute("loginId", userDTO.getId());
            // MainController 이동
            return "redirect:/main/";
        } else {
            return "login";
        }
    }
}

