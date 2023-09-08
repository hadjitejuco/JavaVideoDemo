// Program to use final variable to Create constant.
public class Demo10 {
    
    final static double PI = 3.14159;
    
    public static void main( String args[ ] )
    {
        double r = 10.0, a;
        
        a = PI * r * r;
        
        System.out.println("Area of Circle : " + a);
    }
}
