package com.shusheng.future.htmltopdf;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author 刘闯
 * @date 2022/5/20
 */
public class HtmlToPdf {

    //    wkhtmltopdf在系统中的路径
    private static final String toPdfTool = "F:\\Development\\wkhtmltopdf\\bin\\wkhtmltopdf.exe";

    /**
     * html转pdf
     *
     * @param srcPath  html路径，可以是硬盘上的路径，也可以是网络路径
     * @param destPath pdf保存路径
     */
    public static void convert(String srcPath, String destPath, String toPdfTool){
        // 如果父目录不存在 则创建父目录
        FileUtil.mkdir(FileUtil.file(destPath).getParentFile());

        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append(" --header-line");//页眉下面的线
        cmd.append(" --margin-top 3cm ");//设置页面上边距 (default 10mm)
        // cmd.append(" --header-html file:///"+WebUtil.getServletContext().getRealPath("")+FileUtil.convertSystemFilePath("\\style\\pdf\\head.html"));// (添加一个HTML页眉,后面是网址)
        cmd.append(" --header-spacing 5 ");// (设置页眉和内容的距离,默认0)
        //cmd.append(" --footer-center (设置在中心位置的页脚内容)");//设置在中心位置的页脚内容
        //cmd.append(" --footer-html file:///"+WebUtil.getServletContext().getRealPath("")+FileUtil.convertSystemFilePath("\\style\\pdf\\foter.html"));// (添加一个HTML页脚,后面是网址)
        cmd.append(" --footer-line");//* 显示一条线在页脚内容上)
        cmd.append(" --footer-spacing 5 ");// (设置页脚和内容的距离)
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);
        try{
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream(), StandardCharsets.UTF_8));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(proc.getErrorStream(), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line); //输出内容
            }
            String line1 = null;
            while ((line1 = br1.readLine()) != null) {
                System.out.println(line1); //输出内容
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        String sourcePath = "http://192.168.101.15/energy_loss/#/login";

        HtmlToPdf.convert(sourcePath, "G:\\testpdf.pdf",toPdfTool);

        System.out.println("成功！！！");
    }
}