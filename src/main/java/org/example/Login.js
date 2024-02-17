document.getElementById('loginForm').onsubmit = function(event) {
    event.preventDefault();

    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/login"; // 后端服务器的URL
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    var data = JSON.stringify({
        "username": document.getElementById('username').value,
        "password": document.getElementById('password').value
    });

    xhr.onreadystatechange = function () {
        if (xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            alert(json.result); // 显示登录结果
        } else {
           alert("You Catch a Bug!! " + xhr.status);
        }
    };

    xhr.send(data);
};
