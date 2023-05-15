///////////////////////////////////////////////////////////////
//      수정 버튼 클릭시 taskInput addEventListener 활성화      //
//////////////////////////////////////////////////////////////
function editTask(num, text) {
    editNum = num;
    isEditTask = true;
    taskInput.value = text;
    taskInput.focus();
    taskInput.classList.add("active");
}

////////////////////////////////////////////////////////////////////////////////////
//      taskInput listener 를 통해 입력값이 들어오면 post 방식으로 controller 연결      //
///////////////////////////////////////////////////////////////////////////////////
taskInput.addEventListener("keyup", e => {
    let userTask = taskInput.value.trim();
    if(e.key == "Enter" && userTask) {
        <!-- 편집으로 들어온 경우가 아닐떄 -->
        if(!isEditTask) {
            var form = document.createElement('form');
            form.setAttribute('method','post');
            form.setAttribute('action', '/main/insert')
            form.setAttribute('enctype', 'multipart/form-data');

            var hidden_id = document.createElement('input');
            hidden_id.setAttribute('type', 'hidden');
            hidden_id.setAttribute('name', 'Id');
            hidden_id.setAttribute('value', loginId);

            var upload_img = document.getElementById("fileUpload");

            var hidden_todo = document.createElement('input');
            hidden_todo.setAttribute('type', 'hidden');
            hidden_todo.setAttribute('name', 'Todo');
            hidden_todo.setAttribute('value', userTask);

            var hidden_done = document.createElement('input');
            hidden_done.setAttribute('type', 'hidden');
            hidden_done.setAttribute('name', 'Done');
            hidden_done.setAttribute('value', 0);

            form.appendChild(upload_img);
            form.appendChild(hidden_id);
            form.appendChild(hidden_todo);
            form.appendChild(hidden_done);

            document.body.appendChild(form);
            form.submit();
        } else {
            // 편집(edit 버튼 클릭)으로 들어온 경우에
            isEditTask = false;
            location.href = "/main/edit?num=" + editNum + "&task=" + userTask;
        }
        taskInput.value = "";
    }
});