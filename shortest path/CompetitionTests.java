import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * 
 * @author Jerzy Jaskuc
 * 
 * Question 1:
 * As my data structures i use classes that represent intersections and streets. Intersection basically contains
 * a collection(ArrayList) of streets going out of that intersection. Then the overall graph, the city is just an array of all intersections.
 * I use this data structure cause it's intuitive, readable and information is easily accessible as well as it can be easily converted into other forms.
 * Futhermore, in Dijksta, I use the Prioryty Queue for the algorithm, which is based on unordered list, as we are not focused on performance and it's
 * the simplest way to implement the queue and it behaves well with high density .
 * 
 * In Floyd-Warshall for computing i use matrix which contain the distances from one vertex to another (as in default implementation),
 * The matrix is built from java classes i mentioned previously. Matrix allows for quick and simple computing of the shortest path.
 * 
 * 
 * Question 2:
 * The biggest difference between the algorithms is that Dijkstra is finding the shortest path from one vertex to the others, 
 * while Floyd-Warshall finds shortest paths between all pairs of vertices in the graph. In our case when we need to compute all paths to choose the correct time , i would use 
 * Floyd-Warshall as we need to find paths between all pairs of vertices and Dijkstra would require a separate run for each vertex, which
 * increases it running time by a factor of V.
 * 
 * For the density of the graph, it heavily affects the performance of the Dijkstra as it's running time is dependent on
 * the amount of edges in a graph, since it checks every edge to find the shortest path( O(VE log V) which can go to (V^3 log V) in complete graph). 
 * The running time of Floyd-Warshall however would be unaffected as it only depends on the amount of vertices (Stable O(V^3)
 *
 * Another difference is that Dijkstra does not work with negative weights and Floyd-Warshall does(not negative cycles however)
 * 
 * If we need to find the shortest path from one vertex to another, i would use Dijkstra as it's quick for just finding one shortest path.
 * However, if i needed to calculate all of the shortest paths between vertices in a dense graph i would choose Floyd-Warshall
 * as it would offer better performance in that case. Also, if there were negative weights, Floyd-Warshall would be the way to go in that case too.
 */
public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 75, 71, 55);
        assertEquals(34, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("1000EWD.txt", 75, 71, 55);
        assertEquals(26, dijkstra.timeRequiredforCompetition());
 
      //  dijkstra = new CompetitionDijkstra("input-A.txt", 75, 71, 88);
      //  assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-B.txt",60, 80, 50);
        assertEquals(10000, dijkstra.timeRequiredforCompetition());//

      //  dijkstra = new CompetitionDijkstra("input-C.txt", 75, 71, 88);
       // assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-D.txt", -1, -1, -1);
        assertEquals(-1, dijkstra.timeRequiredforCompetition());

       /* dijkstra = new CompetitionDijkstra("input-E.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-F.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-G.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-H.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-I.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());
		*/
        dijkstra = new CompetitionDijkstra("input-J.txt", 75, 71, 88);
        assertEquals(-1, dijkstra.timeRequiredforCompetition()); //
        
        dijkstra = new CompetitionDijkstra("input-K.txt", 73, 76, 81);
        assertEquals(220, dijkstra.timeRequiredforCompetition()); 
        
        dijkstra = new CompetitionDijkstra(null, 73, 76, 81);
        assertEquals(-1, dijkstra.timeRequiredforCompetition());

    }

    @Test
    public void testFWConstructor() {
    	CompetitionFloydWarshall FW = new CompetitionFloydWarshall("tinyEWD.txt", 75, 71, 55);
        assertEquals(34, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("1000EWD.txt", 75, 71, 55);
        assertEquals(26, FW.timeRequiredforCompetition());
        
      //  FW = new CompetitionFloydWarshall("input-A.txt", 75, 71, 88);
      //  assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-B.txt", 60, 80, 50);
        assertEquals(10000, FW.timeRequiredforCompetition());
        
       // FW = new CompetitionFloydWarshall("input-C.txt", 75, 71, 88);
       // assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-D.txt", -1, -1, -1);
        assertEquals(-1, FW.timeRequiredforCompetition());
        /*
        FW = new CompetitionFloydWarshall("input-E.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-F.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-G.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-H.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-I.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        */
        FW = new CompetitionFloydWarshall("input-J.txt", 75, 71, 88);
        assertEquals(-1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-K.txt", 73, 76, 81	);
        assertEquals(220, FW.timeRequiredforCompetition()); 
        
        FW = new CompetitionFloydWarshall(null, 73, 76, 81	);
        assertEquals(-1, FW.timeRequiredforCompetition()); 
    }
    
}