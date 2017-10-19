package game;

public class LetsTheGameBegin {

	public static void main(String[] args) {
		
		Ships ships = new Ships();
		int [][] array = ships.getBattlefield();
		
		System.out.println("~~~~( Battlefield )~~~~");
		System.out.println();
		System.out.println("   A B C D E F G H I J");
		for(int i = 0; i < array.length; i++ ){
			if(i < 9){
				System.out.print(i+1 + "  ");
			}else{
				System.out.print(i+1 + " ");
			}
			for(int j = 0; j < array[i].length; j++){
				if(array[i][j] == 0){
					System.out.print("- ");
				}else if(array[i][j] == 1){
					System.out.print("* ");
				}
			}
			System.out.println();
		}

	}

}
