import java.util.Random;

/**
 * Constructor for Kitten object
 * @param i row position
 * @param j column position
 * @param x character representation
 */
class Kitten extends Cat{
	
	Kitten(int i, int j, char x){
		super(i,j,x);
	}

	/**
	 * @see Feline#move()
	 */
	int[] move()
	{
		Random rand=new Random();
		int i=rand.nextInt(10);
		int ar=this.getR();
		int ac=this.getC();
		int r=ar;
		int c=ac;
		if(i!=1 && i!=2 && i!=3)
		{
			int k=0;
			
			while(k==0) {
				
			k=1;
			i=rand.nextInt(8);
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
		}
		int[] pos= {r,c,-1,-1};
		return pos;
	}
	
	/**
	 * @see Feline#attack(Animal)
	 */
	boolean attack(Animal a)
	{
		Random rand=new Random();
		
		if(a instanceof Cat)
		{
			int i=rand.nextInt(10);
			if(i==1|| i==2|| i==3)
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
