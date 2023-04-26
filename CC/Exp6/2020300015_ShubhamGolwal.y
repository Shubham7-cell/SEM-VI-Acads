%{
#include <string.h>
extern int yylex();

void yyerror(char *s);
    int posX;
    int posY;
    int flag = 0;
%}

%union {
    int intval;
}

%token<intval> DIRECTION
%token<intval> START

%%
statement: statement direction
| START {posX = 0; posY = 0;}

direction: DIRECTION {
    switch($1){
        case 110:
            posY += 1;
            break;
        case 119:
            posX -= 1;
            break;
        case 115:
            posY -= 1;
            break;
        case 101:
            posX += 1;
            break;
        }
}

%%

void yyerror(char *s){
    printf("The given string is Invalid");
    flag = 1;
    return;
}

int main(){
    yyparse();
    if(!flag) printf("Final position is = (%d,%d)", posX, posY);
    else printf("Please try again");
}