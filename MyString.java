public class MyString implements CharSequence,Comparable<CharSequence> {
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }
  
  public MyString(char[] s){
    data = s;
  }
  
  public int compareTo(CharSequence input) {
	  if (input == null) {
		  throw new NullPointerException();
	  }
	  if (input.length() < this.length()) {
		  return this.length() - input.length();
	  }
	  for (int i = 0; i < this.length(); i++) {
		  if (this.charAt(i) != input.charAt(i)) {
			  return this.charAt(i) - input.charAt(i);
		  }
	  }
	  return 0;
  }

  public int length() {
    return data.length;
  }

  public char charAt(int i) {
	if (i < 0 || i >= data.length) {
			throw new IndexOutOfBoundsException();
	}
	return data[i];
  }

  public CharSequence subSequence(int start, int end) {
	if (start < 0 || end <= 0 || end < start || start > this.length() || end > this.length()) {
		throw new IndexOutOfBoundsException();
	}
    char[] ans = new char[end - start];
    for (int i = start; i < end; i++){
      ans[i - start] = data[i];
    }
	CharSequence an = new MyString(ans);
    return an;
  }

  public String toString(){
    String ans = "";
    for (int i = 0; i < data.length; i++) {
      ans += data[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    // sole constructor test
    MyString msg = new MyString("droid");
    System.out.println("MyString msg = new MyString(\"charlotte\")");

    // toString()
    System.out.println("msg: " + msg);                                                  // "droid"

    // length()
    System.out.println("msg.length(): " + msg.length());                                // 5

    System.out.println();

    // charAt() exception catch
    System.out.println("msg.charAt(-1):");
    try {
      System.out.println(msg.charAt(-1));                             // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    System.out.println("msg.charAt(15):");
    try {
      System.out.println(msg.charAt(15));                             // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // charAt()
    System.out.println("msg.charAt(0): " + msg.charAt(0));                              // "d"
    System.out.println("msg.charAt(3): " + msg.charAt(3));                              // "i"

    System.out.println();

    // subSequence() exception catch
    // start < 0
    System.out.println("msg.subSequence(-1,4):");
    try {
      System.out.println(msg.subSequence(-1,4));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // end < 0
    System.out.println("msg.subSequence(1,-4):");
    try {
      System.out.println(msg.subSequence(1,-4));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // start > end
    System.out.println("msg.subSequence(11,4):");
    try {
      System.out.println(msg.subSequence(11,4));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // end > length()
    System.out.println("msg.subSequence(1,14):");
    try {
      System.out.println(msg.subSequence(1,14));                      // IndexOutOfBoundsException
    } catch(IndexOutOfBoundsException e) { e.printStackTrace(); }

    System.out.println();

    // subSequence()
    System.out.println("msg.subSequence(0,3): " + msg.subSequence(0,3));                // "dro"
    System.out.println("msg.subSequence(2,5): " + msg.subSequence(2,5));                // "oid"

    System.out.println();

    // compareTo()
    System.out.println("msg.compareTo(\"droid\"): " + msg.compareTo("droid"));          // 0
    System.out.println("msg.compareTo(\"bat\"): " + msg.compareTo("bat"));              // 1
    System.out.println("msg.compareTo(\"seventh\"): " + msg.compareTo("seventh"));      // -1
    System.out.println("msg.compareTo(\"drank\"): " + msg.compareTo("drank"));          // 1
    System.out.println("msg.compareTo(\"drunk\"): " + msg.compareTo("drunk"));          // -1

  }
}
