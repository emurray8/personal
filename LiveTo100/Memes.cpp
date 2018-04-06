#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "memes.h"
using namespace std;

void calculateSolutions(vector<Recipe> & mix){
  //2*x*x	-	3*y	+	10*z*z	+	43	=	0
  Recipe kek = {1,1,1};
  while(mix.size() != 6){
    if(((2*kek.vitaC*kek.vitaC)-(3*kek.vitaD)+(10*kek.vitaA*kek.vitaA)+43) ==	0 && !contains(mix, kek)){
      mix.push_back(kek);
    }
    kek.vitaC = (rand() % 99)+1;
    kek.vitaD = (rand() % 99)+1;
    kek.vitaA = (rand() % 99)+1;
  }
}
bool contains(vector<Recipe> & mix, Recipe & meme){
  bool ret = false;
  for (unsigned i = 0; i < mix.size(); i++){
    if(meme.vitaC == mix[i].vitaC && meme.vitaD == mix[i].vitaD && meme.vitaA == mix[i].vitaA){
      ret = true;
    }
  }
  return ret;

}
void printSolutions(vector<Recipe> & mix){
  Recipe best = {mix[0].vitaC, mix[0].vitaD, mix[0].vitaA};
  int min = mix[0].vitaD;
	for (unsigned i = 0; i < mix.size(); i++){
    if(mix[i].vitaD < min){
      min = mix[i].vitaD;
      best = {mix[i].vitaC, mix[i].vitaD, mix[i].vitaA};
    }
  }


    cout << "Found 6 solutions" << endl;
  	cout << "   x=" << mix[0].vitaC	<< " y=" << mix[0].vitaD << " z=" << mix[0].vitaA << endl;
    cout << "   x=" << mix[1].vitaC	<< " y=" << mix[1].vitaD << " z=" << mix[1].vitaA << endl;
    cout << "   x=" << mix[2].vitaC	<< " y=" << mix[2].vitaD << " z=" << mix[2].vitaA << endl;
    cout << "   x=" << mix[3].vitaC	<< " y=" << mix[3].vitaD << " z=" << mix[3].vitaA << endl;
    cout << "   x=" << mix[4].vitaC	<< " y=" << mix[4].vitaD << " z=" << mix[4].vitaA << endl;
    cout << "   x=" << mix[5].vitaC	<< " y=" << mix[5].vitaD << " z=" << mix[5].vitaA << endl;

  cout << "Best solution:" << endl;
  cout << "   x=" << best.vitaC	<< " y=" << best.vitaD << " z=" << best.vitaA << endl;

  cout << "Take " << best.vitaC <<" (IUs) of vitamin C, " << best.vitaD << " (IUs) of vitamin D, and " << best.vitaA  << " (IUs) of vitamin A and live to 100!" << endl;
}
