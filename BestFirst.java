import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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
                List<State> toGo = EvaluateOperators(state, tractats);
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
        Comparator<State> comparator = (state1, state2) -> {        //we'll sort the list by the heuristic (lower is better, higher is worse)
            float heuristic1 = heuristic.Evaluate(state1, targetState, costMap);
            float heuristic2 = heuristic.Evaluate(state2, targetState, costMap);
            return Float.compare(heuristic1, heuristic2);
        };

        statesToOrder.removeIf(state -> pendents.contains(state));
        pendents.addAll(statesToOrder);
        pendents.sort(comparator);
        for (State st : pendents) {
            System.out.println(st.getX()+" "+st.getY()+" --> "+heuristic.Evaluate(st, targetState, costMap));
        }
        System.out.println("///////////////////////////////////////");
    }
}
