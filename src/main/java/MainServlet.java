import DB.DbConnectionCheck;
import article.ArticleDAO;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private String message;
	public void init() {
		message = "안녕";
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);
		try {
			ArticleDAO ad = new ArticleDAO();
			DbConnectionCheck check = new DbConnectionCheck();
			check.connectionTest();
			System.out.println(ad.selectArticleAll());
//			System.out.println(MyBatisJavaConfClient.main());
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>"  + "</h1>");
			out.println("</body></html>");
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(command.equals("/searchArticles.do")){
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");

			writer.println("We are in"+command);
			writer.println("</body></html>");
		}

	}

	public void destroy() {
	}
}