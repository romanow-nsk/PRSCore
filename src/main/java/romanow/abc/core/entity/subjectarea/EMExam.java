package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.EntityRefList;

public class EMExam extends EMNamedEntity{
    @Getter private EntityLink<EMDiscipline> EMDiscipline = new EntityLink<>();                     // Обратная ссылка
    @Getter private EntityLink<EMExamRule> rule = new EntityLink<>(EMExamRule.class);               // Регламент
    @Getter private EntityLinkList<EMGroup> groups = new EntityLinkList<>(EMGroup.class);           // Группы
    @Getter private EntityRefList<EMTicket> tickets = new EntityRefList<>(EMTicket.class);          // Состояние сдачи студентом
    }
