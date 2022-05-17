package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.EntityRefList;

public class EMGroupRating extends EMNamedEntity{
    @Getter private EntityLink<EMDiscipline> EMDiscipline = new EntityLink<>();                     // Обратная ссылка
    @Getter private EntityLink<EMExamRule> rule = new EntityLink<>(EMExamRule.class);               // Регламент
    @Getter private EntityLink<EMGroup> group = new EntityLink<>(EMGroup.class);                    // Группа
    @Getter private EntityRefList<EMStudRating> ratings = new EntityRefList<>(EMStudRating.class);  // Рейцтинги студентов
    public EMGroupRating(){}
    }
