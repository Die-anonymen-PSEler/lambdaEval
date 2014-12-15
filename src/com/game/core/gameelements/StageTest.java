package com.game.core.gameelements;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.game.core.gameelements.elements.Machine;
import com.game.core.gameelements.elements.Metal;

public class StageTest {
	
	Stage s;
	
	@Before
	public void setUp() throws Exception {
		s = new Stage();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void test1() {
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
		assertTrue("Kein MetallMachinenElement als Ergebnis", c.getClass() == MetalMachineElement.class);
		assertTrue("Zu wenige Elemente", ((MetalMachineElement)c).getMetals().size() == 2);
		
		for (int i = 0; i < 2; i++) {
			assertTrue("Falsches Element", ((MetalMachineElement)c).getMetals().get(i).getColorId() == 5);
		}
	}
	
	@Test
	public void test2() {
		MetalMachineElement mmE = new MetalMachineElement();
		Stage s2 = new Stage();
		mmE.addMetal(new Metal(3));
		mmE.setMachine(new Machine(3));
		
		s2.addComponent(mmE);
		s2.addComponent(s);
		
		MetalMachineElement mme = new MetalMachineElement();
		mme.addMetal(new Metal(42));
		mme.setMachine(new Machine(42));
		
		MetalMachineElement metalOnly = new MetalMachineElement();
		metalOnly.addMetal(new Metal(4));
		metalOnly.setMachine(null);
		s.addComponent(mme);
		s.addComponent(metalOnly);
		
		Component c = s.eval(null);
		assertTrue("Kein MetallMachinenElement", c.getClass() == MetalMachineElement.class);
		assertTrue("Falsche Anzahl an Elementen", ((MetalMachineElement)c).getMetals().size() == 1);
		assertTrue("Falsches Element", ((MetalMachineElement)c).getMetals().get(0).getColorId() == 4);
	}
	
	@Test
	public void test3() {
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
		assertTrue("Kein MetallMachinenElement", c.getClass() == MetalMachineElement.class);
		assertTrue("Falsche Anzahl an Elementen", ((MetalMachineElement)c).getMetals().size() == 2);
		assertTrue("Falsches Element", ((MetalMachineElement)c).getMetals().get(0).getColorId() == 5);
		assertTrue("Falsches Element", ((MetalMachineElement)c).getMetals().get(1).getColorId() == 5);
	}

}
