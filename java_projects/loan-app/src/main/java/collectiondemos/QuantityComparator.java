package collectiondemos;

import java.util.Comparator;

public class QuantityComparator implements Comparator<Product>
{

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getQuantity() > o2.getQuantity() ? 1 : -1;
    }
}
