import java.util.Random;

class Turtle extends Animal{
	
	/**
	 * Constructor for Turtle object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Turtle(int i, int j,char x){
		super(i,j,x);
	}
	/**
	 * @see Animal#move()
	 */
	int[] move()
	{
		Random rand=new Random();
		int i=rand.nextInt(2);
		int ar=this.getR();
		int ac=this.getC();
		int r=ar;
		int c=ac;
		if(i==1)
		{
			int k=0;
			
			while(k==0) {
				
			k=1;
			i=rand.nextInt(4);
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
		}
		int[] pos= {r,c,-1,-1};
		return pos;
	}
	
	/**
	 * @see Animal#attack(Animal)
	 */
	boolean attack(Animal a)
	{
		Random rand=new Random();
		int i=rand.nextInt(2);
		if(i==0)
			return false;
		return true;
	}
}