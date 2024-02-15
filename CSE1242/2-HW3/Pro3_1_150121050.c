//Emirhan Türkol 150121050
#include <stdio.h>


void reverseN(int *number, int N);

int main(void)
{
    //the largest integer is 2147483647 which has 10 digits which is also the arrays size
    //'0' 's ASCII code is 48 in decimal 57 is 9
    char number[10];
    int digits;
    int* pNumber;

    //filling char array with the int 58 to be able to understand where the given number ends 
    for (int i=0; i<10; i++)
    {
        number[i]=58;
    }

    printf("Please enter a number\n");
    scanf("%s", &number);
    printf("Please enter another number to determine which digits will be reversed\n");
    scanf("%d", &digits);

    
    
    int numberArray[10];

    //filling the int array with -1's to understand where the number ends
    for (int i=0; i<10; i++)
    {
        numberArray[i]=-1;
    }  
    //copying the number from char array to int array using their ASCII code
    for (int i=0; i<10; i++)
    {
        if(number[i]<58 && number[i]>47)
        {
            numberArray[i]=number[i]-48;
        }       
    }
    
    //Assiging a pointer to the first element of the int array
    pNumber=numberArray;

    reverseN(pNumber,digits);
  
}

void reverseN(int *number, int N)
{
    int count=0;
    //Counting the digits of the number
    for (int i=0; i<10; i++)
    {
        if(*(number+i)!=-1)
        {
            count++;
        }
        else
        {
            break;
        }        
    }
    //Printing the digits that are untouched
    for(int i=0; i<count-N; i++)
    {
        printf("%d", *(number+i));
    }
    //Printing the last N digits in reverse order
    int a=0;
    for(int i=N; i>0; i--)
    {       
        printf("%d",*(number+count-1-a));
        a++;
    }      
}


