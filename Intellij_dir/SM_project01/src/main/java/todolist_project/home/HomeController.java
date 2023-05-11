package todolist_project.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index() {
        // index.jsp 파일로 연결
        return "index";
    }


    @GetMapping("/test")
    public String test() {
        return "tt";
    }

    @PostMapping("/fileSave")
    public String fileSave(@ModelAttribute testDTO t, MultipartFile file, Model model, HttpServletRequest request) {

        HttpSession session  = request.getSession();
        String uploadPath = session.getServletContext().getRealPath("/") + "img_upload";

        String fileName = file.getOriginalFilename();
        File target = new File(uploadPath, fileName);

//        System.out.println("root = " + root);

        System.out.println("입력으로 들어온 fileName = " + fileName);
        System.out.println(t.toString());
        System.out.println("설정된 업로드 경로 uploadPath = " + uploadPath);

        System.out.println("target 경로 = " + target.getPath());

        if ( ! new File(uploadPath).exists()) {
            System.out.println("폴더가 없습니다. 새롭게 생성합니다.");
            new File(uploadPath).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
            model.addAttribute("file", file);
        } catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("file", "error");
        }




        return "tt1";
    }
}
