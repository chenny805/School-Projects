package com.alexchenny;

public class Driver{
	
	public static void main(String[] args){
		
		// Gets the ElectronicDevice to use
		
		ElectronicDevice newDevice = new Television();
		
		// TurnTVOn contains the command to turn on the tv
		// When execute() is called on this command object
		// it will execute the method on() in Television
		
		TurnOn onCommand = new TurnOn(newDevice);
		
		// Calling the execute() causes on() to execute in Television
		
		DeviceButton onPressed = new DeviceButton(onCommand);
		
		// When press() is called theCommand.execute(); executes
		
		onPressed.press();
		
		//----------------------------------------------------------
		
		// Now when execute() is called off() of Television executes
		
		TurnOff offCommand = new TurnOff(newDevice);
		
		// Calling the execute() causes off() to execute in Television
		
		onPressed = new DeviceButton(offCommand);
		
		// When press() is called theCommand.execute(); executes
		
		onPressed.press();
		
		//----------------------------------------------------------
		
		// Now when execute() is called volumeUp() of Television executes
		
		TurnVolumeUp volUpCommand = new TurnVolumeUp(newDevice);
				
		// Calling the execute() causes volumeUp() to execute in Television
				
		onPressed = new DeviceButton(volUpCommand);
				
		// When press() is called theCommand.execute(); executes
				
		onPressed.press();
		onPressed.press();
		onPressed.press();
	}
}