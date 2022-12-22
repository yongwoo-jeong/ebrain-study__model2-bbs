package comment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommentDAO {
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	CommentMapper mapper;

	public List<Comment> selectComments(String id) {
		int articleId = Integer.parseInt(id);
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(CommentMapper.class);
			List<Comment> commentOnArticle = mapper.selectComments(articleId);
			session.close();
			return commentOnArticle;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
