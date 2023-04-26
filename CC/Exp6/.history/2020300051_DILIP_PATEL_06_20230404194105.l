%{
#include <stdio.h>
#include "y.tab.h"
#include <string.h>
int x = 0;
int y = 0;
%}

%%
[nsew]  {
    yylval.intval = *yytext;
    return DIRECTION;
}
[ \t]  ;
"START" {return START;}     
"$"  {return 0;}
\n|. return yytext[0];

%%
