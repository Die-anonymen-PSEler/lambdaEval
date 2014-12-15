package com.game.core.gameelements;

public abstract class Component {
	
	/**
	 * evaluates the component and returns the resulting 
	 * @param comp the component that shall be used for evluation. may be null
	 * @return the resulting component of the evaluation
	 */
	public abstract Component eval(Component comp);
}
