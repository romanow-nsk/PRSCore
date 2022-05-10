package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;

public class EMTheme extends EMNamedEntity{
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter private EntityLink<EMDiscipline> EMDiscipline = new EntityLink<>();               // Обратная ссылка
    @Getter private EntityRefList<EMTask> themes = new EntityRefList<>(EMTask.class);
}
