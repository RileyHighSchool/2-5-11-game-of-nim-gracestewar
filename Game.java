import java.util.Scanner;
public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;



    public Game(){
        player1 = new Player();
        player2 = new Player();
       
    }

    public void setFirstPlayer(){
        if (Math.random() > 0.5){
            currentPlayer = player1;
        } else{
            currentPlayer = player2;
        }
    }
    
    public void endGame(){
        if (currentPlayer == player1){
            System.out.println("You win, " + player2.getName());
            player2.updateScore(1);
        } else{
            System.out.println("You win, " + player1.getName());
            player1.updateScore(1);
        }
        System.out.println(player1.getName() + " you have " + player1.getScore());
        System.out.println(player2.getName() + " you have " + player2.getScore());

        System.out.println(" Would you like to play again? (y/n)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if(input.equals("y")){
            Board.populate();
            play();
        }
    }



    public void switchPlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2;
          }else{
            currentPlayer = player1;
          }
    }
        

    public void play(){
        setFirstPlayer();
        while (Board.getPileSize() > 1){
            System.out.println("It is now your turn " + currentPlayer.getName());
            System.out.println("There are " + Board.getPileSize() + " pieces on the board");
            Board.takePieces();
            switchPlayer();
        } 
        endGame();
    }
}


