package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;

public class EMStudRating extends StateEntity {
    @Getter private EntityLink<EMGroupRating> EMGroupRating = new EntityLink<>();           // Обратная ссылка
    @Getter private EntityLink<EMExamTaking> EMExamTaking = new EntityLink<>();             // Обратная ссылка (последний)
    @Getter private EntityLink<EMStudent> student = new EntityLink<>(EMStudent.class);      // Студент
    @Getter @Setter int semesterRating=0;
    @Getter @Setter int questionRating=0;
    @Getter @Setter int excerciceRating=0;
    public int getSumRating(){
        return semesterRating+excerciceRating+questionRating;
        }
    @Getter private EntityRefList<EMAnswer> answers = new EntityRefList<>(EMAnswer.class);  // Ответы
    public EMStudRating(){}
    public boolean enableToRemove(){
        int state = getState();
        return state==Values.StudRatingUndefined || state==Values.StudRatingNotAllowed || state==Values.StudRatingAllowed;
    }
}
