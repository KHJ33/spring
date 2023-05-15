/////////////////////////////////////////////////////////
//      ... 버튼 클릭시 수정 버튼과 삭제 버튼이 보여짐       //
////////////////////////////////////////////////////////
function showMenu(selectedTask, num) {

    let menuDiv = selectedTask.parentElement.lastElementChild
    menuDiv.classList.add("show");

    document.addEventListener("click", e => {
        if(e.target.id != "b"+num ) {
            menuDiv.classList.remove("show");
        }
    });
}

///////////////////////////////////////////////////////////////
//      image 버튼 클릭시 primary key 해당되는 이미지 업로드      //
//////////////////////////////////////////////////////////////
function showImg(selectedImg, img_fileName, num) {
    if(!check_imgUpload) {
        document.getElementById("upload-img").src = "/img_upload/"+img_fileName;
        document.getElementById("upload-img").style.display="";
        // document.getElementById("upload-img").style.width = "300px";
        // document.getElementById("upload-img").style.height = "300px";
        check_imgUpload = true;
    } else {
        check_imgUpload = false;
        document.getElementById("upload-img").src = "";
        document.getElementById("upload-img").style.display="none";
    }
}