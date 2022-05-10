package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.utils.OwnDateTime;

public class EMExamTaking extends EMNamedEntity{
    @Getter @Setter OwnDateTime startTime = new OwnDateTime(0);
    @Getter @Setter OwnDateTime endTime = new OwnDateTime(0);
    @Getter @Setter int state = Values.TakingUndefined;
    @Getter EntityLink<EMDiscipline> EMDiscipline = new EntityLink<>();                 // Обратная ссылка
    @Getter EntityLink<EMExam> exam = new EntityLink<>();                               // Обратная ссылка на экзамен
    @Getter EntityLinkList<EMGroup> groups = new EntityLinkList<>(EMGroup.class);       // Группы (группа), для которой прием - прямые ссылки
    @Getter EntityLinkList<EMTicket> tickets = new EntityLinkList<>(EMTicket.class);    // Студенты, для которых прием - прямые ссылки
}
