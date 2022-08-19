package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.StateEntity;

public class SAAnswer extends StateEntity {
    @Getter EntityLink<SAExamRating> SAExamRating = new EntityLink<>();                 // Обратная ссылка
    @Getter EntityLinkList<SAMessage> messages = new EntityLinkList<>(SAMessage.class); // Прямые ссылки
    @Getter EntityLink<SATask> task = new EntityLink<>(SATask.class);                   // Задание
    @Getter @Setter int rating=0;                                                       // Оценка
    public SAAnswer(){}
}
