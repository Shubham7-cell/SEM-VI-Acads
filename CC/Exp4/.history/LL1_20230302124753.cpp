#include <bits/stdc++.h>

using namespace std;
bool ll1(string input)
{
    stack<char> st;
    st.push('$');
    st.push('S');
    int n = input.length();
    int i = 0;
    while (i < n)
    {
        if (st.top() == input[i])
        {
            st.pop();
            i++;
        }
        else if (st.top() == 'S' && input[i] == '(')
        {
            st.pop();
            st.push('S');
            st.push(')');
            st.push('S');
            st.push('(');
        }
        else if (st.top() == 'S' && (input[i] == ')' || input[i] == '$'))
        {
            st.pop();
        }
        else
        {
            return false;
        }
    }
    return true;
}
int main()
{
    string input = "((())$";
    bool ans = ll1(input);
    if (ans)
        cout << "String Accepted\n";
    else
        cout << "string Rejected\n";
    return 0;
}