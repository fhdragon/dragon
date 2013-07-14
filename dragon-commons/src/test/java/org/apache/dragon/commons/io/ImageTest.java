package org.apache.dragon.commons.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * test for image
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jul 04, 2013
 * @since 1.0
 */
public class ImageTest {

	// Local variables
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(ImageTest.class);

	// Logic
	/**
	 * test
	 */
	@Test
	public void image() {
		logger.debug("Begin: image()...");
		String imgPath = "/fhdragon/pastime/photo/SAM_0247.JPG", imgOutPath = "/fhdragon/pastime/photo/test/" + System.currentTimeMillis() + "SAM_0247.JPG";
		zoomPicture(imgPath, imgOutPath, 2800);
		boolean result = true;
		logger.debug("End: result = " + result);
	}

	/**
	 * 缩放图片
	 * 
	 * @param imgPath
	 * @param imgOutPath
	 * @param max
	 * @return
	 */
	public static void zoomPicture(String imgPath, String imgOutPath, int max) {
		double maxLimit = max;
		double ratio = 1.0;
		try {
			BufferedImage Bi = ImageIO.read(new File(imgPath));
//			if ((Bi.getHeight() > maxLimit) || (Bi.getWidth() > maxLimit)) {
//				if (Bi.getHeight() > Bi.getWidth())
//					ratio = maxLimit / Bi.getHeight();
//				else
//					ratio = maxLimit / Bi.getWidth();
//			}
//			int widthdist = (int) Math.floor(Bi.getWidth() * ratio), heightdist = (int) Math.floor(Bi.getHeight()
//					* ratio);

			BufferedImage tag = new BufferedImage(max, max, BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(Bi.getScaledInstance(max, max, BufferedImage.SCALE_SMOOTH), 0, 0,
					null);

			File littleFile = new File(imgOutPath);
			ImageIO.write(tag, "JPEG", littleFile);
		} catch (Exception ex) {
			logger.error("image read error: ", ex);
		}
	}

	/**
	 * allocate expensive external resources(like logging into a database) before any of the test methods in the class.
	 */
	@BeforeClass
	public static void init() {
		logger.debug("Begin: init()...");
		logger.debug("End: init()!");
	}

	/**
	 * releases any resource that you allocate expensive external resources in a {@link BeforeClass} method after all
	 * the tests in the this class have been run. this method guaranteed to run.
	 */
	@AfterClass
	public static void destory() {
		logger.debug("Begin: destory()...");
		logger.debug("End: destory()!");
	}

}
