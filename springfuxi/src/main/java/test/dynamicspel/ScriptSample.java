package test.dynamicspel;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptSample {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager(); //脚本引擎管理器
        ScriptEngine engine = manager.getEngineByName("JavaScript"); //创建脚本引擎

        String script = "function sum(a,b) {return a+b; }"; //定义脚本函数

        engine.eval(script);  //实现函数

        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("sum",100,99);

        System.out.println(result);
    }
}
