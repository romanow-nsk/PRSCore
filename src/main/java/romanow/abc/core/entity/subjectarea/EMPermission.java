package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;

public class EMPermission extends Entity {
    @Getter private EntityLink<EMTeacher> EMTeacher = new EntityLink<>();                   // Обратная ссылка для связи
    @Getter private EntityLink<EMGroupRating> rating = new EntityLink<EMGroupRating>();
}
