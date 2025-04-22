document.getElementById('loginForm').onsubmit = function(event) {
    event.preventDefault();

    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/login"; // 后端服务器的URL
    // var url = "http://localhost:8080/loginString"; // 后端服务器的URL

    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    var data = JSON.stringify({
        "username": document.getElementById('username').value,
        "password": document.getElementById('password').value
    });

    // console.log(data);
    // console.log(xhr);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                alert(json.result); // 显示登录结果
            } else {
               alert("You Catch a Bug!! " + xhr.status);
            }
        }
    };

    xhr.send(data);
};
