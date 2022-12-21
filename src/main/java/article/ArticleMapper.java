package article;

import java.util.List;

public interface ArticleMapper {
//	@Select("SELECT COUNT(*) FROM article")
	List<Article> selectArticleAll();
}
