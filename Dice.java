import java.util.Random;
public class Dice{

    //attributes
    private int Number;

    //empty constructor
    public Dice(){
        this.Number = 0;
    }

    //setter and getter for dice number
    public int getDiceNumber(){
        return Number;
    }
    public void setDiceNumber(int diceNumber){
        Number = diceNumber;
    }

    //method to roll dice
    public void rollDice(){
        Random random = new Random();
        int dice = 1 + random.nextInt( 6 );
        setDiceNumber(dice);
    }

    //toString to display roll result
    public void displayDiceNumber(String a, int b){
        System.out.printf("\n%s rolled the dice, and rolled %d!\n",a,b);
    }
}