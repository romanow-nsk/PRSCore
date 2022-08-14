package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.artifacts.Artifact;

public class SATask extends SANamedEntity {
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter private EntityLink<SATheme> SATheme = new EntityLink<>();  // Обратная ссылка
    @Getter @Setter private String taskText="";
    @Getter @Setter private int type= Values.TaskUndefined;
    @Getter @Setter private int ownRating= 0;                        // Собственный рейтинговый балл
    @Getter private EntityLink<Artifact> artifact = new EntityLink<>(Artifact.class);
    public SATask(){}
}
