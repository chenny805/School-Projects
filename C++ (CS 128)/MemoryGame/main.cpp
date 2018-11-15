//
//  main.cpp
//  MemoryGame1
//
//  CS 256
//  Dr. McCune
//  Created by Alex (Wei) Chen & Kacy Rowe on 1/19/17.
//
//

#include <iostream>
#include <string>
using namespace std;


int main() {
    
    
    // variable to keep track of the number of matches within the game
    int numMatches = 0;
    
    // Array to hold the actual values of the game
    int card[4][4] = { };
    
    // (row, column)
    card[0][0] = 2;
    card[0][1] = 4;
    card[0][2] = 6;
    card[0][3] = 7;
    card[1][0] = 5;
    card[1][1] = 1;
    card[1][2] = 7;
    card[1][3] = 3;
    card[2][0] = 2;
    card[2][1] = 1;
    card[2][2] = 8;
    card[2][3] = 3;
    card[3][0] = 4;
    card[3][1] = 8;
    card[3][2] = 5;
    card[3][3] = 6;
    
    
    
    // Array to hide the values
    string display[4][4] = { };
    
    display[0][0] = "*";
    display[0][1] = "*";
    display[0][2] = "*";
    display[0][3] = "*";
    display[1][0] = "*";
    display[1][1] = "*";
    display[1][2] = "*";
    display[1][3] = "*";
    display[2][0] = "*";
    display[2][1] = "*";
    display[2][2] = "*";
    display[2][3] = "*";
    display[3][0] = "*";
    display[3][1] = "*";
    display[3][2] = "*";
    display[3][3] = "*";
    
    
    
    
    
    // mechanism to shuffle the cards before each game
    int v1 = rand() % 4;
    int v2 = rand() % 4;
    int v3 = rand() % 4;
    int v4 = rand() % 4;

    
    int tempCard;
    
    
    int randNum = rand() % 100;
    
    for (int counter = 0; counter < randNum; counter++) {
    
    tempCard = card[v1][v2];
    card[v1][v2] = card[v3][v4];
    card[v3][v4] = tempCard;
    
        v1 = rand() % 4;
        v2 = rand() % 4;
        v3 = rand() % 4;
        v4 = rand() % 4;

        
        v1 = v2;
        v2 = v4;
        v3 = v1;
        v4 = v3;

        
    }
    
    

    // introduction
    // print the game board with using string array
    cout << "Welcome to Memory Game! \n\n" << "Pick two coordinates on the playing board to see if the numbers match! \n\n"
    
      "       1    2    3    4\n" << "\t __________________\n" <<
    "1   |  " <<display[0][0]  <<"\t"<<  display[0][1]  << "\t "<<  display[0][2] << "\t  " << display[0][3] << "\n"<<
    "2   |  " <<display[1][0]  <<"\t"<<  display[1][1]  << "\t "<<  display[1][2] << "\t  " << display[1][3] << "\n"<<
    "3   |  " <<display[2][0]  <<"\t"<<  display[2][1]  << "\t "<<  display[2][2] << "\t  " << display[2][3] << "\n"<<
    "4   |  " <<display[3][0]  <<"\t"<<  display[3][1]  << "\t "<<  display[3][2] << "\t  " << display[3][3] << "\n"<<
    
    "\n" <<endl;
    
    
    // keep the game going while the player have not gotten 8 matches
    while (numMatches < 8)  {
    
    // prompt user for first coordinate
    cout << "Please enter your first coordinate (ROW, COLOMUN) \n (hit enter after each entry) \n\n";
    
    
    
        int entry1;
        cin >> entry1;
        entry1 = entry1-1;

    
        int entry2;
        cin >> entry2;
        entry2 = entry2-1;

    
    // prompt user for second coordinate
    cout << "Please enter your second coordinate (ROW, COLOMUN) \n (hit enter after each entry) \n\n";
    
    
        int entry3;
        cin >> entry3;
        entry3 = entry3-1;
        
        int entry4;
        cin >> entry4;
        entry4 = entry4-1;

    
    // if the cards match, update the array values and game board
    if (card[entry1][entry2] == card[entry3][entry4]) {
        
        cout << "You have a match!!! \n \n";
        numMatches++;
        
        std::string tempString1 = std::to_string(card[entry1][entry2]);
        display[entry1][entry2] = tempString1;
        
        std::string tempString2 = std::to_string(card[entry3][entry4]);
        display[entry3][entry4] = tempString2;
        
        
        
        // print game board when match is found
        cout <<
        
        "       1    2    3    4\n" << "\t __________________\n" <<
        "1   |  " <<display[0][0]  <<"\t"<<  display[0][1]  << "\t "<<  display[0][2] << "\t  " << display[0][3] << "\n"<<
        "2   |  " <<display[1][0]  <<"\t"<<  display[1][1]  << "\t "<<  display[1][2] << "\t  " << display[1][3] << "\n"<<
        "3   |  " <<display[2][0]  <<"\t"<<  display[2][1]  << "\t "<<  display[2][2] << "\t  " << display[2][3] << "\n"<<
        "4   |  " <<display[3][0]  <<"\t"<<  display[3][1]  << "\t "<<  display[3][2] << "\t  " << display[3][3] << "\n\n\n"<<
        
        // keep track of how many matches the player has
        "You have " << numMatches << " matches so far" << endl;
        
        
        
        }
    
    
    
    }
    
    // congrat player after winning
    cout << "You've Won The Game!!";

    

    return 0;
}




