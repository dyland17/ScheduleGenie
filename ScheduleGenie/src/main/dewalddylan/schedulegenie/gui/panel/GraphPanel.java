package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import main.dewalddylan.schedulegenie.data.Employee;
import main.dewalddylan.schedulegenie.data.enumerations.WorkDay;
import main.dewalddylan.schedulegenie.data.names.GUIDim;

public class GraphPanel extends Panel{
	private JTabbedPane tabbedPane;
	public GraphPanel() {
		super(GUIDim.MAINPANELDIM, "GraphPanel: " ,Panel.NOTHINGBORDER);
		init();
		setupPanel();
	}
	
	@Override
	protected void init() {
		tabbedPane = new JTabbedPane();
		WorkDay[] days = WorkDay.values();
		for(int i = 0; i < 7; i++){
			ChartPanel drawPanel = new ChartPanel();
			tabbedPane.add(days[i].toString(), drawPanel);
		}
		
	}
	@Override
	protected void setupPanel() {
		this.add(tabbedPane);
	}
	
	public WorkDay getCurrentDay() {
		return WorkDay.values()[tabbedPane.getSelectedIndex()];
	}
	
//	public void paint(LinkedList<Employee> employeeList){
//		ChartPanel panel = (ChartPanel) getSelectedTabPanel();
//		panel.pai
//	}
	
	public Panel getSelectedTabPanel(){
		return (Panel) tabbedPane.getSelectedComponent();
	}
	

}