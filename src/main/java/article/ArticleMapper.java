package article;

import java.util.List;

public interface ArticleMapper {
	List<Article> selectAllArticle(int itemsFrom);

	void insertArticle(Article article);
}
