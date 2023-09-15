import java.util.Scanner;

public class RockPaperScissors{
	public static void main(String[] args){
		Move rock = new Move("Rock");
		Move paper = new Move("Paper");
		Move scissors = new Move("Scissors");
		try (Scanner sc = new Scanner (System.in)) {
			rock.setStrongAgainst(scissors);
			paper.setStrongAgainst(rock);
			scissors.setStrongAgainst(paper);
			
			int roundsToWin = 2;
			boolean runAgain = true;

			while(runAgain){
				System.out.printf("%nWelcome to Rock, Paper, Scissors. Please choose an option:%n");
				System.out.println("1. Start game");
				System.out.println("2. Change number of rounds.");
				System.out.println("3. Exit");
				System.out.printf("> ");
				int choice = sc.nextInt();

				if(choice == 3){
					runAgain = false;
					break;
				}

				else if(choice == 2){
					System.out.printf("%nHow many wins are needed to win a match?%n> ");
					roundsToWin = sc.nextInt();
					System.out.printf("%n");
					continue;
				}

				else if(choice == 1){
					System.out.printf("%nThis match will be the first to %d wins %n", roundsToWin);
					int pPoints = 0;
					int compPoints = 0;

					while(pPoints < roundsToWin && compPoints < roundsToWin){
						int random = (int) Math.floor(Math.random()*3) + 1;

						Move compMove = rock; //placeholder
						Move pMove = paper; //placeholder

						if(random == 1){compMove = rock;}
						if(random == 2){compMove = paper;}
						if(random == 3){compMove = scissors;}

						System.out.println("The computer has selected its move. Select your move:");
						System.out.println("1. Rock");
						System.out.println("2. Paper");
						System.out.println("3. Scissors");
						System.out.printf("> ");
						int pchoice = sc.nextInt();

						if(pchoice == 1){pMove = rock;}
						else if(pchoice == 2){pMove = paper;}
						else if(pchoice == 3){pMove = scissors;}
						else{
							System.out.println("Please only enter an input from 1-3.");
							continue;
						}
						
						String outcome = "";
						
						switch(Move.compareMoves(pMove, compMove)){
							case 0:
								outcome = " Player wins round!";
								pPoints++;
								break;
							case 1:
								outcome = " Computer wins round!";
								compPoints++;
								break;
							case 2:
								outcome = " Round is tied!";
								break;
						}
					
						System.out.printf("%nPlayer chose %s. Computer chose %s.%s%n", pMove.getName(), compMove.getName(), outcome);
						System.out.printf("Player - %d. Computer - %d%n%n", pPoints, compPoints);
					}
					if(pPoints > compPoints){System.out.printf("Player wins!%n");}
					else if(pPoints < compPoints){System.out.printf("Computer wins!%n");}

				}

				else{
					System.out.println("Please only enter an input from 1-3.");
					continue;
				}

			}
		}

	}


}