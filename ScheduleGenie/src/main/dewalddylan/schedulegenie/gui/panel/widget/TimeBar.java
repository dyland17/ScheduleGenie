package main.dewalddylan.schedulegenie.gui.panel.widget;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TimeBar {
	private int x, y;
	private int width;
	private final int height;
	private Color barColor = new Color(0,0,200,255);
	
	public TimeBar(int x, int y, int totalHours) {
			this.x = x;
			this.y = y;
			this.width = totalHours * TimeChart.BLOCKSIZE;
			height = (int) (TimeChart.BLOCKSIZE * .6);
	}
	public TimeBar(int x, int y, int totalHours, Color color) {
		this(x,y,totalHours);
		barColor = color;
	}
	public void paint(Graphics2D g2d) {
		g2d.setColor(barColor);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.fill3DRect(x, y, width, height, true);
		
	}
}
