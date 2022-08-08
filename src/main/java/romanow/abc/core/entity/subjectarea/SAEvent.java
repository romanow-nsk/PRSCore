package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.utils.OwnDateTime;

public class SAEvent extends SANamedEntity{
    @Getter private EntityLink<SAGroupRating> SAGroupRating = new EntityLink<>();   // Обратная ссылка
    @Getter @Setter OwnDateTime date = new OwnDateTime(false);                  // Дата проставления оценки
    @Getter private EntityRefList<SAVisit> visits = new EntityRefList<>(SAVisit.class);  // Посещения
    @Getter private EntityLink<SAEduUnit> eduUnit = new EntityLink<>(SAEduUnit.class);   // Учебная единица 0..1
}
