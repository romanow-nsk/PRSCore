package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.utils.OwnDateTime;

public class SATeam extends SANamedEntity{
    @Getter private EntityLink<SAGroupRating> SAGroupRating = new EntityLink<>(); // Обратная ссылка
    @Getter @Setter int teamNum=0;                                                // Номер бригады
    @Getter private EntityLinkList<SAStudent> students = new EntityLinkList<>();  // Студенты
    }
