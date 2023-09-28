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
		width = -1;
		height = -1;
		depth = -1; 
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
		weight = -1;
	}

	BoxWeight(double len, double m) 
	{
		super(len);
		weight = m;
	}
}

class BoxCost extends BoxWeight 
{
	double cost;

	BoxCost(BoxCost ob) 
	{ 
		super(ob);
		cost = ob.cost;
	}

	BoxCost(double w, double h, double d, double m, double c) 
	{
		super(w, h, d, m); 
		cost = c;
	}

	BoxCost() 
	{
		super();
		cost = -1;
	}

	BoxCost(double len, double m, double c) 
	{
		super(len, m);
		cost = c;
	}
}


//Program to explain Multilevel Inheritance.
public class Inheritance3 {
    public static void main(String args[ ]) 
	{
		BoxCost b1 = new BoxCost(10, 15, 20, 25.75, 50.5);
		BoxCost b2 = new BoxCost(2, 3, 4, 5.6, 10.5);
		double vol;

		vol = b1.volume();
		System.out.println("Volume of b1 is " + vol);
		System.out.println("Weight of b1 is " + b1.weight);
		System.out.println("Cost:  " + b1.cost);
		System.out.println();

		vol = b2.volume();
		System.out.println("Volume of b2 is " + vol);
		System.out.println("Weight of b2 is " + b2.weight);
		System.out.println("Cost: " + b2.cost);
		System.out.println();
	}
}
