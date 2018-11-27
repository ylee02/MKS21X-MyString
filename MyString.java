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
	  if (input.length() != this.length()) {
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
	if (i <= 0 || i >= data.length) {
			throw new IndexOutOfBoundsException();
	}
	return data[i];
  }

  public CharSequence subSequence(int start, int end) {
	if (start <= 0 || end <= 0 || end <= start || start > this.length() || end > this.length()) {
		throw new IndexOutOfBoundsException();
	}
    char[] ans = new char[end - start];
    for (int i = start; i < end; i++){javac 
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

  public void main(String[] args) {
    CharSequence s = new MyString("Hello");
    System.out.print (s);
  }
}
