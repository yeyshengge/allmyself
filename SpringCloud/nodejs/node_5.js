//导入http内置模块
var http = require("http");
http.createServer(function (request, response) {

    response.writeHead(200, {"Content-type": "text/plain"});
    for (var i = 0; i < 10; i++) {
        response.write("hello node");
    }
    //该方法用来结束响应，不然客户端一直等待响应是否完成
    response.end();
}).listen(8888);