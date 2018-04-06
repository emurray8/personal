#include <iostream>
#include <vector>
#include <cstdlib>
#include "PersonnelReport.h"
#include "NumDays.h"
#include "FileReader.h"
#include "UserInput.h"
#include "helper.h"

using namespace std;
// always have:
// - default constructor
// - copy constructor
// - destructor
// = operator overload

int main()
{
 try
 {
 UserInput i;
 FileReader in(i.readString("Enter employee file: "));
 while (in.next())
 {
 vector<string> tokens = split(in.readString(), ',');
 PersonnelReport rpt(tokens[0], tokens[1], atof(tokens[2].c_str()));
 cout << rpt << endl;
 }
 }
 catch (const char * msg)
 {
 cout << msg << endl;
 }
}
