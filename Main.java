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
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
    };
    public static Map CustomMap = new Map(CustomCharMap);

    public static void main(String args[]){      

      // TODO: Declare map

      // TODO: Declare initial and target states
      State OriginalIs = new State(0, 0);
      State OriginalTs = new State(9, 9);
      State CustomIs = new State(0, 0);
      State CustomTs = new State(5, 5);
      List<String> path;
      int visitedStates;

      // Declare heuristics
      Heuristic[] heuristics = new Heuristic[3];
      heuristics[0] = Heuristics::Heuristic1; //HEURISTICA BASADA EN DINERS GASTATS
      heuristics[1] = Heuristics::Heuristic2; //HEURISTICA BASADA EN DISTÀNCIA (EUCLIDIANA)
      heuristics[2] = Heuristics::Heuristic3; //HEURISTICA BASADA EN TEMPS (40%) I DINERS(60%)

      // TODO: Declare search algorithms (if desired, you can move this under "Run experiments")
      Search bestFirstCost = new BestFirst(OriginalMap.getCostMap(), heuristics[0]);
      Search bestFirstDistance = new BestFirst(OriginalMap.getCostMap(), heuristics[1]);
      Search bestFirstDistICost = new BestFirst(OriginalMap.getCostMap(), heuristics[2]);
      Search AStarCost = new AStar(OriginalMap.getCostMap(), heuristics[0]);
      Search AStarDistance = new AStar(OriginalMap.getCostMap(), heuristics[1]);
      Search AStarDistICost = new AStar(OriginalMap.getCostMap(), heuristics[2]);

      // TODO: Run experiments
      

      // TODO: Show results
      System.out.println("===========================================\n" +
                        "ALGORITHM: BEST FIRST      HEURISTIC: COST\n" +
                        "===========================================");
      System.out.print("Path: ");
      path = bestFirstCost.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nCost: "+bestFirstCost.calculateCost(OriginalIs, path));
      System.out.println("Visited States: "+visitedStates);
      System.out.println("\n===============================================\n" +
                        "ALGORITHM: BEST FIRST      HEURISTIC: DISTANCE\n" +
                        "===============================================");
      System.out.print("Path: ");
      path = bestFirstDistance.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nCost: "+bestFirstDistance.calculateCost(OriginalIs, path));
      System.out.println("Visited States: "+visitedStates);
      System.out.println("\n======================================================\n" +
                          "ALGORITHM: BEST FIRST      HEURISTIC: DISTANCE & COST\n" +
                          "======================================================");
      System.out.print("Path: ");
      path = bestFirstDistICost.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nCost: "+bestFirstDistance.calculateCost(OriginalIs, path));
      System.out.println("Visited States: "+visitedStates);
      System.out.println("\n===================================\n" +
                        "ALGORITHM: A*      HEURISTIC: COST\n" +
                        "===================================");
      System.out.print("Path: ");
      path = AStarCost.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nCost: "+bestFirstCost.calculateCost(OriginalIs, path));
      System.out.println("Visited States: "+visitedStates);
      System.out.println("\n=======================================\n" +
                        "ALGORITHM: A*      HEURISTIC: DISTANCE\n" +
                        "=======================================");
      System.out.print("Path: ");
      path = AStarDistance.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nCost: "+bestFirstDistance.calculateCost(OriginalIs, path));
      System.out.println("Visited States: "+visitedStates);
      System.out.println("\n==============================================\n" +
                          "ALGORITHM: A*      HEURISTIC: DISTANCE & COST\n" +
                          "==============================================");
      System.out.print("Path: ");
      path = AStarDistICost.DoSearch(OriginalIs, OriginalTs);
      visitedStates = Integer.parseInt(path.getLast());
      path.removeLast();
      path.forEach(dir -> System.out.print(dir+" "));
      System.out.println("\nCost: "+bestFirstDistance.calculateCost(OriginalIs, path));
      System.out.println("Visited States: "+visitedStates);
    }
}



