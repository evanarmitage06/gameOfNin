import java.util.Scanner;
public class Game {
    private Player player1;
    private Player player2;



    public Game(){
        player1 = new Player();
        player2 = new Player();

    }
    public void play(){
        
        while(true){
            Scanner input = new Scanner(System.in);
            Board.populate();
            
            while(Board.getPieces()!=1){
                int currentPlayer = 1;
                
                System.out.println("The purpose of the game is to not grab the last piece of the board\n\nThere are "+Board.getPieces()+" pieces this game");
                
                
                while(currentPlayer == 1){
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
                    if(Board.getPieces()==1){
                        System.out.println(player2.getName()+" YOUVE LOST");
                        player1.upScore();
                        break;
                    }       
                    System.out.println("There are now "+Board.getPieces()+" pieces on the board");   
                currentPlayer=2;
                }if(currentPlayer==2){
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
                    if(Board.getPieces()==1){
                        System.out.println(player1.getName()+" YOUVE LOST");
                        player2.upScore();
                        break;
                    } 
                    System.out.println("There are now "+Board.getPieces()+" pieces on the board");
                }
            }
            System.out.println("The scores are "+player1.getName()+": "+player1.getScore()+ " and "+player2.getName()+": "+player2.getScore()+"Do you want to play again? ");
            String newGame = input.nextLine();
            System.out.println(newGame);
            if(!(newGame.equals("yes"))){
                break;
            }
        }
        if(player1.getScore()>player2.getScore()){
            System.out.println("Player 1 wins");
        }else{
            System.out.println("Player 2 wins");
        }
    }

}
