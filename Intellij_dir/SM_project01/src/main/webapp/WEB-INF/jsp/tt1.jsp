<%--
  Created by IntelliJ IDEA.
  User: GHJ
  Date: 2023-05-11
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">

  <div class="py-5 text-center">
    <h2>게시판</h2>
  </div>

  <h3>파일이 업로드 되었습니다.</h3>
<%--  <span>${file.originalFilename}</span>--%>
<%--  <span>${file.contentType}</span>--%>
</div>
<img src="/img_upload/${upload_img.storedFileName}.${upload_img.contentType.split("/")[1]}" alt="icon">

</body>
</html>
