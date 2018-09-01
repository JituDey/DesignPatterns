public class Dog  implements Cloneable {
    String name;
    int age;
    String color;
    Eye eye;
    Tail tail;
    Leg leg;
    Ear ear;

    public Dog(String name, int age, String color, Eye e, Ear ear, Tail t, Leg l){
        this.name=name;
        this.age=age;
        this.color=color;
        this.eye=e;
        this.ear=ear;
        this.leg=l;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return new Dog(this.name, this.age, this.color, this.eye, this.ear, this.tail, this.leg);
     }
}