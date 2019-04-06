import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    Each contestant walks at a given estimated speed.
 *    The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

class Intersection{
	ArrayList<Street> outgoingStreets;
	// key street, value length
	Intersection(){
		outgoingStreets = new ArrayList<Street>();
	}
	
}
class Street{
	int destination;
	double distance;
	Street(int destination, double distance)
	{
		this.destination = destination;
		this.distance = distance;
	}
}

public class CompetitionDijkstra {

	private int sA;
	private int sB;
	private int sC;
	private Intersection[] city;
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
 	
    	File cityFile = new File(filename);
    	this.sA = sA;
    	this.sB = sB;
    	this.sC = sC;
    	try {
			BufferedReader in = new BufferedReader(new FileReader(cityFile));
			String number = in.readLine();
			int amountOfIntersections = Integer.parseInt(number);
			this.city = new Intersection[amountOfIntersections];
			for(int i=0; i<city.length;i++)
			{
				city[i] = new Intersection();
			}
			number = in.readLine();
			int streetsNumb = Integer.parseInt(number);
			int position;
			for(int i=0; i<streetsNumb; i++)
			{
				position = 0;
				number = in.readLine();
				if(number != null) 
				{
					String[] numbers = number.split("\\s+");
					if(numbers[0].equals("")) // handing the case when there's space in front
						position++;
					int source = Integer.parseInt(numbers[position++]);
					int destination = Integer.parseInt(numbers[position++]);
					double distance = Double.parseDouble(numbers[position++]);
					city[source].outgoingStreets.add(new Street(destination,distance));
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
    	double minimumTime = -2;
    	int leastSpeed = Math.min(sA, sB);
    	leastSpeed = Math.min(leastSpeed, sC);
    	for(int finish=0;finish<city.length;finish++)
    	{

    		double[] distTo = new double[city.length];
    		int edgeTo[] = new int[city.length];
    		ArrayList<Integer> queue = new ArrayList<Integer>();
    		queue.add(finish);
    		// initialize edgeTo and distTo
    		for(int k=0; k<edgeTo.length; k++)
    		{
    			edgeTo[k] = -1;
    			distTo[k] = -1;
    		}
    		distTo[finish] = 0;
    		edgeTo[finish] = finish;
    		// counter also indicates if vertex visited
    		int counter = 0;
    		while(counter < queue.size())
    		{
    			int currentIntersectionNumber = queue.get(counter);
    			Intersection currentIntersection = city[currentIntersectionNumber];
    			for(int j=0; j<currentIntersection.outgoingStreets.size(); j++)
    			{
    				Street relaxedStreet = currentIntersection.outgoingStreets.get(j);
    				if(relaxedStreet.distance + distTo[currentIntersectionNumber] < distTo[relaxedStreet.destination] || distTo[relaxedStreet.destination] == -1)
    				{
    					distTo[relaxedStreet.destination] = relaxedStreet.distance + distTo[currentIntersectionNumber];
    					edgeTo[relaxedStreet.destination] = currentIntersectionNumber;
    				}   
    				if(!queue.contains(relaxedStreet.destination))
    					queue.add(relaxedStreet.destination);
    			}
    			counter++;
    		}
    		Arrays.sort(distTo);
    		double longestDistance = distTo[distTo.length-1];
    		boolean isConnectedCity = true;
    		for(int l=0;l<edgeTo.length;l++)
    		{
    			if(edgeTo[l] == -1)
    				isConnectedCity = false;
    		}
    		if(minimumTime == -2)
    		{
    			minimumTime = (longestDistance*1000)/leastSpeed;
    		}
    		else if(!isConnectedCity)
    			return -1;
    		else if(minimumTime != -1)
    			minimumTime = Math.max(minimumTime, (longestDistance*1000)/leastSpeed);
    	}
    		
    	
        return (int)(minimumTime+1) ;
    }

}