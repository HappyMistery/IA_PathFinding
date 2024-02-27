public class Heuristics {
    //HEURISTICA BASADA EN DINERS GASTATS
    public static float Heuristic1(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
    }

    //HEURISTICA BASADA EN DISTÀNCIA (EUCLIDIANA)
    public static float Heuristic2(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        int a = Math.abs(currentState.getX()+targetState.getX());
        int b = Math.abs(currentState.getY()+targetState.getY());
        return (float)Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
    }

    //HEURISTICA BASADA EN TEMPS (40%) I DINERS(60%)
    public static float Heuristic3(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
    }
}
