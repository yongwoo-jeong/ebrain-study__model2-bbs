package article;

import java.sql.Date;
import java.util.List;

public interface ArticleMapper {
	List<Article> selectAllArticle();

	void insertArticle(String title, String writer,String password,Integer view, String content,
			Date created_at,Integer category_id);
}
