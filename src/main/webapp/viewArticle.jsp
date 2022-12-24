<%@ page import="article.ArticleVO" %>
<%@ page import="comment.CommentVO" %>
<%@ page import="java.util.List" %>
<%@ page import="comment.CommentVO" %>
<%@ page import="article.ArticleVO" %>
<%@ page import="file.FileVO" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/14
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/view_article.css">
    <title>Title</title>
</head>
<body>
<%
    ArticleVO article = (ArticleVO) request.getAttribute("article");
%>
<div class="container">
<header class="header">게시판 - 보기</header>
<div class="writer_time_row">
    <div class="writer_div">
        <span><%=article.getWriter()%></span>
    </div>
    <div>
        <span>등록일시</span>
        <% if (article.getModifiedAt() == null){%>
            <span><%=article.getCreatedAt()%></span>
        <%} else {%>
            <span><%=article.getCreatedAt()%></span>
            <span>수정일시</span>
            <span><%=article.getModifiedAt()%></span>
        <%}%>
    </div>
</div>
    <div class="title_row">
        <div>
            <% if (article.getCategoryId() == 1) {%>
                <span>[JAVA]</span>
            <% } else if (article.getCategoryId() == 2) { %>
                <span>[Javascript]</span>
            <% } else if (article.getCategoryId() == 3) {%>
                <span>[JAVA]</span>
            <% } %>
            <span><%=article.getTitle()%></span>
        </div>
        <div class="view">
            <span>조회수: </span>
            <span><%=article.getView()%></span>
        </div>
    </div>
    <div class="post_container">
        <p><%=article.getContent()%></p>
    </div>
    <div class="file_container">
        <%
            List<FileVO> FileList = (List<FileVO>) request.getAttribute("fileList");
            for (FileVO file : FileList){
        %>
        <div class="file">
            <a href=download.action?file_id=<%=file.getFileUuid()%>>
                <%=file.getNameOriginal()%>
            </a>
        </div>
        <% }%>
    </div>
    <div class="comments_container">
        <%
            List<CommentVO> commentList = (List<CommentVO>) request.getAttribute("commentList");
            for (CommentVO comment : commentList){
        %>
        <div class="comment_row">
            <div class="comment_date"><%=comment.getCreatedAt()%></div>
            <div><%=comment.getContent()%></div>
        </div>
        <% } %>
        <div>
            <form method="post" action=<%=request.getContextPath()%>/commentInsert.action?id=<%=article.getArticleId()%> name="uploadComment">
                <input name="new_comment" class="comment_input" type="text" placeholder="댓글을 입력해주세요" />
                <input type="submit" class="save_button" value="저장" />
            </form>
        </div>
    </div>
    <div class="button_set_container">
        <div class="button_set">
            <a onclick="history.back();" class="list_button">목록</a>
            <a class="modi_del_btn">수정</a>
            <a class="modi_del_btn">삭제</a>
        </div>
    </div>
</div>
</body>
</html>
