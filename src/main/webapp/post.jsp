<%@ page import="post.PostDAO" %>
<%@ page import="post.Post" %><%--
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
    String id = request.getParameter("id");
    PostDAO pd = new PostDAO();
    Post po = pd.selectPost(Integer.parseInt(id));
%>
<div class="container">
<header class="header">게시판 - 보기</header>
<div class="writer_time_row">
    <div class="writer_div">
        <span><%=po.getWriter()%></span>
    </div>
    <div>
        <span>등록일시</span>
        <% if (po.getModified_at() == null){%>
            <span><%=po.getCreated_at()%></span>
        <%} else {%>
            <span><%=po.getCreated_at()%></span>
            <span>수정일시</span>
            <span><%=po.getModified_at()%></span>
        <%}%>
    </div>
</div>
    <div class="title_row">
        <div>
            <% if (po.getCategory_id() == 1) {%>
                <span>[JAVA]</span>
            <% } else if (po.getCategory_id() == 2) { %>
                <span>[Javascript]</span>
            <% } else if (po.getCategory_id() == 3) {%>
                <span>[JAVA]</span>
            <% } %>

            <span><%=po.getTitle()%></span>
        </div>
        <div class="view">
            <span>조회수: </span>
            <span><%=po.getView()%></span>
        </div>
    </div>
    <div class="post_container">
        <p><%=po.getContent()%></p>
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
            <form method="post" action=<%=request.getContextPath()%>/commentUploadAction.jsp?id=<%po.getPost_id();%> name="upload">
                <input class="comment_input" type="text" placeholder="댓글을 입력해주세요" />
                <input type="submit" class="save_button" value="저장" />
            </form>
        </div>
    </div>
    <div class="button_set_container">
        <div class="button_set">
            <a href="index.jsp" class="list_button">목록</a>
            <a class="modi_del_btn">수정</a>
            <a class="modi_del_btn">삭제</a>
        </div>
    </div>
</div>
</body>
</html>
