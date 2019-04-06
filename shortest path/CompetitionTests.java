import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 75, 71, 55);
        assertEquals(34, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("1000EWD.txt", 75, 71, 55);
        assertEquals(26, dijkstra.timeRequiredforCompetition());
 /*
        dijkstra = new CompetitionDijkstra("input-A.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-B.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-C.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-D.txt", 75, 71, 88);
        assertEquals(1, dijkstra.timeRequiredforCompetition());

        dijkstra = new CompetitionDijkstra("input-E.txt", 75, 71, 88);
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
        assertEquals(-1, dijkstra.timeRequiredforCompetition()); 

    }

    @Test
    public void testFWConstructor() {
    	CompetitionFloydWarshall FW = new CompetitionFloydWarshall("tinyEWD.txt", 75, 71, 55);
        assertEquals(34, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("1000EWD.txt", 75, 71, 55);
        assertEquals(26, FW.timeRequiredforCompetition());
        /*
        FW = new CompetitionFloydWarshall("input-A.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-B.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-C.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
        FW = new CompetitionFloydWarshall("input-D.txt", 75, 71, 88);
        assertEquals(1, FW.timeRequiredforCompetition());
        
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
        
       // FW = new CompetitionFloydWarshall("input-K.txt", 75, 71, 88);
       // assertEquals(1, FW.timeRequiredforCompetition()); 
    }
    
}