package com.alexchenny;

public class TurnOn implements Command {

	ElectronicDevice theDevice;
	
	public TurnOn(ElectronicDevice newDevice){
		
		theDevice = newDevice;
		
	}
	
	public void execute() {
		
		theDevice.on();
		
	}

	public void undo() {
		
		theDevice.off();
		
	}
	
}
