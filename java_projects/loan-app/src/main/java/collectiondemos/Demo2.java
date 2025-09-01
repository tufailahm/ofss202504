package collectiondemos;

import java.util.*;

public class Demo2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        Collections.sort(list);

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String temp = itr.next();
            if(temp.equals("a")) {
                itr.remove();
            }
            else {
                System.out.println(temp);
            }
        }

    }
}
