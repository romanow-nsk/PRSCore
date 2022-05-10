package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityRefList;

public class EMDiscipline extends EMNamedEntity{
    @Getter private EntityRefList<EMTheme> themes = new EntityRefList<>(EMTheme.class);
    @Getter private EntityRefList<EMExamRule> rules = new EntityRefList<>(EMExamRule.class);
    @Getter private EntityRefList<EMExam> exafmens = new EntityRefList<>(EMExam.class);
}
