package com.migo.seo.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;
import org.apache.tika.Tika;

/**
 * @author chintald
 *This is a util class generated to do the logic to check file validation and to compress the Image.
 */
public class ImageProcessor {
	
	public void parseImage(BufferedImage image, String fileName) throws IOException {

        BufferedImage resized = resize(image);
        System.out.println("filenam   --------->" + "/Users/chintald/Desktop/"+ new java.util.Date() + fileName);
        File output = new File("/Users/chintald/Desktop/"+ new java.util.Date() + fileName);
        
        if(fileName.contains("png")){
        	ImageIO.write(resized, "png", output);
        }else {
        	ImageIO.write(resized, "jpg", output);
        }
    }

    private BufferedImage resize(BufferedImage img) {
        Image tmp = img.getScaledInstance(IMAGE_WDITH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(IMAGE_WDITH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    public boolean isValidFile(FileItem fileUploadItem , String filename) throws Exception {
		String fileType = null;
		boolean isValid = false;
		InputStream in = fileUploadItem.getInputStream();
		// get the file extension
		String[] fileExtensions = filename.split("\\.");
		String fileExtension = (fileExtensions[fileExtensions.length - 1])
				.toLowerCase();
		ApacheTikaFileType apacheTikaFileType = new ApacheTikaFileType();
		if ((fileExtensions.length > 1)) {
			try {
				Tika tika = new Tika();
				fileType = tika.detect(in);
				System.out.println("filettype" + fileType);
				if (apacheTikaFileType.isValidFileType(fileExtension.toLowerCase(), fileType)) {
					isValid = true;
				}
			}  catch (Exception ex) {
				throw new Exception("Error in Validiting File Type", ex);
			}
		}
		return  isValid;
	}
    
    private static int IMAGE_WDITH = 600;
    private static int IMAGE_HEIGHT = 300;
    

}
