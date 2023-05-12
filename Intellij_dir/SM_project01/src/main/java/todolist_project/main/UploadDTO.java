package todolist_project.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class UploadDTO {
    private MultipartFile file; // save.html -> controller 파일 담는 용도
    private String originalFileName; // 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름
    private String uploadPath; // 파일 저장 경로
    private String contentType; // 타입 명시
    private int size; // size 명시
}
