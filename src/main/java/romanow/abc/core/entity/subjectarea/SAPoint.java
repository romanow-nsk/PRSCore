package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.StateEntity;
import romanow.abc.core.entity.artifacts.Artifact;
import romanow.abc.core.utils.OwnDateTime;

public class SAPoint extends StateEntity {             // Оценка
    @Getter private EntityLink<SASemesterRating> SASemesterRating = new EntityLink<>(); // Обратная ссылка
    @Getter private EntityLink<SAGroupRating> rating = new EntityLink<>();              // рейтинг группы
    @Getter private EntityLink<SAStudent> student = new EntityLink<>();                 // студент
    @Getter private EntityLink<SAEduUnit> eduUnit = new EntityLink<>();                 // учебная единица
    @Getter @Setter double point=0;                 // Рассчитанный (выставленный) итоговый балл
    @Getter @Setter int quality=0;                  // Признаки качества (3-ая СС)
    @Getter @Setter int deliveryWeek=0;             // Неделя сдачи (0 - не в семестре)
    @Getter @Setter OwnDateTime date = new OwnDateTime(false);  // Дата проставления оценки (сдачи)
    @Getter private EntityLink<Artifact> source = new EntityLink<>(Artifact.class);   // Исходник
    @Getter private EntityLink<Artifact> report = new EntityLink<>(Artifact.class);   // Отчет
    @Getter @Setter String variant="";              // Вариант задания
    public SAPoint(){
        setState(Values.PSNotIssued);
        }
    public SAPoint(long gOid, long sOid, long eOid, long srOid){
        rating.setOid(gOid);
        student.setOid(sOid);
        eduUnit.setOid(eOid);
        SASemesterRating.setOid(srOid);
        setState(Values.PSNotIssued);
    }
}
