var http = require("http");
var url = require("url");
http.createServer(function (request, response) {

    //设置响头跟状态码信息
    response.writeHead(200, {"Content-type": "text/plain"});

    //获取参数信息
    //第一个参数为请求地址，参数2：true的话使用query解析参数到一个对象，默认false
    var params = url.parse(request.url, true).query;
    for (var param in params) {
        response.write(param + "=" + params[param]);
    }
    response.end();
}).listen(8888);
console.log("请访问 http://127.0.0.1:8888/");