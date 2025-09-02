package collectiondemos;

public interface Music {
    void play();
    void stop();
}
interface Calculator
{
    int sum(int a, int b);
}
class CalculatorImpl implements Calculator
{
    @Override
    public int sum(int a, int b)
    {
        return a + b;
    }
}
class A
{
    public static void main(String[] args) {
        //1st Way
            Calculator c = new CalculatorImpl();
        System.out.println( c.sum(1, 2));

        //2nd Way
        Calculator c2 = new Calculator()
        {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        System.out.println(c2.sum(1, 2));

        Calculator c3 = (a, b) -> a + b;
        System.out.println(c3.sum(1, 2));


    }
}