package com.shusheng.demo;

import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 刘闯
 * @date 2021/10/14.
 */
public class PythonDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
//        startPythonTwo();
        startPythonThree();
    }


    // 直接执行python代码(获取print的值)
    private static void startPythonOne() throws IOException, InterruptedException{
        String str = "python C:\\Users\\admin\\Desktop\\main.py 1 2";
        Process p = Runtime.getRuntime().exec(str);

        BufferedReader br = new BufferedReader(new
                InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        p.waitFor();
    }

    // 直接执行python代码方法  获取方法的返回值
    private static void startPythonTwo(){
        PythonInterpreter interpreter = new PythonInterpreter();
        // 加载文件
        interpreter.execfile("C:\\Users\\admin\\Desktop\\main.py");

        // 调用方法
        PyFunction func = interpreter.get("power", PyFunction.class);

        PyObject pyObject = func.__call__(new PyObject[]{
                new PyInteger(1),
                new PyInteger(2)
        });

        Integer integer = (Integer) pyObject.__tojava__(Integer.class);

        System.out.println("integer = " + integer);
    }

    // 直接执行python代码方法  获取方法的返回值
    private static void startPythonThree(){
        PythonInterpreter interpreter = new PythonInterpreter();
        // 加载文件
        interpreter.execfile("C:\\Users\\admin\\Desktop\\oa_restful\\src\\oa_service.py");
        // 实例化类名称
        String str = "str";
        // 将要实例化的类
        String instanceClass = "Person";

        // 实例 Python对象
        interpreter.exec("import requests");
        interpreter.exec(str + "=" + instanceClass + "()");

        // 调用实例
        PyObject func = interpreter.get(str);
        // 执行方法
        PyObject power = func.invoke("verify_mobile", new PyObject[]{
                Py.newInteger(1),
                Py.newInteger(2)
        });
        // 转换值
        int i = Py.py2int(power);

        System.out.println("i = " + i);
    }
}
