#include <stdio.h>
#include <cstdlib>
#include <iostream>
#include <ctime>

using namespace std;
int main()
{
    //game initialize
    char a;
    srand((unsigned)time(NULL));
    printf("PRESS ENTER TO CONTINUE \n");
    a=getchar();
    while(a!='\n');
    //create heaps
    int Numberofheaps=((rand()%3)+1)*2+1;
    int heap[Numberofheaps];
    int Numberofobjects=0;
    for (int i=0;i<Numberofheaps;i++)
    {
        heap[i]=((rand()%3)+4)*2+1;
    }
    int player=rand()%2;
    printf("Created %d heaps of sizes ",Numberofheaps);
    for (int i=0;i<Numberofheaps;i++)
    {
        printf("%d ",heap[i]);
    }
    cout<<endl;
    if (player) printf("Player human goes first\n");
    else printf ("Player computer goes first\n");
    //game start
    while(true)
    {
        Numberofobjects=0;
        if (player)
        {
            //human move
            int target=0;
            int objects=0;
            char ch;
            string line;
            do
            {
                cout << "Player human enter the number of objects (Y) to take from what heap (X)- in order: Y X" << endl;
                getline(cin, line);
                int m=line.size();
                target=line[m-1]-'0';
                objects=line[0]-'0';
                if (line[1]!=' ')
                    objects=objects*10+line[1]-'0';
                if (!(target<=Numberofheaps && objects<=heap[target-1] && objects>0))
                {
                    printf ("Player human that is an invalid move, try again.\n");
                    //printf ("Player human that is an invalid move, try again. target=%d. objects=%d", target, objects);
                    cout<<endl;
                }
                else 
                {
                    heap[target-1]=heap[target-1]-objects;
                    break;
                }
            } while(true);
        }
        else
        {
            //computer move
            int targetheap;
            int objectstoken;
            while(true)
            {
                targetheap=rand()%Numberofheaps;
                if (heap[targetheap]!=0)
                    break;
            }
            objectstoken=rand()%heap[targetheap]+1;
            heap[targetheap]=heap[targetheap]-objectstoken;
            printf("Player computer took %d objects from heap %d \n",objectstoken, targetheap+1);
            cout<<endl;
        }
        //check if we have a winner
        for (int i = 0; i < Numberofheaps; i++)
        {
            printf ("%d ", heap[i]);
        }
        cout<<endl;
        for (int i=0;i<Numberofheaps;i++)
        {
            Numberofobjects=Numberofobjects+heap[i];
            //printf("Numberofobjects=%d ",Numberofobjects);
        }
        if (Numberofobjects==0) 
        {
            if (player) 
            {
                printf ("Player human has won\n");
                return 0;
            }
            else
            {
                printf("Player computer has won\n");
                return 0;
            }
             
        }
        player=!player;
    }
    return 0;
}
