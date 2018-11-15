#!/bin/bash

# store dealer_number
dealer_number=$1
new_guess=$2
echo "Dealer number is: $dealer_number"

# first guess
guess=$(( $RANDOM % 20))
echo "First guess is: $guess"

getBigger() {
	temp=$(( ($RANDOM % 20)+$guess ))
	echo $temp
}

getSmaller() {
temp=$(( $RANDOM % $guess ))
	echo $temp
}



#logic

if [[ "$dealer_number" == "$guess" ]]; then
	echo "GAME OVER"

else
	# if bigger
	if [[ "$dealer_number" > "$guess" ]]; then
		new=$(getBigger)
		echo "Try #1: Action was higher: 1 guess $new"
	  ./player.bash $dealer_number $new
	# if less
	else 
		new=$(getSmaller)
		echo "Try #1: Action was lower: 1 guess $new"
	  ./player.bash $dealer_number $new
	fi

fi
