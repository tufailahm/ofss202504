package collectiondemos;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class TextFilter {
    public static boolean isAnuExists(String s) {
        return s.equals("Anu");
    }
    public static int sortText(String s1, String s2) {
        return s1.compareTo(s2);
    }
}

class TextFilter2 implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.equals(s);
    }
}

public class DemoMethodReferences {

    public static void main(String[] args) {
        TextFilter filter = new TextFilter();
        List<String> list = new ArrayList<>();
        list.add("remove A");
        list.add("Anu");
        list.add("Zoo");
        list.add("Zainab");
        list.add("Anu");
        list.add("Anu");
        list.add("Mukesh");

      //  list.removeIf((s) -> TextFilter.isAnuExists(s));
        list.removeIf(TextFilter::isAnuExists);

        list.sort(TextFilter::sortText);
        System.out.println(list);




    }
}
