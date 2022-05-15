package romanow.abc.core.entity.subjectarea.statemashine;

import java.util.ArrayList;

public class TransitionsFactory extends ArrayList<Transition> {
    public final String name;
    public TransitionsFactory(String name0){
        name = name0;
        }
    public ArrayList<Transition> getTransitionsForState(int state){
        ArrayList<Transition> out = new ArrayList<>();
        for(Transition transition : this)
            if (transition.curState==state)
                out.add(transition);
        return out;
        }
    public Transition getByName(String name){
        for (Transition transition : this)
            if (transition.transName.equals(name))
                return transition;
        return null;
    }
}
