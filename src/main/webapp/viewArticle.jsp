<%@ page import="articleVO.ArticleVO" %>
<%@ page import="commentVO.CommentVO" %>
<%@ page import="java.util.List" %>
<%@ page import="comment.CommentVO" %>
<%@ page import="article.ArticleVO" %><%--
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
    ArticleVO articleVO = (ArticleVO) request.getAttribute("articleVO");
%>
<div class="container">
<header class="header">게시판 - 보기</header>
<div class="writer_time_row">
    <div class="writer_div">
        <span><%=articleVO.getWriter()%></span>
    </div>
    <div>
        <span>등록일시</span>
        <% if (articleVO.getModifiedAt() == null){%>
            <span><%=articleVO.getCreatedAt()%></span>
        <%} else {%>
            <span><%=articleVO.getCreatedAt()%></span>
            <span>수정일시</span>
            <span><%=articleVO.getModifiedAt()%></span>
        <%}%>
    </div>
</div>
    <div class="title_row">
        <div>
            <% if (articleVO.getCategoryId() == 1) {%>
                <span>[JAVA]</span>
            <% } else if (articleVO.getCategoryId() == 2) { %>
                <span>[Javascript]</span>
            <% } else if (articleVO.getCategoryId() == 3) {%>
                <span>[JAVA]</span>
            <% } %>
            <span><%=articleVO.getTitle()%></span>
        </div>
        <div class="view">
            <span>조회수: </span>
            <span><%=articleVO.getView()%></span>
        </div>
    </div>
    <div class="post_container">
        <p><%=articleVO.getContent()%></p>
    </div>
    <div class="file_container">
<%--        <% if (po.getFile_id() == 0){%>--%>
<%--        <%} else {%>--%>
        <a>첨부파일 있을경우 이름</a>
<%--        <%}%>--%>
    </div>
    <div class="comments_container">
        <%
            List<CommentVO> commentVOList = (List<CommentVO>) request.getAttribute("commentVOList");
            for (CommentVO commentVO : commentVOList){
        %>
        <div class="comment_row">
            <div class="comment_date"><%=commentVO.getCreatedAt()%></div>
            <div><%=commentVO.getContent()%></div>
        </div>
        <% } %>
        <div>
        <%-- 굳이 포스트방식으로해야하나?--%>
            <form method="post" action=<%=request.getContextPath()%>/commentInsert.action?id=<%=articleVO.getArticleId()%> name="uploadComment">
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
