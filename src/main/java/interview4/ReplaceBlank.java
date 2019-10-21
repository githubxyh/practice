package interview4;

/**
 * 实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入："We are happy"，则输出"We%20are%20happy"
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        String str = "We are happy";
        char[] strArr = str.toCharArray();

        int blankCount = 0;
        for(int i=0; i < strArr.length; i++){
            System.out.println(strArr[i]);
            //注意这里不能写成" ".equals(strArr[i])。
            //因为String的源码中equals方法比较时：如果传入值不是String类(instanceof String),直接返回false
            //char类型不是String类型
            if(' ' == strArr[i]){
                blankCount ++;
            }
        }

        if(blankCount > 0){
            int newLength = strArr.length + blankCount * 3;
            char[] newStrArr = new char[newLength];
            int position = newStrArr.length - 1;
            for(int i=strArr.length-1; i >= 0; i--){
                if(' ' == strArr[i]){
                    newStrArr[position] = '0';
                    newStrArr[position-1] = '2';
                    newStrArr[position-2] = '%';
                    position = position - 3;
                }else{
                    newStrArr[position] = strArr[i];
                    position = position - 1;
                }
            }
            System.out.println(newStrArr);
        }
    }
}
