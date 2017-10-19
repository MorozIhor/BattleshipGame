package game;

import java.util.ArrayList;

public class Ship {
	
	private ArrayList<Cell> cells = new ArrayList<>();
	
	Ship(int x, int y, int length, int position){
		for(int i = 0; i < length; i++){
			cells.add(new Cell(x + i * ((position==0) ? 1 : 0),
							   y + i * ((position==1) ? 1 : 0)));
		}
	}
	
	boolean isOverlayOrTouch(Ship anotherShip){
		for(Cell cell : cells){
			if(anotherShip.isOverlayOrTouchCell(cell)){
				return true;
			}
		}
		return false;
	}
	
	boolean isOverlayOrTouchCell(Cell anotherCell){
		for(Cell cell : cells){
			for(int dx = -1; dx < 2; dx++){
				for(int dy = -1; dy < 2; dy++){
					if(anotherCell.getX() == cell.getX() + dx && 
					   anotherCell.getY() == cell.getY() + dy){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	boolean isOutOfField(){
		for(Cell cell : cells){
			if(cell.getX() >= 10 || cell.getY() >= 10){
				return true;
			}
		}
		return false;
	}
	
	void addShipToArray(int array [][]){
		for(Cell cell : cells){
			array [cell.getX()][cell.getY()] = 1;
		}
	}

}
