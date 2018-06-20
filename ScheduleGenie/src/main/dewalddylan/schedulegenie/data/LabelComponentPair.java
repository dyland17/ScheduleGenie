package main.dewalddylan.schedulegenie.data;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import main.dewalddylan.schedulegenie.data.component.Component;
public class LabelComponentPair<T>{
	//private TypeOfTextField textFieldType;
	private Component editableField;
	private JLabel labelName;
	public static final int  TFSIZE = 6;
	
	public <T> LabelComponentPair(String name, Component<T> editableComponent){
		//textField = new JTextField(TFSIZE);
		labelName = new JLabel(name);
		editableField = editableComponent;
		//textFieldType = typeOfField;
	}
	/*public void changeBorderColor(Color color){
		textField.setBorder(BorderFactory.createLineBorder(color));
	}*/
	
	/*public TypeOfTextField getTextFieldType() {
		return textFieldType;
	}*/
	
	public JLabel getJLabel(){
		return labelName;
	}
	
	public T getComponentPart(String name){
		return (T) editableField.get(name);
	}
	
	public <T> void  addComponentPart(String name, T componentPart){
		editableField.add(name, componentPart);
	}
}
