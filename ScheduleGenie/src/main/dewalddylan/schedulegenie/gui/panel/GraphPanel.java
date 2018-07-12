package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class GraphPanel extends Panel{
	private JTabbedPane tabbedPane;
	private static final String[] days ={"Sunday","Monday","Tuesday","Wednesday",
														"Thursday","Friday","Saturday"};
	
	public GraphPanel() {
		super(GUIDim.MAINPANELDIM, "GraphPanel: " ,Panel.NOTHINGBORDER);
		init();
		setupPanel();
	}
	
	@Override
	protected void init() {
		tabbedPane = new JTabbedPane();
		for(int i = 0; i < 7; i++){
			ChartPanel drawPanel = new ChartPanel();
			tabbedPane.add(days[i], drawPanel);
		}
		
	}
	@Override
	protected void setupPanel() {
		this.add(tabbedPane);
	}
	
	public void paint(){
		getSelectedTabPanel().repaint();
	}
	
	public Panel getSelectedTabPanel(){
		return (Panel) tabbedPane.getSelectedComponent();
	}
	

}