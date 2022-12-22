import MatchCategory.FindCategoryNameId;
import article.Article;
import article.ArticleDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
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
	MyLogger logger = MyLogger.getLogger();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		// 요청이 들어오는 식별자 확인
		String uri = request.getRequestURI();
		MyLogger LOG = MyLogger.getLogger();
		logger.info("현재 주소:" + uri);

		if(uri.equals("/selectArticles.action")){
			getSelectArticles(request,response);
		}
		// 새 게시글 업로드 하기위한 newArticleInsertAction

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		MyLogger LOG = MyLogger.getLogger();
		logger.info("현재 주소:" + uri);
		if (uri.equals("/newArticleInsert.action")) {
			postInsertArticle(request,response);
		}
	}

	public void destroy() {
	}

	/**
	 * /selectArticles.action GET 요청을 처리하고 게시글을 조회해주는 메서드
	 * @param request
	 * @param response
	 */
	public void getSelectArticles(HttpServletRequest request, HttpServletResponse response){
		try{
			ArticleDAO articleDAO = new ArticleDAO();
			List<Article> selectedArticles = articleDAO.selectAllArticle();
			request.setAttribute("selectedArticles", selectedArticles);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (IOException e){
			e.printStackTrace();
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 게시글을 업로드하는 메소드
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void postInsertArticle(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 멀티파트 위해 필요한 파라미터 선언
		String encType = "utf-8";
		int maxSize = 5 * 1024 * 1024;
		// 첨부파일이 저장되는 경로
		String uploadPath = request.getSession().getServletContext().getRealPath("/file");
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, uploadPath, maxSize, encType,
					new DefaultFileRenamePolicy());
			// 게시글 카테고리, 제목, 작성자, 내용, 비밀번호, 비밀번호 확인 받음.
			String category = multi.getParameter("category");
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String content = multi.getParameter("content");
			String password = multi.getParameter("password");
			String password_confirm = multi.getParameter("password_confirm");
			// 유효성 검증을 위한 밸리데이션 값
			Boolean validation = true;
			// equals 이렇게쓰면 안됐던것같은데..
			// 카테고리 선택 안됐을 경우
			if (category.equals("")) {
				logger.warning("No category");
				validation = false;
			}
			//Form data 길이 요건을 충족하지 않는 경우
			if (writer.length() != 3 && title.length() != 4) {
				logger.warning("Writer length out of range");
				validation = false;
			}
			if (title.length() < 2 || title.length() >= 100) {
				logger.warning("title length out of range");
				validation = false;
			}
			if (content.length() < 4 || content.length() >= 200) {
				logger.warning("content length out of range");
				validation = false;
			}
			// 비밀번호가 일치하지 않을 경우
			if (!Objects.equals(password, password_confirm)) {
				logger.warning("Password not confirmed");
				validation = false;
			}
			// 검증되지 않은 경우 이전 페이지로 돌려보내기
			if (!validation) {
				logger.warning("Validaion failed. Back to page");
				response.sendRedirect(request.getContextPath()+"/newArticleInput.jsp");
			} else {
				// 카테고리 ID -> 카테고리명으로 변환
				Integer category_id = new FindCategoryNameId().findCategoryIdFn(category);
				// 게시글 작성 시간 입력을 위한 sql Date
				LocalDateTime currentDateTime = LocalDateTime.now();
				Date sqlDate = Date.valueOf(currentDateTime.toLocalDate());
				// 앞서 받은 Form 데이터를 통해 Article 만듦
				Article newArticle = Article.builder().title(title).writer(writer)
						.content(content).password(password).createdAt(sqlDate)
						.categoryId(category_id).build();
				ArticleDAO articleDAO = new ArticleDAO();
				articleDAO.insertArticle(newArticle);
				// 게시글 먼저 INSERT 하고 파일 INSERT 해야할듯?
				// 포스트ID 안전하게 받아올 방법....

//				 첨부파일이 여러개일경우 enum을 통해 받아옴
//				Enumeration files = multi.getFileNames();
//				while (files.hasMoreElements()) {
//					String param = (String) files.nextElement();
//					String fileName = multi.getOriginalFileName(param);
//					String filesystemName = multi.getFilesystemName(param);
//					// 파일경로, articleId 받아와야함.
//					if (fileName == null)
//						continue;
//				}
				logger.info("New article has made");
				response.sendRedirect("/index.jsp");

			}
		} catch (IOException e) {
			response.sendRedirect("/newArticleInput.jsp");
			e.printStackTrace();
		}
	}
}