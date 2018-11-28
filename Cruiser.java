package battle;


public class Cruiser extends Ship{
	public Cruiser(){
		length = 3;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	@Override
	public String getShipType(){
		return "cruiser";
	}
}
