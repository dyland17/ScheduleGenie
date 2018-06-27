package main.dewalddylan.schedulegenie.tools;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class BorderTester {
	public static boolean testLineBorders(LineBorder border1, LineBorder border2){
		if(border1.getRoundedCorners() == border2.getRoundedCorners()){
			if(border1.getThickness() == border2.getThickness()){
				if(border1.getLineColor() == border2.getLineColor()){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean testBevelBorders(BevelBorder border1, BevelBorder border2){
		if(border1.getBevelType() == border2.getBevelType()){
			if(border1.getHighlightOuterColor() == border2.getHighlightOuterColor()){
				if(border1.getHighlightInnerColor() == border2.getHighlightInnerColor()){
					if(border1.getShadowInnerColor() == border2.getShadowInnerColor()){
						if(border1.getShadowOuterColor() == border2.getShadowOuterColor()){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
