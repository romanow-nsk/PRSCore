package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;

public class SAGroupRating extends SANamedEntity {
    @Getter private EntityLink<SADiscipline> EMDiscipline = new EntityLink<>();                     // Обратная ссылка
    @Getter private EntityLink<SAExamRule> examRule = new EntityLink<>(SAExamRule.class);           // Регламент экзамена
    @Getter private EntityLink<SAGroup> group = new EntityLink<>(SAGroup.class);                    // Группа
    @Getter private EntityLink<SASemesterRule> semRule = new EntityLink<>(SASemesterRule.class);    // Регламент семестра
    @Getter private EntityRefList<SAStudRating> ratings = new EntityRefList<>(SAStudRating.class);  // Рейтинги студентов
    public SAGroupRating(){}
    }
