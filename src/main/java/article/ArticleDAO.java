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
 * myBatis 매퍼들을 이용해 게시글 관련 데이터 송수신
 */
public class ArticleDAO {
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	ArticleMapper mapper;
	MyLogger logger = MyLogger.getLogger();
	public List<ArticleVO> selectAllArticle(Map selectMap) {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			List<ArticleVO> articleVOFromMapper = mapper.selectAllArticle(selectMap);
			session.close();
			return articleVOFromMapper;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public ArticleVO getArticle(String articleId){
		int parsedArticleId = Integer.parseInt(articleId);
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			return mapper.getArticle(parsedArticleId);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int insertArticle(ArticleVO articleVO) {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			// String title, String writer,String password,Integer view, String content, Date created_at,Integer category_id
			mapper.insertArticle(articleVO);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
