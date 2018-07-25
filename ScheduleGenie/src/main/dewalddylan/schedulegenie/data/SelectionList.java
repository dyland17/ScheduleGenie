package main.dewalddylan.schedulegenie.data;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import main.dewalddylan.schedulegenie.gui.button.Button;
import main.dewalddylan.schedulegenie.gui.button.PlusButton;
//vvvv Trying to get rid of this extra list class. vvvv
public class SelectionList implements Iterable<SelectionItem>{
	private ArrayList<SelectionItem> itemList;
	//private static PlusButton plusButton = new PlusButton((int)(SelectionItem.WIDTH/2 -Button.PLUSBUTTONSIZE/2),getProperYPos(0));
	private SelectionItem currentSelectedItem;
	public SelectionList(){
		itemList = new ArrayList<SelectionItem>();
		currentSelectedItem = null;
	}
	//public SelectionList(ArrayList<SelectionItem> itemList){
//		this.itemList = itemList;
//		plusButton.moveButton(getProperYPos(this.itemList.size()));
//		currentSelectedItem = null;
	//}
	
	public void add(String itemName){
//		final int YPos = getProperYPos(itemList.size());
//		itemList.add(new SelectionItem(itemName, YPos));
//		plusButton.moveButton(YPos);
	}
	
	public void remove(SelectionItem item){
		itemList.remove(item);
		updateItemLocations();
	}
	
	private void updateItemLocations() {
//		for(int item = 0; item < itemList.size(); item++){
//			itemList.get(item).setLocation(getProperYPos(item));
//		}
//		plusButton.moveButton(getProperPlusButtonYPos());
	}
	public boolean isEmpty(){
		return itemList.isEmpty();
	}
	
//	public static int getProperYPos(int listIndex){
//		return ((listIndex * SelectionItem.HEIGHT) + SelectionItem.YOFFSET);
//	}
//	
//	private int getProperPlusButtonYPos(){
//		return getProperYPos((itemList.size() - 1));
//	}
	
//	public void paint(Graphics2D g2d){
//		for(SelectionItem item: itemList){
//			item.paint(g2d);
//		}
//		plusButton.paint(g2d);
//	}
	
	public void setSelectedItem(SelectionItem item){
		if(item == null){
			throw new UnsupportedOperationException("Cannot set selectedItem to null. "
																			  +"Please use resetSelectedItem method for this operation.");
		}
		if(currentSelectedItem == null){
			currentSelectedItem = item;
		}
		else{
			currentSelectedItem.setSelected(false);
			currentSelectedItem = item;
		}
		currentSelectedItem.setSelected(true);
			
	}
	public void resetSelectedItem(){
		if(currentSelectedItem != null){
			currentSelectedItem.setSelected(false);
			currentSelectedItem = null;
		}
	}
//	public Rectangle getPlusButtonBounds(){
//		return plusButton.getBounds();
//	}
	public static SelectionList convert(ArrayList<Employee> employeeList){
		SelectionList selectionList = new SelectionList();
		for(Employee employee: employeeList){
			selectionList.add(employee.fullName());
		}
		return selectionList;
	}
	
	@Override
	public Iterator<SelectionItem> iterator() {
		Iterator<SelectionItem> iterator = itemList.iterator();
		return iterator;
	}
}