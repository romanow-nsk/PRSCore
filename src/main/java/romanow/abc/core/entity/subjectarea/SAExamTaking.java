package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;
import romanow.abc.core.utils.OwnDateTime;

public class SAExamTaking extends StateEntity {
    @Getter @Setter String name="";
    @Getter @Setter OwnDateTime startTime = new OwnDateTime(0);
    @Getter @Setter int duration=0;
    @Getter EntityLink<SADiscipline> SADiscipline = new EntityLink<>();                     // Обратная ссылка
    @Getter @Setter boolean oneGroup=false;
    @Getter EntityLink<SAGroup> group = new EntityLink<>(SAGroup.class);                    // Группа, для которой прием - прямая ссылка
    @Getter EntityRefList<SAExamRating> ratings = new EntityRefList<>(SAExamRating.class);  // Студенты, для которых прием - обратные ссылки
    public SAExamTaking(){}
    public String getTitle(){
        return  getName().length()==0 ? "..." : getName()+" "+getStartTime().dateTimeToString();
        }
}
