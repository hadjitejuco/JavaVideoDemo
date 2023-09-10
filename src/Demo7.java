// Program to show dynamic variable initialization of variable
//https://github.com/hadjitejuco/JavaVideoDemo
//Select the MASTER branch
//Go to src FOLDER -> you can see the files
public class Demo7 {
    public static void main( String args[ ] )
    {
        double a = 3.0, b = 4.0;
        // c is dynamically initialized
        
        double c = Math.sqrt(a * a + b * b);
        
        System.out.println("Hypotenuse is " + c);
    }
}
