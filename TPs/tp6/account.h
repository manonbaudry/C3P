typedef struct struct_account account;

struct struct_account{
    int id;
    char name[100];
    double amount;
};

void init_account(account * a, char * name);
void free_account(account *a);

