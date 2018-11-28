package battle;



public class Ship {
	int bowRow;
	int bowCol;
	int length;
	boolean horizontal;
	boolean[] hit = new boolean[4];

	public int getLength(){
		return this.length;
	}

	public int getBowRow(){
		return bowRow;
	}

	public int getBowColumn(){
		return bowCol;
	}

	public boolean[] getHit(){
		return hit;
	}

	public boolean isHorizontal(){
		return horizontal;
	}

	public String getShipType(){
		return "";
	}

	public void setBowRow(int row){
		bowRow = row;
	}

	public void setBowColumn(int col){
		bowCol = col;
	}

	public void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}

	public boolean okToPlaceShipAt(int row, int col, boolean horizontal, Ocean ocean){
		// check the start point of ship is within the map
		if(row < 0 || row > 9){
			return false;
		}
		if(col < 0 || col > 9){
			return false;
		}

		// check the body is within the map and whether it touches any other ship
		if(!horizontal){
			if(row + length > 9){
				return false;
			}
			for(int i = row - 1; i <= row + length; i++){
				for(int j = col - 1; j <= col + 1; j++){
					if(i >= 0 && i <= 9 && j >= 0 && j <= 9){
						if(ocean.isOccupied(i, j)){
							return false;
						}
					}
				}
			}
		}
		else{
			if(col + length > 9){
				return false;
			}
			for(int i = row - 1; i <= row + 1; i++){
				for(int j = col - 1; j <= col + length; j++){
					if(i >= 0 && i <= 9 && j >= 0 && j <= 9){
						if(ocean.isOccupied(i, j)){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public void placeShipAt(int row, int col, boolean hori, Ocean ocean){
		this.bowRow = row;
		this.bowCol = col;
		this.horizontal = hori;
		if(hori){
			for(int i = col; i < col + length; i++){
				ocean.ships[row][i] = this;
			}
		}
		else{
			for(int i = row; i < row + length; i++){
				ocean.ships[i][col] = this;
			}
		}
	}
	
	public boolean shootAt(int row, int col){
		if(this.isSunk()){
			return false;
		}
		if(horizontal){
			if(row != this.bowRow){
				return false;
			}
			for(int i = bowCol; i < bowCol + length; i++){
				if(i == col){
					this.hit[i - bowCol] = true;
					return true;
				}
			}
			return false;
		}
		else{
			if(col != this.bowCol){
				return false;
			}
			for(int i = bowRow; i < bowRow + length; i++){
				if(i == row){
					this.hit[i - bowRow] = true;
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean isSunk(){
		for(int i = 0; i < length; i++){
			if(!hit[i]){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString(){
		if(isSunk()){
			return "x";
		}
		return "S";
	}
	
}
