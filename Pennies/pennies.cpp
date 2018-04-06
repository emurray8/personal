#include <iostream>
#include "UserInput.h"
using namespace std;
int main(){
 cout << "How many days will you be earning a salary?" << endl;
 UserInput in;
 int days = in.readInt();
 double pay = 1;
 double total = 0;
 cout << "-------------------------" << endl;
 for(int i = 0; i < days; i++){
   cout << i << "    " << pay << endl;
   total+=pay;
   pay*=2;
   
 }
 total/=100;
 cout << "You have earned $" <<total << endl;


}
