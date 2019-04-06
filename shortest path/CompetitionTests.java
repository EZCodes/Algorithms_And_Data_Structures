import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra dijkstra = new CompetitionDijkstra("1000EWD.txt", 75, 71, 88);
    	System.out.println(dijkstra.timeRequiredforCompetition());
        assertEquals(2, dijkstra.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor() {
    	CompetitionFloydWarshall FW = new CompetitionFloydWarshall("1000EWD.txt", 75, 71, 88);
    	System.out.println(FW.timeRequiredforCompetition());
        assertEquals(2, FW.timeRequiredforCompetition());
    }
    
}