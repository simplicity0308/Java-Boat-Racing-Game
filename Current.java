import java.util.ArrayList;
import java.util.Random;

public class Current extends RiverObject{
    //attributes
    private static String currentSymbol = "C";
    public ArrayList<Integer> Currents = new ArrayList<Integer>();

    //setter and getter for symbol
    public static String getCurrentSymbol(){
        return currentSymbol;
    }
    public void setCurrentSymbol(String currentsymbol){
        this.currentSymbol = currentsymbol;
    }

    //getter for currents array
    public ArrayList<Integer> getCurrent(){
        return Currents;
    }

    //method to add in current from position 1 to 99
    public void addCurrents(ArrayList<Integer> tempArray){
        Random random = new Random();
        for(int c=0; c<10; c++){
            int a = 1+ random.nextInt(99);
            Currents.add(a);
        }

    }

}

