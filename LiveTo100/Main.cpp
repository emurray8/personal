#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "memes.h"
using namespace std;
int main(){
  srand(time(NULL));
  vector<Recipe> recipes;
  calculateSolutions(recipes);
  printSolutions(recipes);
}
