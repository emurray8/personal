public class Smoker extends Thread {

    private Table m_table = new Table();
    private String m_element;
    private int m_elementNumber;
    private Supplier m_supplier;

    public Smoker(Table table, int elementNumber, String pName, Supplier supplier)
    {
        m_elementNumber = elementNumber;
        this.m_table = table;
        setName(pName);
        m_supplier = supplier;
    }

    @Override
    public void run()
    {
        while(true)
        {
            m_element = m_table.getSmokerElement(m_elementNumber);

            if (!m_table.hasElement(m_element) && !m_table.isEmpty())
            {
                System.out.println(getName() + " has " + m_element + ".");
                try {
                    doSmoke();
                    System.out.println(getName() + " notifies the supplier.");
                    m_supplier.wake();
                } catch (Exception e) {}
            }
        }
    }

    public synchronized void doSmoke() throws Exception
    {
        System.out.println(getName() + " rolls the cigarette.");
        System.out.println(getName() + " smokes.");
        Thread.sleep(1000);
        System.out.println(getName() + " has finished.");
    }

}
