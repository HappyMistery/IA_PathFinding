import java.util.ArrayList;
import java.util.List;

public class State{
    private int x;
    private int y;
    private List<String> path;
    private float heuristic;

    public State(int x, int y){
        // TODO
        this.x = x;
        this.y = y;
        path = new ArrayList<>();
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<String> getPath() {
        return path;
    }

    public float getHeuristic() {
        return heuristic;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public void setHeuristic(float heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public boolean equals(Object other) {
        // TODO
        try {
            if(this.x == ((State)other).x && this.y == ((State)other).y) return true;
            else return false;
        } catch(java.lang.ClassCastException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        /* TODO if using data structures leveraging hash.
        *  IMPORTANT: It MUST be coherent with the "equals" method. That is, if two States are equal, they MUST have the same hashcode.
        *  However, due to collisions, two States with the same hashcode are not necessarily equal.  
        */
        return Integer.parseInt(this.x+""+this.y);
    }
}
