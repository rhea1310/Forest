import java.util.Random;

class Jaguar extends Feline {
	
	/**
	 * Constructor for Jaguar object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Jaguar(int i, int j, char x){
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
			return true;
		}
		else if(this.getClass()==a.getClass())
		{
			int i=rand.nextInt(2);
			if(i==1)
				return true;
		}
		
		return false;
	}
}
