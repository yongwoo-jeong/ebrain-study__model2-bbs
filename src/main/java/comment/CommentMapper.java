package comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
	List<Comment> selectComments(int ArticleId);
	void insertComment(Map comment);
}
