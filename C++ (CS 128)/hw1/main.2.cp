//
//  main.cpp
//  hw1
//
//  Created by Chenny on 1/16/17.
//  Copyright © 2017 Chenny. All rights reserved.
//

#include <iostream>
using namespace std;



int main() {
    
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

    
       //display [0][0] = std::to_string(card [0][0]);
    
    cout << "       1    2    3    4\n" << "\t __________________\n" <<
    "1   |  " <<display[0][0]  <<"\t"<<  display[0][1]  << "\t "<<  display[0][2] << "\t  " << display[0][3] << "\n"<<
    "2   |  " <<card   [1][0]  <<"\t"<<  display[1][1]  << "\t "<<  display[1][2] << "\t  " << display[1][3] << "\n"<<
    "3   |  " <<display[2][0]  <<"\t"<<  display[2][1]  << "\t "<<  display[2][2] << "\t  " << display[2][3] << "\n"<<
    "4   |  " <<display[3][0]  <<"\t"<<  display[3][1]  << "\t "<<  card   [3][2] << "\t  " << display[3][3] << "\n"<< endl;

    
}


