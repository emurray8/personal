#ifndef MEMES_H
#define MEMES_H

#include <vector>
using namespace std;
struct Recipe{
  int vitaC;
  int vitaD;
  int vitaA;
};
void calculateSolutions(vector<Recipe> & mix);
void printSolutions(vector<Recipe> & mix);
bool contains(vector<Recipe> & mix, Recipe & meme);

#endif
