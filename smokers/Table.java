import java.util.ArrayList;
import java.util.Random;

public class Table {

    private ArrayList<String> allElements = new ArrayList<String>();
    private ArrayList<String> supplierElements = new ArrayList<String>();

    public Table()
    {
        allElements.add("tobacco");
        allElements.add("paper");
        allElements.add("matches");
    }

    public void setAgentElements()
    {
        Random random = new Random();

        supplierElements.clear();

        ArrayList<String> copyAllElements = (ArrayList<String>) allElements.clone();

        int element1 = random.nextInt(copyAllElements.size());
        supplierElements.add(copyAllElements.get(element1));

        copyAllElements.remove(element1);
        int element2 = random.nextInt(copyAllElements.size());
        supplierElements.add(copyAllElements.get(element2));
    }

    public boolean isEmpty()
    {
        return (supplierElements.size() == 0);
    }

    public synchronized String getAgentElements()
    {
        notifyAll();
        return supplierElements.toString();
    }

    public synchronized String getSmokerElement(int pElement)
    {
        try {
            this.wait();
        } catch (Exception e) {}
        return allElements.get(pElement);
    }

    public boolean hasElement(String elementName)
    {
        return (supplierElements.contains(elementName));
    }

    public synchronized void pause()
    {
        try {
            this.wait();
        } catch (Exception e) {}
    }
}
