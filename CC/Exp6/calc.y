%{

#include <string.h>
#include <iostream>

extern int yylex();
void yyerror(char *s);

}%

%union {
    int intval;
}

%token <intval> NUMBER

%type <intval> term
%type <intval> factor

%%

statement : expression {
    printf("= %d\n", $1);
};

expression: expression '+' term { $$ = $1 + $3; } 
        |   expression '-' term { $$ = $1 + $3; }
        |   term ;


term: term '*' factor { $$ = $1 * $3; }
    | term '/' factor {
        if($3 == 0)
        yyerror("Divide by 0");
        else $$ = $1 / $3;
    }

    | factor ;


factor: '(' expression ')' { $$ = $2; }
        
        | '-' factor { $$ = $2; }
        | NUMBER ;

%%

void yyerror(char *s)
{
    std:: cout <<s<< std::endl;
}
    

int main()
{
    yyparse();
    
}