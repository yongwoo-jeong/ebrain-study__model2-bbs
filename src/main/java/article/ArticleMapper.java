package article;

import java.sql.Date;
import java.util.List;

public interface ArticleMapper {
	List<Article> selectAllArticle();

	void insertArticle(Article article);
}
