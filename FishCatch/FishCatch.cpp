#include <iostream>
#include "helper.h"
#include "FileReader.h"
using namespace std;
struct count{
	double tAdult;
	double tJuvenile;
	double tDead;
	double total;
};
void go();
int main(){
	go();
}
void go(){
	count c = {0,0,0,0};
	FileReader in("data.txt");
	while(in.next()){
		string line = in.readString();
		vector<string> value = split(line, ',');
		vector<string>::iterator start = value.begin();
		vector<string>::iterator end = value.end();
		for(vector<string>::iterator i = start; i!=end; i++){
			string item = trim(*i);
			if(item == "A"){
				c.tAdult++;
				c.total++;
			}
			else if(item == "J"){
				c.tJuvenile++;
				c.total++;
			}
			else if(item == "D"){
				c.tDead++;
				c.total++;
			}
		}
	}
	printf("%s%.2f\n","Percent Adults: %", c.tAdult/c.total*100);
	printf("%s%.2f\n","Percent Juveniles: %", c.tJuvenile/c.total*100);
	printf("%s%.2f\n","Percent Dead: %", c.tDead/c.total*100);
	
}
