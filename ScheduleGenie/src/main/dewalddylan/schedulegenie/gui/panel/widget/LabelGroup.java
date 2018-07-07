package main.dewalddylan.schedulegenie.gui.panel.widget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.dewalddylan.schedulegenie.data.enumerations.LabelOrientation;

public class LabelGroup {
	private Label[] label;
	private int labelEmptyIndex;
	private int labelCount;
	private int startXPos, startYPos;
	private final boolean isLeftToRight;
	private int labelXMargin;
	private int labelYMargin;
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

	private void initLabels(int startXPos, int startYPos, int labelCount) {
		label = new Label[labelCount];
		this.startXPos = startXPos;
		this.startYPos = startYPos;
		this.labelEmptyIndex = 0;
		this.labelCount = 0;
		this.labelFont = new Font(Font.SANS_SERIF,Font.BOLD, 12);
	}

	public void add(String name){
		checkSize();
		int xPos, yPos;
		//vvvv Change 50 later vvvv
		if(isLeftToRight){
			xPos = startXPos+TimeChart.BLOCKSIZE*labelEmptyIndex+labelXMargin;
			yPos = startYPos + labelYMargin;
		}
		else{
			xPos = startXPos+labelXMargin;
			yPos = startYPos +TimeChart.BLOCKSIZE*labelEmptyIndex+ labelYMargin;
		}
		Label newLabel = new Label(xPos, yPos, name, this); 
		label[labelEmptyIndex] = newLabel;
		updateLabelCount();
	}


	public void paint(Graphics2D g2d){
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

	public void setXLabelMargin(int xAmount){
		this.labelXMargin = xAmount;
		fixLabelPositions();
	}

	public void setYLabelMargin(int yAmount){
		this.labelYMargin = yAmount;
		fixLabelPositions();
	}

	private void fixLabelPositions() {
		if(labelCount == 0)
			return;
		
		for(Label labelIndex: label){
			if(isLeftToRight)
				labelIndex.setLocation(startXPos+TimeChart.BLOCKSIZE*labelEmptyIndex+labelXMargin, startYPos + labelYMargin);
			else
				labelIndex.setLocation(startXPos+labelXMargin, startYPos +TimeChart.BLOCKSIZE*labelEmptyIndex+ labelYMargin);
		}

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
	private  int xPos, yPos;
	private final String name;
	private LabelGroup group;
	
	public Label(int xPos, int yPos, String labelName, LabelGroup group){
		this.xPos = xPos;
		this.yPos = yPos;
		name = labelName;
		this.group = group;
	}
	
	public void translate(int xAmount, int yAmount){
		this.xPos += xAmount;
		this.yPos += yAmount;
	}
	
	public void setLocation(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void paint(Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.setFont(group.getGroupFont());
		g2d.drawString(name, xPos, yPos);
	}
}
