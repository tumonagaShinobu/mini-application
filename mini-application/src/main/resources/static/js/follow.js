'use strict'

function followUser (followId) {
    let followUser = { followingId : followId};
    let csrfToken = document.head.querySelector("[name=_csrf][content]").content;
    let csrfHeader = document.head.querySelector("[name=_csrf_header][content]").content;
    console.log(csrfToken);
    console.log(csrfHeader);
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onload = function () {
        console.log(xmlHttpRequest.response);
        if(xmlHttpRequest.status == 200 && xmlHttpRequest.readyState == 4) {
            if(JSON.parse(xmlHttpRequest.response).success == true){
                var content = document.getElementById(followId + 'Follow').textContent;
                document.getElementById(followId + 'Follow').textContent　= content + 'のフォローに成功しました';
            } else {
                window.alert('フォローに失敗しました');
            }
        }
    };

    xmlHttpRequest.addEventListener('error', function() {
        window.alert('予期せぬエラーでフォローに失敗しました');
    }, false);

    xmlHttpRequest.open('POST', '/follow', true);
    xmlHttpRequest.setRequestHeader('content-type', 'application/json');
    xmlHttpRequest.setRequestHeader(csrfHeader, csrfToken);
    xmlHttpRequest.send(JSON.stringify(followUser));

}