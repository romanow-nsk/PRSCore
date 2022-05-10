package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.entity.Entity;

public class EMNamedEntity extends EMEntity {
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter @Setter private String name="";
    @Getter @Setter private String comment="";
    @Override
    public String getTitle(){
        return name;
        }
}
