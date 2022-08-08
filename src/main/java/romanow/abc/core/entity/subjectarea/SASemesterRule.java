package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.utils.OwnDateTime;

public class SASemesterRule extends SANamedEntity{      // Параметры расчета рейтинга
    @Getter @Setter private int maxWeek=5;              // кол-во недель снижения/добавления
    @Getter @Setter private int weekProc=10;            // процент снижения/добавления в неделю
    @Getter @Setter private double skipPoint=0.5;       // балл за пропуск
    @Getter @Setter private int plusProc=10;            // процент увеличения за качественный показатель
    // Дата начала семестра
    @Getter @Setter private OwnDateTime beginTime = new OwnDateTime(false);
    public SASemesterRule() {
        }
}
