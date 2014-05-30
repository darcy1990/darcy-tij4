package pangguo;


public class Test 
{ 
   public static  int getNumber(String s1,String s2)
    {
        int time = 0;
        for(int i = s2.length() - 1; i >= 0 ; i--) {
            char c = s2.charAt(i);
            int index = s1.indexOf(c);
            time += s1.length() - 1 - index;
            // move the chars after the index to the front
            StringBuffer sb = new StringBuffer(s1.substring(index + 1, s1.length()));
            sb.append(s1.substring(0, index));
            s1 = sb.toString();
        }
        return time;
    }
    //start 提示：自动阅卷起始唯一标识，请勿删除或增加。 
    public static void main(String args[]) 
    { 
       System.out.println(getNumber("Test","Test"));
    } 
    //end //提示：自动阅卷结束唯一标识，请勿删除或增加。
}