//导入http内置模块
var http = require("http");
//创建一个服务
http.createServer(function (request, response) {
    //设置响应状态码
    //设置头信息
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.end("hello node \n");
    //监听一个端口
}).listen(8888);
