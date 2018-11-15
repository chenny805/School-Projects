//
//  main.cpp
//  hw3
//
//  Created by Alex (Wei) Chen & Kacy Rowe 2/22/17.
//  Copyright © 2017 Chenny. All rights reserved.
//

/*
    This program will take in multiple menu text files and average the prices of duplicate items. 
    It will list the item multiple times but the price will be averaged.
 
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <cstring>
#include <cstdlib>
#include <iomanip>


using namespace std;

// protocol for function
float avgP (float sum, int n);

int main(int argc, char * argv[]) {
    
    
    
    int numItem = 1;
    float priceSum = 0;
    float average = 0;
    vector <string> itemV;
    vector <float> priceV; // store all prices from menus
    vector <float> itemTotal; // store all item names from menus
    vector <float> avgPrice; // store the average price from menus
    string item;
    float price;
    
    
    
    // a loop to create a new object for each menu file
    // add all the info from the menu files to the appropriate vectors
    for (int a = 1; a <= argc ; a++) {
        ifstream inObj(argv[a]); // input stream object
        // store all the data from that menu file to vectors
        while (inObj >> item >> price) {
            itemV.push_back(item); // vector for item name
            priceV.push_back(price); // vector for item price
        }
        
    } // end for loop
    
    // make a copy of the vector for comparison purposes
    vector<string> itemVCopy(itemV);
    
    
    string currItem; // a string to store the current item name being compared
    
    // a loop to average the prices of duplicate items but will divide up the average price
    // next loop will fix this problem
    for (int i = 0; i < (itemV.size()); i ++) {
        numItem = 1;
        currItem = itemV[i];
        priceSum = priceV[i];
        
        for (int j = 0; j < (itemVCopy.size()); j ++) {
            if (currItem == itemVCopy[j]) {
            numItem ++;
            priceSum+= priceV[j];
               
            }
        }
        average = avgP(priceSum, numItem);
        avgPrice.insert(avgPrice.begin()+i, average);
        average = 0;
    }
    
    
    vector <string> opItem; // vector to store what names will be displayed
    vector <float> opPrice; // vector to store what prices will be displayed
    
    string ci; // track current item name
    float cp = 0; // track current price
    int n = 0; // track how many of those items there are
    float avg = 0; // store the average price
    
    // a loop to find the duplicate items and sum up their prices to find average
    // fixes the error from last loop
    for (int h = 0; h < (itemV.size()); h ++) {
        ci = itemV[h];
        cp = 0;
        
        for (int k = 0; k < (itemVCopy.size()); k ++) {
            if (ci == itemVCopy[k]){
                n++;
                cp+=priceV[k];
            }
        }
        avg = (cp/n); // calculating average
        opItem.push_back(ci);
        opPrice.push_back(avg);
        avg = 0; // resetting
        n = 0; // resetting
        
    }
    
    // printing settings
    std::cout << std::fixed;
    std::cout << std::setprecision(2); // keeping 2 decimal places
    
    // printing everything on the menus
    cout << "The average prices are: \n" << endl;
    for (int p = 0; p <(opItem.size()); p++) {
        cout << opItem[p] << " "  << opPrice[p] << endl;
    }
    cout << endl;
    
    return 0;

}

// function to average the price of a given item
float avgP (float sum, int n) {
    float itemAvg;
    // equation for averaging prices
    itemAvg = sum/n;
    
    
    return itemAvg;
    
    
}




