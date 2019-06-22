package com.galaxyt.capricorn.common.util.verification;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 图形验证码
 * @author zhouqi
 * @date 2019-01-13 22:43
 * @version v1.0.0
 * @Description 用于生成图片验证码
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-01-13 22:43     zhouqi          v1.0.0           Created
 *
 */
public class CaptchaUtil {


    /**
     * 生成一个数字图形验证码
     * @param width     指定宽度
     * @param height    指定高度
     * @param out       输出流
     * @Description
     *         使用需要设置本次response响应禁止缓存，设置方法如下
     *              response.setHeader("Pragma", "No-cache");
     * 		        response.setHeader("Cache-Control", "no-cache");
     * 		        response.setDateHeader("Expires", 0);
     * 		    最终需要将BufferedImage对象使用ImageIO打印输出，如下
     * 		        ImageIO.write(image, "JPEG", response.getOutputStream());
     * 		        response.getOutputStream().flush();
     * @return
     *      验证码字符串
     *      为NULL代表生成出错
     */
    public static String numberCaptcha(int width, int height, OutputStream out) {


        Random random = new Random();

        // 生成缓冲区image对象
        BufferedImage image = new BufferedImage(width, height, 1);
        // 产生image对象的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        // 设置画布颜色
        g.setColor(CaptchaUtil.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman", 0, 28));
        g.fillRect(0, 0, width, height);
        // 绘制干扰线
        for (int i = 0; i < 40; i++) {
            g.setColor(CaptchaUtil.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        // 绘制字符
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sb.append(rand);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 20 * i + 6, 28);
        }

        g.dispose();

        try {
            ImageIO.write(image, "JPEG", out);
            return sb.toString();
        } catch (IOException e) {
            return null;
        }

    }



    /**
     * 创建颜色
     * @param fc
     * @param bc
     * @return
     */
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }



}
