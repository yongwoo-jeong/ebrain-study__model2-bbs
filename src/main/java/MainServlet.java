import article.ArticleDAO;
import java.io.*;
import java.util.logging.Logger;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private final static Logger LOG = Logger.getGlobal();
	public void init() {}

	/**
	 * MainServlet 에서 모든 요청을 처리
	 * @param request   an {@link HttpServletRequest} object that
	 *                  contains the request the client has made
	 *                  of the servlet
	 *
	 * @param response  an {@link HttpServletResponse} object that
	 *                  contains the response the servlet sends
	 *                  to the client
	 *
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		// 요청이 들어오는 식별자 확인
		String uri = request.getRequestURI();
		LOG.info("현재 주소:"+uri);
		// index 페이지에서 게시글 목록을 조회하기 위한

		if(uri.equals("/searchArticles.do")){
		}

	}

	public void destroy() {
	}
}