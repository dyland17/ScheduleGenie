package main.dewalddylan.schedulegenie.tools;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class GUIBuilderFactory {
	public static JButton buildButton(String buttonName, ActionListener listener) {
		JButton builtButton = new JButton(buttonName);
		builtButton.setPreferredSize(GUIDim.SCHEDULEBUTTONDIM);
		builtButton.addActionListener(listener);
		return builtButton;
	}
}
