#!/usr/bin/perl

# Name: Alex Chen
# Professor Gershman
# CS2600
# December 4th, 2018

# html patterns for finding line index of the channels
$ch2 = "<b>2.1</b>";
$ch4 = "<b>4.1</b>";
$ch7 = "<b>7.1</b>";

$counter = 0; #counter to find line number of the 3 channels
# variables to store the indices of the 3 channels
$index2 = 0; 
$index4 = 0;
$index7 = 0;

# while loop to find the index of the channel 
while(<>) {
	$counter++; # increment counter after each line
	push ( @html, $_ );
	
	# save the line index when it matches the html pattern for the channel
	if ($_ =~ /\Q$ch2\E/) {
		$index2 = $counter+7;
	}
	
	if ($_ =~ /\Q$ch4\E/) {
		$index4 = $counter+7;
	}
	
	if ($_ =~ /\Q$ch7\E/) {
		$index7 = $counter+7;
	}
}

# print the channel Title
@CBS = @html[$index2] =~ /((?<="title">)[\w\d\s]*)/;
print "2.1 - " . join( ',', @CBS) . "\n";

@NBC = @html[$index4] =~ /((?<="title">)[\w\d\s]*)/;
print "4.1 - " . join( ',', @NBC) . "\n";

@ABC = @html[$index7] =~ /((?<="title">)[\w\d\s]*)/;
print "7.1 - " . join( ',', @ABC) . "\n\n\n";



