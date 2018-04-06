import java.util.Random;
public class Supplier extends Thread {

    private Table m_table;

    public Supplier(Table table)
    {
        m_table = table;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
							Random rand = new Random();
                Thread.sleep(rand.nextInt(500)+500);
            } catch (Exception e) {}
            m_table.setAgentElements();
            output("The supplier puts " + m_table.getAgentElements() + " on the table.");
            pause();
        }
    }

    public synchronized void wake()
    {
        try
        {
            notify();
        } catch(Exception e){}
    }


    public synchronized void pause()
    {
        try
        {
            this.wait();
        } catch (Exception e) {}
    }

    private void output(String pOutput)
    {
        System.out.println(pOutput);
    }
}
