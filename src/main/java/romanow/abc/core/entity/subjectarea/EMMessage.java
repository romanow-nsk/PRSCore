package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.artifacts.Artifact;
import romanow.abc.core.entity.users.User;
import romanow.abc.core.utils.OwnDateTime;

public class EMMessage extends Entity {
    @Getter @Setter private String text="";
    @Getter private EntityLink<Artifact> artifact = new EntityLink<>(Artifact.class);
    @Getter private OwnDateTime sendTime = new OwnDateTime();
    @Getter private EntityLink<User> author = new EntityLink<>();           // id user'a
    public EMMessage(){}
}
