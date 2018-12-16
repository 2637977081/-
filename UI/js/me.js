   
//存储cookie
function setCookie(name,value){
    var exdate = new Date();
    exdate.setTime(exdate.getTime()+24*60*60*1000);
    document.cookie=name + "=" +escape(value) +"; expires="+exdate.toGMTString() +";Path="+escape("/");
    console.log("cookie",document.cookie);
}

//获取cookie
function getCookie(name){
    console.log("cookie",document.cookie);
    if (document.cookie.length > 0) {
        var begin = document.cookie.indexOf(name + '=')
        console.log("begin",begin);
        if (begin !== -1) {
            begin += name.length + 1 // cookie值的初始位置
            var end = document.cookie.indexOf(';', begin) // 结束位置
            if (end === -1) {
                end = document.cookie.length // 没有;则end为字符串结束位置
            }
            console.log("end",end);
            return unescape(document.cookie.substring(begin, end))
        }
        
    }
    return null;
}

//删除指定cookie
function delCookie (name) {
    var exp = new Date()
    exp.setTime(exp.getTime() - 1)
    var cval = setCookie(name)
    if (cval && cval != null) {
      document.cookie = name + '=' + cval + ';expires=' + exp.toGMTString()
    }
}

//清除所有cookie
function clearCookie () {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g)
    if (keys) {
      for (var i = keys.length; i--;) {
        document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
      }
    }
  }