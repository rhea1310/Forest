
class Board {

	char boardarray[][]= new char[15][15];
	
	Board()
	{
		for(int i=0; i<15; i++)
		{
			for(int j=0; j<15 ; j++)
			{
				boardarray[i][j]='.';
			}
		}
	}
	
	void add(char x, int r, int c)
	{
		boardarray[r][c]=x;
	}
	
	void remove(int r, int c)
	{
		boardarray[r][c]='.';
	}
	
	void display()
	{
		for(int i=0; i<15; i++)
		{
			for(int j=0; j<15 ; j++)
			{
				System.out.print(boardarray[i][j]);
			}
			System.out.println();
		}
	}
	boolean check(int i, int j)
	{
		if(boardarray[i][j]=='.')
			return true;
		else 
			return false;
			
	}
	
}
