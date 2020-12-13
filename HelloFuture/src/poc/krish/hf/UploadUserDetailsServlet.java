package poc.krish.hf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.ByteArrayInputStream;

/**
 * Servlet implementation class UploadUserDetails
 */
@WebServlet("/uploadUserDetails")
@MultipartConfig
public class UploadUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadUserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String s3response;
		String fileName="";
		InputStream inputStream=null;
		Part filePart = request.getPart("inputPhoto");
		String data = request.getParameter("imageData");
		
		byte[] bytes=null;
		if(filePart!=null && filePart.getSize()>0) {
		fileName=getFileName(filePart);
		System.out.println("Inside if ");
		//String fileName="test1.jpg";
		inputStream = filePart.getInputStream();
		}else if(data!=null) {
			data = data.substring(data.indexOf(",") + 1);
	        bytes = Base64.getDecoder().decode(data);
	        inputStream = new ByteArrayInputStream(bytes);
	        System.out.println("Inside elseif ");
		}
		String fullNameMetadata = request.getParameter("fname");
		String phoneNumberMetadata = request.getParameter("phoneNumber");
		System.out.println("File Name :"+fileName);
		System.out.println("Full Name :"+fullNameMetadata);
		//System.out.println("Data: "+data);
		CaptureImage capImg= new CaptureImage();
		PrintWriter writer = response.getWriter();
		s3response=capImg.uploadUserDetails(inputStream, fullNameMetadata,phoneNumberMetadata+".jpg");
		
			//writer.println("Welcome, " + name);
			response.setContentType("text/html");
			writer.println("<!DOCTYPE html>" +
					"<html>\n" +
					"<head><title>Success</title></head>\n"+
					"<body>\n" +
					"<h1>" + s3response + "</h1>\n" +
					"</body>\n" + 
					"</html>"
					);			
		
	}
	 private static String getFileName(Part part) {
		    for (String cd : part.getHeader("content-disposition").split(";")) {
		      if (cd.trim().startsWith("filename")) {
		        String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
		        return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
		      }
		    }
		    return null;
		  }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
