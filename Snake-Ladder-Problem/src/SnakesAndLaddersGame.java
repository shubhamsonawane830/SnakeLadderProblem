import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SnakesAndLaddersGame {
	
	final static int WIN_POINT = 100;
	static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
	static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
	{
		snake.put(96,68);
		snake.put(72,54);
		snake.put(52,35);
		snake.put(25,2);
		snake.put(97,44);

		ladder.put(6,24);
		ladder.put(11,40);
		ladder.put(60,85);
		ladder.put(46,90);
		ladder.put(17,69);
	}

	public int rollDice(){
		int roll = 0;
		Random random = new Random();
		roll = random.nextInt(7);
		return (roll==0?1:roll);
	}

	public int calculatePlayerValue(int player,int diceValue){
		player = player + diceValue;
		if(player>WIN_POINT){
			player=player-diceValue;
			return player;
		}
		if(null!=snake.get(player)){
			System.out.println("Oops!You landed on Snake");
			player=snake.get(player);
		}
		if(null!=ladder.get(player)){
			System.out.println("Yes!You landed on Ladder");
			player=ladder.get(player);
		}
		return player;
	}

	public boolean win(int player){
		return WIN_POINT == player;
	}

	public void startGame(){
		int player1=0,player2=0;
		int currentPlayer=-1;
		Scanner s = new Scanner(System.in);
		String str;
		int diceValue=0;
		do{
			System.out.println(currentPlayer==-1?"\nFIRST PLAYER TURN: " : "\nSECOND PLAYER TURN: ");
			System.out.println("Press r to roll dice");
			str = s.next();
			diceValue = rollDice();

			if(currentPlayer == -1){
				player1 = calculatePlayerValue(player1,diceValue);
				System.out.println("First Player: "+player1);
				System.out.println("Second Player: "+player2);
				System.out.println("---------");
				if(win(player1)){
					System.out.println("First Player Won!");
					return;
			}
			} else {
				player2 = calculatePlayerValue(player2,diceValue);
				System.out.println("First Player: "+player1);
				System.out.println("Second Player: "+player2);
				System.out.println("-------------");
				if(win(player2)){
					System.out.println("Second Player Won!");
					return;
			 }
			}
			currentPlayer=-currentPlayer;
		}while("r".equals(str));
	  }

	public static void main(String args[]){
		System.out.println("WELCOME TO SNAKE AND LADDERS GAME");
		SnakesAndLaddersGame s = new SnakesAndLaddersGame();
		s.startGame();
	}
}





