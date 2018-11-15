#!/usr/bin/perl

# Name: Alex Chen
# Professor: Gershman
# Course: CS 2600
# Homework: 4

# array to store entries
@entry = ();
# loop to store data in array
while ( <STDIN> ) {
	# trim off the beginning of the string 
	$pts = substr ($_, 38);
	# trim to get command name
	$command_name = substr ($_, 65);
	# merge the two substrings
	substr ($pts, 9) = $command_name;
	# add entry to array
	push @entry, $pts;
}

print "##################\n";
# sort and store array
@sorted = sort( @entry );

# print the result
for ( $i = 0; $i <= $#sorted; $i++ ) {
	print $sorted[$i];
}
