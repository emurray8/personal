#ifndef TIMEOFF_H
#define TIMEOFF_H

#include "NumDays.h"

using namespace std;

class TimeOff
{
private:
  NumDays sick_days;
  NumDays vacation_days;
public:
  TimeOff();
  TimeOff(const TimeOff & other);
  virtual ~TimeOff() {};
  TimeOff & operator=(const TimeOff & other);
  void setMonthsWorked(double months);
  double getSickDays() const;
  double getVacationDays() const;
};


#endif
