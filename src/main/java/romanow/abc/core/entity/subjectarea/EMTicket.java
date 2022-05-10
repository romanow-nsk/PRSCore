package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;

public class EMTicket extends Entity {
    @Getter private EntityLink<EMExam> EMExamen = new EntityLink<>();                     // Обратная ссылка
    @Getter private EntityLink<EMExamTaking> taking = new EntityLink<>();                   // Прием (без связывания)
    @Getter private EntityLink<EMStudent> student = new EntityLink<>(EMStudent.class);      // Студент
    @Getter @Setter int state = Values.TicketUndefined;
    @Getter @Setter int semesterRating=0;
    @Getter @Setter int questionRating=0;
    @Getter @Setter int excerciceRating=0;
    @Getter private EntityRefList<EMAnswer> answers = new EntityRefList<>(EMAnswer.class);  // Ответы
}
