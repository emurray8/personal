#include <iostream>
#include <string>
#include "MajorityElement.h"

using namespace std;

void MajorityElement::grow()
{
	int * temp = new int[m_size+1];
	for (int i = 0; i < m_size; i++)
	{
		temp[i] = m_ary[i];
	}
	m_size = m_size+1;
	delete [] m_ary;
	m_ary = temp;
}
void MajorityElement::shrink()
{
	m_size = m_size-1;
	int * temp = new int[m_size];
	for (int i = 0; i < m_size; i++)
	{
		temp[i] = m_ary[i];
	}
	delete [] m_ary;
	m_ary = temp;
}
MajorityElement::MajorityElement() : m_size(0){
	m_ary = new int[m_size];
}
MajorityElement::MajorityElement(const MajorityElement & other){
	for (int i = 0; i < other.m_size; i++)
	{
		grow();
		m_ary[i] = other.m_ary[i];
	}
}
MajorityElement::~MajorityElement(){
	delete [] m_ary;
}
int MajorityElement::size() const{
	return m_size;
}
void MajorityElement::append(int value){
	grow();
	m_ary[m_size-1] = value;
	if(findMajorityElement() == -1){
		shrink();
		throw "Loss of Special Property Exception";
	}
}
void MajorityElement::remove(int value){
	bool found = false;

	for(int i = 0; i < m_size; i++){
		if(m_ary[i] == value)
		found = true;
	}
	if(found){
		m_size = m_size-1;
		int * temp = new int[m_size];
		bool removedOne = false;
		for (int i = 0; i < m_size+1; i++)
		{
			if(!removedOne){
				if(m_ary[i] != value)
				temp[i] = m_ary[i];
				else
				removedOne = true;
			}else{
				temp[i-1] = m_ary[i];
			}

		}


			delete [] m_ary;
			m_ary = temp;
			if(findMajorityElement() == -1)
				throw "Loss of Special Property Exception";
	}
}
void MajorityElement::removeAt(int index){
	if(index >= 0 && index < m_size){
		m_size = m_size-1;
		int * temp = new int[m_size];
		if(index == 0){
			for(int i = 0; i < m_size; i++){
				temp[i] = m_ary[i+1];
			}
		}else{
			for (int i = 0; i < m_size; i++)
			{
					if(i != index)
					temp[i] = m_ary[i];
					else
					temp[i-1] = m_ary[i];
			}
		}


			delete [] m_ary;
			m_ary = temp;
			if(findMajorityElement() == -1)
				throw "Loss of Special Property Exception";
	}else{
		throw "Index Out Of Bounds";
	}
}
int MajorityElement::operator[](int index){
	if( index > m_size || index < 0)
    {cout << "Index out of bounds" <<endl;
		return -1;}
	else
  	return m_ary[index];
}
int MajorityElement::findMajorityElement(){
	int count = 0, i, majorityElement;
 for (i = 0; i < m_size; i++) {
		 if (count == 0)
				 majorityElement = m_ary[i];
		 if (m_ary[i] == majorityElement)
				 count++;
		 else
				 count--;
 }
 count = 0;
 for (i = 0; i < m_size; i++)
		 if (m_ary[i] == majorityElement)
				 count++;
 if (count > m_size/2)
		 return majorityElement;
 return -1;
}
ostream & operator <<(ostream & os, const MajorityElement & other)
{
	for (int i = 0; i < other.m_size; i++)
		os << i << " :"<< other.m_ary[i] << endl;
	return os;
}
