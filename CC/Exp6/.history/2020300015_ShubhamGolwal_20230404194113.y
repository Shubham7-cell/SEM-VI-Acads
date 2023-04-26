%{
#include <string.h>
extern int yylex();
void yyerror(char *s);
int x;
int y;
int flag = 0;
%}

%union {
    int intval;
}



%token<intval> DIRECTION
%token<intval> START
%%
statement: statement direction 
            | START {x = 0;y = 0;}

direction: DIRECTION {
    switch($1){
        case 110:
            y+=1;
            break;
        case 119:
            x-=1;
            break;
        case 115:
            y-=1;
            break;
        case 101:
            x+=1;
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
    if(!flag) printf("Final position is = (%d,%d)", x,y);
    else printf("Please try again");
}