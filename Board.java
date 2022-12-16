public class Board {
    private static int pile;

    // Randomly picks the # of pieces on the board
    public static void populate(){
        pile = 3;
        pile = (int)(Math.random()*41+10);
    }
    public static int getPieces(){
        return pile;
    }
    // Takes the # of pieces away from the pile that the player chose
    public static void takePieces(int num){
       pile = pile-num;
           
        
    }
}
