package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;

public class SAEduUnit extends SANamedEntity{                   // Учебная единица
    @Getter private EntityLink<SADiscipline> SADiscipline = new EntityLink<>();  // Обратная ссылка
    @Getter @Setter private int basePoint=0;                    // Базовый балл
    @Getter @Setter private int unitType= Values.UndefinedType; // Тип учебной единицы
    @Getter @Setter private int orderNum= 0;                    // Порядковый номер
}
