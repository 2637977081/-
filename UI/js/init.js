
var bashIp = "127.0.0.1";
var bashAccountPort = "8031";
var bashStoragePort = "8041";
var bashCoursePort = "8061";

//账号管理服接口调用
var bashAccountUrl = "http://"+bashIp+":"+bashAccountPort+"/account/";
var bashUserUrl = "http://"+bashIp+":"+bashAccountPort+"/user/";
var bashOrgUrl = "http://"+bashIp+":"+bashAccountPort+"/org/";
var bashRoleUrl = "http://"+bashIp+":"+bashAccountPort+"/role/";

//存储服务接口调用
var bashStorageUrl = "http://"+bashIp+":"+bashStoragePort+"/file/";

//课程管理服务接口调用
var bashCourseUrl = "http://"+bashIp+":"+bashCoursePort+"/course/";
var bashLessonUrl = "http://"+bashIp+":"+bashCoursePort+"/lesson/";
var bashTeachUrl = "http://"+bashIp+":"+bashCoursePort+"/teach/";

var user = null;

var random = "0000";

var nginxIp = "127.0.0.1";

var user = null;