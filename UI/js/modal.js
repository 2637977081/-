// 获取弹窗
var modal = document.getElementById('myModal');

// 获取 <span> 元素，用于关闭弹窗 that closes the modal
var span = document.getElementsByClassName("close")[0];

// 点击 <span> (x), 关闭弹窗
span.onclick = function() {
    modal.style.display = "none";
}

// 在用户点击其他地方时，关闭弹窗
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}