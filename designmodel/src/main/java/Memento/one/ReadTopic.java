package Memento.one;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by des on 2020/3/14.
 */
public class ReadTopic {
    // 断点位置
    private long pos;
    // 文件对象
    RandomAccessFile in;

    public ReadTopic(){
        // 获取断点位置
        pos = getRestorePos();
        String path = this.getClass().getResource("/").getPath();
        path += "Memento/one/MyTopic.txt";
        try {
            in = new RandomAccessFile(path,"rw");
            // 根据断点位置，定位文件游标
            in.seek(pos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得断点位置方法
     * @return
     */
    private long getRestorePos(){
        long value = 0;
        String path = this.getClass().getResource("/").getPath();
        path += "Memento/one/Mymemo.txt";
        RandomAccessFile in2 = null;
        try {
            in2 = new RandomAccessFile(path,"rw");
            value = in2.readInt();
        } catch (Exception e) {
            pos = 0;
        }finally {
            try {
                in2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * 获得一道题目
     * @return
     */
    public String getNextTopic(){
        String s = null;
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 保存断点位置方法
     */
    private void saveRestorePos(){
        String path = this.getClass().getResource("/").getPath();
        path += "Memento/one/Mymemo.txt";
        try {
            RandomAccessFile out = new RandomAccessFile(path,"rw");
            pos = in.getFilePointer();
            out.writeInt((int)pos);
            out.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }

    }

    public void close(){
        saveRestorePos();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 简单测试
    public static void main(String[] args) {
        String strMark = "";
        Scanner sc = new Scanner(System.in);
        // 开始做题，已切换到断点位置
        ReadTopic obj = new ReadTopic();
        do {
            String strTopic = obj.getNextTopic();
            System.out.println(strTopic);
            sc.nextInt();
            sc.nextLine();
            System.out.println("if continue,press 'y' ");
            strMark = sc.nextLine();
        }while (strMark.equals("y"));

        obj.close();
    }
}
