function out(i) {
    var v = i.validity;
    if (true === v.valueMessing) {
        i.setCustomValidity("请填写该字段");
    } else {
        if (true === v.patternMismatch) {
            i.setCustomValidity("请输入8位数字的学号");
        } else {
            i.setCustomValidity("");
        }
    }
}

function toggle(sDivId) {
    var oDiv = document.getElementById(sDivId);
    oDiv.style.display = (oDiv.style.display == "none") ? "block" : "none";
}

function openwindow(file) {
    window.open(file, 'intro', 'height:489,width=719,top=100,left=100, resizable=no,scrollable=no');
}

function initConfirmPassword() {
    var elem = document.getElementById("password2");
    elem.addEventListener("blur", verifyPassword);
    /*这里函数的参数input其实就是事件，可以用evt，这里用input主要是方便看懂*/
    function verifyPassword(input) {
        input = input.srcElement;
        var primaryPassword = document.getElementById('password').value;

        if (input.value != primaryPassword) {
            // the provided value doesn't match the primary email address
            input.setCustomValidity('密码和确认密码不匹配！');
        } else {
            input.setCustomValidity('');
        }

    }
}

function addiframe(type) {
    var container = document.getElementById("container");
    try {
        container.removeChild(document.getElementById("iframepage"));
    } catch (e) {}
    var iframe = document.createElement("iframe");
    if (type == 'java') {
        iframe.src = "abc.jsp";
    } else if (type == 'net') {
        iframe.src = "def.jsp";
    } else {
        iframe.src = "adg.jsp";
    }
    iframe.id = "iframepage";
    iframe.width = "100%";
    iframe.frameBorder = "0";
    iframe.height = "400px";
    iframe.scrolling = "no";
    container.appendChild(iframe);

}

function openapply() {
    var oDiv1 = document.getElementById("apply-form-ip");
    var oDiv2 = document.getElementById("ps-info");
    oDiv1.style.display = "block";
    oDiv2.style.display = "none";
}

function closeapply() {
    var oDiv1 = document.getElementById("apply-form-ip");
    var oDiv2 = document.getElementById("ps-info");
    oDiv1.style.display = "none";
    oDiv2.style.display = "none";
}

function toggleapply() {
    var oDiv1 = document.getElementById("apply-form-ip");
    var oDiv2 = document.getElementById("ps-info");
    oDiv1.style.display = "none";
    oDiv2.style.display = "block";
}

function previewFile() {
    var preview = document.getElementById('head-img');
    var file = document.querySelector('input[type=file]').files[0];
    var reader = new FileReader();

    reader.onloadend = function() {
        preview.src = reader.result;
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }
}

function isImage(type) {
    switch (type) {
        case 'image/jpeg':
        case 'image/png':
        case 'image/gif':
        case 'image/bmp':
        case 'image/jpg':
            return true;
        default:
            return false;
    }
}

function handleFileSelect(evt) {
    evt.stopPropagation();
    evt.preventDefault();

    var files = evt.dataTransfer.files;
    var file = files[files.length - 1];
    var isImg = isImage(file.type),
        reader = new FileReader();
    if (isImg) {
        reader.onload = function() {
            preview.src = reader.result;
        };
        reader.readAsDataURL(file);
    } else {
        alert("这不是图片");
    }

}

function handleDragOver(evt) {
    evt.stopPropagation();
    evt.preventDefault();
}

function closeall() {
    var oTable1 = document.getElementById('11-fall');
    var oTable2 = document.getElementById('12-fall');
    var oTable3 = document.getElementById('13-fall');
    var oTable4 = document.getElementById('14-fall');
    oTable1.style.display = "none";
    oTable2.style.display = "none";
    oTable3.style.display = "none";
    oTable4.style.display = "none";
}

function showme(oTableid) {
    var arr = new Array('11-fall', '12-fall', '13-fall', '14-fall');
    for (var i = 0; i < 4; i++) {
        if (oTableid == arr[i]) {
            document.getElementById(arr[i]).style.display = "block";
            continue;
        }
        document.getElementById(arr[i]).style.display = "none";
    }
}

function initConfirmDateTime() {
    var elem = document.getElementById("endtime");
    elem.addEventListener("blur", function verifyDateTime(input) {
        input = input.srcElement;
        var begintime = document.getElementById('begintime').value;
        if (input.value != begintime) {
            input.setCustomValidity('截止时间应该大于起始时间！');
        } else {
            input.setCustomValidity('');
        }
    });
}

function adjust() {
    var objs = document.getElementsByTagName("input");
    for (var i = 0; i < objs.length; i++) {
        if (objs[i].type == "text" || objs[i].type == "number" || objs[i].type == "email") {
            objs[i].style.width = "240px";
        }
    }
}
