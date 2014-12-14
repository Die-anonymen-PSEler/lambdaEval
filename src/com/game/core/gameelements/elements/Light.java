package com.game.core.gameelements.elements;

public class Light extends GameElement {
	
	private boolean green;
	
	public Light() {
		setGreen(false);
		type = GameElementTypes.LIGHT;
	}
	
	

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}



	public boolean isGreen() {
		return green;
	}



	public void setGreen(boolean green) {
		this.green = green;
	}

}
