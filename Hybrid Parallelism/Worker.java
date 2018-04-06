import java.util.concurrent.*;
import java.util.*;
import java.io.*;
public class Worker{
  private List<String[]> m_players = new ArrayList<>();
  private List<String[]> m_finalists = Collections.synchronizedList(new ArrayList<String[]>());
  private List<String[]> m_topfive = new ArrayList<>();
  private List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
  private String m_file;
  private String m_year;

  public static void main(String[] args) throws Exception{
    new Worker(args);
  }

  public Worker(String[] args){
    m_year = args[0];
    m_file = "BatStatsByYear/" + m_year + ".csv";
    BufferedReader br = null;
	  String line = "";
  	try {
  		br = new BufferedReader(new FileReader(m_file));
      br.readLine();
  		while ((line = br.readLine()) != null) {
        String[] player = line.split(",");
        m_players.add(player);
      }
    }catch(Exception e){
      System.out.println("File Not Found");
      System.exit(0);
    }
    try{
      parseChunks();
    }catch(Exception e){
      System.out.println("Parsing Exception");
    }
    calculateTopFive();
    for(String[] strAry : m_topfive){
      for(String str : strAry){
        System.out.print(str + ",");
      }
      System.out.println("");
    }
  }

  public void parseChunks() throws Exception{
    int[] groups = getDistributions(m_players.size(), 5);
    int threadEnd = groups[0];
    int threadStart = 0;
    int threadCount = 1;
    for(int i = 0; i < groups.length; i++){
      final int start = threadStart;
      final int end = threadEnd;
      final int count = threadCount;
      Callable<Boolean> task = () ->
      {
        getHighAB(start, end);
        return true;
      };
      if(i != groups.length-1)
      threadEnd+=groups[i+1];
      threadStart+=groups[i];
      threadCount++;
      tasks.add(task);
    }
    ExecutorService executor = Executors.newFixedThreadPool(5);
    List<Future<Boolean>> futures = executor.invokeAll(tasks);

    for (Future<Boolean> f : futures)
    {
      if (!f.get())
      throw new Exception("Thread completion error!");
    }

    executor.shutdown();

  }


  public void getHighAB(int start, int end){
	  for(int i = start; i < end; i++){
      if(Integer.parseInt(m_players.get(i)[7]) >= 400){
        m_finalists.add(new String[]{m_players.get(i)[1],m_players.get(i)[3],Double.toString(calculateOPS(m_players.get(i))),m_year});
      }
    }
  }
  public double calculateOPS(String[] player){
    Double ab = Double.parseDouble(player[7]);
    Double h = Double.parseDouble(player[9]);
    Double bb = Double.parseDouble(player[16]);
    Double twoB = Double.parseDouble(player[10]);
    Double threeB = Double.parseDouble(player[11]);
    Double hr = Double.parseDouble(player[12]);
    return (((h+bb)/(ab+bb)) + (((h-twoB-threeB-hr) + (2*twoB) + (3*threeB) + (4*hr))/ab));
    /*
    0,   1,   2,  3, 4,5, 6, 7,8,9,10,11,12,13, 14,15,16,17
    index,Name,Age,Tm,Lg,G,PA,AB,R,H,2B,3B,HR,RBI,SB,CS,BB,SO
    OPS	=	Onbase	Percentage	(OBP)	+	Slugging	Percentage	(SLG)
    Where:
    OBP	=	(H	+	BB)	/	(AB	+	BB)
    SLG	=	(	(H	-	2B	-	3B	-	HR)	+	(2	*	2B)	+	(3	*	3B)	+	(4	*HR	)	)	/	AB
   */
  }
  public void calculateTopFive(){
    List<Double> topOPS = new ArrayList<Double>();
    String[][] best = new String[5][];
    for(int i = 0; i < m_finalists.size(); i++){
      topOPS.add(Double.parseDouble(m_finalists.get(i)[2]));
    }
    Collections.sort(topOPS);
    Collections.reverse(topOPS);
    for(int i = 0; i < m_finalists.size(); i++){
      double current = Double.parseDouble(m_finalists.get(i)[2]);
      if(topOPS.get(0) == current)
        best[0] = m_finalists.get(i);
      if(topOPS.get(1) == current)
        best[1] = m_finalists.get(i);
      if(topOPS.get(2) == current)
        best[2] = m_finalists.get(i);
      if(topOPS.get(3) == current)
        best[3] = m_finalists.get(i);
      if(topOPS.get(4) == current)
        best[4] = m_finalists.get(i);
    }
    for(String[] strAry : best){
      m_topfive.add(strAry);
    }
  }
  public int[] getDistributions(int total, int divisor){
    int x = total%divisor;
    int[] groups = new int[divisor];
    for(int i = 0; i < divisor; i++){
      groups[i] = total/divisor;
    }
    int count = 0;
    for(int i = 0; i < x; i++){
        groups[count]++;
        count++;
        if(count == divisor-1)
        count = 0;
    }
    return groups;
  }
}
