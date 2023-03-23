#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int state;
char code[1000];
char c2;
char start;
int start_index;
char buff[1000];
int buff_index;

char keys[26][20] = {"auto",
                     "double",
                     "main",
                     "struct",
                     "long",
                     "case",
                     "enum",
                     "char", "register", "return",
                     "union",
                     "const",
                     "short",
                     "for",
                     "void", "default", "goto",
                     "while",
                     "int",
                     "char",
                     "if",
                     "else",
                     "switch",
                     "break",
                     "enum", "printf"};
int key_store[26][2];
int key_count;
int extra_count;

void lexical_analyzer(char c[], int n)
{
    int i = 0;
    if (c[n - 1] == '\n')
        n -= 1;

    while (i < n)
    {
        switch (state)
        {

        case 0:

            c2 = c[i];
            i++;

            // operators
            if ((c2 == '+') || (c2 == '-'))
            {
                state = 1;
            }
            else if (c2 == '/')
            {
                if (i < n)
                {
                    if (c[i] == '/')
                    {
                        printf("Single line comment\n\n");
                        i = n;
                    }
                    else if (c[i] == '*')
                    {
                        i++;
                        printf("multi line comment\n\n");
                        state = 6;
                    }
                    else
                        state = 1;
                }
                printf("< arithmetic operator : %c > recognized\n\n", c2);
            }

            else if ((c2 == '%') || (c2 == '*'))
                state = 1;
            else if ((c2 == '&') || (c2 == '|'))
                state = 2;
            else if (c2 == '^')
                state = 3;
            else if (c2 == '=')
                state = 4;
            else if ((c2 == '>') || (c2 == '<'))
                state = 5;
            else if (c2 == '!')
                if (i < n && c[i] == '=')
                {

                    recognized\n\n ",c2);
                }
                else

                    i++;
printf("< relational operator : %c= >




printf("< logical operator : %c > recognized\n\n",c2);
 

//header
else if(c2 == '#' && i<n)
{
                if (c[i] == 'i')
                {
                    printf("header file included\n\n");
                    i = n;
                }
                else if (c[i] == 'd')
                {
                    printf("constant defined\n\n");
                    i += 6;
                }
}

//separators
else if(c2 == ',' || c2 == ';')
printf("< separator : %c > recognized\n\n",c2);

//braces, brackets, parenthesis
else if(c2 == '(' || c2 == ')')
printf("< parenthesis : %c > recognized\n\n",c2);

else if(c2 == '[' || c2 == ']')
printf("< brackets : %c > recognized\n\n",c2);
 






else if(c2 == '{' || c2 == '}')
printf("< braces : %c > recognized\n\n",c2);

//constants
else if (isdigit(c2)>0)
{
                start = c2;
                start_index = 0;
                buff_index = 0;
                buff[buff_index] = c2;
                buff_index++;
                state = 7;
}

//string
else if(c2 == '"')
{
                buff_index = 0;
                buff[buff_index++] = c2;
                state = 8;
}

//keyword and identifier
else if(isalpha(c2)>0 || c2=='_')
{
                key_count = 0;
                for (int j = 0; j < 26; j++)
                {
                    if (c2 == keys[j][0])
                    {
                        key_store[key_count][0] = j;
                        key_store[key_count][1] = strlen(keys[j]);
                        key_count++;
                    }
                }
                extra_count = key_count;

                if (key_count > 0) // check for keywords
                    state = 9;
                else
                    state = 10;

                start = c2;
                buff[0] = c2;

                buff_index = 1;
}

break;




case 1:
if (i<n)
{
                if (c2 == '+' || c2 == '-')
                {
                    if (c2 == c[i])
                    {

                        recognized\n\n ",c2,c2);
                    }
                }

                i++;
printf("< arithmetic operator : %c%c >

state=0; break;
 

if(c[i] == '=')
{
                    recognized\n\n ",c2);
}
else
 
i++;
printf("< assignment operator : %c= >




printf("< arithmetic operator : %c > recognized\n\n",c2);
 
}

state=0; break;

case 2:
if (i<n)
{
                if (c[i] == c2)
                {

                    recognized\n\n ",c2,c2);
                }
                else

                    i++;
printf("< logical operator : %c%c >
 





printf("< bitwise operator : %c > recognized\n\n",c2);
}

state=0; break;

case 3:
printf("< bitwise operator : %c > recognized\n\n",c2);

state=0; break;

case 4:
if (i<n)
{
                if (c2 == c[i])
                {

                    recognized\n\n ",c2,c2);
                }
                else

                    i++;
printf("< relational operator : %c%c >




printf("< assignment operator : %c > recognized\n\n",c2);
 

}

state=0; break;

case 5:
if (i<n)
{
                if (c2 == c[i])
                {

                    recognized\n\n ",c2,c2);
                }
                else
                {

                    i++;
printf("< bitwise operator : %c%c >





if(c[i] == '=')
{
                        recognized\n\n ",c2);

                            i++;
printf("< relational operator : %c= >
 




 




recognized\n\n",c2);
}
                }
else
printf("< relational operator : %c >
 
}

state=0; break;

case 6:

if (i<n)
{
                c2 = c[i];
                i++;

                if (i < n && c2 == '*' && c[i] == '/')
                {
                    i++;
                    state = 0;
                }
}

break;

case 7:
if (i<n)
{
                c2 = c[i];
                i++;

                if (isdigit(c2) > 0)
                {
                    buff[buff_index] = c2;
                    buff_index++;
                }
                else if (c2 == '.')
                {
                    if (isdigit(start) > 0)
                    {
                        start = '.';
                        start_index = buff_index;
                        buff[buff_index] = c2;
                        buff_index++;

                        +, - : i - 3
                    }
                    else // dot repeats ifafter . just after e, i-2, +,- just

                    {
                        i--;
                        printf("< Constant : ");
                        for (int k = 0; k < buff_index; k++)
                            printf("%c", buff[k]);
                        printf(" > recognized\n\n");
                        state = 0;
                        break;
                    }
                }
                else if (c2 == 'E')
                {
                    if (start == '.')
                    {
                        start = 'E';
                        start_index = buff_index;
                        buff[buff_index] = c2;
                        buff_index++;
                        if (i < n)
                        {
                            if (c[i] == '+' || c[i] == '-')
                            {
                                start = c[i];
                                start_index = buff_index;
                                buff[buff_index] = c[i];
                                i++;
                                buff_index++;
                            }
                            else
                            {
                                i--;
                                printf("< Constant : ");
                                for (int k = 0; k < buff_index - 1; k++)
                                    printf("%c", buff[k]);
                                printf(" > recognized\n\n");
                                state = 0;
                                break;
                            }
                        }
                        else // ends with E
                        {
                            i -= 1;

                            printf("< Constant : ");
                            for (int k = 0; k < buff_index - 1; k++)
                                printf("%c", buff[k]);
                            printf(" > recognized\n\n");

                            state = 0;
                            break;
                        }
                    }
                    else // E repeats
                    {
                        i = (i - 2) - (buff_index - start_index);
                        if (buff_index - start_index > 1)
                        {
                            printf("< Constant : ");
                            for (int k = 0; k < buff_index; k++)
                                printf("%c", buff[k]);
                            printf(" > recognized\n\n");
                        }
                        else
                        {
                            printf("< Constant : ");
                            for (int k = 0; k < buff_index - 2; k++)
                                printf("%c", buff[k]);
                            printf(" > recognized\n\n");
                        }
                    }
                }
                else
                {

                    state = 0;
                    break;

                    printf("< Constant : ");
                    for (int k = 0; k < buff_index; k++)
                        printf("%c", buff[k]);
                    printf(" > recognized\n\n");
                    i--;
                    state = 0;
                }
}
else
{
                if (isdigit(start) > 0 || start == '.')

                {
                    printf("< Constant : ");
                    for (int k = 0; k < buff_index; k++)
                        printf("%c", buff[k]);
                    printf(" > recognized\n\n");
                }
                else if (start == '+' || start == '-')
                {
                    if ((buff_index - start_index) > 1)
                    {
                        printf("< Constant : ");
                        for (int k = 0; k < buff_index; k++)
                            printf("%c", buff[k]);
                        printf(" > recognized\n\n");
                    }
                    else
                    {
                        i -= 2;
                        printf("< Constant : ");
                        for (int k = 0; k < buff_index - 2; k++)
                            printf("%c", buff[k]);
                        printf(" > recognized\n\n");
                    }
                }

                state = 0;
}
break;

case 8:
if(i<n)
{
                c2 = c[i];
                i++;

                if (c2 == '"')
                {
                    if (buff_index == 1)
                    {
                        printf("< string : empty string > recognized\n\n");
                        state = 0;
                        break;
                    }
                    else
                    {
                        if (buff[buff_index - 1] != '\\')

                        {
                            printf("< string : ");
                            for (int k = 1; k < buff_index; k++)
                                printf("%c", buff[k]);
                            printf(" > recognized\n\n");
                            state = 0;
                            break;
                        }
                        else
                        {
                            buff[buff_index] = c2;
                            buff_index++;
                        }
                    }
                }
                else
                {
                }
}
 




buff[buff_index]=c2; buff_index++;
 
else//abrupt end to string
{
                i -= (buff_index - 1);
                state = 0;
}
break;

case 9:
if (i<n)
{
                c2 = c[i];
                i++;

                if (isalpha(c2) > 0 && islower(c2) > 0)
                {

                    extra_count = 0;
                    for (int x = 0; x < key_count; x++)
                    {
                        if (key_store[x][0] != -1 && key_store[x][1] != -1)
                        {
                            if (buff_index < key_store[x][1] && c2 == keys[key_store[x][0]][buff_index])

                            {
                                extra_count++;
                            }
                            else
                            {
                                key_store[x][0] = -1;
                                key_store[x][1] = -1;
                            }
                        }
                    }

                    buff[buff_index++] = c2;

                    if (extra_count == 0)
                    {
                        state = 10;
                    }
                }
                else
                {

                    i--;
                    if (extra_count == 1)
                    {

                        for (int f = 0; f < key_count; f++)
                        {
                            if (key_store[f][0] != -1 && key_store[f][1] != -1)
                            {
                                if (buff_index == key_store[f][1])
                                {
                                    printf("< Keyword : ");
                                    for (int k = 0; k < buff_index; k++)
                                        printf("%c", buff[k]);
                                    printf(" > recognized\n\n");
                                    state = 0;
                                    break;
                                }
                            }
                        }
                        if (state == 9)
                            state = 10;
                        break;
                    }
                    else

                    {
                        if (isalpha(c[i]) > 0 || isdigit(c[i]) > 0 || c[i] == '_')
                            state = 10;
                        else
                            state = 0;
                    }
                }

}
else
{
                if (extra_count == 1)
                {
                }
                else
                {
                }

                printf("< Keyword : ");
                for (int k = 0; k < buff_index; k++)
                    printf("%c", buff[k]);
                printf(" > recognized\n\n");

                printf("< Id : ");
                for (int k = 0; k < buff_index; k++)
                    printf("%c", buff[k]);
                printf(" > recognized\n\n");

                state = 0;
}

break;

case 10:
if(i<n)
{
                c2 = c[i];
                i++;

                if (c2 == '_' || isalpha(c2) > 0 || isdigit(c2) > 0)
                {
                }
                else
                {

                    buff[buff_index++] = c2;

                    i--;
                    printf("< Id : ");

                    for (int k = 0; k < buff_index; k++)
                        printf("%c", buff[k]);
                    printf(" > recognized\n\n");
                    state = 0;
                }
}
else
{
                printf("< Id : ");
                for (int k = 0; k < buff_index; k++)
                    printf("%c", buff[k]);
                printf(" > recognized\n\n");
                state = 0;
}

break;
        }
    }
}

int main()
{
    FILE *fptr;
    char ch;

    fptr = fopen("code.txt", "r");

    if (fptr == NULL)
    {
        printf("File is not available \n");
    }
    else
    {
        state = 0;
        while (fgets(code, sizeof(code), fptr))
        {
printf("\n%s\n", code);
lexical_analyzer(code, strlen(code));
        }
    }
