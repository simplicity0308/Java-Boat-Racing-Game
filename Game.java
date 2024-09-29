import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.Scanner;


public class Game{
	Scanner input = new Scanner(System.in);
	RiverObject robj = new RiverObject();
	River river = new River();
	Boat player1 = new Boat();
	Boat player2 = new Boat();
	Dice player1Dice = new Dice();
	Dice player2Dice = new Dice();
	Trap trap = new Trap();
	Current current = new Current();
	Player player = new Player();
	Text text = new Text();
	HighScores board = new HighScores();

	//attributes
	int scorePlayer1 = 0;
	int scorePlayer2 = 0;
	int turnCounter = 0;
	final int CurrentScore = 5;
	final int TrapScore = -5;
	final int TurnsScore = +5;
	private String winner;
	private int winnerScore; 

	//constructor
	public Game(){
		playGame();
	}

	//player input name
	public void playGame(){
		player.playerName();

		//create game with river and objects
		robj.setObjectsList();
		trap.addTraps(robj.objectsList);
		current.addCurrents(robj.objectsList);

		//set player starting position, change display if boats are stacked
		river.setCase(player1.getBoatLocation(),player2.getBoatLocation());
		switch(river.getCase()){
			case 1:
				river.changeRiver(player1.getBoatLocation(), river.getStackedBoat());
				break;
			case 2:
				river.changeRiver(player1.getBoatLocation(),player1.boat1Symbol);
		}
		river.generateObject(trap.Traps, current.Currents);
		river.displayRiverBorder();
		System.out.print("\n");
		river.displayRiver();
		System.out.print("\n");
		river.displayRiverBorder();
		System.out.print("\n");

		//winning condition checking
		try{
			while(player1.getBoatLocation()<100 && player2.getBoatLocation()<100){
				//player 1 turn
				System.out.printf("%s (B1), press ENTER or type anything to roll the dice: ", player.player1.playerName);
				input.nextLine();
				turnCounter = turnCounter + 1;

				player1Dice.rollDice();
				player1.setBoatLocation(player1Dice.getDiceNumber());
				player1Dice.displayDiceNumber("B1", player1Dice.getDiceNumber());

				//after player 1 moves, change boat symbol because boats are no longer stacked
				river.setCase((player1.getBoatLocation() - player1Dice.getDiceNumber()), player2.getBoatLocation());
				switch(river.getCase()){
					case 1:
						river.changeRiver((player1.getBoatLocation() - player1Dice.getDiceNumber()), player2.boat2Symbol);
						break;
					case 2:
						river.changeRiver((player1.getBoatLocation() - player1Dice.getDiceNumber()), player1.emptyBoat);
						break;
				}

				//check object trigger
				while(trap.Traps.contains(player1.getBoatLocation()) || current.Currents.contains(player1.getBoatLocation())){
					if(trap.Traps.contains(player1.getBoatLocation())){
	                        player1.encounterTrap();;
	                        scorePlayer1 += TrapScore;
	                    }else if (current.Currents.contains(player1.getBoatLocation())){
	                        player1.encounterCurrent();
	                        scorePlayer1 += CurrentScore;
	                    }else{
	                    	break;
	                    }
				}

				//update boat positions again 
				river.setCase(player1.getBoatLocation(), player2.getBoatLocation());
	                switch(river.getCase()){
	                	case 1:
	                        river.changeRiver(player1.getBoatLocation(), river.getStackedBoat());
	                        break;
	                    case 2:
	                        river.changeRiver(player1.getBoatLocation(), player1.boat1Symbol);
	                        break;
	
	                	}
					river.displayRiverBorder();
					System.out.print("\n");
					river.displayRiver();
					System.out.print("\n");
					river.displayRiverBorder();
					System.out.println("\n");
					System.out.println(text.getLegend());
					//clear screen
					for(int p=0; p<10; p++){
						System.out.print("\n");
					}
		
				//player 2 turn
				System.out.printf("%s (B2), press ENTER or type anything to roll the dice: ",player.player2.playerName);
	                input.nextLine();
	                player2Dice.rollDice();
	                player2.setBoatLocation(player2Dice.getDiceNumber());
	                player2Dice.displayDiceNumber("B2", player2Dice.getDiceNumber());
	
	                //after player 2 moves, change boat symbol because boats are no longer stacked
	                river.setCase((player2.getBoatLocation() - player2Dice.getDiceNumber()), player1.getBoatLocation());
	                switch(river.getCase()){
	                    case 1:
	                        river.changeRiver(player1.getBoatLocation(), player1.boat1Symbol);
	                        break;
	                    case 2:
	                        river.changeRiver(player2.getBoatLocation() - player2Dice.getDiceNumber(), player2.emptyBoat);
	                        break;
	                }
	
	                //check object trigger
	                while(trap.Traps.contains(player2.getBoatLocation()) || current.Currents.contains(player2.getBoatLocation())){
	                    if(trap.Traps.contains(player2.getBoatLocation())){
	                        player2.encounterTrap();;
	                        scorePlayer2 += TrapScore;
	                    }
	                    else if (current.Currents.contains(player2.getBoatLocation())){
	                        player2.encounterCurrent();
	                        scorePlayer2 += CurrentScore;
	                    }else{
	                    	break;
	                    }
	                }
	
	                //update positions again
	                river.setCase(player2.getBoatLocation(), player1.getBoatLocation());
	                switch(river.getCase()){
	                    case 1:
	                        river.changeRiver(player2.getBoatLocation(), river.getStackedBoat());
	                        break;
	                    case 2:
	                        river.changeRiver(player2.getBoatLocation(), player2.boat2Symbol);
	                        break;
	
	                }
					river.displayRiverBorder();
					System.out.print("\n");
	                river.displayRiver();
					System.out.print("\n");
					river.displayRiverBorder();
					System.out.println("\n");
					System.out.print(text.getLegend());
					//clear screen
					for(int p=0; p<10; p++){
						System.out.print("\n");
					}
			}	
		}catch(Exception e){
			System.out.print("\n");
			System.out.println(text.getGameOver()); //boat move past 100, gameend
		}

		//calculate score
		finally{
			scorePlayer1 += (turnCounter * TurnsScore);
			scorePlayer2 += (turnCounter * TurnsScore);

			if(scorePlayer1 > scorePlayer2){
				System.out.printf("|~~| %s (B1) wins |~~|!\n\n",player.player1.playerName);
				System.out.println(text.getScoreBoard());
				System.out.printf("    Boat 1 Score: %d\n", scorePlayer1);
				System.out.printf("    Boat 2 Score: %d\n", scorePlayer2);
				System.out.printf("    Number of Turns: %d\n\n\n", turnCounter);
				winner = player.player1.playerName;
				winnerScore = scorePlayer1;
			}else if(scorePlayer2 > scorePlayer1){
				System.out.printf("|~~| %s (B2) wins |~~|!\n\n",player.player2.playerName);
				System.out.println(text.getScoreBoard());
				System.out.printf("    Boat 1 Score: %d\n", scorePlayer1);
				System.out.printf("    Boat 2 Score: %d\n", scorePlayer2);
				System.out.printf("    Number of Turns: %d\n\n\n", turnCounter);
				winner = player.player2.playerName;
				winnerScore = scorePlayer2;
			}else{
				System.out.printf("|~~| It's a tie! |~~|\n\n");
				System.out.println(text.getScoreBoard());
	            System.out.printf("    Boat 1 Score: %d\n", scorePlayer1);
	            System.out.printf("    Boat 2 Score: %d\n", scorePlayer2);
				System.out.printf("    Number of Turns: %d\n\n\n", turnCounter);
				winner= "<Tied Game>";
				winnerScore = scorePlayer1;
			}

			//record scores into txt file
			try{
				String nl = System.getProperty("line.separator");
				FileWriter fw = new FileWriter("TopScore.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(winner+" ; "+winnerScore+"\r\n");
				
				bw.flush();
				fw.close();
			}catch(Exception e){
				System.err.println("Error: "+ e.getMessage());
			}
			
			
		  }
		}
	}