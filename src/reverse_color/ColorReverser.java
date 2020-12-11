package reverse_color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorReverser {
	public static void main(String[] args) throws IOException {
		// 获取原始图片流
		String path = "/Users/Jason/eclipse-workspace/my_gadget/src/reverse_color/";
		BufferedImage bi = ImageIO.read(new File(path + "do.jpg"));

		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();

		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j);
				// 反转颜色

				bi.setRGB(i, j, 0xffffff - pixel);

			}
		}

		FileOutputStream ops = new FileOutputStream(new File(path + "new.jpg"));
		ImageIO.write(bi, "jpg", ops);
		ops.flush();
		ops.close();
	}
}
