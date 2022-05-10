package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;

public class EMExam extends EMNamedEntity{
    @Getter private EntityLink<EMDiscipline> EMDiscipline = new EntityLink<>();                     // Обратная ссылка
    @Getter private EntityLink<EMExamRule> rule = new EntityLink<>(EMExamRule.class);               // Регламент
    @Getter private EntityRefList<EMTheme> themes = new EntityRefList<>(EMTheme.class);             // Темы
    @Getter private EntityRefList<EMGroup> groups = new EntityRefList<>(EMGroup.class);             // Группы
    @Getter private EntityRefList<EMExamTaking> takings = new EntityRefList<>(EMExamTaking.class);  // Приемы экзамена
    @Getter private EntityRefList<EMTicket> tickets = new EntityRefList<>(EMTicket.class);          // Состояние сдачи студентом
    }
