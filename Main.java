// Pascal Phoa - Lecture26 Homework

public class Main{
	public static void main(String[] args){

		Decorator decorator = new Decorator();
		
		// Build and display
		decorator.BuildHouse();
		decorator.displayHouse(decorator.getHouse());

		System.out.println("\n Making some changes... \n");

		// Testing functions
		decorator.setFloorColor("Downstairs", "Blue", true);
		decorator.setWallColor("Bedroom1", "Green", false);

		decorator.addFurniture("Chair", "Bedroom1");
		decorator.addFurniture("TV", "Living Room");
		//decorator.removeFurniture("Table", "Kitchen");

		decorator.displayHouse(decorator.getHouse());

		int countHouse = decorator.countInventory("House");
		System.out.println("Num of inventories House: " + countHouse);

		int countUpstairs = decorator.countInventory("Upstairs");
		System.out.println("Num of inventories Upstairs: " + countUpstairs);


	}
}
