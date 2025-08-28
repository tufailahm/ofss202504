class Welcome
{
	public void display()
	{
		System.out.println("Welcome display called");
	}
	public static void main(String args[])
	{
		System.out.println("1. Welcome String ");
		Welcome w = new Welcome();
		int marks[] = {12,112};
		w.main(marks);
	}
	public static void main(int args[])
	{
		System.out.println("2. Welcome INT");
	}
}
public class Hello
{
	public static void main(String args[])
	{
		Welcome w = new Welcome();
		w.display();
		System.out.println("Hello");
	}
}
class A
{
}
class B
{
}