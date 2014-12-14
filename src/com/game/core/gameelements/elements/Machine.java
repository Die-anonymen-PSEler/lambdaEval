package com.game.core.gameelements.elements;

public class Machine extends GameElement {
	
	/**
	 * represents the color of the machine
	 */
	private int colorId;
	
	public Machine(int colorId) {
		this.colorId = colorId;
		type = GameElementTypes.MACHINE;
	}
	
	public int getColorId() {
		return colorId;
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return "Ich bin ein Machine und habe " + colorId;
	}

}
