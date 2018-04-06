#include <iostream>
#include "FileReader.h"
#include "helper.h"
#include <vector>
#include "stdlib.h"
#include <string>
#include "tempUtils.h"
using namespace std;
int main()
{
  vector<double> high;
  vector<double> low;
  populate(high, low);
  chart(high, low);
}
void populate(vector<double> & high, vector<double> & low){
  FileReader in("temps.txt");
  if(in.next()){
  string line = in.readString();
  vector<string> tokens = split(line, ',');
  vector<string>::iterator start = tokens.begin();
  vector<string>::iterator end = tokens.end();
  for (vector<string>::iterator p = start; p!=end; p++)
  {
    string token = trim(*p);
    double num_token = atof(token.c_str());
   low.push_back(num_token);
  }
}
if(in.next()){
  string line = in.readString();
  vector<string> tokens = split(line, ',');
  vector<string>::iterator hstart = tokens.begin();
  vector<string>::iterator hend = tokens.end();
  for (vector<string>::iterator p = hstart; p!=hend; p++)
  {
     string token = trim(*p);
     double num_token = atof(token.c_str());
    high.push_back(num_token);
  }}
}
void chart(const vector<double> & high, const vector<double> & low){
  string s1;
  string s2;
  string s3;
  string s4;
  string s5;
  vector<double>::const_iterator start = low.begin();
  vector<double>::const_iterator end = low.end();
  for (vector<double>::const_iterator p = start; p!=end; p++)
  {
     if(*p <= 40){
       s1 += "-";
     }
     if(*p >40 && *p <=50){
       s2 += "-";
     }
     if(*p >50 && *p <=60){
       s3 += "-";
     }
     if(*p >60 && *p <=70){
       s4 += "-";
     }
     if(*p > 70){
       s5 += "-";
     }
  }
  vector<double>::const_iterator hstart = high.begin();
  vector<double>::const_iterator hend = high.end();
  for (vector<double>::const_iterator p = hstart; p!=hend; p++)
  {
     if(*p <= 40){
       s1 += "+";
     }
     if(*p >40 && *p <=50){
       s2 += "+";
     }
     if(*p >50 && *p <=60){
       s3 += "+";
     }
     if(*p >60 && *p <=70){
       s4 += "+";
     }
     if(*p > 70){
       s5 += "+";
     }
  }
  cout << "<=40        :" << s1 << endl;
  cout << ">40 and <=50: "<< s2 << endl;
  cout << ">50 and <=60: "<< s3 << endl;
  cout << ">60 and <=70: "<< s4 << endl;
  cout << ">70         : "<< s5 << endl;

}
