import java.util.*;
import java.awt.Point;
import java.io.*;
public class Master{

	public static void main(String args[])throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the x coordinate of your reference point: ");
		int x = scan.nextInt();
		System.out.print("\nEnter the y coordinate of your reference point: ");
		int y = scan.nextInt();
		new Master().go(x,y);	
	}
	private static final int m = 100;
	private static final int g = 4;
	private static final int n = 80;
	private static final int gSize = n/g;
	private Point[] array = new Point[n];
	private Point refPoint;
	private List<Point> groupFinals = new ArrayList<>();

	public void go(int x, int y)throws Exception{

		populateArray();
		refPoint = new Point(x,y);
		List<Point> ptList = new ArrayList<>();
		for(int i = 0; i < array.length; i++){
			if(array[i] != null){
				ptList.add(array[i]);
				//printPoint(array[i]);
			}
		}
		List<Process> list = new ArrayList<>();
    	for (int i = 0; i < g; i++)
    	{
      		System.out.printf("Starting process %d ...%n",i+1);
      		Process p = new ProcessBuilder("java", "Worker").start();
      		sendParameters(p, generatePartialArray(array, g, gSize*i));
      		list.add(p);
    	}
    	for(Process p : list){
    		readResults(p);
    	}
    	/*for(Point d : groupFinals){
    		System.out.println(d);
    	} */
    	double refDist = Math.sqrt((Math.pow(refPoint.getX(), 2) + Math.pow(refPoint.getY(),2)));
    	double distance = Math.sqrt((Math.pow(refPoint.getX()-groupFinals.get(0).getX(), 2) + Math.pow(refPoint.getY()-groupFinals.get(0).getY(),2)));
    	double closestDist = distance;
    	Point closest = new Point(groupFinals.get(0));
    	for(int i = 0; i < groupFinals.size();  i++){
    		distance = Math.sqrt((Math.pow(refPoint.getX()-groupFinals.get(i).getX(), 2) + Math.pow(refPoint.getY()-groupFinals.get(i).getY(),2)));
    		if(distance <= closestDist){
    			closestDist = distance;
    			closest = groupFinals.get(i);
    		}

    	}
    	System.out.printf("%s%.0f%s%.0f%s\n","Closest point is (" , closest.getX() , "," , closest.getY(),")");

	}
	public void printPoint(Point p){
		System.out.printf("%s%.0f%s%.0f%s\n","(",p.getX(),",",p.getY(),")");
	}
  	public void readResults(Process p) throws Exception{
    	p.waitFor();
        List<Double> reads = new ArrayList<>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    	String line = br.readLine();
    	reads.add(Double.parseDouble(line));
    	line = br.readLine();
   		reads.add(Double.parseDouble(line));
    	groupFinals.add(new Point(reads.get(0).intValue(),reads.get(1).intValue()));
    	

        
    }
	public void sendParameters(Process p, Point[] points)throws Exception{
    	PrintWriter writer = new PrintWriter(new OutputStreamWriter(p.getOutputStream(), "UTF-8"));
    	writer.println(refPoint.getX());
    	writer.println(refPoint.getY());
    	for(int i = 0; i < points.length; i++){
    		writer.println(points[i].getX());
    		writer.println(points[i].getY());
    	}
    	writer.println(-1);
    	writer.flush();
	}
	public void populateArray(){
		Random rand = new Random();
		for(int i = 0; i < n; i++){
			int x = rand.nextInt(m);
			int y = rand.nextInt(m);
			array[i] = new Point(x,y);
			//System.out.println("Entry " + i + " :"+array[i]);
		}
	}
	public Point[] generatePartialArray(Point[] ary, int divisor, int index){
		Point[] temp = new Point[ary.length/divisor];
		for(int i = 0; i < temp.length; i++){
			temp[i] = ary[index];
			index++;
		}
		return temp;
	}

}