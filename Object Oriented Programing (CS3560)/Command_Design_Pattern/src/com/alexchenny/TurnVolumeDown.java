package com.alexchenny;


public class TurnVolumeDown implements Command {

	ElectronicDevice theDevice;
	
	public TurnVolumeDown(ElectronicDevice newDevice){
		
		theDevice = newDevice;
		
	}
	
	public void execute() {
		
		theDevice.volumeDown();
		
	}

	public void undo() {
		
		theDevice.volumeUp();
		
	}
	
}