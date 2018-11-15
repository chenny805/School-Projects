#!/bin/bash


#echo $rand

get_rand() {
	rand=$(( $RANDOM % 20 ))
	echo $rand
}


check() {
	$1

}



# START

# get random number to start game
num=$(get_rand)
echo "Num is $num"
./player.bash $num 
 
player_guess=$1 
# add logic
#if [$player_guess -ne $num]; then
#	./player.bash $num
#fi





#playerguess=./player.bash $num

echo "Player guess is: $1"
# while not correct











