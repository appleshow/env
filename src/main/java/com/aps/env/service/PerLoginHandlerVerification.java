package com.aps.env.service;

import com.aps.env.comm.CommUtil;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <dl>
 * <dt>com.aps.env.service.PerLoginHandlerVerification</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/8</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class PerLoginHandlerVerification implements PreLoginHandler {
    private final static String CODES = "0123456789";
    private final static int LEN = 4;

    /**
     * @param session
     * @return
     * @throws Exception
     */
    @Override
    public Map<?, ?> handle(HttpSession session) throws Exception {
        Map<String, Object> ret = new HashMap<String, Object>();

        String code = randomCode();
        session.setAttribute(CommUtil.SESSION_VERIFICATION, code);
        ret.put("imgData", "data:image/png;base64," + Base64.getEncoder().encodeToString(generateImg(code)));

        return ret;
    }

    /*
     * 4位随机数字字符串
     *
     * @return
     */
    private String randomCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LEN; ++i) {
            sb.append(CODES.charAt(random.nextInt(CODES.length())));
        }
        return sb.toString();
    }

    /*
     * 绘制PNG图片
     *
     * @return
     */
    private byte[] generateImg(String code) throws IOException {

        final int width = 75;
        final int height = 50;

        BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimg.createGraphics();

        // 背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.GRAY);
        g.setFont(new Font("黑体", Font.BOLD, 25));

        // 干扰线
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }

        for (int i = 0; i < LEN; ++i) {
            g.drawString(String.valueOf(code.charAt(i)), 5 + 16 * i, 30);
        }

        g.dispose();

        // 输出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimg, "png", baos);
        baos.close();

        return baos.toByteArray();
    }
}
