package todolist_project.main;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoListDTO {
    private Long Num;
    private String Id;
    private String Todo;
    private int Done;
}
