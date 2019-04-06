import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra dijkstra = new CompetitionDijkstra("1000EWD.txt", 1, 2, 3);
    	System.out.println(dijkstra.timeRequiredforCompetition());
        assertEquals(2, dijkstra.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor() {
        //TODO
    }

    //TODO - more tests
    
}