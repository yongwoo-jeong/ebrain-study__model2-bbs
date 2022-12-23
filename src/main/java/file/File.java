package file;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {
	private int fileUuid;
	private String nameOnServer;
	private String nameOriginal;
	private String filePath;
	private int articleId;

	}
