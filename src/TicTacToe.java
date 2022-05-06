import java.util.Scanner;

public class TicTacToe {
	
	private Player player1,player2;
	private Board board;
	
	public static void main(String[] args)
	{
		TicTacToe t=new TicTacToe();
		t.startGame();
	}
	
	
	public void startGame()
	{
		//player Input
		Scanner sc=new Scanner(System.in);
		player1=takePlayerInput(1);
		player2=takePlayerInput(2);
		while(player1.getSymbol()==player2.getSymbol())
		{
			System.out.println("Symbol Already Taken !! Pick another Symbol");
			char symbol=sc.next().charAt(0);
			player2.setSymbol(symbol);
			
		}
		
		//Create Board
		
	  board=new Board(player1.getSymbol(),player2.getSymbol());
	  
		//Conduct the game
	  boolean player1Turn=true;//if player1Turn==true it means player1 turn and if player1Turn==false it means player2Turn
      int status=Board.INCOMPLETE;
	  while(status==Board.INVALID || status==Board.INCOMPLETE)
      {
		  if(status==Board.INVALID)
		  {
			  System.out.println("Enter value of x from 0 to 2 and y from 0 to 2");
		  }
    	  if(player1Turn)
    	  {
    		  System.out.println("Player1 - "+player1.getName()+"'s turn");
    		  System.out.println("Enter x: ");
    		  int x=sc.nextInt();
    		  System.out.println("Enter y: ");
    		  int y=sc.nextInt();
    		   status=board.move(player1.getSymbol(),x,y);//This function check whether this index coordinates is valid ,complete,win ,draw
    		  if(status==Board.INVALID)
    		  {
    			  System.out.println("Invalid Move !! Try again");
    		  }
    		  else
    		  {
    			  player1Turn=false;
    			  board.print();
    		  }
    		  
    		  
    	  }
    	  else
    	  {
    		  System.out.println("Player2 - "+player2.getName()+"'s turn");
    		  System.out.println("Enter x: ");
    		  int x=sc.nextInt();
    		  System.out.println("Enter y: ");
    		  int y=sc.nextInt();
    		   status=board.move(player2.getSymbol(),x,y);//This function check whether this index coordinates is valid ,complete,win ,draw
    		  if(status==Board.INVALID)
    		  {
    			  System.out.println("Invalid Move !! Try again");
    		  }
    		  else
    		  {
    			  player1Turn=true;
    			  board.print();
    		  }
    		  
    	  }
      }
	  if(status==Board.PLAYER_1_WIN)
	  {
		  System.out.println("Player1 "+player1.getName()+" wins!! ");
	  }
	  else if(status==Board.PLAYER_2_WIN)
	  {
		  System.out.println("Player2 "+player2.getName()+" wins!! ");
	  }
	  else
	  {
		  System.out.println("Draw !!");
	  }
		  
	}
	
	//player Input function
	
	private Player takePlayerInput(int num)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Player "+num+" name: ");
		String name=sc.nextLine();
		System.out.println("Enter Player "+num+" symbol: ");
		char symbol=sc.next().charAt(0);
		Player p=new Player(name,symbol);
		return p;
		
	}
	
	

}
