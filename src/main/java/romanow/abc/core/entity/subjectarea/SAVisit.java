package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.utils.OwnDateTime;

public class SAVisit extends Entity {
    @Getter private EntityLink<SAEvent> SAEvent = new EntityLink<>();   // Обратная ссылка
    @Getter @Setter OwnDateTime date = new OwnDateTime(false);      // Время фмксации
    @Getter private EntityLink<SAStudent> student = new EntityLink<>(SAStudent.class);   // Студент
}
