package jarry.atguigu.crud.utils;

import com.mchange.v1.io.OutputStreamUtils;

import java.io.File;

/**
 * 高级获取功能
 * public String[] list()  ： 获取指定目录下的所有文件或者文件夹的名称数据
 public File[] listFiles()  :获取指定目录下的所有文件或者文件夹的File 数组
 */
public class 高级获取功能 {
    public static void main(String[] args) {
        File file = new File("F:\\");
//        public String[] list()  ： 获取指定目录下的所有文件或者文件夹的名称数据

        String[] newStr = file.list();
//        System.out.println(newStr);
        for (String s:newStr){
            System.out.println(s);
        }

        System.out.println("============================");
        File[] fileArray = file.listFiles();
        for(File f : fileArray){
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());

        }

    }



}
