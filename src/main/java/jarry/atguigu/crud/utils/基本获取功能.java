package jarry.atguigu.crud.utils;

import org.springframework.util.SocketUtils;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取功能：
 *  public String getAbsolutePath()：获取绝对路径
 public String getPath()        ：获取相对路径
 public String getName()    ： 获取名称
 public long length()    ：获取长度，字节数（用于判断文件的大小）
 public long lastModified()  ： 获取最后一次的修改时间，毫秒值（MD5值）
 */
public class 基本获取功能 {
    public static void main(String[] args) {
        // 创建文件对象
        File file = new File("a.txt");
        System.out.println("getAbsolutePath:" + file.getAbsolutePath());
        System.out.println("getPath:" + file.getPath());
        System.out.println("getName:" + file.getName());
        System.out.println("length:" + file.length());
        System.out.println("lastModified:" + file.lastModified());
        Date d = new Date(1516948026828L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newTimeFormat = sdf.format(d);
        System.out.println(d);
        System.out.println(newTimeFormat);



    }



}
