<%@ page import="java.util.Objects" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="MatchCategory.FindCategoryNameId" %>
<%@ page import="article.Article" %>
<%@ page import="article.ArticleDAO" %>
<%@ page import="java.time.LocalDateTime" %>
Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/15
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 멀티파트 위해 필요한 파라미터 선언
    String encType = "utf-8";
    int maxSize = 5*1024*1024;
    // 첨부파일이 저장되는 경로
    String uploadPath = request.getSession().getServletContext().getRealPath("/file");
    MultipartRequest multi;
        try{
            multi = new MultipartRequest(request, uploadPath, maxSize, encType,
                    new DefaultFileRenamePolicy());
            // 게시글 카테고리, 제목, 작성자, 내용, 비밀번호, 비밀번호 확인 받음.
            // 비밀번호는 자바스크립트로 프론트에서도 검증
            String category = multi.getParameter("category");
            String title = multi.getParameter("title");
            String writer = multi.getParameter("writer");
            String content = multi.getParameter("content");
            String password = multi.getParameter("password");
            String password_confirm = multi.getParameter("password_confirm");
            // 비밀번호가 일치하지 않을 경우
            // 이전 페이지로 오류 안내 메세지와 함께 돌려보내기
            if (!Objects.equals(password, password_confirm)){
                response.sendRedirect(request.getContextPath()+"/newArticleInput.jsp");
            }
            // 카테고리 ID -> 카테고리명으로 변환
            Integer category_id = new FindCategoryNameId().findCategoryIdFn(category);
            LocalDateTime currentDateTime = LocalDateTime.now();
            Date sqlDate = Date.valueOf(currentDateTime.toLocalDate());

            // 앞서 받은 Form 데이터를 통해 Article 만듦
            Article newArticle = Article.builder().title(title).writer(writer).content(content).password(password).createdAt(sqlDate).categoryId(category_id).build();
            System.out.println(newArticle.getTitle());
            System.out.println(newArticle.getPassword());


            // 첨부파일이 여러개일경우 enum을 통해 받아옴
            Enumeration files = multi.getFileNames();
            while (files.hasMoreElements()){
                String param = (String) files.nextElement();
                String fileName = multi.getOriginalFileName(param);
                String filesystemName = multi.getFilesystemName(param);
                if(fileName == null) continue;

            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            response.sendRedirect("/index.jsp");
        }




%>