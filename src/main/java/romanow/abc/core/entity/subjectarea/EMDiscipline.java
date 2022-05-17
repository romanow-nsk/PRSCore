package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.EntityRefList;

public class EMDiscipline extends EMNamedEntity{
    @Getter private EntityRefList<EMTheme> themes = new EntityRefList<>(EMTheme.class);
    @Getter private EntityRefList<EMExamRule> rules = new EntityRefList<>(EMExamRule.class);
    @Getter private EntityRefList<EMGroupRating> ratings = new EntityRefList<>(EMGroupRating.class);
    @Getter private EntityRefList<EMExamTaking> takings = new EntityRefList<>(EMExamTaking.class);
    public void createMaps(){
        ratings.createMap();
        rules.createMap();
        themes.createMap();
        }
    public EMDiscipline(){}
}
