import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput{
    //attributes
    int userInput  = -1;  //set to -1 is to avoid triggering try catch

    //constructor
    public UserInput(){
        setNumber();
        getNumber();
        checkNumber(getNumber());
    }
    
    //setter getter for user input
    public int getNumber(){
        return userInput;
    }
    public void setNumber(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoose action, enter number between 1 to 4:");
        try{
            userInput = input.nextInt();
            while(userInput < 1 || userInput > 4){
                System.out.print("Number not between 1 and 4, please retry: ");
                userInput = input.nextInt();
            }
        }catch(InputMismatchException wrgInput){
            System.out.print("Invalid input, please retry: ");
            setNumber();
        }
    }
    
    //method to check number and execute
    public void checkNumber(int i){
        Text text = new Text();
        switch(i){
            case 1: 
                System.out.println(toString());
                new Game();
                System.out.println(text.getAction());
                UserInput x = new UserInput();
                break;
            case 2:
                System.out.println(toString());
                System.out.println("=======================================================================\n");
                System.out.println(text.getRule());
                System.out.print("\n");
                System.out.println("=======================================================================\n");
                System.out.print("\n\n");
                System.out.print(text.getAction());
                UserInput y = new UserInput();
                break;
            case 3:
                System.out.println(toString());
                System.out.println("=======================================================================\n");
                HighScores l = new HighScores();
                //l.sortFile();
                l.displayLeaderboard();
                System.out.print("\n");
                System.out.println("=======================================================================\n");
                System.out.print("\n\n");
                System.out.print(text.getAction());
                UserInput z = new UserInput();
            case 4:
                System.out.println(toString());
                System.out.println(text.getExit());
                System.exit(0);
        }   
    }

    //method to tell user what option they chose
    public String toString(){
        return String.format("Action Executed: %s", userInput);
    }
}