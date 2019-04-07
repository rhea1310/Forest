import java.util.Random;

class Lion extends Feline{
	
	/**
	 * Constructor for Lion object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Lion(int i, int j, char x){
		super(i,j,x);
	}
	
	/**
	 * @see Feline#attack(Animal)
	 */
	boolean attack(Animal a)
	{
		Random rand=new Random();
		
		if(a instanceof Canine)
			return true;
		else if(a instanceof Turtle)
		{
			int i=rand.nextInt(5);
			if(i==5)
				return true;
		}
		else if(a instanceof Hippo)
			return true;
		return false;
	}
	
}