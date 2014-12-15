package com.game.core.gameelements.elements;

public abstract class GameElement {
	/**
	 * the position of the gameelement
	 */
	private int posX, posY;
	
	/**
	 * true if the element was picked up by the player
	 */
	private boolean pickedUp;
	
	GameElementTypes type;
	
	/**
	 * returns the position of the gameelement on thee map
	 * @return a vector2d containing the coordinates
	 */
	public Vector2d getPosition() {
		Vector2d result = new Vector2d();
		result.x = (double) posX;
		result.y = (double) posY;
		return result;
	}
	
	/**
	 * 
	 * @return true if the element is picked up; false otherwise
	 */
	public boolean isPickedUp() {
		return pickedUp;
	}
	
	/**
	 * sets pickedUp to true
	 */
	public void pickUp() {
		pickedUp = true;
	}
	
	/**
	 * sets picked up to false
	 */
	public void place() {
		pickedUp = false;
	}
	
	/**
	 * attempts to render the gameelement to the screen
	 */
	public abstract void render();
}
