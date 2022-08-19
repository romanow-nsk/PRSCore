package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;

public class SASemesterRating extends StateEntity {
    @Getter private EntityLink<SAGroupRating> SAGroupRating = new EntityLink<>();           // Обратная ссылка
    @Getter private EntityLink<SAStudent> student = new EntityLink<>(SAStudent.class);      // Студент
    @Getter private EntityRefList<SAPoint> points = new EntityRefList<>(SAPoint.class);     // Оценки
    @Getter @Setter int semesterRating=0;
    public SASemesterRating(){}
    }
