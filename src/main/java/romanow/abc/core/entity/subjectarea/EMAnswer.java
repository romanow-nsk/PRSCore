package romanow.abc.core.entity.subjectarea;

import lombok.Getter;
import lombok.Setter;
import romanow.abc.core.constants.Values;
import romanow.abc.core.entity.Entity;
import romanow.abc.core.entity.EntityLink;
import romanow.abc.core.entity.EntityLinkList;
import romanow.abc.core.entity.artifacts.Artifact;

public class EMAnswer extends Entity {
    @Getter EntityLink<EMTicket> EMTicket = new EntityLink<>();                         // Обратная ссылка
    @Getter EntityLinkList<EMMessage> messages = new EntityLinkList<>(EMMessage.class); // Прямые ссылки
    @Getter EntityLink<EMTask> tasl = new EntityLink<>(EMTask.class);                   // Задание
    @Getter @Setter int rating=0;                                                       // Оценка
    @Getter @Setter int state= Values.AnswerNoAck;                                      // Состояние
    public EMAnswer(){}
}
