package com.game.core.gameelements;

import com.game.core.gameelements.elements.Light;

public class LightStageElement extends Component {
	
	private Light light;
	private Stage stage;
	
	public LightStageElement() {
		stage = new Stage();
	}
	
	public void setStage(Stage s) {
		this.stage = s;
	}
	
	public void setLight(Light l) {
		this.light = l;
	}
	
	public Light getLight() {
		return light;
	}
	
	

	@Override
	public Component eval(Component comp) {
		return stage.eval(null);
	}

}
