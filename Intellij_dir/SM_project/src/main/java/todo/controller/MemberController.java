package todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todo.dto.MemberDTO;
import todo.service.MemberSerivce;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberSerivce memberSerivce;

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {

//        System.out.println(memberDTO.toString());

        int saveResult = memberSerivce.save(memberDTO);
//        int saveResult = 0;
        if (saveResult > 0) {
            return "login";
        } else {
            return "save";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // 값이 없어도 있는것만 들어간다.
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        boolean loginResult = memberSerivce.login(memberDTO);
//        boolean loginResult = true;
        if (loginResult) {
//            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        } else {
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberSerivce.findAll();

        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    // 조회 오는 방식이 /member?id=1
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberSerivce.findById(id);

        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        memberSerivce.delete(id);
        return "redirect:/member/";
    }
}
