import java.util.LinkedList;
class Stack {
	private int top = -1;
	private char [] stack;
	
	public Stack(String str) {
		this.stack = new char[str.length()];
	}

	public void push(char S) {
		stack[++top] = S;
	}

	public char pop() {
		if (this.top == -1){
			System.out.println("UnderFlow");
			return 'X';
		}
		return stack[top--];
	}

	public char peek() {
		return stack[top];
	}
	public void printStack() {
		for(int i=0; i<stack.length; i++){
			System.out.print(stack[i]);
		}
	}
}

class StackChallenge {
	public static void main (String args[]) {
		String str = "nitin";
		Stack st = new Stack(str);
		int i = 0;
		while (i != str.length()) {
			
			st.push(str.charAt(i));
			i++;
		}

		// Check if palindrome
		int flag = 0;
		i = 0;
		while (i != str.length()) {
			char S = st.pop();
			if (str.charAt(i) == S) {
				flag++;
			}
			i++;

		}

		if (flag == i){
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");

		}
	}
} 