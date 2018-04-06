#ifndef NUMDAYS_H
#define NUMDAYS_H

using namespace std;

class NumDays
{
private:
  double work_hours;
  double days;
  double ConvertDays(double hours);
public:
  NumDays();
  NumDays(const NumDays & other);
  NumDays(double hours);
  virtual ~NumDays() {};
  double getDays();
  double getHours();
  void setHours(double hours);
  void setDays(double d);
  NumDays & operator =(const NumDays & other);
  NumDays operator +(const NumDays & other) const;
  NumDays operator -(const NumDays & other) const;
  NumDays operator ++();
  NumDays operator ++(int);
  NumDays operator --();
  NumDays operator --(int);
};

#endif
