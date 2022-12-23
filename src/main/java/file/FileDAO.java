package file;

import comment.CommentMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FileDAO{
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	CommentMapper mapper;
	public void insertFile() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(CommentMapper.class);
	}
}
