package romanow.abc.core.entity.subjectarea;

import romanow.abc.core.ErrorList;
import romanow.abc.core.entity.Entity;

public class EMEntity extends Entity {
    public String getFullTitle(){
        return getOid()+" "+getTitle();
        }
    public ErrorList getErrorList(){
        return new ErrorList();
        }
}
