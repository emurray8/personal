import java.io.*;
import java.util.*;
public class Master{

  private List<String[]> m_top25 = new ArrayList<>();
  private List<String[]> m_top5 = new ArrayList<>();

  public static void main(String[] args){
    new Master().go();
  }
  public void go(){
    try{
      Process p1 = new ProcessBuilder("java", "Worker", "2011").start();
      Process p2 = new ProcessBuilder("java", "Worker", "2012").start();
      Process p3 = new ProcessBuilder("java", "Worker", "2013").start();
      Process p4 = new ProcessBuilder("java", "Worker", "2014").start();
      Process p5 = new ProcessBuilder("java", "Worker", "2015").start();
      printResults(p1);
      printResults(p2);
      printResults(p3);
      printResults(p4);
      printResults(p5);

    }catch(Exception e){
      System.out.println("Process launch failure");
    }
    calculateTopFive();
    int count = 1;
    System.out.printf("      %s           %s       %s     %s%n", "Name", "Team", "OPS", "Year");
    for(String[] strAry : m_top5){
      System.out.printf("%d%s   %s    %s    %.3f    %s%n", count,". ",strAry[0],strAry[1],Double.parseDouble(strAry[2]),strAry[3]);
      count++;
    }
  }
  private void printResults(Process p) throws Exception{
      p.waitFor();

      BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
      String line = "";
      while ((line = br.readLine()) != null)
      {
          String[] temp = line.split(",");
          m_top25.add(temp);
      }
    }
    public void calculateTopFive(){
      List<Double> topOPS = new ArrayList<Double>();
      String[][] best = new String[5][];
      for(int i = 0; i < m_top25.size(); i++){
        topOPS.add(Double.parseDouble(m_top25.get(i)[2]));
      }
      Collections.sort(topOPS);
      Collections.reverse(topOPS);
      for(int i = 0; i < m_top25.size(); i++){
        double current = Double.parseDouble(m_top25.get(i)[2]);
        if(topOPS.get(0) == current)
          best[0] = m_top25.get(i);
        if(topOPS.get(1) == current)
          best[1] = m_top25.get(i);
        if(topOPS.get(2) == current)
          best[2] = m_top25.get(i);
        if(topOPS.get(3) == current)
          best[3] = m_top25.get(i);
        if(topOPS.get(4) == current)
          best[4] = m_top25.get(i);
      }
      for(String[] strAry : best){
        m_top5.add(strAry);
      }
    }
}
