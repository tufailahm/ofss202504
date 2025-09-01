package com.training.inheritdemos;

class Animal
{
    int age=100;
    String name;
    public void sleep(){
        System.out.println("Animal sleep");
    }
    public void eat(){
        System.out.println("Animal eat");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Animal finalize");
    }
}
class Dog extends Animal
{
    String breed;
    int age=90;
    public void fetchBall(){
        int age=1999;
        System.out.println("Dog fetch ball :"+age);
        System.out.println("Dog fetch ball :"+this.age);
        System.out.println("Dog fetch ball :"+super.age);
    }

    @Override
    public void eat() {
        System.out.println("Dog eat");
    }
    protected void finalize() throws Throwable {
        System.out.println("Dog finalize");
    }
}
class Bird extends Animal
{
    public void fly(){
        System.out.println("Bird fly");
    }
    protected void finalize() throws Throwable {
        System.out.println("Bird finalize");
    }
}
class Men extends Animal {

}
public class Demo1 {
    public static void main(String[] args) {
//        //way 1
//        System.out.println("Way 1");
//
//        Dog d=new Dog();
//                d.eat();
//                d.sleep();
//                d.fetchBall();
//        Bird b=new Bird();
//                b.eat();
//                b.sleep();
//                b.fly();

                //neha
        System.out.println("Way 2");
            Animal a=new Dog();
            a.sleep();
            a.eat();
            Dog d2=(Dog)a;
            if(d2 instanceof  Dog)
                    d2.fetchBall();

            a = new Bird();
            Bird  b2=(Bird)a;
            a.eat();
            a.sleep();
            b2.fly();
            a=null;
            b2=null;
            d2=null;
            System.gc();
    }
}