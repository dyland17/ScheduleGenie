package main.dewalddylan.schedulegenie.data;

public class Position {
	private final int xPos;
	private final int yPos;
	private final int xIndent;
	private final int yIndent;
	/**
	 * 
	 * @param xPos position of x coordinate.
	 * @param yPos position of y coordinate.
	 * @param indent indentation of x and y positions.
	 */
	public Position(int xPos, int yPos, int indent){
		this.xPos = xPos;
		this.yPos = yPos;
		xIndent = indent;
		yIndent = indent;
	}
	/**
	 * 
	 * @param xPos position of x coordinate.
	 * @param yPos position of y coordinate.
	 * @param xIndent indentation of x position.
	 */
	public Position(int xPos, int yPos, int xIndent, int yIndent) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xIndent = xIndent;
		this.yIndent = yIndent;
	}
	/**
	 * 
	 * @return xPos plus xIndent if a indent exist.
	 */
	public int xPos() {
		return (xPos + xIndent);
	}
	/**
	 * 
	 * @return yPos plus yIndent if a indent exist.
	 */
	public int yPos() {
		return (yPos + yIndent);
	}
	public int getxIndent() {
		return xIndent;
	}
	public int getyIndent() {
		return yIndent;
	}
	/**
	 * @param xPos new xPos for Position object.
	 * @param yPos new yPos for Position object.
	 * @return new instance of the Position object.
	 * <h2>Note:
	 * 			<p>
	 * 				  xIndent: value is equal to the previous instance of the object. <br>
	 * 			 	  yIndent: value is equal to the previous instance of the object.
	 * 			</p>
	 * <h2/>
	 */
	public Position newInstance(int xPos, int yPos){
		return new Position(xPos, yPos, this.xIndent, this.yIndent);
	}
	/**
	 * @param xPos new xPos for Position object.
	 * @param yPos new yPos for Position object.
	 * @param indent x and y indentation are equal to indent value.
	 * @return new instance of the Position object.
	 */
	public Position newInstance(int xPos, int yPos, int indent){
		return new Position(xPos, yPos, indent);
	}
	/**
	 * @param xPos new xPos for Position object.
	 * @param yPos new yPos for Position object.
	 * @param xIndent x indentation.
	 * @param yIndent y indentation.
	 * @return new instance of the Position object.
	 */
	public Position newInstance(int xPos, int yPos, int xIndent, int yIndent){
		return new Position(xPos, yPos, xIndent, yIndent);
	}
}
