<%--
  Created by IntelliJ IDEA.
  User: GHJ
  Date: 2023-05-10
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


테스트 함수로 넘어옴

<div class="container">

    <div class="py-5 text-center">
        <h2>게시판</h2>
    </div>


    <div style="margin:10% 10% 10% 10%;">
        <!--  파일첨부 -->
        <form  action="/fileSave" method="post"  enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input class="btn btn-primary btn-sm"  type="submit" value="업로드"/>
        </form>
    </div>
</div>

<div class="inputArea">
    <label for="inputImg">이미지</label>
    <input type="file" id="inputImg" name="file"/>
    <div class="select_img"><img src=""/></div>

    <script>
        $("#inputImg").change(function (){
            if(this.files && this.files[0]) {
                var reader = new FileReader();
                reader.onload = function (data) {
                    $(".select_img img").attr("src", data.target.result).width(500);
                }
                reader.readAsDataURL(this.files[0]);
            }
        });

    </script>

</div>


</body>
</html>
