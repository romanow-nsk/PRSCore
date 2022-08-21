package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;

public class SAGroupRating extends SANamedEntity {
    @Getter private EntityLink<SADiscipline> SADiscipline = new EntityLink<>();                         // Обратная ссылка
    @Getter private EntityLink<SAExamRule> examRule = new EntityLink<>(SAExamRule.class);               // Регламент экзамена
    @Getter private EntityLink<SAGroup> group = new EntityLink<>(SAGroup.class);                        // Группа
    @Getter private EntityLink<SASemesterRule> semRule = new EntityLink<>(SASemesterRule.class);        // Регламент семестра
    @Getter private EntityRefList<SAExamRating> examRatings = new EntityRefList<>(SAExamRating.class);  // Рейтинги студентов
    @Getter private EntityRefList<SASemesterRating> semRatings = new EntityRefList<>(SASemesterRating.class);  // Рейтинги студентов
    @Getter private EntityRefList<SAEvent> events = new EntityRefList<>(SAEvent.class);                 // Мероприятия (события)
    @Getter private EntityRefList<SATeam> teams = new EntityRefList<>(SATeam.class);                    // Бригады
    public SAGroupRating(){}
    public void createMap(){
        semRatings.createMap();
        examRatings.createMap();
        teams.createMap();
        if (SADiscipline.getRef()!=null)
            SADiscipline.getRef().createMaps();
        if (group.getRef()!=null)
            group.getRef().getStudents().createMap();
        }
    }
