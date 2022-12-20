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
	 *
	 */
	private Integer articleId;
	@NonNull
	private String title;
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
