import java.util.*;
import java.io.*;
import java.util.concurrent.*;
public class Main{
  private Matrix m_matrix;
  private Matrix b;
  private Matrix a;

    public static void main(String args[])throws Exception{
      new Main().go();
    }
    public void go()throws Exception{
      Scanner in = new Scanner(System.in);

      a = new Matrix(in.nextLine());

      b = new Matrix(in.nextLine());
      System.out.println(multiply(a,b));
      writeOut();
    }

    private void writeOut() throws Exception{
      PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
      writer.write(m_matrix.toString());
      writer.close();
    }

    private int multiply(Matrix A, Matrix B) throws Exception{
        //int products[] = new int[A.size()];
        m_matrix = new Matrix(a.getRows(), b.getCols());
        List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
        for (int c = 0 ; c < A.getRows(); c++ )
        {
          for (int d = 0 ; d < B.getCols() ; d++ )
          {
          final int item = c;
          final int item2 = d;

          Callable<Boolean> task = () ->
          {
                int total = 0;
                for (int k = 0 ; k < B.getRows() ; k++ )
                {
                  total += A.getCell(item, k)*B.getCell(k, item2);
                  //sum = sum + A.get(item).get(k)*B.get(k).get(item2);
                }
                m_matrix.setCell(item, item2, total);


            return true;
          };
          tasks.add(task);

          }
        }


        ExecutorService executor = Executors.newFixedThreadPool(50);
        List<Future<Boolean>> futures = executor.invokeAll(tasks);

        for (Future<Boolean> f : futures)
        {
          if (!f.get())
          throw new Exception("Thread completion error!");
        }

        executor.shutdown();

        return m_matrix.getCellTotal();

    }

}
