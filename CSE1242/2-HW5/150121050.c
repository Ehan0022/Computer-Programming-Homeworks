//Emirhan Türkol 150121050

/*This program will have a default song list that will be given in a txt file via the command line. It will then give various choices to the user such as adding new songs
deleting existing ones, printing the current state of the list and printing the song list to another txt file that was also passed in via command line.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Song 
{
    char songName[30];
    int duration;
    struct Song* next;
} Song;

//** allows us to change the value inside the pointer
//this function inserts a new song to the list according to its duration value
void insertNode(Song** head, const char* songName, int duration);
//this functin allows us to remove a song when its name is provided
void removeSong(Song** head, const char* userInput);
//this function opens the file that the usser provides via command line and prints songname fields of each song struct in the linked list to that file.
void writeToFile(Song* head, const char* filename);
//this function prints the contents of the songs to the console.
void printList(Song* head);



int main(int argc, char* argv[]) 
{
    FILE* file = fopen(argv[1], "r");
    char buffer[30];
    char data[8][30];

    int b = 0;
    //this loops reads the lines of the txt file that was provided via the command line and stores each line in the two dimensional data array.
    while (fgets(buffer, 30, file) != NULL) {
        strcpy(data[b], buffer);
        b++;
    }

    //printf("%s\n", data[0]);
    //printf("%s\n", data[1]);
    //printf("%s\n", data[2]);
    //printf("%s\n", data[3]);
    //printf("%s\n", data[4]);
    //printf("%s\n", data[5]);
    //printf("%s\n", data[6]);
    //printf("%s\n", data[7]);
    
    Song* head = NULL;

    //printf("%d\n", (((int)data[0][strlen(data[0]) - 5]) - 48) * 60 +(((int)data[0][strlen(data[0]) - 3]) - 48) * 10 +(((int)data[0][strlen(data[0]) - 2]) - 48);
        //printf("%d\n", (((int)data[7][strlen(data[7]) - 5]) - 48) * 60 +(((int)data[7][strlen(data[0]) - 3]) - 48) * 10 +(((int)data[7][strlen(data[7]) - 2]) - 48);



    //this loop will create song structs and create a linked list according to each songs duration time
    for (int i = 0; i < 8; i++) 
    {
        // creating new song
        Song* newSong = (Song*)malloc(sizeof(Song));

        strcpy(newSong->songName, data[i]);

        newSong->duration = (((int)data[i][strlen(data[i]) - 5]) - 48) * 60 +(((int)data[i][strlen(data[i]) - 3]) - 48) * 10 +(((int)data[i][strlen(data[i]) - 2]) - 48);
        newSong->next = NULL;

        //insert the song to the list
        if (head == NULL || newSong->duration < head->duration) 
        {
            newSong->next = head;
            head = newSong;
        } 

        else 
        {
            Song* current = head;

            while (current->next != NULL && current->next->duration < newSong->duration) {
                current = current->next;
            }
            newSong->next = current->next;
            current->next = newSong;
        }
    }

    //printf("%s\n", head->songName);
   // printf("%s\n", head->next->songName);

//printf("%s\n", head->duration); 
  // printf("%d\n", head->next->duration);

 

    // Print the sorted linked list
    printf("The list in duration order: \n");
    printList(head);
    printf("\n");

    //users choice
    int choice;

     printf("Enter your choice: \n");
        printf("1 to insert a song into the list.\n");
        printf("2 to delete a song from the list.\n");
        printf("3 to print the songs in the list.\n");
        printf("4 to print the songs to an output file.\n");
        printf("5 to end.\n");
        scanf("%d" ,&choice);
    //when getchar is not used the scanner gets messed up.
    getchar();

    while(choice!=5)
    {   
        //if users input is'1' inserts the song that the user provided. The input must be provided as a hole string
        if(choice==1)
        {
            char userInput[25];
            printf("Enter a song:\n");
            fgets(userInput, sizeof(userInput), stdin);

            int songDur = (((int)userInput[strlen(userInput) - 5]) - 48) * 600+(((int)userInput[strlen(userInput) - 5]) - 48) * 60 + (((int)userInput[strlen(userInput) - 3]) - 48) * 10 + (((int)userInput[strlen(userInput) - 2]) - 48);
            
            // insert the song
            insertNode(&head, userInput, songDur);
        }
    //Removes a song from the list if the user enters a song name that is present in the list
        if(choice==2)
        {
            char songToRemove[25];
            printf("Enter a song name to remove:\n");
            fgets(songToRemove, sizeof(songToRemove), stdin);

            // remove the song
            removeSong(&head, songToRemove);
        }
        //prints the current state of the list to the console
        if(choice==3)
        {
            printf("The list in duration order: \n");
            printList(head);
            printf("\n");
        }
        //prints the content of list to a txt file that the user must provide via command line
        if (choice == 4) 
        {
        
         char* filename = argv[2];

        writeToFile(head, filename);
        printf("Songs written to the file.\n");
        }
       

        printf("Enter your choice: \n");
        printf("1 to insert a song into the list.\n");
        printf("2 to delete a song from the list.\n");
        printf("3 to print the songs in the list.\n");
        printf("4 to print the songs to an output file.\n");
        printf("5 to end.\n");
        scanf("%d" ,&choice);
        printf("\n");
        getchar();
    }


    return 0;
}

void insertNode(Song** head, const char* songName, int duration) 
{
    //this will create a new node
    Song* newSong = (Song*)malloc(sizeof(Song));
    strcpy(newSong->songName, songName);
    newSong->duration = duration;
    newSong->next = NULL;

    // Insert the new Song node into the linked list
    if (*head == NULL || newSong->duration < (*head)->duration) 
    {
        newSong->next = *head;
        *head = newSong;
    } 
    
    else 
    {
         Song* current = *head;
        while (current->next != NULL && current->next->duration < newSong->duration) 
        {
            current = current->next;
        }
        newSong->next = current->next;
        current->next = newSong;
    }
}

void removeSong(Song** head, const char* userInput)
{
    
    Song* current = *head;
    Song* prev = NULL;


     while (current != NULL) {
        // Compare the first x characters of the song name with the user's input
        if (strncmp(current->songName, userInput, strlen(userInput) - 1) == 0) 
        {           
            if (prev == NULL)
             {
                *head = current->next;
            }
             else 
            {
                prev->next = current->next;
            }

            Song* temp = current;
            current = current->next;
            

        } 
        else 
        {
            prev = current;
            current = current->next;
        }
    }
}

void writeToFile(Song* head, const char* filename) 
{
    FILE* file = fopen(filename, "w");
    if (file == NULL) 
    {
        printf("Error opening the file.\n");
        return;
    }

    Song* current = head;

    while (current != NULL) 
    {
        //this function allow us to write to a file
        fprintf(file, "%s", current->songName);
        current = current->next;
    }

    fclose(file);
}

void printList(Song* head) 
{
    Song* current = head;
    int i = 0;

    //this loop will print the songName fields of each song
    while (current != NULL) 
    {
        printf("Element %d: %s", i + 1, current->songName);
        current = current->next;
        i++;
    }
}