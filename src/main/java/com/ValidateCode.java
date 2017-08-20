package com;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by des on 2017/7/4.
 * 验证码
 */
public class ValidateCode extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
           创建空白图片，获取画笔，设置画笔颜色，绘制矩形背景，调用自定义方法获取长度5的字母数字组合字符串
           再设置字体颜色，绘制字符串，绘制干扰线
         */
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect(0, 0, 100, 30);

        String number = getNumber(5);
        HttpSession session = req.getSession();
        session.setAttribute("code", number);      //0.绑定 验证码字符串  到seesion中传入；方便在登录的servlet中与用户输入的校验
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font(null, Font.BOLD, 24));
        g.drawString(number, 5, 25);

        for (int i = 0; i < 8; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }

        resp.setContentType("image/jpeg");
        OutputStream ops = resp.getOutputStream();
        ImageIO.write(image, "jpeg", ops);
        ops.close();
    }

    /**
     * 生成随机长度的字母数字的字符串
     *
     * @param size 要求的长度
     * @return
     */
    private String getNumber(int size) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "";
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            number += str.charAt(r.nextInt(str.length()));
        }

        return number;
    }

}
