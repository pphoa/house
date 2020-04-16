import java.util.ArrayList;
import java.util.List;

// Pascal Phoa = Lecture26 Homework

public class Composite implements Component{
	String name;
	String wallColor;
	String floorColor;
	List<Component> myChildren = new ArrayList<Component>();
	
	// Constructor.
	public Composite(String name) {
		this.name = name;
		this.wallColor = "Biege";
		this.floorColor = "Biege";
	}
	
	public void addChild(Component component) {
		myChildren.add(component);
	}

	public void removeChild(Component component){
		System.out.println("Removing object (Composite)");
		myChildren.remove(component);
		System.out.println("FInished removing (Composite)");
	}

	@Override
	public void display() {
		System.out.println(this.name + "  " + this.wallColor + " wall " + this.floorColor + " floor ");	// Composite node prints itself first
		for (Component child: myChildren) {  // then it delegates the task of printing to its children too
			child.display();
		}
	}

	@Override
	public void setWallColor(String color, boolean apply) {
		this.wallColor = color;
		if(!apply) return;
		for (Component child: myChildren) {
			child.setWallColor(color, apply);
		}
		
	}

	@Override
	public void setFloorColor(String color, boolean apply) {
		this.floorColor = color;
		if(!apply) return;
		for (Component child: myChildren) {
			child.setFloorColor(color, apply);
		}
		
	}

	@Override
	public void addFurniture(Component furniture){ addChild(furniture); }

	//@Override
	//public void removeFurniture(String furniture) { removeChild(new Composite(furniture)); }

	@Override
	public int countInventory(Component object){
		int count = 0;
		if(object.getClass() == LeafNode.class) count++;

		for(Component child : myChildren){
			count = child.countInventory(child) + count;
		}

		return count;
	}

	@Override
	public Component getAreaObject(String areaName) {
		if (this.name.equals(areaName))
			return this;
		else {
			Component areaObject = null;
			for (Component child: myChildren) {
				areaObject = child.getAreaObject(areaName);
				if (areaObject !=null)
					break;
			}
			return areaObject;
		}		
	}
}
