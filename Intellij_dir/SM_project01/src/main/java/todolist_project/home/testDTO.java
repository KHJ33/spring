package todolist_project.home;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class testDTO {
    private MultipartFile file; // save.html -> controller 파일 담는 용도
    private String originalFileName; // 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름
    private int fileAttached; // 파일 첨부 여부(첨부 되면 1, 미첨부 되면 0)
}
