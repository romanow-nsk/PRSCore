package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;

public class EMTicket extends StateEntity {
    @Getter private EntityLink<EMExam> EMExam = new EntityLink<>();                         // Обратная ссылка
    @Getter private EntityLink<EMExamTaking> EMExamTaking = new EntityLink<>();             // Обратная ссылка
    @Getter private EntityLink<EMStudent> student = new EntityLink<>(EMStudent.class);      // Студент
    @Getter @Setter int semesterRating=0;
    @Getter @Setter int questionRating=0;
    @Getter @Setter int excerciceRating=0;
    @Getter private EntityRefList<EMAnswer> answers = new EntityRefList<>(EMAnswer.class);  // Ответы
    public EMTicket(){}
    public boolean enableToRemove(){
        return getState()==Values.TakingUndefined || getState()==Values.TicketAllowed|| getState()==Values.TicketNotAllowed;
    }
}
