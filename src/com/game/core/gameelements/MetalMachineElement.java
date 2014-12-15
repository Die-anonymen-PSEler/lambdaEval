package com.game.core.gameelements;

import java.util.ArrayList;
import java.util.List;

import com.game.core.gameelements.elements.Machine;
import com.game.core.gameelements.elements.Metal;

public class MetalMachineElement extends Component {
	
	private List<Metal> metals;
	private Machine machine;
	
	public MetalMachineElement() {
		setMetals(new ArrayList<Metal>());
	}	
	
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
		if (counter > 1) {
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
		else if (counter == 1) {
			result = comp;
		}
		else {
			this.setMachine(null);
			result = this;
		}
		
		return result;
	}

	public List<Metal> getMetals() {
		return metals;
	}

	public void setMetals(List<Metal> metals) {
		this.metals = metals;
	}
	
	public void addMetal(Metal metal) {
		getMetals().add(metal);
	}
	
	public Machine getMachine() {
		return machine;
	}
	
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
