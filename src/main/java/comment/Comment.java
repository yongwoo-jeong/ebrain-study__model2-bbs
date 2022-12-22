package comment;

import java.sql.Date;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	private Integer commentId;
	@NonNull
	private String content;
	private Date createdAt;
	private Integer articleId;
}
