import java.util.Scanner;
public class Player {
    private String name;
    private int score;
    public Player(){
        score = 0;
        System.out.println("Enter Player Name: ");
        Scanner sc = new Scanner(System.in);
        String newName =sc.nextLine();
    
        name = newName;
        System.out.println("Hello and welcome to the game, "+ name);
      }
      public Player(String inputName){
        name = inputName;
        score = 0;
        System.out.println("Hello and welcome to the game, "+ name);
      }
      public int getScore(){
          return score;
      }
      public String getName(){
          return name;
      }
      public void upScore(){
          
      }




}
