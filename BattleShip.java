package battle;

public class BattleShip extends Ship{
	public BattleShip(){
		length = 4;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	@Override
	public String getShipType(){
		return "battleship";
	}

}
