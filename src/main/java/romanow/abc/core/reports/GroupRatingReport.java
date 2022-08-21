package romanow.abc.core.reports;

import romanow.abc.core.UniException;
import romanow.abc.core.constants.Values;
import romanow.abc.core.constants.ValuesBase;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.subjectarea.*;
import romanow.abc.core.utils.OwnDateTime;

import java.util.ArrayList;

public class GroupRatingReport extends ReportBase {
    private SAGroupRating rating;
    private int eduUnitIdx0;
    public GroupRatingReport(SAGroupRating rating0) {
        super(Values.RepGroup);
        rating = rating0;
        }
    public String getTitle(){
        return rating.getName()+" на "+new OwnDateTime().dateToString();
        }

    @Override
    public ArrayList<TableCol> createHeader() {
        ArrayList<TableCol> head = new ArrayList<>();
        head.add(new TableCol("№ п/п",5).setAlign(TableCol.AlignCenter));
        head.add(new TableCol("Студент",20));
        head.add(new TableCol("Семестр",5));
        head.add(new TableCol("Экзамен",5));
        head.add(new TableCol("Итог",5));
        head.add(new TableCol("ECTS",5));
        head.add(new TableCol("Оценка",5));
        head.add(new TableCol("Бригада",10));
        eduUnitIdx0 = head.size();
        for(SAEduUnit eduUnit : rating.getSADiscipline().getRef().getUnits()){
            head.add(new TableCol(eduUnit.getName(),5));
            }
        return head;
        }

    public String toString(){
        return getTitle()+"\n"+rating.toString();
    }
    public String toShortString(){
        return rating.getName();
        }
    public void createReportFile(TableData table, String fspec) throws UniException {
        rating.createMap();
        ArrayList<TableCol> head = createHeader();
        table.openReport(getTitle(),fspec);
        EntityRefList<SAStudent> students = rating.getGroup().getRef().getStudents();
        SADiscipline discipline = rating.getSADiscipline().getRef();
        table.openPage(getTitle(),head,students.size()+1,true);
        for(int i=0;i<students.size();i++){
            SAStudent student = students.get(i);
            table.setCellValue(i,0,i+1);
            table.setCellValue(i,1,student.getTitle());
            SASemesterRating semesterRating = rating.getSemRatings().getByNumber(student.getOid());
            SAExamRating examRating = rating.getExamRatings().getByNumber(student.getOid());
            if (semesterRating==null || examRating==null){
                table.setCellTextColor(i,1, ValuesBase.ColorRed);
                continue;
                }
            semesterRating.createMap();
            table.setCellValue(i,2,semesterRating.getSemesterRating());
            table.setCellValue(i,3,examRating.getExamRating());
            int sum = semesterRating.getSemesterRating()+examRating.getExamRating();
            table.setCellValue(i,4,""+sum);
            table.setCellValue(i,5,SAPoint.ECTS(sum));
            table.setCellValue(i,6,SAPoint.pointNote(sum));
            SATeam team = rating.getTeams().getById(semesterRating.getTeam().getOid());
            table.setCellValue(i,6,team==null ? "" : team.getName());
            for(int j=0;j<discipline.getUnits().size();j++){
                SAEduUnit eduUnit = discipline.getUnits().get(j);
                SAPoint point = semesterRating.getPoints().getByNumber(eduUnit.getOid());
                if (point!=null)
                    table.setCellValue(i,eduUnitIdx0+j,Math.round(point.getPoint()));
                }
            }
        table.setCellValue(students.size(),1,"Среднее");
        table.savePage();
        table.saveReport();
    }
}
