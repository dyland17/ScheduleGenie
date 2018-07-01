package main.dewalddylan.schedulegenie.tools;

import java.awt.GridBagConstraints;

public class GridBagHelper {
	public static void setupConstraints(GridBagConstraints gbc, int x, int y){
		gbc.gridx = x;
		gbc.gridy = y;
	}
	
	public static void setupConstraints(GridBagConstraints gbc, int x, int y, int width, int height){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
	}
	
	public static void setupConstraints(GridBagConstraints gbc, int x, int y,  int fill){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.fill = fill;
	}
	
	public static void setupConstraints(GridBagConstraints gbc, int x, int y,  int fill, double weightx,double weighty){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.fill = fill;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
	}
}
