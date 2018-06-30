package main.dewalddylan.schedulegenie.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

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
		super(GUIDim.MAINPANELDIM, Panel.DARKBORDER);
		init();
		setupPanel();
	}
	
//	private void setupGraphPanel() {
//		tabbedPane = new JTabbedPane();
//		tabbedPane.setPreferredSize(this.getPreferredSize());
//		String[] days = {"Sunday","Monday","Tuesday","Wednesday",
//							"Thursday","Friday","Saturday"};
//		for(int i = 0; i < 7; i++){
//			GraphPanel drawPanel = new GraphPanel();
//			JScrollPane scrollPane = new JScrollPane(drawPanel);
//			tabbedPane.add(days[i], scrollPane);
//		}
//		outsidePanel.add(tabbedPane,BorderLayout.EAST);
//	}
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
	
	public Panel getSelectedTabPanel(){
		return (Panel) tabbedPane.getSelectedComponent();
	}
	

}