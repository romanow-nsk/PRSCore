package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.StateEntity;

public class EMAnswer extends StateEntity {
    @Getter EntityLink<EMStudRating> EMStudRating = new EntityLink<>();                 // Обратная ссылка
    @Getter EntityLinkList<EMMessage> messages = new EntityLinkList<>(EMMessage.class); // Прямые ссылки
    @Getter EntityLink<EMTask> task = new EntityLink<>(EMTask.class);                   // Задание
    @Getter @Setter int rating=0;                                                       // Оценка
    public EMAnswer(){}
}
