package battle;

public class Destroyer extends Ship{
	public Destroyer(){
		length = 2;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	@Override
	public String getShipType(){
		return "destroyer";
	}
}
