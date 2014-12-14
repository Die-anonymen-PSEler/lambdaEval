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
		mmE.setMachine(new Machine(1));
		mmE.setMetal(new Metal(1));
		
		MetalMachineElement mme2 = new MetalMachineElement();
		mme2.setMachine(new Machine(2));
		mme2.setMetal(new Metal(2));
		
		MetalMachineElement mme3 = new MetalMachineElement();
		mme3.setMachine(new Machine(41));
		mme3.setMetal(new Metal(42));
		
		
		s.addComponent(mmE);
		s.addComponent(mme2);
		s.addComponent(mme3);
		
		Component c = s.eval(null);
		System.out.println(c.toString());
	}

}
