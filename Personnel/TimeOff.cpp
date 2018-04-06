#include "TimeOff.h"

using namespace std;

TimeOff::TimeOff(){}

TimeOff::TimeOff(const TimeOff & other)
{
  sick_days = other.sick_days;
  vacation_days = other.vacation_days;
}

TimeOff & TimeOff::operator =(const TimeOff & other)
{
  sick_days = other.sick_days;
  vacation_days = other.vacation_days;
}

void TimeOff::setMonthsWorked(double months)
{
  sick_days.setHours(months*8);
  vacation_days.setHours(months*12);
}

double TimeOff::getSickDays() const
{
  NumDays ND(sick_days);
  return ND.getDays();
}

double TimeOff::getVacationDays() const
{
  NumDays ND(vacation_days);
  return ND.getDays();
}
