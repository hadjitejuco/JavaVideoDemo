// Simple Inheritance example

class SuperClass
{
    int i,j,k, ans;
    
    void showmsgSuper()
    {
	System.out.println("This msg from Super class..!");
    }
}

class SubClass extends SuperClass
{
    void showmsgSub()
    {
	System.out.println("This msg from Sub class..!");
    }
}


public class Inheritance1 {
    public static void main(String[] args) {
        SubClass ob1 = new SubClass();
        ob1.showmsgSuper();
        ob1.showmsgSub();
    }

}
