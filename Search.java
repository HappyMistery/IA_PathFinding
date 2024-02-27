import java.util.List;
import java.util.ArrayList;

public abstract class Search {
    private float[][] costMap;
    private Heuristic heuristic; 

    public Search(float[][] costMap, Heuristic heuristic){
        this.costMap = costMap;
        this.heuristic = heuristic;
    }

    public List<State> DoSearch(State initialState, State targetState){
        /* TODO: Implement search algorithm
         * You CANNOT change the input parameters (i.e., initial and target state).
         * However, feel free to use inheritance, auxiliar methods and/or change the return type. */
    }    

    protected List<State> EvaluateOperators(State currentState, State targetState, List<String> path){
        /* TODO: Obtain the states that can be accessed from the current state.
         * Consider their cost, heuristic...
         * Feel free to change the input parameters and/or return type.
         */
        List<State> accessibleStates = new ArrayList<>();
        accessibleStates.add(new State(currentState.getX()-1, currentState.getY()));    //Left state [0]
        accessibleStates.add(new State(currentState.getX()+1, currentState.getY()));    //Right state [1]
        accessibleStates.add(new State(currentState.getX(), currentState.getY()-1));    //Bottom state [2]
        accessibleStates.add(new State(currentState.getX(), currentState.getY()+1));    //Top state [3]
        String comesFrom = path.getLast();
        switch (comesFrom) {
            case "U": //Comes from the top
                accessibleStates.remove(3);
                break;
            case "D": //Comes from the bottom
                accessibleStates.remove(2);
                break;
            case "R": //Comes from the Right
                accessibleStates.remove(1);
                break;
            default: //Comes from the Left
                accessibleStates.remove(0);
                break;
        }
        accessibleStates.removeIf(state -> state.getX() > 9 || state.getX() < 0 
                                        || state.getY() > 9 || state.getX() < 0             //eliminem estat si surt dels límits...
                                        || costMap[state.getX()][state.getY()] == 100000);  //...o és una muntanya
        return accessibleStates;
    }
}
