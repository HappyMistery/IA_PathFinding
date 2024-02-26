public class State{
    private int x;
    private int y;

    public State(int x, int y){
        // TODO
        this.x = x;
        this.y = y;
    }
    

    @Override
    public boolean equals(Object other) {
        // TODO
    }

    @Override
    public int hashCode() {
        /* TODO if using data structures leveraging hash.
        *  IMPORTANT: It MUST be coherent with the "equals" method. That is, if two States are equal, they MUST have the same hashcode.
        *  However, due to collisions, two States with the same hashcode are not necessarily equal.  
        */
    }
}
