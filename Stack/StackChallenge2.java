import java.util.LinkedList;
class Stack {
	public int top = -1;
	public char [] stack;
	public int size;
	public Stack(String str) {
		this.stack = new char[str.length()];
	}

	public void push(char S) {
		stack[++top] = S;
		size++;
	}

	public char pop() {
		if (this.top == -1){
			// System.out.println("UnderFlow");
			return 'X';
		}
		return stack[top--];
	}

	public char peek() {
		return stack[top];
	}
	public void printStack() {
		for(int i=stack.length-1; i>=0; i--){
			System.out.print(stack[i]);
			System.out.println();
		}
	}
}

class StackChallenge2 {
	public static void main (String args[]) {
		String str = "nitin?";
		Stack st = new Stack(str);
		int i = 0;
		while (i != str.length()) {
			if (!(str.charAt(i) == '!' | str.charAt(i) == '?' | str.charAt(i) == ' '))
				st.push(str.charAt(i++));
			else
				i++;
		}

		// print stack
		// st.printStack();

		// print top
		// System.out.println(st.top);
		// Check if palindrome
		int flag = 0;
		i = 0;
		while (i != str.length()) {
			if (!(str.charAt(i) == '!' | str.charAt(i) == '?' | str.charAt(i) == ' '))
			{
			char S = st.pop();
			if (S == 'X')
				break;
			// Checking each character
			if (str.charAt(i) == S) {
				flag++;
				i++;

				}
			}
			else
				i++;

		}
		// flag 
		// System.out.println(flag);
		// System.out.println(i);
		// System.out.println(st.size);
		if (flag == (st.size)){
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");

		}
	}
} 