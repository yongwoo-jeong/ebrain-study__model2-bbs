package article;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
/**
 * 게시글 DAO
 */
public class Article {
	/**
	 * 게시글
	 * id INT(11) - 프라이머리키
	 * auto_increment
	 */
	private Integer articleId;
	/**
	 * 게시글 제목
	 * VARCHAR(100) NOT NULL
	 */
	@NonNull
	private String title;
	/**
	 *  게시글 작성자
	 *  VARCHAR(4) NOT NULL
	 */
	@NonNull
	private String writer;
	/**
	 * 게시글 비밀번호
	 * VARCHAR(5) NOT NULL
	 */
	@NonNull
	private String password;
	/**
	 * 게시글 조회수
	 * INT(11) NOT NULL Default 0
	 */
	private Integer view;
	/**
	 * 게시글 본문
	 * TEXT NOT NULL
	 */
	@NonNull
	private String content;
	/**
	 * 게시글 작성시간
	 * DATETIME NOT NULL
	 */
	@NonNull
	private Date createdAt;
	/**
	 * 게시글 수정시간
	 * DATETIME
	 */
	private Date modifiedAt;
	/**
	 * 카테고리 ID - 외래키
	 * INT(11) NOT NULL
	 */
	@NonNull
	private Integer categoryId;

}
