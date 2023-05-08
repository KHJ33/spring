package todolist_project.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String Id;
    private String Password;
    private String Name;
}
