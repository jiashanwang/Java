package jarry.atguigu.crud.utils;

import org.springframework.util.SocketUtils;
import sun.corba.OutputStreamFactory;

import java.io.File;
import java.io.IOException;

/**
 * 重命名：public boolean renameTo(File dest)
 *  注意：如果路径名相同，就是改名
 *      如果路径名不相同，就是改名并剪切
 *
 * 路径以盘符开始：绝对路径
 *  路径不以盘符开始：相对路径
 */
public class rename {
    public static void main(String[] args) throws IOException {
        // 创建一个文件对象
//        File file = new File("林青霞.jpg");
//        file.createNewFile();
//        // 需求：我要修改这个文件的名称为东方不败
//        File newFile = new File("东方不败.jpg");
//        System.out.println("renameTo:" + file.renameTo(newFile));
        File file5 = new File("东方不败.jpg");
        File file6 = new File("e:\\岳不群.jpg");
        System.out.println("renameTo:" +file5.renameTo(file6));


    }

}
