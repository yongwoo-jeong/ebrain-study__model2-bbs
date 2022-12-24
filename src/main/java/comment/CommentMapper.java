package comment;

import java.util.List;
import java.util.Map;

/**
 * 댓글을 위한 마이배티스 매퍼 인터페이스
 */
public interface CommentMapper {

	/**
	 * 각 article 에 해당하는 댓글 리스트를 리턴
	 * @param ArticleId
	 * @return List of CommentVO
	 */
	List<CommentVO> selectComments(int ArticleId);

	/**
	 * 새로운 댓글 생성하는 메서드
	 * @param newComment 댓글 내용과 articleId 를 가진 Map
	 */
	void insertComment(Map newComment);
}
