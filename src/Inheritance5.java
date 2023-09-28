// Program to use super keyword to call Super class constructor to 
// initialize super class instance variables
class Box 
{
	private double width;
	private double height;
	private double depth;

	Box(Box ob) 
	{ 
		width = ob.width;
		height = ob.height;
		depth = ob.depth;
	}

	Box(double w, double h, double d) 
	{
		width = w;
		height = h;
		depth = d;
	}

	Box() 
	{
		width = 1; 
		height = 1; 
		depth = 1; 
	}

	Box(double len) 
	{
		width = height = depth = len;
	}

	double volume() 
	{
		return width * height * depth;
	}
}

class BoxWeight extends Box 
{
	double weight; 

	BoxWeight(BoxWeight ob) 
	{ 
		super(ob);
		weight = ob.weight;
	}

	BoxWeight(double w, double h, double d, double m) 
	{
		super(w, h, d); 
		weight = m;
	}

	BoxWeight() 
	{
		super();
		weight = 1;
	}

	BoxWeight(double len, double m) 
	{
		super(len);
		weight = m;
	}
}


public class Inheritance5 {
    public static void main(String args[ ]) 
	{
		BoxWeight b1 = new BoxWeight(10, 15, 20, 25.75);
		BoxWeight b2 = new BoxWeight(2, 3, 4, 2.25);
		BoxWeight b3 = new BoxWeight(); 
		BoxWeight b4 = new BoxWeight(5, 6);
		BoxWeight b5 = new BoxWeight(b1);
		double vol;
	
		vol = b1.volume();
		System.out.println("Volume of b1 is " + vol);
		System.out.println("Weight of b1 is " + b1.weight);
		System.out.println("");

		vol = b2.volume();
		System.out.println("Volume of b2 is " + vol);
		System.out.println("Weight of b2 is " + b2.weight);
		System.out.println("");

		vol = b3.volume();
		System.out.println("Volume of b3 is " + vol);
		System.out.println("Weight of b3 is " + b3.weight);
		System.out.println("");

		vol = b4.volume();
		System.out.println("Volume of b4 is " + vol);
		System.out.println("Weight of b4 is " + b4.weight);
		System.out.println("");

		vol = b5.volume();
		System.out.println("Volume of b5 is " + vol);
		System.out.println("Weight of b5 is " + b5.weight);
	}

}
