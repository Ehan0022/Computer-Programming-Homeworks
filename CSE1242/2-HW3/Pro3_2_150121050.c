//Emirhan Türkol 150121050
#include <stdio.h>

 double I_calculateWeightBack(int a,int b);
 double r_calculateWeightBack(int a,int b);

int main(void)
{
    int row;
    int columm;
    //Takes input
    printf("Please enter the row number\n");
    scanf("%d", &row);
    printf("Please enter the columm number\n");
    scanf("%d", &columm);

    double result = I_calculateWeightBack(row,columm);
    double result2 = r_calculateWeightBack(row,columm)-80;
    printf("The result from iteration: %f\n", result);
    printf("The result from recursion: %f", result2);
    
}

 double I_calculateWeightBack(int a,int b)
{   
    //Creates a two dimensional array where all elements will be calculated
    double table[31][31];
    table[0][0]=80;
     
    //This loop calculates the values of the first columm using the given table[0][0] value
     for(int i=1; i<31; i++)
     {
        table[i][0]=table[i-1][0]/2+80;
     }

    int count = 0;
    
    //This loop calculates the rest of the elements in the array
     for(int i=1; i<31; i++)
     {
        for(int j=1+count; j<31; j++)
        {
            table[j][i]=table[j-1][i-1]/2+table[j-1][i]/2+80;
        }
        count++;
     }

     return table[a][b]-80;
}

 double r_calculateWeightBack(int a,int b)
 {
    //The first two if statements are there to to determine the limits, returning 0
    if(b>a)
    {
        return 0;
    }
    else if(a<0 || b<0)
    {
        return 0;
    }
    //This is our base case
    else if(a==0 && b==0)
    {
        return 80;
    }   
    //This is the recursive procedure
    else
    {
        return  (r_calculateWeightBack(a-1,b-1)/2+r_calculateWeightBack(a-1,b)/2+80);
    }
 }

