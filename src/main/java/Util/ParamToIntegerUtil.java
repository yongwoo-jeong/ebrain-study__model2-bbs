package Util;

/**
 * page 쿼리스트링을 받아 적절한 page 넘버를 돌려주는 클래스
 */
public class ParamToIntegerUtil {
	/**
	 * page 쿼리스트링을 받아 적절한 page 넘버를 돌려주는 함수
	 * @param pageNumber 쿼리스트링으로 받아온 정수로 기대되는 파라미터
	 * @return DB Select Limit 쿼리에 사용가능한 정수를 돌려준다
	 */
	public Integer ParamToInteger(String pageNumber){
		int parsedPageNumber;
		// null 해당할 경우 초기 페이지로 설정한다.
		if(pageNumber == null){
			parsedPageNumber = 1;
		} else{
			// page 파라미터에 .action 이 딸려오기 때문에 제거
			pageNumber = pageNumber.replaceAll(".action", "");
			// 제거한 pageNumber 가 숫자로 구성된 스트링인지 확인
			boolean isNumeric = pageNumber.matches("[+-]?\\d*(\\.\\d+)?");
			// 숫자가 아닌 값이 들어왔을 경우 페이지 1로 보내기
			if(!isNumeric){
				parsedPageNumber = 1;
			} else{
				parsedPageNumber = Integer.parseInt(pageNumber);
			}
		}
		return parsedPageNumber;
	}
}
