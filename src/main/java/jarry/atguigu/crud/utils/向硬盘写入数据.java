package jarry.atguigu.crud.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 向硬盘写入数据 {


    public static void main(String[] args) throws IOException {

        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("js.txt");
        // 创建字节输出流对象做了几件事情
        //1，调用系统功能去创建文件
        //2,创建fos对象
        //3，把fos对象指向这个文件
//        写数据
        fos.write("hello world ".getBytes());
        fos.write("hello java".getBytes());
        fos.close();




    }




}
