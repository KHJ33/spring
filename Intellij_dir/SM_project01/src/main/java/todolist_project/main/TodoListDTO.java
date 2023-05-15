package todolist_project.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class TodoListDTO {
    private Long Num;
    private String Id;
    private String Todo;
    private Date Completed_date;
    private int Done;
    private int ExistsImg;
    private String img_fileName;

}
