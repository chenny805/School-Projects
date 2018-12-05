package com.alexchenny;

public class TurnOff implements Command {

	ElectronicDevice theDevice;
	
	public TurnOff(ElectronicDevice newDevice){
		
		theDevice = newDevice;
		
	}
	
	public void execute() {
		
		theDevice.off();
		
	}

	// Used if you want to allow for undo
	// Do the opposite of execute()
	
	public void undo() {
		
		theDevice.on();
		
	}
	
}
