#include <iostream>
#include <algorithm>
#include "FileWriter.h"
#include "FileReader.h"
#include <vector>
using namespace std;
int median(int in1, int in2, int in3, int in4, int in5, int in6, int in7, int in8, int in9);
int main(){
  FileReader in("PeskyImages/Pesky1.ppm");
  FileReader in2("PeskyImages/Pesky2.ppm");
  FileReader in3("PeskyImages/Pesky3.ppm");
  FileReader in4("PeskyImages/Pesky4.ppm");
  FileReader in5("PeskyImages/Pesky5.ppm");
  FileReader in6("PeskyImages/Pesky6.ppm");
  FileReader in7("PeskyImages/Pesky7.ppm");
  FileReader in8("PeskyImages/Pesky8.ppm");
  FileReader in9("PeskyImages/Pesky9.ppm");

  vector<int> pixels;
  vector<int> image1;
  vector<int> image2;
  vector<int> image3;
  vector<int> image4;
  vector<int> image5;
  vector<int> image6;
  vector<int> image7;
  vector<int> image8;
  vector<int> image9;
  int skip = 0;
  while(in.next()){
    skip++;
    if(skip > 4){
      image1.push_back(in.readInt());
    }
  }
  skip = 0;
  while(in2.next()){
    skip++;
    if(skip > 4){
      image2.push_back(in2.readInt());
    }
  }
  skip = 0;
  while(in3.next()){
    skip++;
    if(skip > 4){
      image3.push_back(in3.readInt());
    }
  }
  skip = 0;
  while(in4.next()){
    skip++;
    if(skip > 4){
      image4.push_back(in4.readInt());
    }
  }
  skip = 0;
  while(in5.next()){
    skip++;
    if(skip > 4){
      image5.push_back(in5.readInt());
    }
  }
  skip = 0;
  while(in6.next()){
    skip++;
    if(skip > 4){
      image6.push_back(in6.readInt());
    }
  }
  skip = 0;
  while(in7.next()){
    skip++;
    if(skip > 4){
      image7.push_back(in7.readInt());
    }
  }
  skip = 0;
  while(in8.next()){
    skip++;
    if(skip > 4){
      image8.push_back(in8.readInt());
    }
  }
  skip = 0;
  while(in9.next()){
    skip++;
    if(skip > 4){
      image9.push_back(in9.readInt());
    }
  }
  for(unsigned i = 0; i < image1.size(); ++i) {
  pixels.push_back(median(image1[i],image2[i],image3[i],image4[i],image5[i],image6[i],image7[i],image8[i],image9[i]));
}


  FileWriter out("output.ppm");
  out.writeLine("P3");
  out.writeLine("# CREATOR: GIMP PNM Filter Version 1.1");
  out.writeLine("495 557");
  out.writeLine("255");
  vector<int>::iterator begin = pixels.begin();
	vector<int>::iterator end = pixels.end();
	for (vector<int>::iterator p = begin; p != end; p++)
		out.writeLine(*p);
}
int median (int in1, int in2, int in3, int in4, int in5, int in6, int in7, int in8, int in9)
{
  int arr[] = {in1, in2, in3, in4, in5, in6, in7, in8, in9};


 sort(arr, arr+9);

  return arr[4];
}
