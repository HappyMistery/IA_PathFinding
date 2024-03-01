import java.util.List;

public class Main {

    public static char[][] OriginalCharMap = {
      {'P','N','N','N','P','P','P','P','P','P'},
      {'P','N','N','N','M','M','P','P','N','P'},
      {'P','N','N','N','M','M','N','N','N','P'},
      {'P','A','A','A','A','A','A','N','N','N'},
      {'P','N','A','C','A','A','A','A','A','N'},
      {'P','A','A','C','M','C','C','A','A','A'},
      {'P','A','M','A','M','M','C','A','A','A'},
      {'A','A','M','A','M','C','C','P','M','P'},
      {'A','A','M','C','M','C','P','P','P','P'},
      {'A','A','C','C','M','C','C','C','C','C'},
    };
    public static Map OriginalMap = new Map(OriginalCharMap);

    public static char[][] CustomCharMap = {
      {'N','N','P','C','P'},
      {'A','A','M','N','N'},
      {'A','M','M','N','N'},
      {'N','N','N','M','C'},
      {'N','P','P','N','C'},
    };
    public static Map CustomMap = new Map(CustomCharMap);

    public static void main(String args[]){      

      // TODO: Declare map

      // TODO: Declare initial and target states
      State OriginalIs = new State(0, 0);
      State OriginalTs = new State(9, 9);
      State CustomIs = new State(0, 0);
      State CustomTs = new State(4, 4);

      // Declare heuristics
      Heuristic[] heuristics = new Heuristic[3];
      heuristics[0] = Heuristics::Heuristic1; //HEURISTICA BASADA EN DINERS GASTATS
      heuristics[1] = Heuristics::Heuristic2; //HEURISTICA BASADA EN DISTÀNCIA (EUCLIDIANA)
      heuristics[2] = Heuristics::Heuristic3; //HEURISTICA BASADA EN TEMPS (40%) I DINERS(60%)

      // TODO: Declare search algorithms (if desired, you can move this under "Run experiments")
      Search bestFirstCostO = new BestFirst(OriginalMap.getCostMap(), heuristics[0]);
      Search bestFirstDistanceO = new BestFirst(OriginalMap.getCostMap(), heuristics[1]);
      Search bestFirstDistICostO = new BestFirst(OriginalMap.getCostMap(), heuristics[2]);
      Search AStarCostO = new AStar(OriginalMap.getCostMap(), heuristics[0]);
      Search AStarDistanceO = new AStar(OriginalMap.getCostMap(), heuristics[1]);
      Search AStarDistICostO = new AStar(OriginalMap.getCostMap(), heuristics[2]);

      Search bestFirstCostC = new BestFirst(CustomMap.getCostMap(), heuristics[0]);
      Search bestFirstDistanceC = new BestFirst(CustomMap.getCostMap(), heuristics[1]);
      Search bestFirstDistICostC = new BestFirst(CustomMap.getCostMap(), heuristics[2]);
      Search AStarCostC = new AStar(CustomMap.getCostMap(), heuristics[0]);
      Search AStarDistanceC = new AStar(CustomMap.getCostMap(), heuristics[1]);
      Search AStarDistICostC = new AStar(CustomMap.getCostMap(), heuristics[2]);

      // TODO: Run experiments
      

      // TODO: Show results
      System.out.println("===========================================\n" +
                        "ALGORITHM: BEST FIRST      HEURISTIC: COST\n" +
                        "===========================================");
      SearchAndshowStats(bestFirstCostO, bestFirstCostC, OriginalIs, OriginalTs, CustomIs, CustomTs);
      System.out.println("\n===============================================\n" +
                        "ALGORITHM: BEST FIRST      HEURISTIC: DISTANCE\n" +
                        "===============================================");
      SearchAndshowStats(bestFirstDistanceO, bestFirstDistanceC, OriginalIs, OriginalTs, CustomIs, CustomTs);
      System.out.println("\n======================================================\n" +
                          "ALGORITHM: BEST FIRST      HEURISTIC: DISTANCE & COST\n" +
                          "======================================================");
      SearchAndshowStats(bestFirstDistICostO, bestFirstDistICostC, OriginalIs, OriginalTs, CustomIs, CustomTs);
      System.out.println("\n===================================\n" +
                        "ALGORITHM: A*      HEURISTIC: COST\n" +
                        "===================================");
      SearchAndshowStats(AStarCostO, AStarCostC, OriginalIs, OriginalTs, CustomIs, CustomTs);
      System.out.println("\n=======================================\n" +
                        "ALGORITHM: A*      HEURISTIC: DISTANCE\n" +
                        "=======================================");
      SearchAndshowStats(AStarDistanceO, AStarDistanceC, OriginalIs, OriginalTs, CustomIs, CustomTs);
      System.out.println("\n==============================================\n" +
                          "ALGORITHM: A*      HEURISTIC: DISTANCE & COST\n" +
                          "==============================================");
      SearchAndshowStats(AStarDistICostO, AStarDistICostC, OriginalIs, OriginalTs, CustomIs, CustomTs);
    }


    private static void SearchAndshowStats(Search algoO, Search algoC, State OriginalIs, State OriginalTs, State CustomIs, State CustomTs) {
      List<String> path;
      int visitedStates;
      float cost;

      System.out.println("----ORIGINAL MAP STATISTICS----");
      System.out.print("Path: ");
      path = algoO.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nTime to travel: "+path.size()+" days");
      cost = algoO.calculateCost(OriginalIs, path);
      System.out.println("Cost: "+cost);
      System.out.println("Cost-optimal: "+(cost > 33.0f ? "No" : "Yes"));
      System.out.println("Visited States: "+visitedStates);
      System.out.println("\n----CUSTOM MAP STATISTICS----");
      System.out.print("Path: ");
      path = algoC.DoSearch(CustomIs, CustomTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nTime to travel: "+path.size()+" days");
      cost = algoC.calculateCost(CustomIs, path);
      System.out.println("Cost: "+cost);
      System.out.println("Cost-optimal: "+(cost > 25.5f ? "No" : "Yes"));
      System.out.println("Visited States: "+visitedStates);
    }
}



