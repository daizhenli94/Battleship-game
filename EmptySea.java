package battle;

public class EmptySea extends Ship{
	public EmptySea(){
		length = 1;
	}
	
	@Override
	public boolean shootAt(int row, int col){
		hit[0] = true;
		return false;
	}
	
	@Override
	public boolean isSunk(){
		return false;
	}
	
	@Override
	public String getShipType(){
		return "empty";
	}
	
	@Override
	public String toString(){
		if(hit[0]){
			return "-";
		}
		return ".";
	}
	
	
}
