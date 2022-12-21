import article.Article;
import article.ArticleDAO;
import java.io.*;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * CRUD 관련 모든 요청을 처리하는 메인서블릿
 */
@WebServlet("*.action")
public class MainServlet extends HttpServlet {



	public void init() {}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html; charset=utf-8");
		// 요청이 들어오는 식별자 확인
		String uri = request.getRequestURI();
		MyLogger LOG = MyLogger.getLogger();
		System.out.println("현재 주소:"+ uri);
		// index 페이지에서 게시글 목록을 조회하기 위한 /searchArticles.do
		try{
			ArticleDAO articleDAO = new ArticleDAO();
			List<Article> selectedArticles = articleDAO.selectArticleAll();
			request.setAttribute("selectedArticles", selectedArticles);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (IOException e){
			e.printStackTrace();
		}
	}


	public void destroy() {
	}
}