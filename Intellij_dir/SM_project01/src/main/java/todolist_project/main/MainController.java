package todolist_project.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final TodoListService todoListService;

    // ################# 메인 페이지 controller ################# //
    @GetMapping("/")
    public String mainform(HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");

        System.out.println("들어온 아이디 = " + id);

        List<TodoListDTO> todoListDTO = todoListService.todolist(id);
        model.addAttribute("todolist", todoListDTO);

        if (todoListDTO != null) {
            System.out.println("여기까지 성공 = " + todoListDTO);
        }

        return "main";
    }

    // ################# 삭제 버튼 클릭 controller ################# //
    @GetMapping("/delete")
    public String delete(@RequestParam("num") Long num) {
        todoListService.delete(num);
        return "redirect:/main/";
    }

    // ################# 수정 버튼 클릭 controller ################# //
    @GetMapping("/update")
    public String updateform(@RequestParam("num") Long num, HttpSession session) {
        session.setAttribute("num", num);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TodoListDTO todoListDTO, HttpSession session) {
        Long num = (Long) session.getAttribute("num");
//        String update_todo = todoListDTO.getTodo();
        System.out.println("num = " + num);
        System.out.println("수정사항된 = " + todoListDTO.toString());

        todoListDTO.setNum(num);

        todoListService.update(todoListDTO);


        return "redirect:/main/";
    }

    // ################# 추가 버튼 클릭 controller ################# //
    @PostMapping("/insert")
    public String insert(@ModelAttribute TodoListDTO todoListDTO) {

        System.out.println("추가 버튼 클릭시 넘어오는 값 = " + todoListDTO);

        todoListService.insert(todoListDTO);

        return "redirect:/main/";
    }

    // ################# Checkbox 변경 controller ################# //
    @GetMapping("/check")
    public String check(@RequestParam("num") Long num) {
        System.out.println("checkbox 클릭 num = " + num);

        todoListService.changebox(num);
        return "redirect:/main/";
    }

}
