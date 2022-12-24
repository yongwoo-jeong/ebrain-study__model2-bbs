package comment;

import article.ArticleMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import logger.MyLogger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 마이배티스 매퍼를 이용해 댓글 관련 데이터 생성, 읽기, 삭제하는 클래스
 */
public class CommentDAO {
	static SqlSession session;
	MyLogger logger = MyLogger.getLogger();
	public CommentMapper loadMapper(){
		CommentMapper mapper = null;
		String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory;
		try{
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			mapper = session.getMapper(CommentMapper.class);
		} catch (IOException e) {
			String currentClass = MyLogger.getClassName();
			logger.severe(currentClass+e);
			e.printStackTrace();
		}
		return mapper;
	}

	/**
	 * 게시글에 해당하는 댓글을 List 형태로 반환해주는 메서드
	 * @param id articleId
	 * @return  List of commentVO
	 */
	public List<CommentVO> selectComments(String id) {
		int articleId = Integer.parseInt(id);
		List<CommentVO> commentVOOnArticle = loadMapper().selectComments(articleId);
		session.close();
		return commentVOOnArticle;
	}

	/**
	 * 댓글 insert 해주는 메서드
	 * @param commentMap
	 */
	public void insertComment(Map<String,String> commentMap){
		loadMapper().insertComment(commentMap);
		session.commit();
		session.close();
	}
}
