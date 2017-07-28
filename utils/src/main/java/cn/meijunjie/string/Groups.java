package cn.meijunjie.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 组是用括号划分的正则表达式，0 表是整个组的编号，然后由外及里 组的编号一次增加
 */

public class Groups {

    public  static  final String POEM = "Twas brilling, and this slithy toves\n" +
                                        "Did gyre and gimble in the wabe.\n";

    public static void main(String[] args)
    {
        Matcher  matcher = Pattern.compile("(?m)(\\S+)\\s+((\\S++)\\s+(\\S+))$").matcher(POEM);
        Matcher matcher1 = Pattern.compile("[^[A-Z]]\\S+").matcher(POEM);

//        while (matcher.find())
//        {
//            for(int i = 0; i <= matcher.groupCount(); i++)
//            {
//                System.out.println(matcher.group(i));
//            }
//        }

        while (matcher1.find())
        {
            System.out.println(matcher1.group());
        }
    }
}
