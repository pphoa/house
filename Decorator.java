// Pascal Phoa - Lecture26 Homework

public class Decorator {
	
	Composite myHouse;
	LeafNode leaf;	
	
	public void BuildHouse() {
		leaf = new LeafNode("Chair");
		myHouse = new Composite("House");
                Composite upStairs = new Composite("Upstairs");
                Composite downStairs = new Composite("Downstairs");
                myHouse.addChild(upStairs);
                myHouse.addChild(downStairs);

                // Upstairs             
                Composite bed1 = new Composite("Bedroom1");
                Composite bed2 = new Composite("Bedroom2");
                Composite bath = new Composite("Bathroom");

                upStairs.addChild(bed1);
                upStairs.addChild(bed2);
                upStairs.addChild(bath);
                bed1.addChild(new LeafNode("Bed"));
                bed1.addChild(new LeafNode("Dresser"));
                bed2.addChild(new LeafNode("Double Bed"));
                bed2.addChild(new LeafNode("Dresser"));
                bed2.addChild(new LeafNode("Chair"));
                bed2.addChild(new LeafNode("Chair"));
                bath.addChild(new LeafNode("Shower Curtain"));
                bath.addChild(new LeafNode("Cabinet"));	

		// Downstairs
                Composite living = new Composite("Living Room");
                Composite kitchen = new Composite("Kitchen");
                Composite hallway = new Composite("Hallway");

                downStairs.addChild(living);
                downStairs.addChild(kitchen);
                downStairs.addChild(hallway);
                living.addChild(new LeafNode("Couch"));
                living.addChild(new LeafNode("Coffee Table"));
                living.addChild(new LeafNode("Armchair"));
                living.addChild(new LeafNode("Armchair"));
                kitchen.addChild(new LeafNode("Table"));
                kitchen.addChild(new LeafNode("Chair"));
                kitchen.addChild(new LeafNode("Chair"));
                kitchen.addChild(new LeafNode("Chair"));
                kitchen.addChild(new LeafNode("Chair"));
                hallway.addChild(new LeafNode("Dresser"));
                hallway.addChild(new LeafNode("Mirror"));
                hallway.addChild(new LeafNode("Closet"));
	}
	
	public void setWallColor(String areaName, String color, boolean applyToChildren) {
		Component myObject = myHouse.getAreaObject(areaName);
		if (myObject != null)
			myObject.setWallColor(color, applyToChildren);
	}

	public void setFloorColor(String areaName, String color, boolean applyToChildren) {
		Component myObject = myHouse.getAreaObject(areaName);
		if (myObject != null)
			myObject.setFloorColor(color, applyToChildren);
	}

	public void addFurniture(String furnitureName, String roomName){
		Component room = myHouse.getAreaObject(roomName);
		if(room != null)
			room.addFurniture(new LeafNode(furnitureName));
	}

	/*
	public void removeFurniture(String furnitureName, String roomName){
		Component room = myHouse.getAreaObject(roomName);
		if(room != null)
			System.out.println("here (decorator)");
			room.removeFurniture(furnitureName);
	}
	*/

	public int countInventory(String areaName){
		Component myObject = myHouse.getAreaObject(areaName);
		if(myObject.getClass() == LeafNode.class) return 1;
		return myObject.countInventory(myObject);
	}
	
	public Composite getHouse() {
		return myHouse;
	}
	
	public void displayHouse(Composite component) {
		myHouse.display();
	}
}	
