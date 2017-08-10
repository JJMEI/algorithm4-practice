package test.dynamicspel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelHello {

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //SpEL表达式解析器
        ExpressionParser parser = new SpelExpressionParser();
        //parseExpression()方法进行解析
        Expression expression = parser.parseExpression("'Hello' + ' world!'");

        //从解析结果中获取值
        String message = (String) expression.getValue();

        System.out.println(message);
    }
}
