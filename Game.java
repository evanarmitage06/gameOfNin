import java.util.Scanner;
 
import javax.xml.namespace.QName;
 
public class Game
{
    private Player player1;
    private Player player2;
 
    public Game()
    {
        player1 = new Player();
        player2 = new Player();
    }
 
    // Main game method; starts, controls, and ends the game
    Boolean round = true;
 
    public void play()
    {
       
        while(round)
        {
            Scanner input = new Scanner(System.in);
            Board.populate();
           
            while(Board.getPieces()!=1)
            {
                int currentPlayer = 1;
               
                System.out.println("\nThe goal of the game is to make the other player take the last piece on the board.\n");
                System.out.println("There are " + Board.getPieces() + " pieces on the board.");
               
                // Player 1's turn; prompts for how many pieces they want to take
                while(currentPlayer == 1){
                    System.out.println(player1.getName()+", it is your turn. How many pieces will you pick: ");
                    int turn = input.nextInt();
                    while(true)
                    {
                        if(turn<=(Board.getPieces()/2)&&turn>=1)
                        {
                          Board.takePieces(turn);
                          break;
                        }
                        else if(turn>=(Board.getPieces()/2)&&turn>=1)
                        {
                          System.out.println("You cannot take more than " + Board.getPieces()/2);
                          turn = input.nextInt();
                        }
                        else if(turn<=0)
                        {
                          System.out.println("You cannot take less than 1.");
                          turn = input.nextInt();
                        }
 
                    }
 
                    // Checks how many pieces are left; if only 1 the game ends
                    if(Board.getPieces()==1)
                    {
                      System.out.println("\nThere is only 1 piece left! " +player1.getName()+" has won the round!");
                      player1.upScore();
                      break;
                    }      
                    System.out.println("\nThere are now "+Board.getPieces()+" pieces on the board");  
               
                // Player 2's turn; prompts for how many pieces they want to take
                currentPlayer=2;
                }if(currentPlayer==2)
                {
                    System.out.println(player2.getName()+", it is your turn. How many pieces will you pick: ");
                    int turn = input.nextInt();
                    while(true){
                        if(turn<=(Board.getPieces()/2)&&turn>=1)
                        {
                          Board.takePieces(turn);
                          break;
                        }
                        else if(turn>=(Board.getPieces()/2)&&turn>=1)
                        {
                          System.out.println("You cannot take more than " + Board.getPieces()/2);
                          turn=input.nextInt();
                        }
                        else if(turn<=0)
                        {
                          System.out.println("You cannot take less than 1.");
                        }
 
                    }
 
                    // Checks how many pieces are left; if only 1 the game ends
                    if(Board.getPieces()==1)
                    {
                        System.out.println("\nThere is only 1 piece left! "+player2.getName()+" has won the round!");
                        player2.upScore();
                        break;
                    }
                    System.out.println("\nThere are now "+Board.getPieces()+" pieces on the board");
 
                }
            }
 
            // Prints the all-time scores of both players, and who is currently winning
            System.out.println("\nThe scores are: \n"+player1.getName()+": "+player1.getScore()+ "\n" +player2.getName()+": "+player2.getScore());
            if(player1.getScore()>player2.getScore())
            {
                System.out.println(player1.getName()+" is winning!");
            }else{
                System.out.println(player2.getName()+" is winning!");
            }
           
            break;
        }
 
        // Prompts the user to play again
        boolean validInput = false;
 
        while(!validInput)
        {
          System.out.println("Would you like to play again? Please enter Yes or No.");
          Scanner newGame = new Scanner(System.in);
          String playAgainResponse = newGame.nextLine();
 
        if(playAgainResponse.equals("Y") || playAgainResponse.equals("Yes") || playAgainResponse.equals("yes"))
        {
            play();
            validInput = true;
        }
        else if(playAgainResponse.equals("N") || playAgainResponse.equals("No") || playAgainResponse.equals("no"))
        {
          System.out.println("Game Over");
          validInput = true;
        }
        else
        {
          System.out.println("That is not a valid input.");
        }
      }
       
    }
 
}
 
 

