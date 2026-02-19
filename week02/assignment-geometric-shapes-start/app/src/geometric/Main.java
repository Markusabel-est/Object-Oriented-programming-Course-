package geometric;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner scan;
	static Geometric[] arrayGeom;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		arrayGeom = new Geometric[10];
		int j;
		boolean mainLoop = true;

		while(mainLoop){
			System.out.println("Enter command");
			
			String command = scan.next();

			switch (command) {
				case "quit":
					mainLoop = false;
				case "show":
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;

				case "circle":
					j = 0;
					while(arrayGeom[j] != null && j < arrayGeom.length){
						j++;
					}
					if(arrayGeom[j] == null){
						double x = scan.nextDouble();
						double y = scan.nextDouble();
						double r = scan.nextDouble();
						arrayGeom[j] = new Circle(x, y, r);
					}
					else{
						System.out.println("Array is full");
					}
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;
				case "rectangle":
					j = 0;
					while(arrayGeom[j] != null && j < arrayGeom.length){
						j++;
					}
					if(arrayGeom[j] == null){
						double x = scan.nextDouble();
						double y = scan.nextDouble();
						double w = scan.nextDouble();
						double h = scan.nextDouble();
						arrayGeom[j] = new Rectangle(x, y, w, h);
					}
					else{
						System.out.println("Array is full");
					}
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;
				case "move":
					int m = scan.nextInt();
					double dx = scan.nextDouble();
					double dy = scan.nextDouble();
					if(m < arrayGeom.length && arrayGeom[m] != null){
						arrayGeom[m].move(dx, dy);
					}
					else{
						System.out.println("Out of range or object does not exist");
					}
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;
				case "remove":
					int k = scan.nextInt();
					if(k < arrayGeom.length && arrayGeom[k] != null){
						arrayGeom[k] = null;
					}
					else{
						System.out.println("The object you want delete is out of range or object does not exist");
					}
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;
				case "filter":
					String val = scan.next();
					double threshold = scan.nextDouble();
					GeometricPredicate g;
					if(val.equals("x")){
						g = new FilterByX(threshold);
					}
					else if(val.equals("y")){
						g = new FilterByY(threshold);
					}
					else{
						g = new FilterByArea(threshold);
					}
					for (int i = 0; i < arrayGeom.length; i++) {
						if(arrayGeom[i] != null){
							if (g.predicate(arrayGeom[i])) {
								arrayGeom[i] = null;
							}
						}
					}
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;
				case "sort":
					String va = scan.next();
					
					if (va.equals("x")){
						Arrays.sort(arrayGeom, new SortByX());
					}else if(va.equals("y")){
						Arrays.sort(arrayGeom, new SortByY());
					}
					else{
						Arrays.sort(arrayGeom, new SortByArea());
					}
					for (int i = 0; i < arrayGeom.length; i++) {
            			System.out.println(i + ": " + arrayGeom[i]);
        			}
					break;
				default:
					System.out.println("unknown command");
			}
		}
	}
}
