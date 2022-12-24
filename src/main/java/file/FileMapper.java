package file;

import java.util.List;
import java.util.Map;

/**
 * 파일을 위한 매퍼 인터페이스
 */
public interface FileMapper {

	/**
	 * 파일 insert
	 * @param newFile
	 */
	void insertFile(FileVO newFile);

	/**
	 * 게시글에 해당하는 파일들 반환
	 * @param articleId
	 * @return  List<FileVO>
	 */
	List<FileVO> selectFiles(int articleId);

	/**
	 * 다운로드 할 파일 인스턴스 반환
	 * @param uuid
	 * @return
	 */
	FileVO selectForDownload(String uuid);

}
