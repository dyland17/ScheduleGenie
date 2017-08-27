package main.dewalddylan.schedulegenie.gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ScheduleScreen extends Window{
	//GUI components
	private JPanel optionPanel;
	private JTabbedPane tabbedPane;
	private JPanel outsidePanel;
	private JButton saveButton;
	private JButton editButton;
	//Dimensions for gui
	public static final Dimension OPTIONPANELSIZE = new Dimension(190,620);
	public static final Dimension SCHEDULEPANELSIZE = new Dimension(500,560);
	public ScheduleScreen() {
		super(Window.SCHEDULESCREEN, Window.MAINSCREEN);
		setupScreen();
		this.finishPackingScreen();
	}

	private void setupScreen() {
		Container c = window.getContentPane();
		outsidePanel = new JPanel();
		outsidePanel.setPreferredSize(Window.SCHEDULESCREEN);
		setupOptionPanel();
		setupGraphPanel();
		c.add(outsidePanel);
	}

	private void setupGraphPanel() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(SCHEDULEPANELSIZE);
		String[] days = {"Sunday","Monday","Tuesday","Wednesday",
							"Thursday","Friday","Saturday"};
		for(int i = 0; i < 7; i++){
			SchedulePanel drawPanel = new SchedulePanel();
			JScrollPane scrollPane = new JScrollPane(drawPanel);
			tabbedPane.add(days[i], scrollPane);
		}
		outsidePanel.add(tabbedPane,BorderLayout.EAST);
	}

	private void setupOptionPanel() {
		optionPanel = new JPanel();
		optionPanel.setPreferredSize(OPTIONPANELSIZE);
		optionPanel.setLayout(new FlowLayout());
		//Buttons for right now, might add scroll down menu before buttons.
		saveButton = new JButton("Save");
		saveButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		optionPanel.add(saveButton);
		editButton = new JButton("Edit");
		editButton.setPreferredSize(Window.SCHEDULEBUTTONSIZE);
		optionPanel.add(editButton);
		outsidePanel.add(optionPanel, BorderLayout.WEST);
	}
}
