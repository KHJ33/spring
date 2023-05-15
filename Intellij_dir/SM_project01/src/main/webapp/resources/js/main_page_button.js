/////////////////////////////////////////////////////////////////
// Completed 메뉴 부분에 날짜 입력되면 post 방식으로 controller 보냄 //
////////////////////////////////////////////////////////////////
function date() {
    var start_date = document.querySelector("#start_date").value
    var end_date = document.querySelector("#end_date").value

    var form = document.createElement('form');
    form.setAttribute('method','post');
    form.setAttribute('action', '/main/period')

    var hidden_start_date = document.createElement('input');
    hidden_start_date.setAttribute('type', 'hidden');
    hidden_start_date.setAttribute('name', 'start_date');
    hidden_start_date.setAttribute('value', start_date);

    var hidden_end_date = document.createElement('input');
    hidden_end_date.setAttribute('type', 'hidden');
    hidden_end_date.setAttribute('name', 'end_date');
    hidden_end_date.setAttribute('value', end_date);

    form.appendChild(hidden_start_date);
    form.appendChild(hidden_end_date);

    document.body.appendChild(form);
    form.submit();
}

//////////////////////////////////////////////////////////////////
//      삭제(delete) 버튼 클릭시 primary key 를 get 방식으로 보냄    //
/////////////////////////////////////////////////////////////////
function deleteTask(deleteNum) {
    location.href = "/main/delete?num="+deleteNum;
}

////////////////////////////////////////////////////////////////////
//      체크박스 클릭시 금일 날짜를 post 방식으로 controller 로 보냄    //
//////////////////////////////////////////////////////////////////
function updateStatus(num, done) {
    const date = new Date();

    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);
    const dateStr = year + '-' + month + '-' + day;

    console.log(dateStr);
    console.log(num);

    var form = document.createElement('form');
    form.setAttribute('method','post');
    form.setAttribute('action', '/main/updateStatus')

    var hidden_num = document.createElement('input');
    hidden_num.setAttribute('type', 'hidden');
    hidden_num.setAttribute('name', 'Num');
    hidden_num.setAttribute('value', parseInt(num));

    var hidden_completed_date = document.createElement('input');
    hidden_completed_date.setAttribute('type', 'hidden');
    hidden_completed_date.setAttribute('name', 'Completed_date');
    hidden_completed_date.setAttribute('value', dateStr);

    var hidden_done = document.createElement('input');
    hidden_done.setAttribute('type', 'hidden');
    hidden_done.setAttribute('name', 'Done');
    hidden_done.setAttribute('value', done);

    form.appendChild(hidden_num);
    form.appendChild(hidden_completed_date);
    form.appendChild(hidden_done);

    document.body.appendChild(form);
    form.submit();
}

///////////////////////////////////////////////////////////////////
//      filter 버튼 구현 , 각각의 버튼 클릭시 해당되는 값을 보여줌      //
/////////////////////////////////////////////////////////////////
filters.forEach(btn => {
    btn.addEventListener("click", () => {
        document.querySelector("span.active").classList.remove("active");
        btn.classList.add("active");

        // location.href = "/main/filters?id="+btn.id;
        let f = document.createElement('form');
        f.setAttribute('method', 'post');
        f.setAttribute('action', '/main/')

        let obj;
        obj = document.createElement('input');
        obj.setAttribute('type', 'hidden');
        obj.setAttribute('name', 'check_filter');
        obj.setAttribute('value', btn.id);

        f.appendChild(obj);

        document.body.appendChild(f);
        f.submit();
    });
});