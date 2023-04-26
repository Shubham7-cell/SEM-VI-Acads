%{
#include <stdio.h>
#include "y.tab.h"
#include <string.h>
int variable_one = 0;
int variable_two = 0;
%}

%%
[nsew] {
yylval.intval = *yytext;
return DIRECTION;
}
[ \t] ;
"START" {return START;}
"$" {return 0;}
\n|. return yytext[0];

%%