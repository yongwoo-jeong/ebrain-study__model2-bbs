<%@ page import="article.Article" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/14
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/post.css">
    <title>Title</title>
</head>
<body>
<%
    Article article = (Article) request.getAttribute("article");
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
<%--        <% if (po.getFile_id() == 0){%>--%>
<%--        <%} else {%>--%>
        <a>첨부파일 있을경우 이름</a>
<%--        <%}%>--%>
    </div>
    <div class="comments_container">
        <div class="comment_row">
            <div>시간</div>
            <div>댓글내용</div>
        </div>
        <div>
            <form method="post" action=<%=request.getContextPath()%>/commentUploadAction.jsp?id=<%article.getArticleId();%> name="upload">
                <input class="comment_input" type="text" placeholder="댓글을 입력해주세요" />
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