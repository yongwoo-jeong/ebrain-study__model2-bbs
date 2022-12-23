package comment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommentDAO {
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	CommentMapper mapper;

	public List<CommentVO> selectComments(String id) {
		int articleId = Integer.parseInt(id);
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(CommentMapper.class);
			List<CommentVO> commentVOOnArticle = mapper.selectComments(articleId);
			session.close();
			return commentVOOnArticle;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void insertComment(Map<String,String> commentMap){
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(CommentMapper.class);
			mapper.insertComment(commentMap);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
