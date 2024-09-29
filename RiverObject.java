import java.util.ArrayList;
import java.util.Random;

public class RiverObject{
    //Attributes
    private int objectStrength;
    ArrayList<Integer> objectsList = new ArrayList<Integer>();

    //constructor
    public void RiverObject(){
        this.objectStrength = 0;
    }

    //setter and getter for object strength
    public int getObjectStrength(){
        return objectStrength;
    }
    public void setObjectStrength(int strength){ 
        this.objectStrength = strength + 1;
    }

    //setter and getter for object list
    public ArrayList<Integer> getObjectsList(){
        return objectsList;
    }
    public void setObjectsList(){
        for(int i = 0; i<100; i++){
            objectsList.add(i);
        }
    }

    //method to generate random object strength
    public void randomObjectStrength(){
        Random random = new Random();
        setObjectStrength(random.nextInt(6));
    }
} 