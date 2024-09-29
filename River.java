import java.util.ArrayList;
public class River{
    private String stackedBoat = "S";
    private int caseSelector = 0;

    String[] riverEmpty = new String[]{
        "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
        "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
        "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
        "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
        "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
    };

    //empty constructor
    public void River(){
    }
    
    //setter getter when boats are stacked
    public String getStackedBoat(){
        return stackedBoat;
    }
    public void setStackedBoat(String StackedBoat){
        this.stackedBoat = StackedBoat;
    }

    //setter getter for case checker for boat symbol
    public int getCase(){
        return caseSelector;
    }
    public void setCase(int a, int b){
        if(a == b){
            caseSelector = 1;
        }else if(a != b){
            caseSelector = 2;
        }else if(a != b && a<10 ){
            caseSelector = 3;
        }
    }

    //method to display river
    public void displayRiver(){
        for(int i = 0; i < riverEmpty.length; i++){
            System.out.print(riverEmpty[i]);
        }
    }
    public void displayRiverBorder(){
        for(int i=0; i < riverEmpty.length; i++){
            System.out.print("=");
        }
    }

    //method to update river after generating objects
    public void changeRiver(int a, String b){
        riverEmpty[a] = b;
    }

    //method to add in traps and currents to river
    public void generateObject(ArrayList<Integer> trap, ArrayList<Integer> current){
        for(int x:current){
            riverEmpty[x] = Current.getCurrentSymbol();
        }
        for(int y:trap){
            riverEmpty[y] = Trap.getTrapSymbol();
        }
    }
}  