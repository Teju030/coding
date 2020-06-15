# Coding
Coding CPP
What does compiler do ?
What does linker do ?

Pre processing - 
#include statements -> includes alll the code present in the header file into the current file 
#define <old_word> <new_work>

#if 1
#endif 
-----------------------------------------------------------------------------

Linker - find each symbol and function declared and link them together.
Entry point not neccesarily to be main()
we can define customized entry function

sizeof() or sizeof bool

#pragma once -> includes header file only once even though it is declared multiple times


#include <>
#include ""

char* buffer = new char[8];
memset(buffer, 0, 8);

int a =10;
int& ref = a; -> ref is just aliase, ref is not a var.
once you assign the reference to ref you can not change it 
In that case you would want to use pointers

static var or function -> then it is linked only for that translation units
extern int s;


Size of the column and rows for vectors 
std::cout << "Rows in the 2d vector: " << MyVector.size()
std::endl << "Collumns in the 1st row: " << MyVector[0].size()

freopen("input.txt", "r", stdin);  to read input from file

STL sort function is applicable for - > arrays vector, deque
it is hybrid of quick sort, heap sort, and insertion sort
