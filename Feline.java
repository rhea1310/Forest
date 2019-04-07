import java.util.Random;

abstract class Feline extends Animal{
	
	/**
	 * Constructor for Feline object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Feline(int i, int j, char x){
		super(i,j,x);
	}
	
	/**
	 * @see Animal#move()
	 */
	int[] move()
	{
		int k=0;
		int ar=getR();
		int ac=getC();
		int r=ar, c=ac;
		
		while(k==0) {
			
		k=1;
		Random rand=new Random();
		int i=rand.nextInt(8);
		switch(i)
		{
		case 0:
			r-=1;
			break;
		case 1:
			r+=1;
			break;
		case 2:
			c-=1;
			break;
		case 3:
			c+=1;
			break;
		case 4:
			r-=1;
			c-=1;
			break;
		case 5:
			r+=1;
			c+=1;
			break;
		case 6:
			r-=1;
			c+=1;
			break;
		case 7:
			r+=1;
			c-=1;
			break;
		}
		
		if(r<0 || r>14 || c<0 || c>14)
		{
			k=0;
			r=ar;
			c=ac;
		}
			
		}
		this.setcord(r, c);
		int[] pos= {r,c,-1,-1};
		return pos;
	}
	
	/**
	 * @see Animal#attack(Animal)
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
		else if(this.getClass()==a.getClass())
		{
			int i=rand.nextInt(2);
			if(i==1)
				return true;
		}
		
		return false;
	}
}