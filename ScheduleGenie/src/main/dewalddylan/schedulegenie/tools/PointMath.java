package main.dewalddylan.schedulegenie.tools;

import java.awt.Point;

public class PointMath {
	public static Point getPointXDistance(Point point1, Point point2){
		return new Point((int)(point1.getX() - point2.getX()),(int)point1.getY());
	}
	public static Point getPointYDistance(Point point1, Point point2){
		return new Point((int)point1.getX(),(int)(point1.getY() - point2.getY()));
	}
	public static Point getDeltaPoint(Point point1, Point point2){
		return new Point((int)(point1.getX() - point2.getX()),(int)(point1.getY() - point2.getY()));
	}
	
	public static Point getPointAddition(Point point1, Point point2){
		return new Point((int)(point1.getX() + point2.getX()),(int)(point1.getY() + point2.getY()));
	}
	
	public static int getXAddition(int point1x, int point2x){
		return point1x + point2x;
	}
	
	public static int getXSubtraction(int point1x, int point2x){
		return point1x - point2x;
	}
}
