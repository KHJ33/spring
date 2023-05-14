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
        System.out.println("들어온 이름 = " + (String) session.getAttribute("loginIdName"));

        List<TodoListDTO> todoListDTO = todoListService.todolist(id);
        model.addAttribute("todolist", todoListDTO);

        if (todoListDTO != null) {
            System.out.println("여기까지 성공 = " + todoListDTO);
        }

        return "main";
    }

    @PostMapping("/")
    public String main_check_filter(@RequestParam("check_filter") String check_filter, HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");
        System.out.println("post main 부분 접속 / check_filter = " + check_filter + " / id = " + id);

        List<TodoListDTO> todoListDTO = todoListService.todolist(id,check_filter);
        System.out.println("post main todoListDTO = " + todoListDTO);

        model.addAttribute("todolist", todoListDTO);
        model.addAttribute("check_filter", check_filter);

        return "main";
    }

    @PostMapping("/period")
    public String main_period(@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date,
                              HttpSession session, Model model) {
        String id = (String) session.getAttribute("loginId");
        System.out.println("start_date = /" + start_date + "/ end_date = " + end_date);

        Object[] objects = todoListService.todolist_period(id, start_date, end_date);

//        System.out.println("object[0] = " + objects[0]);

//        List<TodoListDTO> todoListDTO = todoListService.todolist_period(id,start_date, end_date);

        model.addAttribute("todolist", objects[0]);
        model.addAttribute("start_date", objects[1]);
        model.addAttribute("end_date", objects[2]);
        model.addAttribute("check_filter", "completed");

        return "main";
    }

//    @GetMapping("/period")
//    public String perid(@RequestParam("start_date") Date start_date, @RequestParam("end_date") Date end_date, Model model) {
//        System.out.println("start_date = " + start_date + " end_date = " + end_date);
//
//        model.addAttribute("check_filter", "completed");
//
//        return "main";
//    }


    // ################# 삭제 버튼 클릭 controller ################# //
    @GetMapping("/delete")
    public String delete(@RequestParam("num") Long num, Model model) {
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

    // ################# 추가 버튼 클릭 controller _ version 1 ################# //
    @PostMapping("/insert")
    public String insert(@ModelAttribute TodoListDTO todoListDTO,
                         @ModelAttribute UploadDTO uploadDTO,
                         MultipartFile file, Model model, HttpServletRequest request) {

        System.out.println("추가 버튼 클릭시 넘어오는 값 = " + todoListDTO);
        System.out.println("UploadDTO = " + uploadDTO.toString());

        System.out.println("uploadDTO = " + uploadDTO.getFile());

        System.out.println("file isEmpty() = " + file.isEmpty());

//        파일 업로드가 되어 있지 않다면
        if (file.isEmpty() == true) {
            todoListService.insert(todoListDTO);
        } else {
            System.out.println("구현중입니다.");
            HttpSession session = request.getSession();
            String uploadPath = session.getServletContext().getRealPath("/") + "img_upload";

            todoListDTO.setExistsImg(1);

            uploadDTO.setOriginalFileName(file.getOriginalFilename());
            uploadDTO.setContentType(file.getContentType());
            uploadDTO.setSize((int)file.getSize());
            uploadDTO.setUploadPath(uploadPath);

            todoListService.insert_img(todoListDTO, uploadDTO, file);

            System.out.println("Main / uploadDTO storedFileName = " + uploadDTO.getStoredFileName());


            System.out.println("최종 todolist = " + todoListDTO.toString());
//            model.addAttribute("todolist",todoListDTO);
//            model.addAttribute("upload_img", uploadDTO);
//            return "re";

        }


        return "redirect:/main/";
    }


    // ################# Checkbox 변경 controller ################# //
    @GetMapping("/check")
    public String check(@RequestParam("num") Long num) {
        System.out.println("checkbox 클릭 num = " + num);

        todoListService.changebox(num);
        return "redirect:/main/";
    }

    // ################# 새로운 수정 controller _ version 2 ################# //
    @GetMapping("/edit")
    public String edit(@RequestParam("num") Long num, @RequestParam("task") String todo) {

        System.out.println("새롭게 생성한 num = " + num + " todo = " + todo);

        todoListService.edit(num, todo);

        return "redirect:/main/";
    }

    // ################# clear all (다중삭제 구현) controller ################# //
    @PostMapping("/select_clear")
    public String select_clear(@RequestParam("num_Arr") List<Integer> num_Arr) {
        System.out.println("num_Arr.size = " + num_Arr.size());
        System.out.println("num_Arr tostring = " + num_Arr.toString());

        for (int i = 0 ; i < num_Arr.size() ; i++) {
            System.out.println("num_Arr 값 = " + num_Arr.get(i));
        }

        if (!num_Arr.isEmpty()) {
            System.out.println("service 단으로 이동");
            todoListService.select_clear(num_Arr);
        }




        return "redirect:/main/";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@ModelAttribute TodoListDTO todoListDTO) {

        System.out.println("updateStatus controller 값 = " + todoListDTO.toString());

        System.out.println("Date = " + todoListDTO.getCompleted_date());

        todoListService.updateStatus(todoListDTO);


        return "redirect:/main/";
    }




    // ################# test controller ################# //
    @PostMapping("/test")
    public String test(@ModelAttribute TodoListDTO todoListDTO) {

        System.out.println("test controller 값 = " + todoListDTO.toString());


        return "tt";
    }

}
