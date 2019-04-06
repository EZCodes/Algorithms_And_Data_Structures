import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    Each contestant walks at a given estimated speed.
 *    The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

/*class Intersection{
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
*/
public class CompetitionFloydWarshall {

	private int sA;
	private int sB;
	private int sC;
	private Intersection[] city;
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
    */
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
 	
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
    	double matrix[][] = makeGraphMatrix(this.city);
    	// intermediate vertex
    	for(int i=0; i<matrix.length; i++)
    	{
    		// start vertex
    		for (int j=0; j<matrix.length; j++)
    		{
    			// end vertex
    			for(int k=0; k<matrix.length; k++)
    			{
    				if(matrix[j][i] + matrix[i][k] < matrix[j][k])
    					matrix[j][k] = matrix[j][i] + matrix[i][k];
    			}
    		}
    	}
    	double maxPath = findMaxPath(matrix);
    	if(maxPath == Double.POSITIVE_INFINITY)
    		return -1;
    	else
    	{
    		minimumTime = (maxPath*1000)/leastSpeed;
    		return (int) (minimumTime+1);
    	}
    		
    }
    private double[][] makeGraphMatrix(Intersection[] city)
    {
    	double matrix[][] = new double[city.length][city.length];
    	// initialize with infinites
    	for(int i=0; i<matrix.length; i++)
    	{
    		for(int j=0; j<matrix.length; j++)
    		{
    			matrix[i][j] = Double.POSITIVE_INFINITY;
    		}
    	}
    	// make a matrix
    	for(int i = 0; i<matrix.length; i++)
    	{
    		int amountOfStreets = city[i].outgoingStreets.size();
    		for(int j=0; j<amountOfStreets; j++)
    		{
    			matrix[i][city[i].outgoingStreets.get(j).destination] = city[i].outgoingStreets.get(j).distance;
    		}
    	}
    	return matrix;
    }
    private double findMaxPath(double matrix[][])
    {
    	double maxPath = -1;
    	for(int i=0; i<matrix.length; i++ )
    	{
    		for(int j=0; j<matrix.length; j++)
    		{
    			if(matrix[i][j]>maxPath)
    				maxPath = matrix[i][j];
    		}
    	}
    	return maxPath;
    }

}