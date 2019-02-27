package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 10:54
 * @Version 1.0
 * @Function:
 *      牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 *      写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 *      但却读不懂它的意思。例如，“student. a am I”。
 *      后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 *
 */
public class 翻转单词顺序列 {

    //无额外复杂度的解法
    public static String ReverseSentence1(String str){
        if(str == null || str.length() == 0 || str.trim().equals("")){
            return str;
        }

        //整体交换，再局部交换
        char[] ch = str.toCharArray();
        int a = 0;
        int b = ch.length-1;
        while(a <= b){
            exch(ch, a++, b--);
        }

        //局部交换
        for(int i = 0; i < ch.length; i++){
            if(i+1 < ch.length && ch[i+1] != ' '){

            }
        }

        return "";
    }
    private static String exch(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    //额外的空间复杂度O(N)
    public static String ReverseSentence(String str) {
        if(str == null || str.length() == 0 || str.trim().equals("")){
            return str;
        }

        String[] strArr = str.split("\\s");
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length - 1; i >= 0; i--){
            sb.append(strArr[i]+ " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args){
        String str = " ";
        System.out.println(ReverseSentence(str));
    }

}
