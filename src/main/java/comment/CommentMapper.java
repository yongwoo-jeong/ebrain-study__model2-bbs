package comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
	List<CommentVO> selectComments(int ArticleId);
	void insertComment(Map newComment);
}
