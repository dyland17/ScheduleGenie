package main.dewalddylan.schedulegenie.data;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;
import main.dewalddylan.schedulegenie.gui.EmployeeScreen;
public class SGTextField extends JTextField {
	private TypeOfTextField textFieldType;
	public static final int  TFSIZE = 10;
	private String title;
	public SGTextField(TypeOfTextField typeOfField,String name){
		super(TFSIZE);
		title = name;
		textFieldType = typeOfField;
	}
	public void changeBorderColor(Color color){
		setBorder(BorderFactory.createLineBorder(color));
	}
	public TypeOfTextField getTextFieldType() {
		return textFieldType;
	}
	public String getTitle(){
		return title;
	}
}
