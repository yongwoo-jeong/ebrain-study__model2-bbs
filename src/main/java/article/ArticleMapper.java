package article;

import java.util.List;
import java.util.Map;

/**
 * 게시글(article) 위한 매퍼 인터페이스
 */
public interface ArticleMapper {

	/**
	 * 조건에 맞는 게시글을 리턴해주는 메서드
	 * @param map 날짜, 키워드, 카테고리, 페이징 정보가 담긴 Map
	 * @return List<ArticleVO>
	 */
	List<ArticleVO> selectAllArticle(Map map);

	/**
	 * article table 에 insert 위한 매퍼 인터페이스
	 * @param articleVO
	 * @return
	 */
	Integer insertArticle(ArticleVO articleVO);

	/**
	 * 개별 게시글 인스턴스 반환
	 * @param articleId 아티클 ID(PK)
	 * @return ActicleVO
	 */
	ArticleVO getArticle(int articleId);

	/**
	 * 게시글을 지우는 매퍼 인터페이스
	 * @param articleId
	 */
	void deleteArticle(int articleId);
}
