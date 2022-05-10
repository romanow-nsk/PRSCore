package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.ErrorList;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.artifacts.Artifact;

public class EMTask extends EMNamedEntity{
    @Getter private transient ErrorList errorList = new ErrorList();
    @Getter private EntityLink<EMTheme> EMDiscipline = new EntityLink<>();  // Обратная ссылка
    @Getter @Setter private String taskText="";
    @Getter @Setter private int type= Values.TaskUndefined;
    @Getter @Setter private int ownRating= 0;                        // Собственный рейтинговый балл
    @Getter private EntityLink<Artifact> artifact = new EntityLink<>(Artifact.class);
}
