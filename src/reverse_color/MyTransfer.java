package reverse_color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyTransfer {
	public static void main(String[] args) throws IOException {
		// 获取原始图片流
		String path = "/Users/Jason/eclipse-workspace/my_gadget/src/reverse_color/";
		BufferedImage bi = ImageIO.read(new File(path + "starfleet-logo-vector.png"));

		int width = bi.getWidth();
		int height = bi.getHeight();
		int minx = bi.getMinX();
		int miny = bi.getMinY();

		for (int i = minx; i < width; i++) {
			for (int j = miny; j < height; j++) {
				int pixel = bi.getRGB(i, j);
				// 反转颜色
				if (pixel == 0x0B0E1B) {
					System.out.println("change"+i+" "+j);
					bi.setRGB(i, j, 0x000);
				}
				else if (pixel == 0xE7E7E7) {
					System.out.println("change---"+i+" "+j);
					bi.setRGB(i, j, 0xfff);
					
				}

			}
		}

		FileOutputStream ops = new FileOutputStream(new File(path + "ssss.jpg"));
		ImageIO.write(bi, "jpg", ops);
		ops.flush();
		ops.close();
	}
}
