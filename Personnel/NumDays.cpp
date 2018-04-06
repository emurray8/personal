#include "NumDays.h"

using namespace std;

NumDays::NumDays(){}

NumDays::NumDays(const NumDays & other)
{
  setHours(other.work_hours);
}

NumDays::NumDays(double hours)
{
  setHours(hours);
}

void NumDays::setDays(double d)
{
  days = d;
  work_hours = days*8;
}
void NumDays::setHours(double hours)
{
  work_hours = hours;
  days = work_hours/8;
}
double NumDays::getDays()
{
  return days;
}
double NumDays::getHours()
{
  return work_hours;
}

NumDays & NumDays::operator =(const NumDays & other)
{
  work_hours = other.work_hours;
  days = other.days;
}

NumDays NumDays::operator +(const NumDays & other) const
{
  NumDays ND(work_hours);
  ND.setHours(ND.work_hours + other.work_hours);
  return ND;
}

NumDays NumDays::operator -(const NumDays & other) const
{
  NumDays ND(work_hours);
  ND.setHours(ND.work_hours - other.work_hours);
  return ND;
}

NumDays NumDays::operator ++()
{
  setHours(work_hours+1);
  return *this;
}

NumDays NumDays::operator ++(int)
{
  NumDays ND(*this);
  operator++();
  return ND;
}

NumDays NumDays::operator --()
{
  setHours(work_hours-1);
  return *this;
}

NumDays NumDays::operator --(int)
{
  NumDays ND(*this);
  operator--();
  return ND;
}
