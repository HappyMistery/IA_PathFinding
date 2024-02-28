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
        if(lastState == null) return null;
        if(newState.getX() > lastState.getX()) return "R";  //goes to the right
        else if(newState.getX() < lastState.getX()) return "L"; //goes to the left
        else if(newState.getY() > lastState.getY()) return "D"; //goes to the top
        else return "U";    //goes to the bottom
    }

    protected List<State> EvaluateOperators(State currentState, List<String> path, List<State> tractats){
        /* TODO: Obtain the states that can be accessed from the current state.
         * Consider their cost, heuristic...
         * Feel free to change the input parameters and/or return type.
         */
        List<State> accessibleStates = new ArrayList<>();
        accessibleStates.add(new State(currentState.getX()-1, currentState.getY()));    //Left state [0]
        accessibleStates.add(new State(currentState.getX()+1, currentState.getY()));    //Right state [1]
        accessibleStates.add(new State(currentState.getX(), currentState.getY()-1));    //Bottom state [2]
        accessibleStates.add(new State(currentState.getX(), currentState.getY()+1));    //Top state [3]
        if(!path.isEmpty()) {
            String comesFrom = path.getLast();
            switch (comesFrom) {
                case "D": //Comes from the top
                    accessibleStates.remove(2);
                    break;
                case "U": //Comes from the bottom
                    accessibleStates.remove(3);
                    break;
                case "L": //Comes from the Right
                    accessibleStates.remove(1);
                    break;
                default: //Comes from the Left
                    accessibleStates.remove(0);
                    break;
            }
        }
        accessibleStates.removeIf(state -> state.getX() > 9 || state.getX() < 0 
                                        || state.getY() > 9 || state.getY() < 0);               //eliminem l'estat si surt dels límits...
        accessibleStates.removeIf(state -> tractats.contains(state));                           //...o si ja l'hem tractat...
        accessibleStates.removeIf(state -> costMap[state.getY()][state.getX()] == 100000);      //...o si és una muntanya
        return accessibleStates;
    }

    public float calculateCost(State iniState, List<String> path) {
        State st = iniState;
        float cost = 0;
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
