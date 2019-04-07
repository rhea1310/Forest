import java.util.Random;

class Hippo extends Animal{
	
	/**
	 * Constructor for Hippo object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Hippo(int i, int j,char x)
	{
		super(i,j,x);
	}
	/**
	 * @see Animal#move()
	 */
	int[] move()
	{
		int k=0;
		int ar=this.getR();
		int ac=this.getC();
		int r=ar,c=ac;
		
		while(k==0) {
			
		k=1;
		Random rand=new Random();
		int i=rand.nextInt(4);
		switch(i)
		{
		case 0:
			r=r-1;
			break;
		case 1:
			r=r+1;
			break;
		case 2:
			c=c-1;
			break;
		case 3:
			c=c+1;
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
		if(this.getClass()==a.getClass())
		{
			int i=rand.nextInt(2);
			if(i==1)
				return true;
		}
		return false;
	}
}
