// Pascal Phoa - Lecture26 Homework

public class LeafNode implements Component{
	String name;
	
	// Constructor
	public LeafNode(String name) {
		this.name =  name;
	}
	
	@Override
	public void display() {
		System.out.println(this.name);		
	}

	@Override
	public void setWallColor(String color, boolean applyToChildren) {}

	@Override
	public void setFloorColor(String color, boolean applyToChildren) {}

	@Override
	public void addFurniture(Component furniture) {}

	//@Override
	//public void removeFurniture(String furniture) {}

	@Override
	public int countInventory(Component object) { return 1; }

	@Override
	public Component getAreaObject(String areaName) {
		if (this.name.equals(areaName))
			return this;
		else
			return null;
	}

}
