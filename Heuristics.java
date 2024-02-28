public class Heuristics {
    //HEURISTICA BASADA EN DINERS GASTATS
    public static float Heuristic1(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        float cost = map[currentState.getY()][currentState.getX()];
        return cost;    //higher is worse
    }

    //HEURISTICA BASADA EN DISTÀNCIA (EUCLIDIANA)
    public static float Heuristic2(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        int a = currentState.getX() - targetState.getX();
        int b = currentState.getY() - targetState.getY();
        return (float)Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)); //higher is worse
    }

    //HEURISTICA BASADA EN DISTÀNCIA (Euclidiana, 40%) I COST(60%)
    public static float Heuristic3(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        float distancia = Heuristic2(currentState, targetState, map);
        float cost = map[currentState.getY()][currentState.getX()];
        float distanceCoef = (float) ((distancia/(float)(Math.sqrt(Math.pow(map.length, 2)*2)))*4);
        float costCoef = (float) ((cost/5)*6);
        return distanceCoef+costCoef; //higher is worse
    }
}
