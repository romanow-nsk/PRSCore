package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.users.User;

public class EMTeacher extends Entity {
    @Getter private EntityLink<User> User = new EntityLink<>(User.class);
    @Getter private EntityRefList<EMPermission> permissions = new EntityRefList<>(EMPermission.class);
    public EMTeacher(){}
}
