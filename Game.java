import java.util.Scanner;
public class Game {
    private Player player1;
    private Player player2;



    public Game(){
        player1 = new Player();
        player2 = new Player();

    }
    public void play(){
        while(Board.getPieces()!=1){
            int currentPlayer = 1;
            Scanner input = new Scanner(System.in);
            System.out.println("The purpose of the game is to not grab the last piece of the board\n\nThere are "+Board.getPieces()+" pieces this game");
            
            
            if(currentPlayer == 1){
                System.out.println(player1.getName()+", it is your turn. How many pieces will you pick: ");
                int turn = input.nextInt();
                while(true){
                    if(turn<=(Board.getPieces()/2)&&turn>=1){
                        Board.takePieces(turn);
                        
                        break;
                    }else{
                        System.out.println("That's too much or to little nerd");
                        turn=input.nextInt(); 
                    }
                }
                System.out.println("There are now "+Board.getPieces()+" pieces on the board");   
            currentPlayer=2;
            }else{
                System.out.println(player2.getName()+", it is your turn. How many pieces will you pick: ");
                int turn = input.nextInt();
                while(true){
                    if(turn<=(Board.getPieces()/2)&&turn>=1){
                        Board.takePieces(turn);
                        break;
                    }else{
                        System.out.println("That's too much or to little nerd");
                        turn=input.nextInt(); 
                    }
                }
                System.out.println("There are now "+Board.getPieces()+" pieces on the board");
            }






        }
    }
    //public boolean playAgain(){

    //}

}
