package com.game.core.gameelements;

import java.util.ArrayList;
import java.util.List;

import com.game.core.gameelements.elements.Machine;
import com.game.core.gameelements.elements.Metal;

public class MetalMachineElement extends Component {
	
	/**
	 * a list containing all metal elements associated with the machine
	 */
	private List<Metal> metals;
	
	/**
	 * the machine within this construct
	 */
	private Machine machine;
	
	/**
	 * creates a new instance of MetalMachineElement
	 */
	public MetalMachineElement() {
		setMetals(new ArrayList<Metal>());
	}	
	
	/**
	 * checks whether this construct has a machine or not
	 * @return true if the machine does not exist (== null); false otherwise
	 */
	public boolean metalOnly() {
		return (machine == null);
	}
	
	@Override
	public Component eval(Component comp) {
		// this thing can not process anything or was given nothing to process
		if (metalOnly() && comp != null) {
			// no machine -> no processing; comp needs to be added
			Stage s = new Stage();
			s.addComponent(this);
			s.addComponent(comp);
			return s;
		}
		else if (comp == null) {
			return this;
		}
		int machineId = machine.getColorId();
		int counter = 0;
		Component result;
		for (int i = 0; i < getMetals().size(); i++) {
			if (machineId == getMetals().get(i).getColorId()) {
				counter++;
			}
		}
		if (counter > 0) {
			if (comp.getClass() == MetalMachineElement.class && ((MetalMachineElement)comp).metalOnly()) {
				MetalMachineElement compMachine = (MetalMachineElement)comp;
				List<Metal> compMetals = compMachine.getMetals();
				MetalMachineElement resultMachine = new MetalMachineElement();
				for (int i = 0; i < counter; i++) {
					for (int j = 0; j < compMetals.size(); j++) {
						resultMachine.addMetal(compMetals.get(j));
					}
				}
				return resultMachine;
			}
			else {
				Stage s = new Stage();
				for (int i = 0; i < counter; i++) {
					s.addComponent(comp);
				}
				result = s.eval(null);
			}
		}
		else {
			this.setMachine(null);
			result = this;
		}
		
		return result;
	}
	
	/**
	 * get method for the metal list
	 * @return the list containing all the metal pieces
	 */
	public List<Metal> getMetals() {
		return metals;
	}

	/**
	 * assigns a new list containing metal pieces to this object
	 * @param metals a list containing metal pieces
	 */
	public void setMetals(List<Metal> metals) {
		this.metals = metals;
	}
	
	/**
	 * adds a metal object to this object
	 * @param metal the metal object to add
	 */
	public void addMetal(Metal metal) {
		getMetals().add(metal);
	}
	
	/**
	 * returns machine within this construct
	 * @return the machine
	 */
	public Machine getMachine() {
		return machine;
	}
	
	/**
	 * assigns a machine element to the construct
	 * @param machine the machine element to the construct
	 */
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
	@Override
	public String toString() {
		if (machine == null) {
			return "MetalMachineElement: " + " metall " + metals.toString();
		}
		else {
			return "MetalMachineElement: " + machine.toString() + " " + metals.toString();
		}
		
	}
}
