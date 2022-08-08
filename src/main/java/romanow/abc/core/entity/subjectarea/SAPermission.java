package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;

public class SAPermission extends Entity {
    @Getter private EntityLink<SATeacher> EMTeacher = new EntityLink<>();                   // Обратная ссылка для связи
    @Getter private EntityLink<SAGroupRating> rating = new EntityLink<SAGroupRating>();
}
