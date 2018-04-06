import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author evan
 */
public class Master {

  public static void main(String args[]) throws Exception
  {
    new Master().go();
  }

  private void go() throws Exception
  {
    System.out.println();
    System.out.println("Starting process 1...");
    Process p1 = new ProcessBuilder("java", "Worker", "stats1.txt").start();
    System.out.println("Starting process 2...");
    Process p2 = new ProcessBuilder("java", "Worker", "stats2.txt").start();
    System.out.println("Starting process 3...");
    Process p3 = new ProcessBuilder("java", "Worker", "stats3.txt").start();
    System.out.println("Starting process 4...");
    Process p4 = new ProcessBuilder("java", "Worker", "stats4.txt").start();
    printResults(p1);
    printResults(p2);
    printResults(p3);
    printResults(p4);	
  }

  private void printResults(Process p) throws Exception{
    p.waitFor();
        
    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
    String line = br.readLine();
    while (line != null)
    {
        System.out.println(line);
        line = br.readLine();
    }
        
    }
}
