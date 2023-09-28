// Simple Inheritance example 
class  A 
{
	int i, j;
	
	void showij() 
	{
		System.out.println("i and j: " + i + " " + j);
	}
}

class B extends A 
{
	int k;

	void showk() 
	{
		System.out.println("k: " + k);
	}
	
	void sum() 
	{
		System.out.println("i+j+k: " + (i+j+k));
	}
}


public class Inheritance2 {
    public static void main(String args[ ]) 
	{
		A sup = new A();
		B sub = new B();

		sup.i = 10;
		sup.j = 20;
		sup.showij();

		sub.i = 7;
		sub.j = 8;
		sub.k = 9;
		sub.showij();
		sub.showk();
		sub.sum();
	}

}
