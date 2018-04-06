#ifndef MYUTILS_H
#define MYUTILS_H



#include <string>
using namespace std;

class MyUtils{

	public:
	MyUtils() {};
	void printSeats(char[][30]);
	void printMenu();
	void calculateRemainingSeats(char[][30]);
	void printPrices(double[15]);
	void readPrices(string, double*);
	void buyTickets(int, int, int, char[][30], double&, double[15]);

};
#endif
