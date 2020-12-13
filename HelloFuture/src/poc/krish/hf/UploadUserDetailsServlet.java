package poc.krish.hf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.InputStream;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String s3response;
		String fileName = "";
		InputStream inputStream = null;
		Part filePart = request.getPart("inputPhoto");
		String data = request.getParameter("imageData");

		byte[] bytes = null;
		RequestDispatcher rd;
		try {
			if (filePart != null && filePart.getSize() > 0) {
				//fileName = getFileName(filePart);
				inputStream = filePart.getInputStream();
				System.out.println("inside if");
			} else if (!data.isEmpty()) {
				data = data.substring(data.indexOf(",") + 1);
				bytes = Base64.getDecoder().decode(data);
				inputStream = new ByteArrayInputStream(bytes);
				System.out.println("Data :" + data.isEmpty());
			} else {
				System.out.println("inside else-if-else");
				rd=request.getRequestDispatcher("unableRegistration.jsp");
				rd.forward(request, response);
			}

			/*
			 * else { System.out.println("inside else"); rd =
			 * request.getRequestDispatcher("unableRegistration.jsp"); rd.forward(request,
			 * response); }
			 */
			String fullNameMetadata = request.getParameter("fname");
			String ssnMetadata = request.getParameter("phoneNumber");
			//System.out.println("File Name :" + fileName);
			//System.out.println("Full Name :" + fullNameMetadata);
			// System.out.println("Data: "+data);
			CaptureImage capImg = new CaptureImage();
			// PrintWriter writer = response.getWriter();
			s3response = capImg.uploadUserDetails(inputStream, fullNameMetadata, ssnMetadata + ".jpg");
			if (s3response != null) {

				rd = request.getRequestDispatcher("postRegistration.jsp");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("unableRegistration.jsp");
				rd.forward(request, response);
			}
		} catch (Exception ex) {
			rd=request.getRequestDispatcher("unableRegistration.jsp");
			rd.forward(request, response);
		}

	}

//	private static String getFileName(Part part) {
//		for (String cd : part.getHeader("content-disposition").split(";")) {
//			if (cd.trim().startsWith("filename")) {
//				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
//				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE
//																													// fix.
//			}
//		}
//		return null;
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
