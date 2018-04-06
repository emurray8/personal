#include <iostream>
using namespace std;
int main()
{
  for(int i = 0; i < 6; i++){
    cout << i << " ";
    for(int j = 5; j > -1; j--){
		cout << j << " ";
		for(int k = 0; k < 5; k+=2){
			cout << k;	
		}
		cout << " ";
    }
  	cout << endl;
  }
}
