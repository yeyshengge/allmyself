var path = require("path");
//exports 就是 module.exports，
// 但是这里直接是赋值，所以不能直接使用exports，否则exports就不是module.exports了
module.exports = {
    //js入口
    entry: './src/main.js',
    output: {
        //__dirname 是node的一个全局变量，获得当前文件所在目录的完整目录名
        //两根杠
        path: path.resolve(__dirname, './dist'),
        //给生成的js文件取名
        filename: 'bundle.js'
    },
    module:{
        rules : [
            {
                test:/\.css$/,
                use:["style-loader","css-loader"]
            }
        ]
    }
};