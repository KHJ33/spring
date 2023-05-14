package todolist_project.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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


//    파일 업로드 하나만 진행할떄 ( MultipartFile file )
    @PostMapping("/fileSave")
    public String fileSave(@ModelAttribute testDTO t,
                           @ModelAttribute testDTO2 t2,
                           MultipartFile file, Model model, HttpServletRequest request) {

        HttpSession session  = request.getSession();
        String uploadPath = session.getServletContext().getRealPath("/") + "img_upload";

        String fileName = file.getOriginalFilename();
        File target = new File(uploadPath, fileName);

//        System.out.println("root = " + root);

        System.out.println("입력으로 들어온 fileName = " + fileName);
        System.out.println("t DTO = " + t.toString());
        System.out.println("t2 DTO = " + t2.toString());


        System.out.println("file 정보 찍어보기 = " + file.getContentType());
        if (file.getSize() == 0) {
            return "tt1";
        }


        System.out.println("설정된 업로드 경로 uploadPath = " + uploadPath);

        System.out.println("target 경로 = " + target.getPath());

        if ( ! new File(uploadPath).exists()) {
            System.out.println("폴더가 없습니다. 새롭게 생성합니다.");
            new File(uploadPath).mkdirs();
        }



        //파일 복사
        try {
            System.out.println("file.getBytes() = " + file.getBytes());
            FileCopyUtils.copy(file.getBytes(), target);
            model.addAttribute("file", file);
        } catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("file", "error");
        }


        System.out.println("file = " + file);

        return "tt1";
    }

    // 여러정보가 같이 넘어 올때

//    @PostMapping("/fileSave")
//    public String fileSave(@ModelAttribute testDTO t, MultipartHttpServletRequest file, Model model, HttpServletRequest request) {
//
//        HttpSession session  = request.getSession();
//        String uploadPath = session.getServletContext().getRealPath("/") + "img_upload";
//
//
//
//        String fileName = t.getOriginalFileName();
//        File target = new File(uploadPath, fileName);
//
////        System.out.println("root = " + root);
//
//        System.out.println("입력으로 들어온 fileName = " + fileName);
//        System.out.println(t.toString());
//
//
//        System.out.println("file 정보 찍어보기 = " + file.getContentType());
//
//
//        System.out.println("설정된 업로드 경로 uploadPath = " + uploadPath);
//
//        System.out.println("target 경로 = " + target.getPath());
//
//        if ( ! new File(uploadPath).exists()) {
//            System.out.println("폴더가 없습니다. 새롭게 생성합니다.");
//            new File(uploadPath).mkdirs();
//        }
//
//
//
//        //파일 복사
//        try {
//            FileCopyUtils.copy(file.getBytes(), target);
//            model.addAttribute("file", file);
//        } catch(Exception e) {
//            e.printStackTrace();
//            model.addAttribute("file", "error");
//        }
//
//
//        System.out.println("file = " + file);
//
//        return "tt1";
//    }

}
