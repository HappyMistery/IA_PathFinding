import java.util.List;
import java.util.ArrayList;

public class BestFirst extends Search {

    public BestFirst(float[][] costMap, Heuristic heuristic){
        super(costMap, heuristic);
    }

    @Override
    public List<String> DoSearch(State initialState, State targetState){
        /* TODO: Implement search algorithm
         * You CANNOT change the input parameters (i.e., initial and target state).
         * However, feel free to use inheritance, auxiliar methods and/or change the return type. */
        List<String> path = new ArrayList<>();
        List<State> pendents = new ArrayList<>();
        pendents.add(initialState);
        List<State> tractats = new ArrayList<>(); 
        boolean trobat = false;
        while (!trobat && !pendents.isEmpty()) {
            State state = pendents.getFirst();
            pendents.removeFirst();
            if(state.equals(targetState)) {
                trobat = true;
            } else {
                List<State> toGo = EvaluateOperators(state, path, tractats);
                addBestToWorst(toGo, targetState, pendents, tractats);
            }
            String step = knowDirection(tractats.size() > 0 ? tractats.getLast() : null, state);
            if(step != null) path.add(step);
            tractats.add(state);
        }
        if(trobat) return path;
        else return null;
    }

    private void addBestToWorst(List<State> statesToOrder, State targetState, List<State> pendents, List<State> tractats) {
        statesToOrder.sort((state1, state2) -> {
            return Float.compare(heuristic.Evaluate(state1, targetState, costMap), heuristic.Evaluate(state2, targetState, costMap));
        });
        for(int i = statesToOrder.size()-1; i >= 0; i--) {
            if(!tractats.contains(statesToOrder.get(i)) && !pendents.contains(statesToOrder.get(i))) pendents.addFirst(statesToOrder.get(i));
        }
    }
}
