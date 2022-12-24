package file;

import comment.CommentMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FileDAO{


	public static FileMapper getMapper() throws IOException {
		String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory;
		FileMapper mapper;
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(FileMapper.class);
		return mapper;
	}

	public List<FileVO> selectFiles(String articleId) throws IOException {
		return getMapper().selectFiles(Integer.parseInt(articleId));
	}

	public FileVO selectForDownload(String uuid) throws IOException {
		return getMapper().selectForDownload(uuid);
	}

	public void insertFile(FileVO newFile) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		mapper = session.getMapper(FileMapper.class);
		mapper.insertFile(newFile);
		session.commit();
		session.close();
	}
}
