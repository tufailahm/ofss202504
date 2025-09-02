package collectiondemos;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

 class LongProductsNames
        implements Predicate<String> {
    public boolean test(String product) {
        return product.length() > 3;
    }
}
class ShortProductsNames
        implements Predicate<String> {
    public boolean test(String product) {
        return product.length() == 2;
    }
}
public class Demo3 {

    public static void main(String[] args) {

    }
}
