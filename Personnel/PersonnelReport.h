#ifndef PERSONNELREPORT_H
#define PERSONNELREPORT_H

#include <iostream>
#include <string>
#include "TimeOff.h"

using namespace std;

class PersonnelReport
{
private:
  double employee_months;
  TimeOff employee_TimeOff;
  string employee_name;
  string employee_ID;

public:
  PersonnelReport();
  PersonnelReport(const PersonnelReport & other);
  PersonnelReport(string name, string ID, double months);
  virtual ~PersonnelReport() {};
  PersonnelReport & operator=(const PersonnelReport & other);
  friend ostream & operator <<(ostream & os, const PersonnelReport & other);
};

ostream & operator <<(ostream & os, const PersonnelReport & other);

#endif
