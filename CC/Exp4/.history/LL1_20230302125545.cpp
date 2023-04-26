#include <bits/stdc++.h>

using namespace std;
bool ll1(string RegX_input)
{
    stack<char> st;
    st.push('$');
    st.push('S');
    int n = RegX_input.length();
    int i = 0;
    while (i < n)
    {
        if (st.top() == RegX_input[i])
        {
            st.pop();
            i++;
        }
        else if (st.top() == 'S' && RegX_input[i] == '(')
        {
            st.pop();
            st.push('S');
            st.push(')');
            st.push('S');
            st.push('(');
        }
        else if (st.top() == 'S' && (RegX_input[i] == ')' || RegX_input[i] == '$'))
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
    string RegX_input = "(())$";
    bool result = ll1(RegX_input);
    if (result)
        cout << "Your String is accepted!\n";
    else
        cout << "Your String isn't accepted!\n";
    return 0;
}