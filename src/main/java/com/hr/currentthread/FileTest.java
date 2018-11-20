package com.hr.currentthread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huran
 * @Title: FileTest
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/2917:45
 */
public class FileTest {
    public static void main(String[] args) {
        List<String> list=  getAllFile("D:\\");
        list.forEach(System.out::println);
    }
    public static List<String> getAllFile(String path){
        List<String>allFile=new ArrayList<>();
        File f=new File(path);
        File[]files=f.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                String directoryPath =file.getPath();
                getAllFile(directoryPath);
            }else {
              String filePath=  file.getPath();
              if(filePath.endsWith(".md")){
                  continue;
              }
              allFile.add(filePath);

            }
        }
        return allFile;
    }
}
