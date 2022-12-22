package article;

import Logger.MyLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
	public List<Article> selectAllArticle() {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			List<Article> articleFromMapper = mapper.selectAllArticle();
			session.close();
			return articleFromMapper;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insertArticle(Article article) {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			// String title, String writer,String password,Integer view, String content, Date created_at,Integer category_id
			mapper.insertArticle(article);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
