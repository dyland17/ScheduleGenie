package main.dewalddylan.schedulegenie.data.manager;

import java.awt.Point;
import java.awt.Rectangle;

import main.dewalddylan.schedulegenie.data.SelectionItem;
import main.dewalddylan.schedulegenie.data.SelectionList;

public class MouseManager {
	public static boolean wasThePlusButtonClicked(Rectangle rectangle, Point clickPoint){
		return (rectangle.contains(clickPoint))?true:false;
	}
	
	public static SelectionItem wasASelectedItemClicked(SelectionList list, Point clickPoint){
		for(SelectionItem item: list){
			if(item.getBounds().contains(clickPoint)){
				if(item.getMinusButtonBounds().contains(clickPoint)){
					item.setMinusButtonClicked(true);
				}
				return item;
			}
		}
		return null;
	}
}
