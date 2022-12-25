package article;

import logger.MyLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * myBatis 매퍼들을 이용해 게시글 관련 데이터 생성, 읽기, 수정, 삭제하는 클래스
 */
public class ArticleDAO {
	/**
	 * session commit, close 위한 sql 세션 멤버변수
	 */
	static SqlSession session;
	/**
	 * myLogger 인스턴스 받아오기
	 */
	MyLogger logger = MyLogger.getLogger();

	/**
	 * ArticleMapper 로드해주는 메서드
	 * @return
	 */
	public ArticleMapper loadMapper(){
		ArticleMapper mapper = null;
		String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory;
		try{
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
		} catch (IOException e) {
			String currentClass = MyLogger.getClassName();
			logger.severe(currentClass+e);
			e.printStackTrace();
		}
		return mapper;
	}

	/**
	 * index page, 검색 조건 토대로 해당되는 아티클 인스턴스 리스트를 리턴해주는 메서드
	 * @param selectMap 날짜, 키워드, 카테고리, 페이징 정보가 담긴 Map
	 * @return List<ArticleVO>
	 */
	public List<ArticleVO> selectAllArticle(Map selectMap) {
			List<ArticleVO> articleVOFromMapper = loadMapper().selectAllArticle(selectMap);
			session.close();
			return articleVOFromMapper;
	}

	/**
	 * 개별 게시글 보기 페이지를 위해 게시글 인스턴스를 반환해주는 메서드
	 * @param articleId 스트링형태로 받아 정수형태로 변환 후 매퍼 인터페이스로 전달
	 * @return  ArticleVO
	 */
	public ArticleVO getArticle(String articleId){
		int parsedArticleId = Integer.parseInt(articleId);
		ArticleVO getArticle =  loadMapper().getArticle(parsedArticleId);
		session.close();
		return getArticle;
	}

	/**
	 * 게시글 등록을 위한 메서드
	 * @param articleVO
	 */
	public void insertArticle(ArticleVO articleVO) {
		loadMapper().insertArticle(articleVO);
		session.commit();
		session.close();
	}

	/**
	 * 게시글 삭제를 위한 메서드
	 * @param articleId 서블릿에서 게시글 ID 스트링으로 받아온다.
	 */
	public void deleteArticle(String articleId){
		loadMapper().deleteArticle(Integer.parseInt(articleId));
		session.commit();
		session.close();
	}
}
