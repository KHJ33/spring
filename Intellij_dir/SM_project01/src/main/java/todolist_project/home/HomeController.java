package todolist_project.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        // index.jsp 파일로 연결
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        // index.jsp 파일로 연결
        return "test";
    }
}
