package article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
	List<ArticleVO> selectAllArticle(Map map);
	Integer insertArticle(ArticleVO articleVO);

	ArticleVO getArticle(int articleId);
}
