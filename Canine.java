import java.util.Random;

abstract class Canine extends Animal {
	
	/**
	 * Constructor for Canine object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Canine(int i, int j, char x)
	{
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
		int r=ar,c=ac;
		int inc=0;
		int mr=ar,mc=ac;
		while(k==0) {
			
		k=1;
		Random rand=new Random();
		int i=rand.nextInt(2);
		inc=(i==0)?1:2;

		i=rand.nextInt(4);
		switch(i)
		{
		case 0:
			mr=r-1;
			r=r-inc;
			
			break;
		case 1:
			mr=r+1;
			r=r+inc;
			break;
		case 2:
			mc=c-1;
			c=c-inc;
			break;
		case 3:
			mc=c+1;
			c=c+inc;
			break;
		}
		
		if(r<0 || r>14 || c<0 || c>14)
		{
			k=0;
			r=ar;
			c=ac;
			mr=ar;
			mc=ac;
		}
		}
		int[] pos= new int[4];
		pos[0]=r;
		pos[1]=c;
		if(inc==1)
		{
		pos[2]=-1;
		pos[3]=-1;
		}
		else
		{
		pos[2]=mr;
		pos[3]=mc;
		}
		this.setcord(r, c);
		return pos;
	}
	
	
	/**
	 * @see Animal#attack(Animal)
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
		
		return false;
		
		
	}
	
}
