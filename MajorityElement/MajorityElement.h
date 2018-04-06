#ifndef MAJORITYELEMENT_H
#define MAJORITYELEMENT_H

#include <iostream>
#include <string>

using namespace std;

class MajorityElement
{
private:
	int * m_ary;
	int m_size;
	void grow();
  void shrink();
public:
	MajorityElement();
	MajorityElement(const MajorityElement & other);
	virtual ~MajorityElement();
	int size() const;
	void append(int value);
	void remove(int value);
	void removeAt(int index);
	int operator[](int index);
	int findMajorityElement();
	friend ostream & operator <<(ostream & os, const MajorityElement & other);
};

ostream & operator << (ostream & os, const MajorityElement & other);

#endif
