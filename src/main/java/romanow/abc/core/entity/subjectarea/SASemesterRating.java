package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.UniException;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.StateEntity;

public class SASemesterRating extends StateEntity {
    @Getter private EntityLink<SAGroupRating> SAGroupRating = new EntityLink<>();           // Обратная ссылка
    @Getter private EntityLink<SAStudent> student = new EntityLink<>(SAStudent.class);      // Студент
    @Getter private EntityRefList<SAPoint> points = new EntityRefList<>(SAPoint.class);     // Оценки
    @Getter private EntityLink<SATeam> team = new EntityLink<>(SATeam.class);               // Бригада
    @Getter @Setter int semesterRating=0;
    public void createMap(){
        points.createMap();
        }
    @Override
    public long getKeyNum() {
        return student.getOid();
        }
    public int calcSemesterRating(EntityRefList<SAEduUnit> units, SASemesterRule rule) throws UniException {
        semesterRating=0;
        double sum=0;
        units.createMap();
        for(SAPoint point : points){
            if (point.getState()!=Values.PSAccepted)
                continue;
            SAEduUnit unit = units.getById(point.getEduUnit().getOid());
            if (unit==null)
                UniException.bug("Не найдена уч.единица id="+point.getEduUnit().getOid()+" для оценки id="+point.getOid());
            sum += point.calcPointValue(unit,rule);
            }
        semesterRating = (int)Math.round(sum);
        return semesterRating;
        }
    public SASemesterRating(){}
    }
