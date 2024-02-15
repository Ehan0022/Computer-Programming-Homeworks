//Emirhan Türkol 150121050
//This program aims to apply some specified actions a data group that is passed in a txt file and print the results of it to another txt file. 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>


typedef struct
{
   char cArrray[51];
}String;




char charAt(String *s, int index);
String* concat(String *s1, String *s2);
unsigned int strSearch(String *s1, String *s2);
unsigned int findScore(String *s1);

void myFunction(char* word,char c);



void main (int argc, char* argv[])
{
   
   FILE* inputFile = fopen("input.txt", "r");   
   
    char* outputFileName = argv[2];

    FILE* outputFile = fopen(outputFileName, "w");

    char text[800];
    char line[51];

    // This array will fill the char array with null characters
    int textLength = sizeof(text) / sizeof(text[0]);
    for (int i = 0; i < textLength; i++) 
    {
        text[i] = '\0';
    }

    // This code reads each line and then concatenates them to the larger array
    while (fgets(line, sizeof(line), inputFile) != NULL)
    {
        strcat(text, line);
    }

    fclose(inputFile);

    // Print the contents of the text array
    printf("%s\n", text);

    // Create an integer array to store newline character indexes
    int newlineIndexes[800];
    int newlineCount = 0;

    // Iterate through the text array to find newline characters
    for (int i = 0; i < strlen(text); i++)
    {
        if (text[i] == '\n') {
            newlineIndexes[newlineCount] = i;
            newlineCount++;
        }
    }

    // Shift the values in the newlineIndexes array
    for (int i = newlineCount - 1; i >= 1; i--) 
    {
    newlineIndexes[i] = newlineIndexes[i - 1];
    }


    newlineIndexes[0] = 0;

    // Print the newline character indexes
    printf("Newline character indexes:\n");
    for (int i = 0; i < newlineCount; i++)
    {
        printf("%d ", newlineIndexes[i]);
    }
    printf("\n");
    printf("The new line count is :%d\n", newlineCount );
    
 

    String myStrings[newlineCount];
    
    for(int i=0; i<newlineCount; i++)
    {
        for(int j=0; j<51; j++)
        {
            myStrings[i].cArrray[j]='\0';
        }
    }

     
        for (int i = 0; i < newlineCount; i++) 
        {
        int lineStartIndex = newlineIndexes[i];
        int lineEndIndex = (i == newlineCount - 1) ? strlen(text) : newlineIndexes[i + 1] + 1;
        int lineLength = lineEndIndex - lineStartIndex;
        strncpy(myStrings[i].cArrray, text + lineStartIndex, lineLength);
        }

    printf("Lines stored in the String array:\n");
    for (int i = 0; i < newlineCount; i++) 
    {
        printf("%s", myStrings[i].cArrray);
    }

    //By using this code I realized that at my String arrays first index there were new line characters but I could not solve it so I will implement the rest of my code accordingly to get around the fact I was not able to remove the new line characters.
    /*if(myStrings[2].cArrray[0]=='\n')
    {
        printf("true");
    }*/
    
    
    char Result[800];
    
    int indexOfNull = 0;

for (int i = 0; i < newlineCount; i++) 
{

    for (int z = 0; z < 800; z++) 
    {
        if (Result[z] == '\0') 
        {
            indexOfNull = z;
            break;
        }
    }

    for (int j = 0; j < 51; j++) 
    {
        if (myStrings[i].cArrray[j] == '1')
         {
            char index = myStrings[i].cArrray[j + 2];
            Result[indexOfNull] = charAt(&myStrings[i], (int)index - 48);
            Result[indexOfNull + 1] = '\n';
            indexOfNull += 2;
        }
        else if (myStrings[i].cArrray[j] == '2') {
            String *s1 = (String *)malloc(sizeof(String));
            String *s2 = (String *)malloc(sizeof(String));
            
            // take the required string 
            strncpy(s1->cArrray, myStrings[i].cArrray, j);
            s1->cArrray[j] = '\0';

            // take the required string 
            strncpy(s2->cArrray, myStrings[i].cArrray + j + 1, strlen(myStrings[i].cArrray) - j - 1);
            s2->cArrray[strlen(myStrings[i].cArrray) - j - 1] = '\0';

            String *concatenatedString = concat(s1, s2);
            strcpy(Result + indexOfNull, concatenatedString->cArrray);
            indexOfNull += strlen(concatenatedString->cArrray);

            Result[indexOfNull] = '\n';
            indexOfNull++;

          
        }
        else if (myStrings[i].cArrray[j] == '3') 
        {
            String *s1 = (String *)malloc(sizeof(String));
            String *s2 = (String *)malloc(sizeof(String));

    // extracting the string 
    strncpy(s1->cArrray, myStrings[i].cArrray, j);
    s1->cArrray[j] = '\0';

    
    strcpy(s2->cArrray, myStrings[i].cArrray + j + 1);

   //calling strSearch to get the result
    unsigned int wordLength = strSearch(s1, s2);

    
    char resultChar = (char)(wordLength + '0'+8);
    Result[indexOfNull] = resultChar;
    indexOfNull++;

    Result[indexOfNull] = '\n';
    indexOfNull++;

    Result[indexOfNull] = '\0'; 

    
        }

        else if(myStrings[i].cArrray[j] == '4')
    {
        
    }
    else if(myStrings[i].cArrray[1]=='e'&&myStrings[i].cArrray[2]=='x'&&myStrings[i].cArrray[3]=='i'&&myStrings[i].cArrray[4]=='t')
    {
        Result[indexOfNull]='P';
        Result[indexOfNull+1]='r';
        Result[indexOfNull+2]='o';
        Result[indexOfNull+3]='g';
        Result[indexOfNull+4]='r';
        Result[indexOfNull+5]='a';
        Result[indexOfNull+6]='m';
        Result[indexOfNull+7]=' ';
        Result[indexOfNull+8]='e';
        Result[indexOfNull+9]='n';
        Result[indexOfNull+10]='d';
        Result[indexOfNull+11]='s';
        Result[indexOfNull+12]='\n';
    }

    }

    
}


printf("%s", Result);


 fprintf(outputFile, "%s", Result);
  fclose(outputFile);
}

unsigned int findScore(String *myString) {
    int score = 0;

    for (int i = 0; i<51; i++) {
        char ch = toupper(myString->cArrray[i]);

        // This table is the scores for each letter, toupper function allows us to not write the lowercase letters
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
            ch == 'L' || ch == 'N' || ch == 'R' || ch == 'S' || ch == 'T') 
            {
            score += 1;
        } else if (ch == 'D' || ch == 'G') 
        {
            score += 2;
        } else if (ch == 'B' || ch == 'C' || ch == 'M' || ch == 'P') 
        {
            score += 3;
        } else if (ch == 'F' || ch == 'H' || ch == 'V' || ch == 'W' || ch == 'Y') 
        {
            score += 4;
        } else if (ch == 'K') 
        {
            score += 5;
        } else if (ch == 'J' || ch == 'X') 
        {
            score += 8;
        }
    }
}



char charAt(String *s, int index)
{
    if(index<=50&&index>-1)
    {
        return s->cArrray[index];
    }
    else
    {
        return 'z';
    }    
}

String *concat(String *s1, String *s2)
{
    int s1Length = strlen(s1->cArrray);
    int s2Length = strlen(s2->cArrray);

    String* result = (String*)malloc(sizeof(String));

    // These for loops will conconate the given strings
    
    for (int i = 0; i < s1Length; i++) 
    {
        result->cArrray[i] = s1->cArrray[i];
    }

    for (int j = 0; j < s2Length; j++) 
    {
        result->cArrray[s1Length + j] = s2->cArrray[j];
    }

    // this line will determine the end of the string
    result->cArrray[s1Length + s2Length] = '\0';
    return result;


}

    unsigned int strSearch(String* myString, String* myString2)
    {

    int length = 0;
    int found = 0;
    int i = 0;

    while (myString->cArrray[i] != '\0') 
    {
        int j = i;
        int wordLength = 0;

        // this loop will calculate the length
        while (myString->cArrray[j] != ' ' && myString->cArrray[j] != '\0') 
        {
            wordLength++;
            j++;
        }

        // this loop checks if the word has the required letters
        int hasLetters = 1;
        for (int k = 0; myString2->cArrray[k] != '\0'; k++) 
        {

            char letter = myString2->cArrray[k];
            int letterFound = 0;

            for (int l = i; l < j; l++) 
            {
                if (myString->cArrray[l] == letter) {
                    letterFound = 1;
                    break;
                }
            }

            if (!letterFound) 
            {

                hasLetters = 0;
                break;
            }
        }

        if (hasLetters) 
        {
            length += wordLength;  
            found = 1;
        }

        if (myString->cArrray[j] == '\0') {
            break;  
        }

        i = j + 1;  
    }

    // return the length if found and return -1 if not
    if (found) 
    {
        return length;
    } else 
    {
        return -1;  
    }
}




