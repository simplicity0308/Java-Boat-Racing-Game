import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);
    Boat player1 = new Boat();
    Boat player2 = new Boat();

    public void playerName(){
        do{
            System.out.print("Player 1, enter your name (Less than 15 characters): ");
            player1.playerName = input.nextLine();
            if(player1.playerName.length() > 10 || player1.playerName.length() <= 0){
                System.out.println("Invalid name, please make sure name is within 10 characters.");
            }else{
                break;
            }
        }while(true);

        do{
            System.out.print("Player 2, enter your name (Less than 15 characters): ");
            player2.playerName = input.nextLine();
            if(player2.playerName.length() > 10 || player2.playerName.length() <= 0){
                System.out.println("Invalid name, please make sure name is within 10 characters.");
            }else{
                break;
            }
        }while(true);
}
}
