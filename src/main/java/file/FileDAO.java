package file;

import comment.CommentMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import logger.MyLogger;
import lombok.extern.flogger.Flogger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FileDAO{

	/**
	 * session commit, close 위한 sql 세션 멤버변수
	 */
	static SqlSession session;
	static MyLogger logger = MyLogger.getLogger();
	/**
	 * 파일 관련한 매퍼를 로드해주는 메소드
	 * @return
	 * @throws IOException
	 */
	public static FileMapper loadMapper(){
		FileMapper mapper = null;
		try {
			String resource = "mybatis-config.xml";
			SqlSessionFactory sqlSessionFactory;
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			mapper = session.getMapper(FileMapper.class);
		} catch (IOException e) {
			String currentClass = MyLogger.getClassName();
			logger.severe(currentClass+e);
			e.printStackTrace();
		}
		return mapper;
	}
	/**
	 * 개별 아티클의 파일 가져오는 메서드
	 * @param articleId 아티클 id 를 스트링으로 받아 정수 형태로 변환해 인터페이스로 전달된다
	 * @return 해당 아티클에 따른 파일들 List<FileVO> 형태로 반환
	 */
	public List<FileVO> selectFiles(String articleId) {
		return loadMapper().selectFiles(Integer.parseInt(articleId));
	}

	/**
	 * 다운로드를 위해 uuid 를 받아 해당 파일 인스턴스 반환
	 * @param uuid
	 * @return FileVO 반환
	 */
	public FileVO selectForDownload(String uuid){
		return loadMapper().selectForDownload(uuid);
	}

	/**
	 * 파일 테이블에 insert 해주는 메서드
	 * @param newFile FileVO 받음
	 */
	public void insertFile(FileVO newFile){
		loadMapper().insertFile(newFile);
		session.commit();
		session.close();
	}
}
