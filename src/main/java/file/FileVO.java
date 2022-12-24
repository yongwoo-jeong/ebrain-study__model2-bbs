package file;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileVO {
	@NonNull
	private String nameOnServer;
	@NonNull
	private String nameOriginal;
	@NonNull
	private int articleId;
	@NonNull
	private String filePath;
	private String fileUuid;

	}
