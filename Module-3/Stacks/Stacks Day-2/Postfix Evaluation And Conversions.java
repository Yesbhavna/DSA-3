import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluation(exp);
  }
}

class Solution{
    public void evaluation(String exp){
        System.out.println(evaluatePostfix(exp));
		System.out.println(postfixToInfix(exp));
		System.out.println(postfixToPrefix(exp));
    }
	public int evaluatePostfix(String postfix) {
		int n = postfix.length();
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < n; i++) {
			char ch = postfix.charAt(i);
			if(Character.isDigit(ch)) {
				st.push(ch - '0');
			}else {
				int op1 = st.pop();//a
				int op2 = st.pop();//b
				if(ch == '+') {
					st.push(op2 + op1);
				}else if(ch == '-') {
					st.push(op2 - op1);
				}else if(ch == '*') {
					st.push(op2 * op1);
				}else {
					st.push(op2 / op1);
				}
			}
		}
		return st.peek();
	}
	public String postfixToInfix(String postfix) {
		int n = postfix.length();
		Stack<String> st = new Stack<>();
		for(int i = 0; i < n; i++) {
			char ch = postfix.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				String op1 = st.pop();//a
				String op2 = st.pop();//b
				String res = "(" + op2 + ch + op1 + ")";
				st.push(res);
			}else {//operand
				st.push(ch + "");
			}
		}
		return st.peek();
	}
	public String postfixToPrefix(String postfix) {
		int n = postfix.length();
		Stack<String> st = new Stack<>();
		for(int i = 0; i < n; i++) {
			char ch = postfix.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				String op1 = st.pop();//a
				String op2 = st.pop();//b
				String res = ch + op2 + op1;//ch exp exp
				st.push(res);
			}else {//operand
				st.push(ch + "");
			}
		}
		return st.peek();
	}
}                         