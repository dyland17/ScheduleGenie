package main.dewalddylan.schedulegenie.data.component;

import java.util.ArrayList;
import java.util.HashMap;

public class Component<T> {
	private HashMap graphicPart;

	public <T> Component(){
		graphicPart = new HashMap<String,T>();
	}
	public  T get(String name){
		return (T) graphicPart.get(name);
	}
	
	public void add(String name, T componentPart){
		graphicPart.put(name, componentPart);
	}
	
	public HashMap<String, T> getPartList(){
		return graphicPart;
	}
}
