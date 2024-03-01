import java.util.List;
import java.util.ArrayList;

public abstract class Search {
    protected float[][] costMap;
    protected Heuristic heuristic; 

    public Search(float[][] costMap, Heuristic heuristic){
        this.costMap = costMap;
        this.heuristic = heuristic;
    }

    public List<String> DoSearch(State initialState, State targetState){
        /* TODO: Implement search algorithm
         * You CANNOT change the input parameters (i.e., initial and target state).
         * However, feel free to use inheritance, auxiliar methods and/or change the return type. */
        return null;
    }   
    
    protected String knowDirection(State lastState, State newState) {
        String dir = "";
        if(lastState == null) return null;
        if(newState.getX() > lastState.getX()) dir = "R";  //goes to the right
        else if(newState.getX() < lastState.getX()) dir = "L"; //goes to the left
        else if(newState.getY() > lastState.getY()) dir = "D"; //goes to the bottom
        else dir = "U";    //goes to the top
        return dir;
    }

    protected List<State> EvaluateOperators(State currentState, List<State> tractats){
        /* TODO: Obtain the states that can be accessed from the current state.
         * Consider their cost, heuristic...
         * Feel free to change the input parameters and/or return type.
         */
        List<State> accessibleStates = new ArrayList<>();
        accessibleStates.add(new State(currentState.getX()-1, currentState.getY()));    //Left state [0]
        accessibleStates.add(new State(currentState.getX()+1, currentState.getY()));    //Right state [1]
        accessibleStates.add(new State(currentState.getX(), currentState.getY()-1));    //Bottom state [2]
        accessibleStates.add(new State(currentState.getX(), currentState.getY()+1));    //Top state [3]
        accessibleStates.removeIf(state -> state.getX() > costMap.length-1 || state.getX() < 0 
                                        || state.getY() > costMap.length-1 || state.getY() < 0);               //eliminem l'estat si surt dels límits...
        accessibleStates.removeIf(state -> tractats.contains(state));                           //...o si ja l'hem tractat...
        accessibleStates.removeIf(state -> costMap[state.getY()][state.getX()] == 100000);      //...o si és una muntanya
        return accessibleStates;
    }

    public float calculateCost(State iniState, List<String> path) {
        State st = iniState;
        float cost = costMap[st.getY()][st.getX()];
        for(String dir : path){
            switch (dir) {
                case "U":   //goes up
                    st = new State(st.getX(), st.getY()-1);
                    break;
                case "D":   //goes down
                    st = new State(st.getX(), st.getY()+1);
                    break;
                case "L":   //goes left
                    st = new State(st.getX()-1, st.getY());
                    break;
                default:    //goes right
                    st = new State(st.getX()+1, st.getY());
                    break;
            }
            cost += costMap[st.getY()][st.getX()];
        }
        return cost;
    }
}
