public class Heuristics {
    //HEURISTICA BASADA EN DINERS GASTATS --> Admisible respecte als diners ja que es té en 
    //compte el cost de passar d'una casella a la següent (resultat <= 5 SEMPRE)
    public static float Heuristic1(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        float cost = map[currentState.getY()][currentState.getX()];
        return cost;    //higher is worse
    }

    //HEURISTICA BASADA EN DISTÀNCIA (EUCLIDIANA) --> No admissible respecte als diners ja que no es té en compte cap cost en cap moment
    public static float Heuristic2(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        int a = currentState.getX() - targetState.getX();
        int b = currentState.getY() - targetState.getY();
        return (float)Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)); //higher is worse
    }

    //HEURISTICA BASADA EN DISTÀNCIA (Euclidiana, 40%) I COST(60%) --> No admissible respecte als diners ja que 
    //el resultat al ser la suma de 2 valors (amb valor total màxim 10) no té per que ser <= 5 SEMPRE
    public static float Heuristic3(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        float distancia = Heuristic2(currentState, targetState, map);
        BestFirst search = new BestFirst(map, Heuristics::Heuristic3);
        float cost = search.calculateCost(new State(0, 0), currentState.getPath());
        float distanceCoef = (float) ((distancia/(float)(Math.sqrt(Math.pow(map.length, 2)*2)))*4);
        float costCoef = (float) ((cost/33)*6); //(cost/33) because optimal final cost is 33
        return distanceCoef+costCoef; //higher is worse
    }
}
