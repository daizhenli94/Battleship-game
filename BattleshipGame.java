package battle;

import java.util.Scanner;

public class BattleshipGame {
	public boolean checkInput(String input){
		if(input.length() != 1){
			return false;
		}
		char c = input.charAt(0);
		if(!Character.isDigit(c)){
			return false;
		}
		return true;
	}
	
	public void play(){
		Scanner s = new Scanner(System.in);
		Ocean ocean = new Ocean();
		ocean.pleaceAllShipRandomly();
		while(!ocean.isGameOver()){
			ocean.printMap();
			ocean.print();
			System.out.println("Enter a row number 0-9");
			String rowInput = s.nextLine();
			while(!checkInput(rowInput)){
				System.out.println("Wrong input, enter number 0-9");
				rowInput = s.nextLine();
			}
			int row = rowInput.charAt(0) - '0';
			System.out.println("Enter a column number 0-9");
			String colInput = s.nextLine();
			while(!checkInput(colInput)){
				System.out.println("Wrong input, enter number 0-9");
				colInput = s.nextLine();
			}
			int col = colInput.charAt(0) - '0';
			ocean.shootAt(row, col);
			System.out.println("Shots Fired: " + ocean.getShotsFired());
			System.out.println("Hit Count: " + ocean.getHitCount());
			System.out.println("Ships Sunk: " + ocean.getShipsSunk());
			
			
			
			
		}
		System.out.println("Game is Over");
		s.close();
	}
	public static void main(String[] args){
		BattleshipGame bs = new BattleshipGame();
		bs.play();
		
		
		
		
	}
}
