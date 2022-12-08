import java.util.Scanner;
public class Game {
    private Player player1;
    private Player player2;



    public Game(){
        player1 = new Player();
        player2 = new Player();

    }
    public void play(){

        int currentPlayer = 1;
        Scanner input = new Scanner(System.in);
        int pile = Board.getPieces();
        System.out.println("The mean of the game is to not be the last player to grab the last piece of the board\n\nThere are "+pile+" pieces this game");
        if(currentPlayer == 1){
            System.out.println(player1.getName()+", it is your turn. How many pieces will you pick: ");
            int turn = input.nextInt();
            while(true){
                if(turn<=(pile/2)&&turn>=1){
                    Board.takePieces(turn);
                    break;
                }else{
                    turn=input.nextInt(); 
                }
            }
            
        }

        

    }
    //public boolean playAgain(){

    //}

}
