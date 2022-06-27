package com.shusheng.utils;

import cn.hutool.core.util.StrUtil;
import com.shusheng.config.BaseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘闯
 * @date 2022/5/18
 */
public class PythonUtils {

    /**
     * 调用python程序
     * @param file 程序的绝对路径
     * @param params 参数
     * @return 返回的结果新
     */
    public static List<String> runPython(String file, String... params){
        String[] str = new String[params.length+2];
        str[0] = "python"; str[1] = file;
        System.arraycopy(params, 0, str, 2, params.length);

        List<String> result = new ArrayList<>();
        Process proc;
        try {
            proc = Runtime.getRuntime().exec(str);// 执行py文件

            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (StrUtil.isNotBlank(line)){
                    result.add(line);
                }
            }
            in.close();
            proc.waitFor();

            return result;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new BaseException("执行python异常！");
        }
    }
}
