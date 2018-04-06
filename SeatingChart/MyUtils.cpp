#include "MyUtils.h"
#include "FileReader.h"
#include <iostream>
#include <string>

using namespace std;

void MyUtils::printSeats(char a[][30]){
	for(int i = 0; i < 15; i++){
		if(i < 9){
			cout << "Row " << i+1 << "  ";
		}else{
			cout << "Row " << i+1 << " ";
		}
		for(int k = 0; k < 30; k++){
			cout << a[i][k];
		}
		cout << endl;
	}
}
void MyUtils::calculateRemainingSeats(char a[][30]){
	int total = 0;
	for(int i = 0; i < 15; i++){
		for(int k = 0; k < 30; k++){
			if(a[i][k] == '#'){
				total++;
			}
		}

	}	
	cout << total << " seats remaining." << endl;
}
void MyUtils::printMenu(){
	cout << "-----------------" << endl << "Menu" << endl << "-----------------" << endl;
	cout << "S: View Seating Chart" << endl;
	cout << "P: View Prices Chart" << endl;
	cout << "B: Buy Tickets" << endl;
	cout << "R: Number of Remaining Seats" << endl;
	cout << "T: Total Sales" << endl;
	cout << "Q: Quit" << endl;
}
void MyUtils::printPrices(double p[]){
	for(int i = 0; i < 15; i++){
		cout << "Price For Row " << i+1 << ": " << p[i] << endl;
	}
}
void MyUtils::readPrices(string file, double *priceArray){
	FileReader reader(file + ".txt");
	int index = 0;
	while(reader.next()){
		priceArray[index++] = reader.readDouble();
	}

}
void MyUtils::buyTickets(int row, int seat, int first, char seats[][30], double &totalCost, double p[]){
	int x = row - 1;
	int y = first - 1;
	int z = y + seat;
	int i = 0;
	double cost = 0;
	bool valid = true;
	if(z > 30 || row > 15 || row < 1 || z < 1){
		valid = false;
	}
	for(int j = y; j < z; j++){
		if(seats[x][j] == '*'){
			valid = false;
		}
	}
	while(valid && y < z){
		seats[x][y] = '*';
		totalCost = totalCost + p[x];
		cost = cost + p[x];		
		y++;
	}
	if(valid){
		cout << "Transaction Complete. Total cost: $" << cost << endl;
	}else{
		cout << "Unavailable seating selected. Transaction cancelled" << endl;
	}
}
