package main.dewalddylan.schedulegenie.data.component;

import java.util.ArrayList;
import java.util.HashMap;

public class Component<JComponent> {
	private HashMap graphicPart;

	public Component(){
		graphicPart = new HashMap<String,JComponent>();
	}
	public  JComponent get(String name){
		return (JComponent) graphicPart.get(name);
	}
	
	public void add(String name, JComponent componentPart){
		graphicPart.put(name, componentPart);
	}
	
	public HashMap<String, JComponent> getPartList(){
		return graphicPart;
	}
}
