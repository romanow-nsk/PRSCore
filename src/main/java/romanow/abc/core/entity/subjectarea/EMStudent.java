package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;

public class EMStudent extends EMNamedEntity{
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter private EntityLink<EMGroup> EMGroup = new EntityLink<>();               // Обратная ссылка
    @Getter @Setter private int state = Values.StudentStateUndefined;

}
