package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.ConstValue;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.StateEntity;
import romanow.abc.core.entity.artifacts.Artifact;
import romanow.abc.core.utils.OwnDateTime;

import java.util.ArrayList;

public class SAPoint extends StateEntity {             // Оценка
    @Getter private EntityLink<SASemesterRating> SASemesterRating = new EntityLink<>(); // Обратная ссылка
    @Getter private EntityLink<SAGroupRating> rating = new EntityLink<>();              // рейтинг группы
    @Getter private EntityLink<SAStudent> student = new EntityLink<>();                 // студент
    @Getter private EntityLink<SAEduUnit> eduUnit = new EntityLink<>();                 // учебная единица
    @Getter @Setter double point=0;                 // Рассчитанный (выставленный) итоговый балл
    @Getter @Setter int quality=0;                  // Признаки качества (3-ая СС, 0 - нет, 1-"+", 2-"-")
    @Getter @Setter int deliveryWeek=0;             // Неделя сдачи (0 - отсутствует, -1 - вне семестра)
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
    public String setDeliveryWeekDate(OwnDateTime date2, SASemesterRule rule){
        long tt1 = date2.timeInMS();
        long tt2 = rule.getSmstrDate().timeInMS();
        if (tt1 < tt2)
            return "Дата сдачи до начала семестра";
        long week = (tt1-tt2) / 1000 / 60 / 60/ 24 / 7;
        if (week >=rule.getSemesterDuration()) {
            deliveryWeek=-1;
            date = date2;
            return "";
            }
        deliveryWeek = (int)(week+1);
        date = date2;
        return "";
        }
    public String weekToString(){
        if (deliveryWeek==0)
            return "";
        if (deliveryWeek==-1)
            return "???";
        return ""+deliveryWeek;
        }
    public int calcQuality(){
        int out=0;
        for(int vv=quality,i=0;vv!=0;vv/=3,i++){
            int ss=vv%3;
            if (ss==2) out--;
            if (ss==1) out++;
            }
        return out;
        }
    public String show(ArrayList<ConstValue> qualityList){
        String out="";
        for(int vv=quality,i=0;vv!=0;vv/=3,i++){
            int ss=vv%3;
            for(ConstValue cc : qualityList){
                if (cc.value()==i){
                    if (ss==0)
                        continue;
                    if(out.length()!=0)
                        out+="\n";
                    if (ss==2) out+="+";
                    if (ss==1) out+="-";
                    out+=cc.title();
                    break;
                    }
                }
            }
        return out;
    }
}
