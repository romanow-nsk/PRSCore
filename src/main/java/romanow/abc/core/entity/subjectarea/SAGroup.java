package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityRefList;

public class SAGroup extends SANamedEntity {
    @Getter private EntityRefList<SAStudent> students = new EntityRefList<>(SAStudent.class);
    public SAGroup(){}
}
