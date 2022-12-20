<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%--<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>--%>
    <link rel="stylesheet" href="css/index.css">
    <meta charset="UTF-8" />
    <title>게시판 - 목록</title>
</head>
<body>
<%
%>
<div class="container">
    <header class="title"><h1>자유 게시판 - 목록</h1></header>
    <div class="search_nav">
        <%-- 날짜 박스 구현 --%>
        <div class="date_select_div">
            <span>등록일</span>
        </div>
        <div class="category_select_div">
            <div class="category_drop_down">
                <form action="" method="post">
                    <label for="category"></label>
                    <select name="category" id="category">
                        <option>전체 카테고리</option>
                        <option value="JAVA">JAVA</option>
                        <option value="Javascript">Javascript</option>
                        <option value="Database">Database</option>
                    </select>
                </form>
            </div>
        </div>
        <div class="search_input_div">
            <div>
                <label>
                    <input type="text" placeholder="검색어를 입력해주세요. (제목 + 작성자 + 내용)" />
                </label></div>
            <input class="button" type="button" value="검색" />
        </div>
    </div>
    <div class="search_outcome">총 512건</div>
    <div class="post_container">
        <div class="post">
            <span>카테고리</span>
            <a class="post_title">제목</a>
            <span>작성자</span>
            <span>조회수</span>
            <span>등록일시</span>
            <span>수정일시</span>
        </div>
<%--        <%--%>
<%--            PostDAO pd = new PostDAO();--%>
<%--            List<Post> ls = pd.selectPostAll();--%>
<%--            for(Post po : ls) {--%>
<%--        %>--%>
<%--        <div class="post">--%>
<%--            <span class="post_category"><%= new FindCategoryId().findCategoryName(po.getCategory_id()) %></span>--%>
<%--            &lt;%&ndash;            <% System.out.println(po.getFile_id());%>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <% if ( true ){%>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <svg></svg>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <%} else {%>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-5 h-5">&ndash;%&gt;--%>
<%--            &lt;%&ndash;              <path fill-rule="evenodd" d="M15.621 4.379a3 3 0 00-4.242 0l-7 7a3 3 0 004.241 4.243h.001l.497-.5a.75.75 0 011.064 1.057l-.498.501-.002.002a4.5 4.5 0 01-6.364-6.364l7-7a4.5 4.5 0 016.368 6.36l-3.455 3.553A2.625 2.625 0 119.52 9.52l3.45-3.451a.75.75 0 111.061 1.06l-3.45 3.451a1.125 1.125 0 001.587 1.595l3.454-3.553a3 3 0 000-4.242z" clip-rule="evenodd" />&ndash;%&gt;--%>
<%--            &lt;%&ndash;            </svg>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <%}%>&ndash;%&gt;--%>
<%--            <a class="post_title" href="/post.jsp?id=<%= po.getPost_id()%>"><%=po.getTitle()%></a>--%>
<%--            <span><%=po.getWriter()%></span>--%>
<%--            <span><%=po.getView()%></span>--%>
<%--            <span><%=po.getCreated_at()%></span>--%>
<%--            <span></span>--%>
<%--        </div>--%>
<%--        <% } %>--%>
    </div>
    <div class="pagination"></div>
    <button class="button upload_button" type="button" onclick="location.href='upload.jsp'">등록</button>
</div>
</body>
</html>
