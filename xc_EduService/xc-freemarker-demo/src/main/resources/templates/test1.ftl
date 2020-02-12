<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf‐8">
    <title>Hello World!</title>
</head>
<body>
<#--  注释方法
Hello ${name}!
-->
hi ${name}!
遍历list
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>金额</td>
        <td>日期date</td>
        <td>日期time</td>
        <td>日期datetime</td>
    </tr>
    <#if stus?? >
        <#list stus as item>
            <tr>
                <td>${item_index}</td><!--获取索引-->
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.money}</td>
                <td>${item.birthday?date}</td>
                <td>${item.birthday?time}</td>
                <td>${item.birthday?datetime}</td>
                <td>${item.birthday?string('yyyy年MM月dd日')}</td>

            </tr>
        </#list>
    </#if>
</table>
学生的个数${stus?size}<!--获取集合长度--></br>
学生的个数${stuMap?size}<!--获取集合长度--></br>

获取map
<#--第一种方法 ['']该方式可以遍历map获得key的集合 -->
姓名：${(stuMap['stu1'].name)!'默认值'}</br>
<#--第二种方法 -->
姓名：${stuMap.stu2.name}</br>
遍历map</br>
<#list stuMap?keys as k>
    姓名: ${stuMap[k].name} </br>
<#-- 姓名: ${stuMap.k.name} </br> 是错误的-->
</#list>
if指令</br>
<#if stus ??>
    <#list stus as item>
        <table>
            <tr>
                <td <#if item.name == '小红'>style="background-color: pink" </#if>>${item.name}</td>
                <td>${item.age}</td>
                <#--<td <#if item.money>600>style="background-color: pink"</#if>>${item.money}</td> 不可以这么使用-->
                <td <#if item.money gt 600>style="background-color: pink"</#if>>${item.money}</td>
                <!--可以用大括号-->
                <td <#if (item.money > 600)>style="background-color: pink"</#if>>${item.money}</td>
            </tr>
        </table>
    </#list>
</#if>
获取point: ${point}</br> <#--获取point: 123,456,789 默认带逗号-->
字符串化point : ${point?c}</br>
json</br>
<#assign text="{'username':'zhangsan','bank':'中国工商银行'}"/>
    <#assign data=text?eval/>
${data.username}--${data.bank}


</body>
</html>