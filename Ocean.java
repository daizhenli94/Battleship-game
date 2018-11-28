package battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ocean {
	Ship[][] ships = new Ship[10][10];
	boolean[][] visited = new boolean[10][10];
	int shotsFired;
	int hitCount;
	int shipSunk;

	public Ocean(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				ships[i][j] = new EmptySea();
				visited[i][j] = false;
			}
		}
		shotsFired = 0;
		hitCount = 0;
		shipSunk = 0;
	}

	public void pleaceAllShipRandomly(){
		Random random = new Random();
		List<Ship> shipList = new ArrayList<>();
		shipList.add(new BattleShip());
		shipList.add(new Cruiser());
		shipList.add(new Cruiser());
		shipList.add(new Destroyer());
		shipList.add(new Destroyer());
		shipList.add(new Destroyer());
		shipList.add(new Submarine());
		shipList.add(new Submarine());
		shipList.add(new Submarine());
		shipList.add(new Submarine());

		for(Ship ship : shipList){
			int row;
			int col;
			boolean horizontal;
			do{
				row = random.nextInt(10);
				col = random.nextInt(10);
				int hori = random.nextInt(2);
				horizontal = false;
				if(hori == 0){
					horizontal = true;
				}
			}
			while(!ship.okToPlaceShipAt(row, col, horizontal, this));
			ship.placeShipAt(row, col, horizontal, this);
		}

	}
	
	public boolean isOccupied(int row, int col){
		if(this.ships[row][col].getShipType().equals("empty")){
			return false;
		}
		return true;
	}
	
	public boolean shootAt(int row, int col){
		visited[row][col] = true;
		this.shotsFired++;
		Ship hitShip = this.ships[row][col];
		if(hitShip.shootAt(row, col)){
			this.hitCount++;
			return true;
		}
		return false;
		
	}
	
	public int getShotsFired(){
		return this.shotsFired;
	}
	
	public int getHitCount(){
		return this.hitCount;
	}
	
	public int getShipsSunk(){
		return this.shipSunk;
	}
	
	public boolean isGameOver(){
		return this.shipSunk == 10;
	}
	
	public Ship[][] getShipArray(){
		return ships;
	}
	
	public void print(){
		System.out.println("   0  1  2  3  4  5  6  7  8  9");
		for(int i = 0; i <= 9; i++){
			System.out.print(i + " ");
			for(int j = 0; j <= 9; j++){
				String infomation = ".";
				if(visited[i][j]){
					infomation = ships[i][j].toString();
				}
				System.out.print("[" + infomation + "]");
			}
			System.out.println("");
		}
	}
	
	public void printMap(){
		System.out.println("   0  1  2  3  4  5  6  7  8  9");
		for(int i = 0; i <= 9; i++){
			System.out.print(i + " ");
			for(int j = 0; j <= 9; j++){
				char c = ships[i][j].getShipType().charAt(0);
				if(c == 'e'){
					c = '.';
				}
				System.out.print("[" + c + "]");
			}
			System.out.println("");
		}
	}
	


}
