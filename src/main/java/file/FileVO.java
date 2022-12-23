package file;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileVO {
	private int fileUuid;
	@NonNull
	private String nameOnServer;
	@NonNull
	private String nameOriginal;
	@NonNull
	private String filePath;
	@NonNull
	private int articleId;

	}
