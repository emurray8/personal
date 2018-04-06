import java.awt.Point;
import java.util.*;
public class Worker{

	public static void main(String args[]){
		new Worker().go();
	}
	private Point closest;

	public void go(){
    	List<Double> numbers = new ArrayList<>();
    	Scanner scan = new Scanner(System.in);
    	double val = scan.nextDouble();
    	while (val != -1)
    	{
      		numbers.add(val);
      		val = scan.nextDouble();
    	}
    	List<Point> points = new ArrayList<>();
    	Point ref = new Point(numbers.get(0).intValue(),numbers.get(1).intValue());
    	//System.out.println("ref>"+ref);
    	for(int j = 2; j < numbers.size(); j+=2){
    		points.add(new Point(numbers.get(j).intValue(),numbers.get(j+1).intValue()));
    	}
    	/*for (Point p : points){
      		System.out.println(p);
    	}*/
    	double refDist = Math.sqrt((Math.pow(ref.getX(), 2) + Math.pow(ref.getY(),2)));
    	/*double c = Math.sqrt((Math.pow(points.get(0).getX(), 2) + Math.pow(points.get(0).getY(),2)));
    	double distance = c-refDist;
    	double closestDist = distance;
    	closest = new Point(points.get(0));
    	for(int i = 0; i < points.size();  i++){
    		c = Math.sqrt((Math.pow(points.get(i).getX(), 2) + Math.pow(points.get(i).getY(),2)));
    		distance = c-refDist;
    		if(distance <= closestDist){
    			closestDist = distance;
    			closest = points.get(i);
    		}

    	}*/
    	double distance = Math.sqrt((Math.pow(ref.getX()-points.get(0).getX(), 2) + Math.pow(ref.getY()-points.get(0).getY(),2)));
    	double closestDist = distance;
    	Point closest = new Point(points.get(0));
    	for(int i = 0; i < points.size();  i++){
    		distance = Math.sqrt((Math.pow(ref.getX()-points.get(i).getX(), 2) + Math.pow(ref.getY()-points.get(i).getY(),2)));
    		if(distance <= closestDist){
    			closestDist = distance;
    			closest = points.get(i);
    		}

    	}
    	System.out.println(closest.getX());
    	System.out.println(closest.getY());
 
  				
		
	}

}