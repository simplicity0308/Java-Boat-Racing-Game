import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.text.Collator;

public class HighScores{
    Player player = new Player();
    Scanner input = new Scanner(System.in);
    Formatter output = new Formatter();

    //attributes
    String name;
    int score;

    //constructor
    public HighScores(){
    }

    //method to display leaderboard
    public void displayLeaderboard(){
        System.out.println("--HighScores--");
        System.out.println("<Name ; Score>");
        try{
            FileReader fr = new FileReader("TopScore.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
            fr.close();
        }catch(Exception e){
            System.err.println("Error: "+ e.getMessage());
        }
    }

    //sort highscores
    /* 
    public void sortFile() throws IOException{     
    FileReader fileReader = new FileReader("D:\\TopScore.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    List<String> lines = new ArrayList<String>();
    String line = null;
    while ((line = bufferedReader.readLine()) != null) {
        lines.add(line);
    }
    bufferedReader.close();

    Collections.sort(lines, Collator.getInstance());

    FileWriter writer = new FileWriter("D:\\TopScoreSorted.txt"); 
    for(String str: lines) {
      writer.write(str + "\r\n");
    }
    writer.close();
}
    */
}
        
        
    
