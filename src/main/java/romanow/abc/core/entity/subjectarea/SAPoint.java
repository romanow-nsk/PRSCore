package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.utils.OwnDateTime;

public class SAPoint extends Entity {
    @Getter @Setter EntityLink<SAGroupRating> rating = new EntityLink<>();      // рейтинг группы
    @Getter @Setter EntityLink<SAStudent> student = new EntityLink<>();         // студент
    @Getter @Setter EntityLink<SAEduUnit> eduUnit = new EntityLink<>();         // учебная единица
    @Getter @Setter double point=0;         // балл
    @Getter @Setter int quality=0;          // Признаки качества (3-ая СС)
    @Getter @Setter int week=0;             // Неделя сдачи сдачи (0 - не в семестре)
    @Getter @Setter OwnDateTime date = new OwnDateTime(false);  // Дата проставления оценки
}
