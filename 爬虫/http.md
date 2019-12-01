# HTTP

## 简介

HTTP协议是Hyper Text Transfer Protocol（超文本传输协议）的缩写,是用于从万维网（WWW:World Wide Web ）服务器传输超文本到本地浏览器的传送协议。HTTP基于**TCP/IP通信协议**来传递数据（HTML 文件, 图片文件, 查询结果等）。

## 工作原理

HTTP协议工作于客户端-服务端机构上。浏览器作为HTTP客户端通过URL向HTTP服务端即Web服务器发送所有请求。Web服务器根据收到的请求，响应给客户端。HTTP默认端口号为80。

注意事项：

- HTTP是无连接，即每次连接限制处理一个请求，处理完成，响应给客户端后，即断开连接。节省传输时间。