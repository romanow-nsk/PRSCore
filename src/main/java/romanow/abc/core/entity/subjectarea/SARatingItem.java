package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.utils.OwnDateTime;

public class SARatingItem extends Entity {
    @Getter @Setter EntityLink<SAGroupRating> rating = new EntityLink<>();      // рейтинг группы
    @Getter @Setter EntityLink<SAStudent> student = new EntityLink<>();         // студент
    @Getter @Setter EntityLink<SAEduUnit> eduUnit = new EntityLink<>();         // учебная единица
}
