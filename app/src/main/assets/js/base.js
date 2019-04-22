var apiUrl ='http://47.98.126.71:8006';
var imgUrl = "http://47.98.126.71:8006";
var wwwUrl = "http://47.98.126.71:8006";
var kj={
	post: function (c) {
        var config = {
            type: "POST",
            cache: false,
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            autoPrefix: true,
            timeout:3 * 60 * 1000,
            //调用执行后调用的函数
//          complete: function (XMLHttpRequest, textStatus) {
//              if(textStatus == 'timeout'){
//                  alert('请求超时','请求超时',5);
//              }
//          }
        };
        
        $.ajax(config);
    },
    get: function (c) {
        var config = {
            type: "GET",
            cache: false,
            contentType: "application/json",
            dataType: "json",
            autoPrefix: true,
            timeout:3 * 60 * 1000,
            //调用执行后调用的函数
//          complete: function (XMLHttpRequest, textStatus) {
//              if(textStatus == 'timeout'){
//                  alert('请求超时','请求超时',5);
//              }
//          }
        };      
        $.ajax(config);
    }
}
