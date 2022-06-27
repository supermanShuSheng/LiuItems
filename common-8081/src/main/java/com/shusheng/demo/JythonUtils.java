package com.shusheng.demo;

import org.apache.poi.ss.formula.functions.T;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 刘闯
 * @date 2021/10/15.
 */
public class JythonUtils {
    /**
     * @Title: jythonInit
     * @Description: TODO(初始化jython)
     * @param: @return
     * @return: PythonInterpreter
     * @throws
     */
    public static PythonInterpreter jythonInit(){
        //初始化site 配置
        Properties props = new Properties();
        props.put("python.home", ""); //python Lib 或 jython Lib,根据系统中该文件目录路径
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);
        //创建PythonInterpreter 对象
        PythonInterpreter interp = new PythonInterpreter();
        return interp;
    }
    /**
     * @Title: loadPythonFile
     * @Description: TODO(加载python 源码文件，)
     * @param: @param interp
     * @param: @param filePath ，比如：F:\\jpython_jar\\jpythonTest\\pythonTest.py 或/testpython/test.py
     * @param: @return
     * @return: PythonInterpreter
     * @throws
     */
    public static PythonInterpreter loadPythonFile(PythonInterpreter interp, String filePath){
        interp.execfile(filePath);
        return interp;
    }
    /**
     * @Title: loadPythonFunc
     * @Description: TODO(加载python 源码文件中的某个方法)
     * @param: @param interp
     * @param: @param functionName
     * @param: @return
     * @return: PyFunction
     * @throws
     */
    public static PyFunction loadPythonFunc(PythonInterpreter interp, String functionName){
        //加载方法
        PyFunction func = (PyFunction) interp.get(functionName,PyFunction.class);
        return func;
    }
    /**
     * @Title: execFunc
     * @Description: TODO(执行无参方法,返回PyObject)
     * @param: @param func
     * @return: PyObject
     */
    public static PyObject execFunc(PyFunction func){
        PyObject pyobj = func.__call__();
        return pyobj;
    }
    /**
     * @Title: execFuncToString
     * @Description: TODO(执行无参方法,返回一个字符串)
     * @param: @param func
     * @param: @return
     * @return: String
     */
    public static String execFuncToString(PyFunction func){
        PyObject pyobj = execFunc(func);
        return (String) pyobj.__tojava__(String.class);
    }
    /**
     * @Title: execFuncToString
     * @Description: TODO(执行有参方法,返回一个字符串)
     * @param: @param func
     * @param: @param paramName ，参数名
     * @param: @return
     * @return: String
     */
    public static String execFuncToString2(PyFunction func, String paramName){
        PyObject pyobj = func.__call__(new PyString(paramName));
        return (String) pyobj.__tojava__(String.class);
    }
    /**
     * @Title: execFuncToInteger
     * @Description: TODO(执行无参方法,返回一个Integer)
     * @param: @param func
     * @param: @return
     * @return: Integer
     */
    public Integer execFuncToInteger(PyFunction func){
        PyObject pyobj = execFunc(func);
        return (Integer) pyobj.__tojava__(Integer.class);
    }
    /**
     * @Title: execFuncToList
     * @Description: TODO(执行无参方法,返回一个List)
     * @param: @param func
     * @param: @return
     * @return: List<T>
     */
    public List<T> execFuncToList(PyFunction func){
        PyObject pyobj = execFunc(func);
        return (List<T>) pyobj.__tojava__(List.class);
    }
    /**
     * @Title: execFuncToMap
     * @Description: TODO(执行无参方法,返回一个Map<String, Object>)
     * @param: @param func
     * @param: @return
     * @return: Map<String,Object>
     */
    public Map<String, Object> execFuncToMap(PyFunction func){
        PyObject pyobj = execFunc(func);
        return (Map<String, Object>) pyobj.__tojava__(Map.class);
    }
    public void execFuncToByParamsList(PyFunction func, List<T> paramsList){
    }
}
