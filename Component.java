// Pascal Phoa - Lecture26 Homework

public interface Component {
	public void display();  // display is used for printing
	public void setWallColor(String color, boolean applyToChildren);
	public void setFloorColor(String color, boolean applyToChildren);
	public void addFurniture(Component furnitureName);
	// public void removeFurniture(String furniture);
	public int countInventory(Component object);
	public Component getAreaObject(String areaName);  // This is a helper function.  Pass it the name of an area and it returns the object.
}
