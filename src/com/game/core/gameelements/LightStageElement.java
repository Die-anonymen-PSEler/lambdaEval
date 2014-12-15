package com.game.core.gameelements;

import com.game.core.gameelements.elements.Light;

public class LightStageElement extends Component {
	
	/**
	 * the light element that belongs with this element
	 */
	private Light light;
	/**
	 * the stage that is included within this construct
	 */
	private Stage stage;
	
	/**
	 * returns a new instance of LightStageElement
	 */
	public LightStageElement() {
		stage = new Stage();
	}
	
	/**
	 * assigns a new stage to this construct
	 * @param s the stage that overrides the old one
	 */
	public void setStage(Stage s) {
		this.stage = s;
	}
	
	/**
	 * assigns a new light to this construct
	 * @param l the light that overrides the old one
	 */
	public void setLight(Light l) {
		this.light = l;
	}
	
	/**
	 * returns the light
	 * @return the light object within this
	 */
	public Light getLight() {
		return light;
	}
	
	@Override
	public Component eval(Component comp) {
		return stage.eval(null);
	}

}
