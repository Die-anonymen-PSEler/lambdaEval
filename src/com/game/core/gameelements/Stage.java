package com.game.core.gameelements;

import java.util.ArrayList;
import java.util.List;

public class Stage extends Component {
	
	private List<Component> components;
	
	public Stage() {
		components = new ArrayList<Component>();
	}
	
	public void addComponent(Component c) {
		components.add(c);
	}

	/**
	 * eval on stage always return a list with one element
	 */
	@Override
	public Component eval(Component comp) {
		for (int i = 0; i < components.size(); i++) {
			if (components.get(i).getClass() == Stage.class) {
				components.set(i, components.get(i).eval(null));
			}
		}
		
		for (int i = 1; i < components.size(); i++) {
			Component result = components.get(0).eval(components.get(i));
			components.set(0, result);
		}
		return components.get(0);
	}
	
	public String toString(){
		return components.toString();
	}
}
