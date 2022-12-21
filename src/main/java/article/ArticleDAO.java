package article;

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
	public List<Article> selectArticleAll() {
		SqlSessionFactory sqlSessionFactory;
		ArticleMapper mapper;
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			for(Article a: mapper.selectAllArticle()){
				System.out.println(a.getTitle());
			}
		} catch (IOException e) {
			System.out.println("batis FAIL");
			e.printStackTrace();
			throw new RuntimeException(e);}
		return null;
	}
}
