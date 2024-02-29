import java.util.List;
import java.util.ArrayList;

public class AStar extends Search {

    public AStar(float[][] costMap, Heuristic heuristic){
        super(costMap, heuristic);
    }

    @Override
    public List<String> DoSearch(State initialState, State targetState){
        /* TODO: Implement search algorithm
         * You CANNOT change the input parameters (i.e., initial and target state).
         * However, feel free to use inheritance, auxiliar methods and/or change the return type. */
        List<State> pendents = new ArrayList<>();
        pendents.add(initialState);
        List<State> tractats = new ArrayList<>(); 
        boolean trobat = false;
        State state = null;
        while (!trobat && !pendents.isEmpty()) {
            state = pendents.getFirst();
            pendents.removeFirst();
            if(state.equals(targetState)) {
                trobat = true;
            } else {
                List<State> toGo = EvaluateOperators(state, tractats);
                addWithOrder(toGo, state, targetState, pendents, tractats);
            }
        }
        state.getPath().add(""+tractats.size());
        if(trobat) return state.getPath();
        else return null;
    }

    private void addWithOrder(List<State> statesToOrder, State currentState, State targetState, List<State> pendents, List<State> tractats) {
        for(State st : statesToOrder) {
            st.setHeuristic(heuristic.Evaluate(st, targetState, costMap));
            List<String> statePath = new ArrayList<>(currentState.getPath());
            String step = knowDirection(currentState, st);
            if(step != null) statePath.add(step);
            st.setPath(statePath);

            if(!pendents.contains(st))
                pendents.add(st);
            //else if (calculateCost(new State(0, 0), statePath) > calculateCost(new State(0, 0), pendents.getFirst().getPath()))
        }

        pendents.sort((state1, state2) -> {
            return Float.compare(state1.getHeuristic() + calculateCost(new State(0, 0), state1.getPath()), state2.getHeuristic() + calculateCost(new State(0, 0), state2.getPath()));
        });
        tractats.add(currentState);
    }
}