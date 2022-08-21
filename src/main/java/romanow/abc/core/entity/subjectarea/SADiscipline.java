package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityRefList;

public class SADiscipline extends SANamedEntity {
    @Getter private EntityRefList<SATheme> themes = new EntityRefList<>(SATheme.class);
    @Getter private EntityRefList<SAExamRule> rules = new EntityRefList<>(SAExamRule.class);
    @Getter private EntityRefList<SAGroupRating> ratings = new EntityRefList<>(SAGroupRating.class);
    @Getter private EntityRefList<SAExamTaking> takings = new EntityRefList<>(SAExamTaking.class);
    @Getter private EntityRefList<SAEduUnit> units = new EntityRefList<>(SAEduUnit.class);
    public void createMaps(){
        rules.createMap();
        themes.createMap();
        units.createMap();
        }
    public SADiscipline(){}
}
