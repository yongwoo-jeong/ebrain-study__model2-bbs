<%@ page import="java.util.List" %>
<%@ page import="article.Article" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <meta charset="UTF-8" />
    <title>게시판 - 목록</title>
</head>
<body>
<% Integer totalArticle = (Integer) request.getAttribute("totalArticle"); %>
<div class="container">
    <header class="title"><h1>자유 게시판 - 목록</h1></header>
    <form method="get" action=<%=request.getContextPath()%>/selectArticles.action>
        <div class="search_nav">
            <div class="date_select_div">
                <span>등록일</span>
                <input type="date" name="start_date"/>
                <span>~</span>
                <input type="date" name="last_date"/>
            </div>
            <div class="category_select_div">
                <div class="category_drop_down">
                    <form action="" method="post">
                        <label for="category"></label>
                        <select name="category" id="category">
                            <option value="">전체 카테고리</option>
                            <option value="JAVA">JAVA</option>
                            <option value="Javascript">Javascript</option>
                            <option value="Database">Database</option>
                        </select>
                    </form>
                </div>
            </div>
            <div class="search_input_div">
                <div>
                    <input type="text" name="keyword" placeholder="검색어를 입력해주세요. (제목 + 작성자 + 내용)" />
                </div>
                <input class="submit" type="submit" value="검색" />
            </div>
        </div>
    </form>
    <div class="search_outcome">총 <%=totalArticle%>건</div>
    <div class="post_container">
        <div class="post">
            <span>카테고리</span>
            <a class="post_title">제목</a>
            <span>작성자</span>
            <span>조회수</span>
            <span>등록일시</span>
            <span>수정일시</span>
        </div>
        <%
            // articles 데이터 가져오기
            List<Article> articles = (List<Article>) request.getAttribute("selectedArticles");
            // 첫 접속으로 articles 가 불러와지지 않았을때
			if(articles == null){ %>
                <%-- 서블릿에서 받아올수있도록 getArticles.action으로 포워딩           --%>
                <jsp:forward page="/selectArticles.action" />
            <%} %>
            <% for(Article article : articles) {
        %>
        <div class="post">
            <span class="post_category"><%= article.getCategoryId() %></span>
            <%--            <% System.out.println(po.getFile_id());%>--%>
            <%--            <% if ( true ){%>--%>
            <%--            <svg></svg>--%>
            <%--            <%} else {%>--%>
            <%--            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" class="w-5 h-5">--%>
            <%--              <path fill-rule="evenodd" d="M15.621 4.379a3 3 0 00-4.242 0l-7 7a3 3 0 004.241 4.243h.001l.497-.5a.75.75 0 011.064 1.057l-.498.501-.002.002a4.5 4.5 0 01-6.364-6.364l7-7a4.5 4.5 0 016.368 6.36l-3.455 3.553A2.625 2.625 0 119.52 9.52l3.45-3.451a.75.75 0 111.061 1.06l-3.45 3.451a1.125 1.125 0 001.587 1.595l3.454-3.553a3 3 0 000-4.242z" clip-rule="evenodd" />--%>
            <%--            </svg>--%>
            <%--            <%}%>--%>
            <a class="post_title" href="/post.jsp?id=<%= article.getArticleId()%>"><%=article.getTitle()%></a>
            <span><%=article.getWriter()%></span>
            <span><%=article.getView()%></span>
            <span><%=article.getCreatedAt()%></span>
            <span></span>
        </div>
        <% } %>
    </div>
    <div class="pagination">
<%--        <%  String currentPage = (String) request.getAttribute("currentPage");--%>
<%--            String lastPage = (String) request.getAttribute("lastPage");--%>
<%--            System.out.println(currentPage);--%>
<%--            System.out.println(lastPage);--%>
<%--            for (int i = 1; i<=10; i++){%>--%>
<%--        <a  <%=(i == Integer.parseInt(currentPage)) ? "style=color: red'" : "" %> href=<%=request.getContextPath()%>index.jsp?page=<%=i%><%=request.getAttribute("urlWithParam")%>>1</a>--%>
<%--        }%>--%>
    </div>
    <button class="button upload_button" type="button" onclick="location.href='newArticleInput.jsp'">등록</button>
</div>
</body>
</html>
