import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;


    public Game(){
        player1 = new Player();
        player2 = new Player();
    }

    // Main game method; starts, controls, and ends the game
    public void play(){
        
        while(true){
            Scanner input = new Scanner(System.in);
            Board.populate();
            
            while(Board.getPieces()!=1){
                int currentPlayer = 1;
                
                System.out.println("The purpose of the game is to not grab the last piece of the board\n\nThere are "+Board.getPieces()+" pieces this game");
                
                // Player 1's turn; prompts for how many pieces they want to take 
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

                    // Checks how many pieces are left; if only 1 the game ends
                    if(Board.getPieces()==1){
                        System.out.println("\nThere is only 1 piece left! " +player1.getName()+" has won the round!");
                        player1.upScore();
                        break;
                    }       
                    System.out.println("\nThere are now "+Board.getPieces()+" pieces on the board");   
                
                // Player 2's turn; prompts for how many pieces they want to take
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

                    // Checks how many pieces are left; if only 1 the game ends
                    if(Board.getPieces()==1){
                        System.out.println("\nThere is only 1 piece left! "+player2.getName()+" has won the round!");
                        player2.upScore();
                        break;
                    } 
                    System.out.println("\nThere are now "+Board.getPieces()+" pieces on the board");
                }
            }

            // Prints the all-time scores of both players, and who is currently winning
            System.out.println("\nThe scores are: \n"+player1.getName()+": "+player1.getScore()+ "\n" +player2.getName()+": "+player2.getScore());
            if(player1.getScore()>player2.getScore()){
                System.out.println(player1.getName()+" is winning!");
            }else{
                System.out.println(player2.getName()+" is winning!");
            }
            
            
            /* 
             * Work in Progress...
             * 
            // Prompts the players to play again
            System.out.println("Would you like to play again? \nEnter Y or N \n");
            String newGame = input.nextLine();
            
            
            if(newGame.equals("Y")){
                play();
            }else if(newGame.equals("N")){
                System.out.println("Game Over");
                break;
                */
            }
        }
    }
}
