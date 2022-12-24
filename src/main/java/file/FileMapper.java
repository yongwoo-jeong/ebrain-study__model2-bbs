package file;

import java.util.List;
import java.util.Map;

public interface FileMapper {
	void insertFile(FileVO newFile);
	List<FileVO> selectFiles(int articleId);
	FileVO selectForDownload(String uuid);

}
