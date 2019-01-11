
var bashAccountIp = "127.0.0.1";
var bashAccountPort = "8031";
var bashStoragePort = "8041";
var bashCoursePort = "8061";

//账号管理服接口调用
var bashAccountUrl = "http://"+bashAccountIp+":"+bashAccountPort+"/account/";
var bashUserUrl = "http://"+bashAccountIp+":"+bashAccountPort+"/user/";
var bashOrgUrl = "http://"+bashAccountIp+":"+bashAccountPort+"/org/";
var bashRoleUrl = "http://"+bashAccountIp+":"+bashAccountPort+"/role/";

//存储服务接口调用
var bashStorageUrl = "http://"+bashAccountIp+":"+bashStoragePort+"/file/";

//课程管理服务接口调用
var bashCourseUrl = "http://"+bashAccountIp+":"+bashCoursePort+"/course/";

var user = null;

var random = "0000";

var nginxIp = "127.0.0.1";

var user = null;