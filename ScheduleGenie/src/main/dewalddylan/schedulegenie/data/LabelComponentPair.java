package main.dewalddylan.schedulegenie.data;

import javax.swing.JComponent;
import javax.swing.JLabel;

import main.dewalddylan.schedulegenie.data.component.Component;
public class LabelComponentPair{
	//private TypeOfTextField textFieldType;
	private Component<JComponent> editableField;
	private JLabel labelName;
	public static final int  TFSIZE = 8;
	
	public LabelComponentPair(String name, Component<JComponent> editableComponent){
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
	
	public JComponent getComponentPart(String name){
		return (JComponent) editableField.get(name);
	}
	
	public void  addComponentPart(String name, JComponent componentPart){
		editableField.add(name, componentPart);
	}
}
