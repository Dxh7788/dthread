package com.dthread.concurrenth;

import java.io.*;

/**
 * 拆分大文件
 * @author dongxiaohong
 * @date 2019/1/23 14:58
 */
public class SpiltMultiFile {

    private static Integer ARRAY_SIZE = 10;
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/dongxiaohong/seca/sord.txt");
        Reader fr = new FileReader(file);
        LineNumberReader lnr = new LineNumberReader(fr);
        int totalLine=0;
        while (lnr.readLine()!=null){
            totalLine++;
        }
        System.out.println(totalLine);
        lnr.close();
        fr.close();
        //根据行数切分为10个文件,首先找到10个行号保存到数组
        Integer[] lines = new Integer[ARRAY_SIZE];
        int step = (int)Math.ceil(totalLine/ARRAY_SIZE)+1;
        for (int i=0;i<ARRAY_SIZE;i++){
            lines[i] = i*step;
            System.out.println(lines[i]);
        }
        String[] names = file.getName().split("[.]");
        String baseFileName = names[0];
        Reader ffr = new FileReader(file);
        LineNumberReader llnr = new LineNumberReader(ffr);
        for (int i=0;i<ARRAY_SIZE;i++){
            String fileName = baseFileName+"_"+i+".txt";
            int startLine = lines[i];
            int endLine = 0;
            if (i+1>=ARRAY_SIZE){
                endLine = totalLine;
            }else {
                endLine = lines[i+1];
            }
            /**
             * 读取[startLine,endLine]到新的文件中
            * */
            int offsetLine = startLine;
            llnr.setLineNumber(startLine);
            String text;

            Writer fw =new FileWriter(fileName);
            while ((text=llnr.readLine())!=null){
                offsetLine++;
                fw.write(text);
                fw.write("\n");
                if (offsetLine==endLine){
                    /**读完改行后关闭流*/
                    fw.close();
                    break;
                }
                System.out.println(text);
            }
        }
        llnr.close();
        fr.close();
    }
}
