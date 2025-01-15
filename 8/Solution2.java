class Solution {
    public int myAtoi(String s) {
        Automation auto = new Automation();
        for(int i = 0; i < s.length(); i++) {
            auto.get(s.charAt(i));
        }
        return (int) auto.ans;
    }
}

class Automation {
    private static final Map<String, String[]> auto = new HashMap<>() {{
        put("start", new String[] {"start", "signed", "number", "end"});
        put("signed", new String[] {"end", "end", "number", "end"});
        put("number", new String[] {"end", "end", "number", "end"});
        put("end", new String[] {"end", "end", "end", "end"});
    }};
    private boolean signed = true;
    public  long ans = 0;
    private String state = "start";

    private int get_col(char c) {
        if(c == ' ') {
            return 0;
        }
        if(c == '+' || c == '-') {
            return 1;
        }
        if(Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
    public void get(char c) {
        state = auto.get(state)[get_col(c)];
        if(state.equals("signed") && c == '-') {
            signed = false;
        }
        if(state.equals("number")) {
            if (signed) {
                ans = ans * 10 + c - '0';
                if (ans > Integer.MAX_VALUE) {
                    ans = Integer.MAX_VALUE;
                }
            } else {
                ans = ans * 10 - c + '0';
                if (ans < Integer.MIN_VALUE) {
                    ans = Integer.MIN_VALUE;
                }
            }
        }
    }
}