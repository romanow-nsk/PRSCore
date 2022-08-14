package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.users.User;

public class SATeacher extends Entity {
    @Getter private EntityLink<User> user = new EntityLink<>(User.class);
    @Getter private EntityLinkList<SAGroupRating> ratings = new EntityLinkList<>(SAGroupRating.class);
    public SATeacher(){}
}
