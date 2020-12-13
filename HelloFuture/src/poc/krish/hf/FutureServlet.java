package poc.krish.hf;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;

import com.amazonaws.util.IOUtils;
import java.util.Base64;

/**
 * Servlet implementation class FutureServlet
 */
@WebServlet("/futureServlet")
@MultipartConfig
public class FutureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FutureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getParameter("imageData");
		System.out.println("imageData: " + data);
		data = data.substring(data.indexOf(",") + 1);
		byte[] bytes = Base64.getDecoder().decode(data);
		System.out.println("imageData: " + data);
		FaceSearcher fs = new FaceSearcher();
		String faceId = fs.matchFaceImage(ByteBuffer.wrap(bytes));
		RequestDispatcher rd;

		if (faceId != null) {
			NameFinder nf = new NameFinder();
			String name = nf.lookupName(faceId);

			if (name != null) {
				System.out.println("Welcome Message : JSP 1");
				request.setAttribute("Name", name);
				System.out.println("name" + name);
				request.setAttribute("userName", name);
				rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);

			} else
				rd = request.getRequestDispatcher("authenticationFailure.jsp");
			rd.forward(request, response);
		} else
			rd = request.getRequestDispatcher("authenticationFailure.jsp");
		rd.forward(request, response);

	}

}
