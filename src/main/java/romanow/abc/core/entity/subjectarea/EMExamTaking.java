package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;
import romanow.abc.core.utils.OwnDateTime;

public class EMExamTaking extends StateEntity {
    @Getter @Setter String name="";
    @Getter @Setter OwnDateTime startTime = new OwnDateTime(0);
    @Getter @Setter int duration=0;
    @Getter EntityLink<EMDiscipline> EMDiscipline = new EntityLink<>();                     // Обратная ссылка
    @Getter @Setter boolean oneGroup=false;
    @Getter EntityLink<EMGroup> group = new EntityLink<>(EMGroup.class);                    // Группа, для которой прием - прямая ссылка
    @Getter EntityRefList<EMStudRating> ratings = new EntityRefList<>(EMStudRating.class);  // Студенты, для которых прием - обратные ссылки
    public EMExamTaking(){}
    public String getTitle(){
        return  getName().length()==0 ? "..." : getName()+" "+getStartTime().dateTimeToString();
        }
}
