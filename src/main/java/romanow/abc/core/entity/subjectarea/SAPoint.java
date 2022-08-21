package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.Utils;
import romanow.abc.core.constants.ConstValue;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
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
    //----------------------------------------------------
    @Override
    public long getKeyNum() {           // Для поиска по уч.единицам сданным
        return getState()!=Values.PSAccepted ? 0 : eduUnit.getOid();
        }
    //-----------------------------------------------------
    public static int weekDiff(OwnDateTime entDate, OwnDateTime startDate){
        long tt1 = entDate.timeInMS();
        long tt2 = startDate.timeInMS();
        if (tt1==0 || tt2==0)
            return 0;                       // Не определено
        if (tt1 < tt2)
            return -1;
        int week = (int)((tt1-tt2) / 1000 / 60 / 60/ 24 / 7);
        return week;
        }
    //---------------------------------------------------------
    public String setDeliveryWeekByDate(SASemesterRule rule){
        int week = weekDiff(date,rule.getSmstrDate());
        if (week==0)
            return "Дата не определена";
        if (week==-1)
            return "Дата сдачи до начала семестра";
        if (week >=rule.getSemesterDuration()) {
            deliveryWeek=-1;
            return "";
            }
        deliveryWeek = (int)(week+1);
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
    public double calcPointValue(SAEduUnit unit, SASemesterRule rule) {
        if (unit.isManualPointSet())
            return point;
        if (getState()!=Values.PSAccepted)
            return 0;
        double val = unit.getBasePoint();
        double qual =  val*calcQuality()*rule.getQualProc()/100.;
        if (rule.isFineOverSemester()){
            if (deliveryWeek==0 || deliveryWeek==-1 || deliveryWeek>rule.getSemesterDuration())
                val -= val * rule.getOverSemesterPercent()/100.;
            }
        if (rule.isFineOverDate() && unit.getDeliveryWeek()!=0){
            int week=rule.getSemesterDuration()+100;
            if (deliveryWeek>0)
                week = deliveryWeek;
            int diff = week-unit.getDeliveryWeek();
            int overWeeks = rule.getOverDateWeeks();
            if (diff>overWeeks)
                diff=overWeeks;
            val -= val * rule.getOverDatePercent()/100.*diff/overWeeks;
            }
        point = val + qual;
        return point;
        }
    public void setDateByWeek(SASemesterRule rule){
        date = new OwnDateTime(rule.getSmstrDate().timeInMS()+deliveryWeek*7L*24*60*60*1000);
        }
    public static String pointNote(int  x){
        if (x==0) return "--";
        if (x < 50) return "2";
        if (x < 73) return "3";
        if (x < 87) return "4";
        return "5";
        }
    public static String ECTS(int x){
        if (x==0) return "";
        if (x >= 98) return "A+";
        if (x >= 93) return "A";
        if (x >= 90) return "A-";
        if (x >= 87) return "B+";
        if (x >= 83) return "B";
        if (x >= 80) return "B-";
        if (x >= 77) return "C+";
        if (x >= 73) return "C";
        if (x >= 70) return "C-";
        if (x >= 67) return "D+";
        if (x >= 63) return "D";
        if (x >= 60) return "D-";
        if (x >= 50) return "E";
        if (x >= 25) return"FX";
        return "F";
        }
}
