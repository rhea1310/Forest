import java.util.Random;

class Dinosaur extends Animal{
	
	/**
	 * Constructor for Dinosaur object
	 * @param i row position
	 * @param j column position
	 * @param x character representation
	 */
	Dinosaur(int i, int j,char x){
		super(i,j,x);
	}
	/**
	 * @see Animal#move()
	 */
	int[] move()
	{
		Random rand=new Random();
		int ar=this.getR();
		int ac=this.getC();
		int[] pos= {ar,ac,ar,ac,ar,ac};
			int k=0;
			
			while(k==0) {
				
			k=1;
			int i=rand.nextInt(4);
			switch(i)
			{
			case 0:
				pos[0]=ar-3;
				pos[2]=ar-2;
				pos[4]=ar-1;
				break;
			case 1:
				pos[0]=ar+3;
				pos[2]=ar+2;
				pos[4]=ar+1;
				break;
			case 2:
				pos[1]=ac-3;
				pos[3]=ac-2;
				pos[5]=ac-1;
				break;
			case 3:
				pos[1]=ac+3;
				pos[3]=ac+2;
				pos[5]=ac+1;
				break;
			}
			
			if(pos[0]<0 || pos[0]>14 || pos[1]<0 || pos[1]>14)
			{
				k=0;
				for(int j=0;j<6;j++)
				{
					pos[j]=(j%2==0)?ar:ac;
				}
			}
			}
			this.setcord(pos[0], pos[1]);
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
				return false;
		}
		return true;
	}
}
