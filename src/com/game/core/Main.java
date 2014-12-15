package com.game.core;

import com.game.core.gameelements.Component;
import com.game.core.gameelements.MetalMachineElement;
import com.game.core.gameelements.Stage;
import com.game.core.gameelements.elements.Machine;
import com.game.core.gameelements.elements.Metal;

public class Main {

	public static void main(String[] args) {
		Stage s = new Stage();
		MetalMachineElement mmE = new MetalMachineElement();
		mmE.addMetal(new Metal(2));
		mmE.addMetal(new Metal(2));
		mmE.setMachine(new Machine(2));
		
		MetalMachineElement metal = new MetalMachineElement();
		metal.setMachine(null);
		metal.addMetal(new Metal(5));
		
		s.addComponent(mmE);
		s.addComponent(metal);
		
		
		
		Component c = s.eval(null);
		System.out.println(c.toString());
	}

}
