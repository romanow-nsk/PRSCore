package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.users.User;

public class SATeacher extends Entity {
    @Getter private EntityLink<User> User = new EntityLink<>(User.class);
    @Getter private EntityRefList<SAPermission> permissions = new EntityRefList<>(SAPermission.class);
    public SATeacher(){}
}
