import java.util.Random;
import java.util.Scanner;


public class FootballGrid {

	public static String[][] grid;
	public static int count;
	
	public static void main(String[] args) {
		grid = new String[10][10];
		count = 0;
		run();
	}
	
	public static void assignSquare(String name){
		Random r = new Random();
		int i = r.nextInt(10);
		int j = r.nextInt(10);
		while ((grid[i][j] != null)){
			i = r.nextInt(10);
			j = r.nextInt(10);
		}
		grid[i][j] = name;
		count++;
		System.out.println(name + " bought Eagles " + i + ", Patriots " + j);
	}
	
	public static void printSquares(String name){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				if (grid[i][j].equals(name)){
					System.out.println(name + " has Rams " + i + ", Patriots " + j);
				}
			}
		}
	}
	
	public static void square(int i, int j){
		System.out.println(grid[i][j] + " has Eagles " + i + ", Patriots " + j);
	}
	
	public static void printGrid(){
		String[][] prettyGrid = new String[11][11];
		for (int i = 1; i < 11; i++){
			prettyGrid[i][0] = i - 1 + "";
			prettyGrid[0][i] = i - 1 + "";
			for (int j = 1; j < 11; j++){
				prettyGrid[i][j] = grid[i - 1][j - 1];
				if (prettyGrid[i][j] == null){
					prettyGrid[i][j] = "";
				}
			}
		}
		
		System.out.println("Rams along the top, Patriots along the side");
	    for(int i = 0; i < 11; i++){
	        for(int j = 0; j < 11; j++){
	            System.out.print(String.format("%10s", prettyGrid[i][j]));
	        }
	        System.out.println("");
	    }
	}
	
	public static void run(){
		while(true){
			System.out.println("Type 'buy {name} {number} to buy squares for {name}.");
			System.out.println("Type 'print {name} to show what squares {name} has");
			System.out.println("Type 'square {x} {y} to show who has square x, y");
			System.out.println("Type anything else to print grid");
			
			Scanner s = new Scanner(System.in);
			String line = s.nextLine();
			String[] parts = line.split("\\s+");
			if (parts[0].toLowerCase().startsWith("b")){
				for (int i = 0; i < Integer.parseInt(parts[2]); i++){
					assignSquare(parts[1]);
				}
				System.out.println();
				System.out.println(100 - count + " Squares remain");
			} else if (parts[0].toLowerCase().startsWith("p")){
				printSquares(parts[1]);
			} else if (parts[0].toLowerCase().startsWith("s")){
				square(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
			} else {
				break;
			}
		}
		printGrid();
	}

}
