package com.alexchenny;

public class TurnVolumeUp implements Command {

	ElectronicDevice theDevice;
	
	public TurnVolumeUp(ElectronicDevice newDevice){
		
		theDevice = newDevice;
		
	}
	
	public void execute() {
		
		theDevice.volumeUp();
		
	}

	public void undo() {
		
		theDevice.volumeDown();
		
	}
	
}