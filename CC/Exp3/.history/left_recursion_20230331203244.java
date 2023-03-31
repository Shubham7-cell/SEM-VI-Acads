import java.util.ArrayList;

//for production give it in aA | Aa' format that is between productions ' | ' should be there with gap
// else will give wrong answer
class left_recursion{
public static void main(String[] args) {
ArrayList<String> ar=new ArrayList<>();
ar.add(0, "S->Sa | aS | bS | Sbb");
ar.add("A->aA | All");
remove_direct(ar);
}

public static void remove_direct(ArrayList<String> production){ 
ArrayList<String> fin=new ArrayList<>();
for(String s: production){
ArrayList<String> beta=new ArrayList<>();
ArrayList<String> recursion=new ArrayList<>();
String[] array=s.split("->",0); // this splits the first character (LHS) and RHS 
String first=array[0]; //Leading charcter
String S=array[0]+"'";// Making prime of that for leading character
String[] right=array[1].split(" | ",0);//splitting the production 
for(String re: right){
if(re.equals("|")) continue; //ignore this sign
if(first.charAt(0)==re.charAt(0)){ //this checks is there is left recursion present
recursion.add(re); //adds it to recursion arraylist
}else{
beta.add(re); //adds it to beta as ther's no left recursion
}
}
String betaProd=""; //this willl store all the beta productions in a single string
for(String x: beta){
betaProd+=" | "+x+S;//appending the prime of leading character
}
fin.add(array[0]+" ->"+betaProd.substring(3));// first three characters are: ' | ' hence removing that
String prod="";
for(String x: recursion){
int counter=-1;
while(array[0].charAt(0)==x.charAt(++counter));//this counter number of left recursions
int counterCopy=counter;
String f="";
while(counter!=0) {
f+=S;
counter--;
}
prod+=x.substring(counterCopy)+f;
prod+=" | ";
}
prod+="epsilon"; //adding epsilon to prime production
fin.add(S+"->"+prod);
System.out.println("Initial production: ");
System.out.println(s);
System.out.println("Final");
for(String x: fin){
System.out.println(x);
} 
}
}

static void printArrayList(ArrayList<String> ar,String s){
System.out.println(s);
System.out.println("Values");
for(String ss: ar){
System.out.println(ss);
}
}
}
