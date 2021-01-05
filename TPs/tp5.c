#include <stdio.h>
#include <stdlib.h>

#define MEMORY_SIZE 4096
#define REGISTER_SIZE 16

typedef struct {
    unsigned char memory[MEMORY_SIZE];
    unsigned char registers[REGISTER_SIZE];
    unsigned char memory_register;
    unsigned char pc;
} chip8;


chip8* create(){
    return malloc(sizeof(chip8));
}

void initialize(chip8* machine){
    for(int i = 0; i < MEMORY_SIZE; i++){
        machine->memory[i]=0;
    }
    for(int i = 0; i < REGISTER_SIZE; i++){
        machine->registers[i]=0;
    }

    machine->memory_register = 0;
    machine->pc = 0;
}

void read_file(chip8* machine){
    FILE* fp = fopen("sc-games/ALIEN", "r");
    int nb = fread(machine -> memory, 1, 4096, fp);
    fclose(fp);
    printf("%d\n", nb);
}

// a = 0xAB et b = 0xCD
unsigned short concat_char(short a, short b){
    unsigned short res = a; // 0xOOAB
    res = res << 8; // 0xAB00
    res = res | b; // 0xABCD
}

int main (void){
    chip8* machine = create();
    initialize(machine);
    read_file(machine);
    printf("0x%X\n", concat_char(0xAB, 0xCD));

    free(machine);
    return 0;
}