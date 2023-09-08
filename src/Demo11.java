// Program to using final variable within method
// to create local constant.
public class Demo11 {
    public static void main( String args[ ] )
    {
        double r = 10.0, a;
        final double PI = 3.14159;
        a = PI * r * r;
        System.out.println("Area of Circle : " + a);
    }
}
