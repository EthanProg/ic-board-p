#ic-board
取集成电路板的意思。希望它能集成各种各样的功能，但是还能保持微小、高效、简单的特性,拭目以待吧！


##Todo
* 用户管理
* 权限管理
* 菜单管理
* 移动端


##编码规范
* [腾讯前端编码规范](http://alloyteam.github.io/code-guide/)
* [Google Java 编码规范](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html) [中文翻译版](http://www.cnblogs.com/lanxuezaipiao/p/3534447.html)


##前端包管理、构建
接入了前端包管理（bower）、构建（grunt）工具。主要的配置文件为package.json、Gruntfile.js、bower.json文件。
如果成员进行前端开发，必须了解这几个工具的使用并学会配置。后端开发不强制了解。

####package.json
nodejs的配置文件，主要用于一些管理、构建工具下载

####Gruntfile.js
前端构建配置文件，进行js、css、图片等的压缩、合并。压缩规则、合并规则等都在此进行配置。

####bower.json 
前端包管理，比如：jQuery、Angularjs、RequireJs、Bootstrap以及其他的插件。随着未来前端功能的复杂性，所需要的插件会越来越多，引入包管理器会方便管理。

####本地接入
1. 安装[Nodejs](http://www.nodejs.org/) ,并配置环境变量
2. 在项目所在目录，安装前端所需的所有工具，执行：
```shell
npm install
```

3. 开启grunt watch监控js、css等的变化
> 实际编码js等可以分开编码，但是页面引用直接引用压缩合并后的文件。watch的功能就是随时监控分开的各个文件，进行合并






------------------------------
##参考资料
* [Spring Framework](http://spring.io)
* [AngularJS](https://angularjs.org/)	前端的MVVM框架
* [RequireJS](http://www.requirejs.org/)  按需异步加载js
* [BootStrap](http://getbootstrap.com/)	

##一些建议
每个团队成员都可以在此写下一些个人对团队一切有益的建议（排名不分先后）
####Charles
* 建议每个人花费半小时时间了解markdown语法，使用markdown进行文档编写

####Ethan

####逐鹿幸福

