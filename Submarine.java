package battle;

public class Submarine extends Ship{
	public Submarine(){
		length = 1;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	@Override
	public String getShipType(){
		return "submarine";
	}
}
