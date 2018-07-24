package main.dewalddylan.schedulegenie.data;

public class Position {
	private final int xPos;
	private final int yPos;
	private final int xOffset;
	private final int yOffset;
	/**
	 * 
	 * @param xPos position of x coordinate.
	 * @param yPos position of y coordinate.
	 * @param offset for x and y positions.
	 */
	public Position(int xPos, int yPos, int offset){
		this.xPos = xPos;
		this.yPos = yPos;
		this.xOffset = offset;
		this.yOffset = offset;
	}
	/**
	 * 
	 * @param xPos position of x coordinate.
	 * @param yPos position of y coordinate.
	 * @param xOffset offset of x position.
	 * @param yOffset offset of y position.
	 */
	public Position(int xPos, int yPos, int xOffset, int yOffset) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	/**
	 * 
	 * @return xPos plus xOffset if an offset exists.
	 */
	public int xPos() {
		return (xPos + xOffset);
	}
	/**
	 * 
	 * @return yPos plus yOffset if an offset exists.
	 */
	public int yPos() {
		return (yPos + yOffset);
	}
	public int xOffset() {
		return xOffset;
	}
	public int yOffset() {
		return yOffset;
	}
	/**
	 * @param xPos new xPos for Position object.
	 * @param yPos new yPos for Position object.
	 * @return new instance of the Position object.
	 * <h2>Note:
	 * 			<p>
	 * 				  xOffset: value is equal to the previous instance of the object. <br>
	 * 			 	  yOffset: value is equal to the previous instance of the object.
	 * 			</p>
	 * <h2/>
	 */
	public Position newInstance(int xPos, int yPos){
		return new Position(xPos, yPos, this.xOffset, this.yOffset);
	}
	/**
	 * @param xPos new xPos for Position object.
	 * @param yPos new yPos for Position object.
	 * @param offset x and y are equal to the offset value.
	 * @return new instance of the Position object.
	 */
	public Position newInstance(int xPos, int yPos, int offset){
		return new Position(xPos, yPos, offset);
	}
	/**
	 * @param xPos new xPos for Position object.
	 * @param yPos new yPos for Position object.
	 * @param xOffset x offset.
	 * @param yOffset y offset.
	 * @return new instance of the Position object.
	 */
	public Position newInstance(int xPos, int yPos, int xOffset, int yOffset){
		return new Position(xPos, yPos, xOffset, yOffset);
	}
}
