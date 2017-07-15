package main.dewalddylan.schedulegenie.data;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import main.dewalddylan.schedulegenie.data.enumerations.TypeOfTextField;
public class SGTextField extends JTextField {
	private TypeOfTextField textFieldType;
	public SGTextField(int size, TypeOfTextField typeOfField){
		super(size);
		textFieldType = typeOfField;
	}
	public void changeBorderColor(Color color){
		setBorder(BorderFactory.createLineBorder(color));
	}
	public TypeOfTextField getTextFieldType() {
		return textFieldType;
	}
}
