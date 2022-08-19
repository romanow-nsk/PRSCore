package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;

public class SAExamRating extends StateEntity {
    @Getter private EntityLink<SAGroupRating> SAGroupRating = new EntityLink<>();           // Обратная ссылка
    @Getter private EntityLink<SAExamTaking> SAExamTaking = new EntityLink<>();             // Обратная ссылка (последний)
    @Getter private EntityLink<SAStudent> student = new EntityLink<>(SAStudent.class);      // Студент
    @Getter private EntityLink<SASemesterRating> semRating = new EntityLink<>(SASemesterRating.class);
    @Getter @Setter int questionRating=0;
    @Getter @Setter int excerciceRating=0;
    @Getter private EntityRefList<SAAnswer> answers = new EntityRefList<>(SAAnswer.class);  // Ответы
    public SAExamRating(){}
    public boolean enableToRemove(){
        int state = getState();
        return state==Values.StudRatingUndefined || state==Values.StudRatingNotAllowed || state==Values.StudRatingAllowed;
    }
}
