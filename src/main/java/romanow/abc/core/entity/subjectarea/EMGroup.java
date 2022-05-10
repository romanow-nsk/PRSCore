package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityRefList;

public class EMGroup extends EMNamedEntity{
    @Getter private EntityRefList<EMStudent> students = new EntityRefList<>(EMStudent.class);
}
