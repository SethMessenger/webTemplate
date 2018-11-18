$(document).ready(function(){
    $(".login-btn").click(function(){
    	checkLogin();
	});
}); 
function checkLogin(){
	var accountInput = $("#accountInput").val().trim();
	var pwdInput = $("#pwdInput").val().trim();
	
	if(accountInput.length == 0){
		alert("请输入登录名");
	}else if(pwdInput.length == 0){
        alert("请输入密码");
	}else{
		var user = new Object();
		user.account = accountInput;
		user.pwd = pwdInput;
    	
		//参数传递到后台进行查询
		doLogin(user);
	}
		

}
//参数传递到后台进行查询
function doLogin(userObj){
	//同步访问
	var result = "";
	$.ajax({
		url:'/login/checkLogin',
	    type:'POST',
	    async: false,
	    dataType:'json',
	    data:userObj,
	    success:function(msg){
	    	result = msg;
	    },
	    error:function(msg){
	    	alert(msg);
	    }
	});

	
	if(result.code == "-1"){
        swal({
            title: "登录名或密码错误"
        });
	}else if(result.code == "-2"){
        swal({
            title: "账号只允许单机登录，请重新登录",
            text: "请联系管理员了解单点登录系统"
        });
	}else if(result.code == "0"){
        //跳转到主页
        var userId = result.userId;
        window.location.href = "/content/load/wxcms$content/";
	}else {
        swal({
            title: "系统错误",
            text: "请联系管理员"
        });
	}
}

String.prototype.trim=function(){   
    return this.replace(/(^\s*)|(\s*$)/g, "");    
}