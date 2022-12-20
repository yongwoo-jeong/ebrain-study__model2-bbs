package article;

import DB.DBUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ArticleDAO {
	public List<Article> selectArticleAll() {
		SqlSessionFactory sqlSessionFactory;
		articleMapper mapper;
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(articleMapper.class);
			System.out.println("batis ON");
		} catch (IOException e) {
			System.out.println("batis FAIL");
			e.printStackTrace();
			throw new RuntimeException(e);}

		return mapper.selectArticleAll();
	}
}
