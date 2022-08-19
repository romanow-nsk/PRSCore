package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.users.User;

import java.util.HashMap;

public class SAStudent extends Entity {
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter private EntityLink<SAGroup> SAGroup = new EntityLink<>();               // Обратная ссылка
    @Getter private EntityLink<User> User = new EntityLink<>(User.class);
    @Getter @Setter private int state = Values.StudentStateUndefined;
    public String getTitle(){
        return User.getTitle();
        }
    public SAStudent(){}

}
