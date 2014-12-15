package com.game.core.gameelements.elements;

public class Metal extends GameElement {
	
	/**
	 * represents the color of the machine
	 */
	private int colorId;
	
	/**
	 * 
	 * @param colorId the color of the metal piece
	 */
	public Metal(int colorId) {
		this.colorId = colorId;
		type = GameElementTypes.METAL;
	}
	
	/**
	 * 
	 * @return the represent of the color of the metal piece as integer
	 */
	public int getColorId() {
		return colorId;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * debug use
	 */
	@Override
	public String toString() {
		return "Ich bin ein Metallstück und habe " + colorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colorId;
		return result;
	}
	
	@Override
	/**
	 * @param obj the other object in question
	 * @return true if obj is the same or is also a metal object with the same color id
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Metal other = (Metal) obj;
		if (colorId != other.colorId)
			return false;
		return true;
	}
}
