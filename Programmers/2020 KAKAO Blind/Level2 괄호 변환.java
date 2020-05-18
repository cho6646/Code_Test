class Solution {
    public String solution(String p) {
        int len = p.length();

        if(isCorrentOrder(p)) return p;
        if(len == 2) return "()";

        int a = whenUnbreakable(p);
        String u = p.substring(0, a);
        String v = solution(p.substring(a));
        if(isCorrentOrder(u))
        {
            return u + v;
        }
        return "("+v+")"+deleteAndReverse(u);
    }

    public boolean isCorrentOrder(String p)
    {
        if(p.equals("")) return true;
        int left = 0;
        int right = 0;
        for(int i=0; i<p.length(); i++)
        {
            if(p.charAt(i) == '(') left += 1;
            else right += 1;
            if(right > left) return false;
            if(left == right)
            {
                left = 0;
                right = 0;
            }
        }
        if(left == right) return true;
        return false;
    }

    public int whenUnbreakable(String s)
    {
        int left = 0;
        int right = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(') left += 1;
            else right += 1;
            if(left >0 && right >0 && left == right) return i+1;
        }
        return s.length();
    }

    public String deleteAndReverse(String s)
    {
        String result = "";
        for(int i=1; i<s.length()-1; i++)
        {
            if(s.charAt(i) == '(') result += ")";
            else result += "(";
        }
        return result;
    }
}