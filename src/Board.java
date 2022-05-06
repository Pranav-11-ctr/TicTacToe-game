
public class Board {
	
	private char board[][];
	private int boardSize=3;
	char p1Symbol,p2Symbol;
	int count;//No of cells that have been marked
	public static final int PLAYER_1_WIN=1;
	public static final int PLAYER_2_WIN=2;
	public static final int DRAW=3;
	public static final int INCOMPLETE=4;
	public static final int INVALID=5;
	
	
	
	public Board(char p1Symbol,char p2Symbol)
	{
		board=new char[boardSize][boardSize];
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				board[i][j]=' ';
			}
		}
		this.p1Symbol=p1Symbol;
		this.p2Symbol=p2Symbol;
	}



	public int move(char symbol, int x, int y) {
		if(x<0 ||x>=boardSize ||y<0||y>=boardSize||board[x][y]!=' ')//board[x][y]!=' ' this means earlier it is already filled
		{
			return INVALID;
		}
		board[x][y]=symbol;
		count++;
		
		//Check Row
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
		{
			System.out.println("Row");
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		
		//Check Column
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y] )
		{
			System.out.println("Column");
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		//First Diagonal
		if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2] )
		{
			System.out.println("First");
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		//Second Diagonal
		if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[0][2]==board[2][0] )
		{
			System.out.println("Second");
			return symbol==p1Symbol?PLAYER_1_WIN:PLAYER_2_WIN;
		}
		
		if(count==boardSize*boardSize)
		{
			return DRAW;
		}
		return INCOMPLETE;
		
		
	}



	public void print() {
		System.out.println("------------------");
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("**********************");
		
		
	}

}
