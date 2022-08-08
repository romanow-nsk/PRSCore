package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.artifacts.Artifact;
import romanow.abc.core.utils.OwnDateTime;

public class SAPoint extends SARatingItem {         // Оценка
    @Getter @Setter double point=0;                 // балл
    @Getter @Setter int quality=0;                  // Признаки качества (3-ая СС)
    @Getter @Setter int week=0;                     // Неделя сдачи сдачи (0 - не в семестре)
    @Getter @Setter int state= Values.PSNotIssued;  // Состояние
    @Getter @Setter OwnDateTime date = new OwnDateTime(false);  // Дата проставления оценки (сдачи)
    @Getter private EntityLink<Artifact> source = new EntityLink<>(Artifact.class);   // Исходник
    @Getter private EntityLink<Artifact> report = new EntityLink<>(Artifact.class);   // Отчет
    @Getter @Setter String variant="";              // Вариант задания
}
