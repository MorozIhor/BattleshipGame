package game;

import java.util.ArrayList;
import java.util.Random;

public class Ships {

	private int [][] battlefield = new int [10][10];
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private final int[] typeOfShips = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
	private Random random;
	
	
	Ships(){
		random = new Random();
		for(int i = 0; i < typeOfShips.length; i++){
			Ship ship;
			do{
				int x = random.nextInt(10);
				int y = random.nextInt(10);
				int position = random.nextInt(2);
				ship = new Ship(x, y, typeOfShips[i], position);
			}while(ship.isOutOfField() || isOverlayOrTouchShip(ship));
			ships.add(ship);
		}
		addShipsToBattlefield();
	}
	
	boolean isOverlayOrTouchShip(Ship nextShip){
		for(Ship ship : ships){
			if(ship.isOverlayOrTouch(nextShip)){
				return true;
			}
		}
		return false;
	}
	
	void addShipsToBattlefield(){
		for(Ship ship : ships){
			ship.addShipToArray(battlefield);
		}
	}

	public int[][] getBattlefield() {
		return battlefield;
	}
	
}
