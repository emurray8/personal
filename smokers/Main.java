
public class Main {

    public static void main(String[] args) {
        Table smokingtable = new Table();

        Supplier supplier = new Supplier(smokingtable);

        supplier.start();

        for (int i = 0; i < 3; i++)
        {
            Smoker smoker = new Smoker(smokingtable, i, "Smoker " + Integer.toString(i+1), supplier);
            smoker.start();
        }
    }
}
