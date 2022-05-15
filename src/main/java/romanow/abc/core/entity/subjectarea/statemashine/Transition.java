package romanow.abc.core.entity.subjectarea.statemashine;

public class Transition {
    public final int curState;
    public final int nextState;
    public final String title;
    public final String transName;
    public Transition(int curState, int nextState, String title, String transName) {
        this.curState = curState;
        this.nextState = nextState;
        this.title = title;
        this.transName = transName;
        }
}
