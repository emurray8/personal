#include "PersonnelReport.h"

using namespace std;

PersonnelReport::PersonnelReport(){}

PersonnelReport::PersonnelReport(const PersonnelReport & other)
{
  employee_name = other.employee_name;
  employee_ID = other.employee_ID;
}

PersonnelReport::PersonnelReport(string name, string ID, double months)
{
  employee_months = months;
  employee_name = name;
  employee_ID = ID;
  employee_TimeOff.setMonthsWorked(employee_months);
}

PersonnelReport & PersonnelReport::operator =(const PersonnelReport & other)
{
  employee_TimeOff = other.employee_TimeOff;
  employee_name = other.employee_name;
  employee_ID = other.employee_ID;
  employee_months = other.employee_months;
  return *this;
}

ostream & operator<< (ostream & os, const PersonnelReport & other)
{
  os << other.employee_name << " (" << other.employee_ID << ") Days Off:"
  << other.employee_TimeOff.getVacationDays() << " Sick Days: "
  << other.employee_TimeOff.getSickDays();
}
