package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.utils.OwnDateTime;

public class SASemesterRule extends SANamedEntity{      // Параметры расчета рейтинга
    // Дата начала семестра
    @Getter @Setter private OwnDateTime smstrDate = new OwnDateTime(false);
    @Getter @Setter private int semesterDuration=18;    // Продолжительность семестра (недель)
    //----------------------------------------------------------------------------------------------
    @Getter @Setter private boolean fineOverDate=false; // Штраф за нарушение срока сдачи
    @Getter @Setter private int overDateWeeks=5;        // Кол-во недель снижения
    @Getter @Setter private int overDatePercent=50;     // Полный процент снижения
    //----------------------------------------------------------------------------------------------
    @Getter @Setter private boolean fineOverSemester=false; // Штраф за сдачу вне семестра
    @Getter @Setter private int overSemesterPercent=50;     // Процент штрафа за сдачу вне семестра (долг)
    //----------------------------------------------------------------------------------------------
    @Getter @Setter private boolean fineOverIrregular=false; // Штраф за нерегулярность сдачи (дата сдачи не установлена)
    @Getter @Setter private int irregulaFirstWeek=6;         // Неделя начала сдачи
    //----------------------------------------------------------------------------------------------
    @Getter @Setter private double pointPerSkip=0.5;    // Балл за пропуск
    @Getter @Setter private int qualProc=10;            // Процент увеличения/уменьшения за качественный показатель
    public SASemesterRule() {
        }
}
