#include <iostream>
#include "UserInput.h"
#include "FileReader.h"
#include "FileWriter.h"
#include "MyUtils.h"
using namespace std;


int main(){
	const int row_size = 15, seat_size = 30;
	bool run = true;
	string selection = "";
	char seats[row_size][seat_size];
	for(int i = 0; i < 15; i++){
		for(int k = 0; k < 30; k++){
			seats[i][k] = '#';
		}
	}


	UserInput in;
	MyUtils m;
	cout << "Enter the filename of your prices file. No Extension." <<endl;
	string file = in.readString();
	double priceArray[15];
	double totalCost = 0.0;
	m.readPrices(file, priceArray);
	m.printMenu();
	while(run){
		selection = in.readString();
		if(selection == "s" || selection == "S"){
			m.printSeats(seats);
		}
		else if(selection == "q" || selection == "Q"){
			run = false;
		}
		else if(selection == "p" || selection == "P"){
			m.printPrices(priceArray);
		}
		else if(selection == "b" || selection == "B"){
			
			cout << "What row do you want to sit in?" << endl;
			int row = in.readInt();
			cout << "How many seats do you want to buy?" << endl;
			int num_seats = in.readInt();
			cout << "What is the first sit you want to buy?" << endl;
			int starting_seat = in.readInt();
			m.buyTickets(row, num_seats, starting_seat, seats, totalCost, priceArray);
			
		}
		else if(selection == "r" || selection == "R"){
			m.calculateRemainingSeats(seats);
		}
		else if(selection == "t" || selection == "T"){
			cout << "Total Ticket Sale: $" << totalCost << endl;
		}else{
			m.printMenu();
		}

	}
						
}





