package file;

import comment.CommentMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FileDAO{
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	FileMapper mapper;
	public void insertFile(FileVO newFile) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(FileMapper.class);
		mapper.insertFile(newFile);
		System.out.println("trying to insert file");
		session.commit();
		session.close();
		System.out.println("Success insert file");
	}
}