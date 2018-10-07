package com.migo.seo.servlet;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.migo.seo.utils.ImageProcessor;

/**
 * Servlet implementation class FileUploadServlet
 * once File is uploaded and submitted using form submission it does in two steps
 * 
 * Step 1 : Validating the right mime type.
 * Step 2 : Apply the necessary compression techniquies to right to file.
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImageProcessor imageprocessor = new ImageProcessor();   
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				String fname = null;
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						fname = new File(item.getName()).getName();
						if(imageprocessor.isValidFile(item, fname)){
							BufferedImage imBuff = ImageIO.read(item.getInputStream());
							imageprocessor.parseImage(imBuff, fname);
						}	
					}
				}
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}
 
		} else {
			
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
	    dispatcher.forward(request, response);
	}
	
	 

}
