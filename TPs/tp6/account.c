#include "account.h"
#include <string.h>
#include <stdlib.h>


void init_account(account * a, char * name){
    static int id_auto = 0;
    a -> amount = 0; 
    strcpy(a -> name, name);
    a -> id = id_auto;
    id_auto++;
}

void free_account(account *a){
    free(a);
}