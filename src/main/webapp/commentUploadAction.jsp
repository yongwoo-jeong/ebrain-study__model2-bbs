<%@ page import="comment.Comment" %>
<%@ page import="java.util.Objects" %>
<%@ page import="comment.CommentDAO" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/18
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
    String contentComment;
    Integer postId;
    contentComment = request.getParameter("upload");
    postId = Integer.parseInt(request.getParameter("id"));
    if(contentComment == ""){
        // 자바스크립트로만 처리해줘도 괜찮을것같기도..
    }
    Comment co = new Comment();
    co.setPost_id(postId);
    co.setContent(contentComment);

    CommentDAO commentDAO = new CommentDAO();
    try {
        commentDAO.insertComment(co);
    } catch (Exception e){
        e.printStackTrace();
    } finally {
        response.sendRedirect("/post?id="+postId);
    }

 %>

</body>
</html>
