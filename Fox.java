import java.util.Random;

class Fox extends Canine{
	
	/**
	 * Constructor for Fox object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Fox(int i, int j, char x){

		super(i,j,x);
	}
	/**
	 * @see Canine#attack(Animal)
	 */
	boolean attack(Animal a)
	{
		Random rand=new Random();
		
		if(a instanceof Feline)
		{
			int i=rand.nextInt(2);
			if(i==0)
				return false;
			else 
				return true;			
		}
		else if(a instanceof Turtle)
		{
			int i=rand.nextInt(5);
			if(i==5)
				return true;
		}
		else if(this.getClass()==a.getClass())
		{
			int i=rand.nextInt(2);
			if(i==1)
				return true;
		}
		else if(a instanceof Cat)
			return true;
		
		return false;
		
		
	}
	
}