import java.util.ArrayList;
import java.util.Random;


public class Trap extends RiverObject{

    //attributes
    private static String trapSymbol = "T";
    public ArrayList<Integer> Traps = new ArrayList<Integer>();

    //setter and getter for symbol
    public static String getTrapSymbol(){
        return trapSymbol;
    }
    public void setTrapSymbol(String trapsymbol){
        this.trapSymbol = trapsymbol;
    }

    //getter for trap array
    public ArrayList<Integer> getTraps(){
        return Traps;
    }

    //method to add in trap
    public void addTraps(ArrayList<Integer> tempArray){
        Random random = new Random();
        for(int c=0; c<10; c++){
            int a = 1+ random.nextInt(99);
            Traps.add(a);
        }

    }

}

