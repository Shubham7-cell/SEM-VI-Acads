%{
#include "y.tab.h"
#include <math.h>

%}

%%
[1-9]+[0-9]* {
    return NUMBER;
}

[ \t] ;

"$" {
    return 0;
}

\n|. return yytext[0];

%%