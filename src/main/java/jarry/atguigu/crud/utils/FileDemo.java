package jarry.atguigu.crud.utils;


import org.springframework.objenesis.instantiator.sun.MagicInstantiator;
import org.springframework.util.SocketUtils;

import java.io.File;
import java.io.IOException;

/**
 * 创建功能：
 * public boolean createNewFile() ： 创建文件,如果存在这样的文件，就不创建了
 public boolean mkdir() ：创建文件夹，如果存在这样的文件夹，就不创建了
 public boolean mkdirs() : 创建文件夹，如果父文件夹不存在，会帮你创建出来，（用来创建多级文件夹）
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 需求：我要在E盘下创建一个文件夹demo
        File file = new File("e:\\demo");
        System.out.println("mkdir:" + file.mkdir());
        File file1 = new File("e:\\demo\\a.txt");
        System.out.println("createNewFile :" + file1.createNewFile());

        File file4 = new File("e:\\aaa\\bbb\\ccc\\ddd");
        System.out.println("mkdirs:"+ file4.mkdirs());
    }

}
