package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;

public class SATheme extends SANamedEntity {
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter private EntityLink<SADiscipline> EMDiscipline = new EntityLink<>();               // Обратная ссылка
    @Getter private EntityRefList<SATask> tasks = new EntityRefList<>(SATask.class);
    public SATheme(){}
}
