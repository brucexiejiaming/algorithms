package class99;

public class decomparessString {
    
    // a3c2de3f4ghi2
    
    public String decompress(String input) {
        // Write your solution here.
        if (input.length() <= 1) {
          return input;
        }
        
        StringBuilder sb = new StringBuilder();
        char[] inputs = input.toCharArray();
        char preChar = ' ';
        int count = 0;
        
        for (int i = 0; i < inputs.length; i++) {
          if ('a' <= inputs[i] && inputs[i] <= 'z') {
            append(sb, preChar, count);
            preChar = inputs[i];
            count = 1;
          } else if (i != 0 && '0' <= inputs[i - 1] && inputs[i - 1] <= '9'){ // previous is also digit
              count = count * 10 + (int)(inputs[i] - '0');
          } else {
              count = (int)(inputs[i] - '0');
          }
        }
        append(sb, preChar, count);
        return sb.toString();
      }
    
    public void append(StringBuilder sb, char preChar, int count) {
        while (count > 0) {
            sb.append(preChar);
            count--;
        }
    }
}
