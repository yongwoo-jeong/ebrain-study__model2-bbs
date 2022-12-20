<%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/13
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/upload.css">
    <script type="text/javascript" defer src="js/uploadJS.js"></script>
    <title>게시판 - 등록</title>
</head>
<body>
<header class="title"><h1>게시판 - 등록</h1></header>
<main>
    <%-- HTML 태그 이외 서버상 제한 처리 필요 - writer, password, title, contet --%>
    <form enctype="multipart/form-data" method="post" action=<%=request.getContextPath()%>/postUploadAction.jsp name="upload">
        <div class="upload_form_container">
            <div class="category_row container_row">
                <div><span>카테고리 *</span></div>
                <div>
                    <label for="category"></label>
                    <select name="category" id="category" required>
                        <option value="" selected>카테고리 선택</option>z
                        <option value="JAVA">JAVA</option>
                        <option value="Javascript">Javascript</option>
                        <option value="Database">Database</option>
                    </select>
                </div>
            </div>
            <div class="writer_row container_row">
                <div><span>작성자 *</span></div>
                <div><input name="writer" type="text" minlength="3" maxlength="4" required/></div>
            </div>
            <div class="password_row container_row">
                <div><span>비밀번호 *</span></div>
                <div>
                    <input class="password" name="password" placeholder="비밀번호" type="password" minlength="4" maxlength="15" required/>
                    <input class="password_confirm" name="password_confirm" placeholder="비밀번호 확인" type="password" minlength="4" maxlength="15" required/>
                </div>
            </div>
            <div class="title_row container_row">
                <div><span>제목 *</span></div>
                <div><input name="title" type="text" minlength="4" maxlength="100" required/></div>
            </div>
            <div class="content_row container_row">
                <div><span>내용 *</span></div>
                <div><input name="content" type="text" minlength="4" maxlength="2000" required/></div>
            </div>
            <div class="attach_file_row container_row">
                <div><span>파일첨부</span></div>
                <div class="filebox_container">
                    <div class="filebox">
                        <input class="upload_name1" />
                        <label for="file1">파일 찾기</label>
                        <input type="file" name="file" id="file1" />
                    </div>
                    <div class="filebox">
                        <input class="upload_name2" />
                        <label for="file2">파일 찾기</label>
                        <input type="file" name="file" id="file2" />
                    </div>
                    <div class="filebox">
                        <input class="upload_name3" />
                        <label for="file3">파일 찾기</label>
                        <input type="file" name="file" id="file3" />
                    </div>
                </div>
            </div>
        </div>
        <div class="button_container">
            <a href="index.jsp" class="cancel_button">취소</a>
            <input type="submit" class="save_button" value="저장" />
        </div>
    </form>
</main>
<script>

</script>
</body>
</html>
