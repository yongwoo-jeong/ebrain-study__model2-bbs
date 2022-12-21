package article;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Article {
	/**
	 * 게시글 id INT(11) - 프라이머리키
	 * auto_increment
	 */
	private Integer articleId;
	/**
	 * 게시글 제목 VARCHAR(100) NOT NULL
	 */
	@NonNull
	private String title;
	/**
	 * 
	 */
	@NonNull
	private String writer;

	@NonNull
	private String password;
	private Integer view;
	@NonNull
	private String content;
	@NonNull
	private Date createdAt;
	private Date modifiedAt;
	@NonNull
	private Integer categoryId;

}
