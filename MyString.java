public class MyString implements CharSequence,Comparable<CharSequence> {
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }

  public int length() {
    return data.length;
  }

  public char charAt(int i) {
    return data[i];
  }

  public char[] subSequence(int start, int end) {
    char[] ans = new char[end - start];
    int counter = start;
    for (int i = start; i < end; i++){
      ans[i - start] = data[i];
    }
    return ans;
  }

  public String toString(){
    String ans = "";
    for (int i = 0; i < data.length(); i++) {
      ans += data[i];
    }
    return ans;
  }

  public void main(String[] args) {
    CharSequence s = new MyString("Hello");
    System.out.print (s + " "  + t + " " + u);
  }
}
