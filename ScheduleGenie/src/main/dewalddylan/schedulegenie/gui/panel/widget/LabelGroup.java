package main.dewalddylan.schedulegenie.gui.panel.widget;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import main.dewalddylan.schedulegenie.data.Position;
import main.dewalddylan.schedulegenie.data.enumerations.LabelOrientation;

public class LabelGroup {
	private Label[] label;
	private int labelEmptyIndex;
	private int labelCount;
	private Position groupPosition;
	private final boolean isLeftToRight;
	private Font labelFont;

	public LabelGroup(int startXPos, int startYPos, LabelOrientation orientation){
		switch(orientation){
		case LEFTTORIGHT:
			isLeftToRight = true;
			break;
		case TOPTOBOTTOM:
			isLeftToRight = false;
			break;
		default:
			isLeftToRight = true;
		}
		initLabels(startXPos, startYPos, 10);
	}

	private void initLabels(int XPos, int YPos, int labelCount) {
		label = new Label[labelCount];
		this.groupPosition = new Position(XPos, YPos, Position.NO_OFFSET);
		this.labelEmptyIndex = 0;
		this.labelCount = 0;
		this.labelFont = new Font(Font.SANS_SERIF,Font.BOLD, 12);
	}

	public void add(String name){
		checkSize();
		Position labelPosition;
		final int  CHARTOFFSET = getChartOffset();
		final int STRINGOFFSET = 4;
		if(isLeftToRight){
			labelPosition = new Position(groupPosition.xPos(), groupPosition.yPos(), 
														(CHARTOFFSET -STRINGOFFSET), (STRINGOFFSET*2));
		}
		else{
			labelPosition = new Position(groupPosition.xPos(),groupPosition.yPos(),
														Position.NO_OFFSET, (CHARTOFFSET - STRINGOFFSET));
		}
		Label newLabel = new Label(labelPosition, name); 
		label[labelEmptyIndex] = newLabel;
		updateLabelCount();
	}


	public void paint(Graphics2D g2d){
		g2d.setFont(labelFont);
		for(int index = 0; index < labelCount; index++){
			label[index].paint(g2d);
		}
	}

	public void translate(int xAmount, int yAmount){
		for(int index = 0; index < labelCount; index++){
			label[index].translate(xAmount, yAmount);
		}
	}

	public Font getGroupFont(){
		return labelFont;
	}
	public void setGroupFont(Font groupFont){
		labelFont = groupFont;
	}
	
	private int getChartOffset(){
		return TimeChart.BLOCKSIZE * labelEmptyIndex;
	}
	
	private void updateLabelCount(){
		labelEmptyIndex++;
		labelCount++;
	}
	
	private void checkSize(){
		int arraySize = label.length;
		if((labelCount + 1) > arraySize){
			Label[] newLabel = new Label[(arraySize + 10)];
			for(int labelIndex = 0; labelIndex < arraySize; labelIndex++){
				newLabel[labelIndex] = label[labelIndex];
			}
			label = newLabel;
		}
	}
}
class Label{
	private  Position labelPosition;
	private final String name;
	
	public Label(int xPos, int yPos, String labelName){
		labelPosition = new Position(xPos, yPos, Position.NO_OFFSET);
		name = labelName;
	}
	
	public Label(Position position, String labelName){
		this.labelPosition = position;
		name = labelName;
	}
	
	public void translate(int xAmount, int yAmount){
		final int newXPos = labelPosition.xPos() + xAmount;
		final int newYPos = labelPosition.yPos() + yAmount;
		labelPosition =labelPosition.newInstance(newXPos, newYPos);
	}
	
	public void setLocation(int xPos, int yPos){
		labelPosition = labelPosition.newInstance(xPos, yPos);
	}
	
	public void paint(Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.drawString(name, labelPosition.xPos(), labelPosition.yPos());
	}
}
