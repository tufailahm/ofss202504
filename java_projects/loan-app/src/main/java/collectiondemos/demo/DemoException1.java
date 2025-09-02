package collectiondemos.demo;

public class DemoException1 {

    public static void main(String[] args) {
        System.out.println("Hello World1");
        try {
            int i=1/0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
        System.out.println("Hello World2");
    }
}
