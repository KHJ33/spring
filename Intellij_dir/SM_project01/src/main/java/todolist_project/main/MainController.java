package todolist_project.main;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final TodoListService todoListService;

    // ######################################################### //
    // ################# 메인 페이지 controller ################# //
    // ####################################################### //
    @GetMapping("/")
    public String mainform(HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");

        List<TodoListDTO> todoListDTO = todoListService.todolist(id);
        model.addAttribute("todolist", todoListDTO);


        return "main";
    }

    // ######################################################### //
    // ################# 메인 페이지 controller ################# //
    // #####   post 방식으로 들어올때 ( check_filter 가 있음) ##### //
    // ####################################################### //

    @PostMapping("/")
    public String main_check_filter(@RequestParam("check_filter") String check_filter, HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");

        List<TodoListDTO> todoListDTO = todoListService.todolist(id,check_filter);

        model.addAttribute("todolist", todoListDTO);
        model.addAttribute("check_filter", check_filter);

        return "main";
    }

    // ####################################################### //
    // ################# 날짜 입력 controller ################# //
    // #####   시작 날짜와 종료 날짜가 입력으로 들어옴 ###### ##### //
    // ##################################################### //
    @PostMapping("/period")
    public String main_period(@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date,
                              HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");

        Object[] objects = todoListService.todolist_period(id, start_date, end_date);

        model.addAttribute("todolist", objects[0]);
        model.addAttribute("start_date", objects[1]);
        model.addAttribute("end_date", objects[2]);
        model.addAttribute("check_filter", "completed");

        return "main";
    }

    // ################# 삭제 버튼 클릭 controller ################# //
    @GetMapping("/delete")
    public String delete(@RequestParam("num") Long num, Model model) {
        todoListService.delete(num);
        return "redirect:/main/";
    }

    // ####################################################################### //
    // ################# task 추가 controller ################################ //
    // ### input 으로 이미지가 들어 올수 있음 #################################### //
    // ### 이미지 정보는 uploadDTO 에 저장됨 #################################### //
    // ####################################################################### //
    @PostMapping("/insert")
    public String insert(@ModelAttribute TodoListDTO todoListDTO,
                         @ModelAttribute UploadDTO uploadDTO,
                         MultipartFile file, Model model, HttpServletRequest request) {

//        파일 업로드가 되어 있지 않다면
        if (file.isEmpty() == true) {
            todoListService.insert(todoListDTO);
        } else {
            HttpSession session = request.getSession();
            String uploadPath = session.getServletContext().getRealPath("/") + "img_upload";

            todoListDTO.setExistsImg(1);

            uploadDTO.setOriginalFileName(file.getOriginalFilename());
            uploadDTO.setContentType(file.getContentType());
            uploadDTO.setSize((int)file.getSize());
            uploadDTO.setUploadPath(uploadPath);

            todoListService.insert_img(todoListDTO, uploadDTO, file);
        }
        return "redirect:/main/";
    }

    // ################################################### //
    // ################# 수정 controller ################# //
    // ### primary key 에 해당되는 내용 수정 ################ //
    // ################################################### //
    @GetMapping("/edit")
    public String edit(@RequestParam("num") Long num, @RequestParam("task") String todo) {

        todoListService.edit(num, todo);

        return "redirect:/main/";
    }

    // ###################################################################### //
    // ################# clear all (다중삭제 구현) controller ################# //
    // ### 삭제 해야 되는 번호를 num_Arr 배열을 통해서 받아옴
    // ### 받아온 primary key 들을 삭제 진행
    // ### upload img db 와 연관되어 있으면 같이 삭제 - db 설정시 on Cascade 설정 필요
    // ###################################################################### //
    @PostMapping("/select_clear")
    public String select_clear(@RequestParam("num_Arr") List<Integer> num_Arr) {

        if (!num_Arr.isEmpty()) {
            todoListService.select_clear(num_Arr);
        }
        return "redirect:/main/";
    }

    // ########################################################## //
    // ################# 체크박스 선택 controller ################# //
    // ### 체크박스 선택한 금일 날짜로 정보 업데이트 진행
    // ########################################################## //
    @PostMapping("/updateStatus")
    public String updateStatus(@ModelAttribute TodoListDTO todoListDTO) {

        todoListService.updateStatus(todoListDTO);

        return "redirect:/main/";
    }

}
