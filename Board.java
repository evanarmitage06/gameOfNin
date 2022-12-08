public class Board {
    private static int pile;


    public static void populate(){
        pile = 3;
        //pile = (int)(Math.random()*41+10);
    }
    public static int getPieces(){
        return pile;
    }
    public static void takePieces(int num){
       pile = pile-num;
           
        
    }
}
