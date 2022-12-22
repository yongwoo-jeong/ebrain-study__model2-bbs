package article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
	List<Article> selectAllArticle(Map map);
	void insertArticle(Article article);
}
