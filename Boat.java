import java.util.ArrayList;
import java.util.Random;

public class Boat{
    private Dice dice = new Dice();
    private Trap trap = new Trap();
    private Current current = new Current();
    private ArrayList<Integer>  Traps = new ArrayList<Integer>();
    private ArrayList<Integer>  Currents = new ArrayList<Integer>();

    //attribute
    String playerName;
    String boat1Symbol = "1";
    String boat2Symbol = "2";
    String emptyBoat = "_";
    private String stackedBoat = "S";
    private int boatLocation = 0;    

    //empty constructor
    public Boat(){
    }

    //setter getter for playername
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playername){
        this.playerName = playername;
    }

    //setter getter for boat location
    public int getBoatLocation(){
        return boatLocation;
    }
    public void setBoatLocation(int i){
        boatLocation = boatLocation + i;
    } 

    //method for operation after encountering current
    public void encounterCurrent(){
        current.randomObjectStrength();
        setBoatLocation(current.getObjectStrength());
        System.out.printf("Encountered current, move foward %d steps.\n",current.getObjectStrength());
    }
    //method for operation after encountering trap
    public void encounterTrap(){
        trap.randomObjectStrength();
        setBoatLocation(trap.getObjectStrength());
        System.out.printf("Encountered trap, move back %d steps.\n",trap.getObjectStrength());
    }

}