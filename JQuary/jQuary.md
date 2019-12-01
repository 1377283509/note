### jQuery简介

- jQuery是一个JavaScript库
- jQuery极大的简化了JavaScript编程
- jQuery可以通过一行简单的标记备添加到网页中
- jQuery包含一下特性：
  - HTML元素选取
  - HTML元素操作
  - CSS操作
  - HTML事件函数
  - JavaScript特效和动画
  - HTML DOM遍历和修改
  - AJAX
  - Utilities

### 向页面中添加jQuery库

jQuery库位于一个JavaScript文件中，其中包含了所有的jQuery函数。

可通过下面的标记把jQuery添加到网页中。

```html
<head>
	<script type="text/javascript" src="jquery.js"></script>
</head>
```

<script>标签应该位于<head>部分。

### 小实例

```html
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").click(function(){
			$("p").hide();
		});
	});
</script>
</head>

<body>
	<h2>This is a heading</h2>
	<p>This is a paragraph.</p>
	<p>This is another paragraph.</p>
	<button type="button">Click me</button>
</body>
</html> 

```



------

### jQuery语法

通过jQuery，可以选取（查询，query）HTML元素，并对它们执行“操作”（actions）。 

```javascript
/* 基础语法:
	$(selector).action()
	-美元符号定义jQuery
	-选择符（selector）“查询”和“查找”HTML元素
	-jQuery的action()执行对元素的操作
*/
/* 示例 */
$(this).hide()  /* 隐藏当前元素 */ 
$("p").hide()   /* 隐藏所有段落 */
$(".class").hide()   /* 隐藏class="class"的元素 */
$("#class").hide()   /* 隐藏id="class"的元素 */
```

### 文档就绪函数

```javascript
$(document).ready(function(){
	/* jQuery functions go here */
})；
```

目的：为了防止文档在完全加载（就绪）前运行jQuery代码。

如果在文档没有完全加载之前就运行函数，操作可能失败。

下面是两个具体的例子：

- 试图隐藏一个不存在的元素
- 获得未完全加载的图像的大小

------

### jQuery选择器

#### jQuery元素选择器

```javascript
/* jQuery 使用 CSS 选择器来选取 HTML 元素。*/
$("p") 				/* 选取 <p> 元素。*/
$("p.intro") 		/* 选取所有 class="intro" 的 <p> 元素。*/
$("p#demo") 		/* 选取所有 id="demo" 的 <p> 元素。*/
$("div#intro .head") /* id="intro" 的 <div> 元素中的所有 class="head" 的元素*/
$(this) 			/* 当前元素 */
```

#### jQuery属性选择器

```javascript
/* jQuery 使用 XPath 表达式来选择带有给定属性的元素。*/
$("[href]") 		/* 选取所有带有 href 属性的元素。*/
$("[href='#']") 	/* 选取所有带有 href 值等于 "#" 的元素。*/
$("[href!='#']") 	/* 选取所有带有 href 值不等于 "#" 的元素。*/
$("[href$='.jpg']") /* 选取所有 href 值以 ".jpg" 结尾的元素。*/
```

#### jQuery CSS选择器

```javascript
/* jQuery CSS 选择器可用于修改HTML元素的CSS属性。 */
$("p").css("background-color","red") /* 将所有p元素的北京更改为红色 */
```

------

### jQuery事件

jQuery是为事件处理特别设计的。

#### jQuery事件函数

jQuery 事件处理方法是 jQuery 中的核心函数。事件处理程序指的是当 HTML 中发生某些事件时所调用的方法。术语由事件“触发”（或“激发”）经常会被使用。通常会把 jQuery 代码放到 <head>部分的事件处理方法中：

```html
/* 实例 */
<html>
<head>
	<script type="text/javascript" src="/jquery/jquery.js"></script>
	<script type="text/javascript">
        $(document).ready(function(){
            $("button").click(function(){ /* button被点击调用触发下面的方法：隐藏所有p标签*/
  	          $("p").hide();   
        });
    });
    </script>
</head>

<body>
    <h2>This is a heading</h2>
    <p>This is a paragraph.</p>
    <p>This is another paragraph.</p>
    <button type="button">Click me</button>
</body>
</html> 

```

#### 单独文件中的函数

如果网站包含许多页面，并且您希望 jQuery 函数易于维护，就需要jQuery 函数放到独立的 .js 文件中。

```html
/* 实例 */
<head>
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="my_jquery_functions.js"></script>
</head>
```

#### jQuery名称冲突

jQuery 使用 $ 符号作为 jQuery 的简介方式。 

某些其他 JavaScript 库中的函数（比如 Prototype）同样使用 $ 符号。

jQuery 使用名为 noConflict() 的方法来解决该问题。

```javascript
var jq=jQuery.noConflict() /* 使用jq来代替 $ 符号*/
```

### jQuery效果

#### 显示/隐藏

##### 通过hide()和show()方法来隐藏和显示HYML元素。

```html
<!-- 
语法: 
$("selector").hide(speed,callback); 
$("selector").show(speed,callback);
speed为速度，callback为方法执行完后要执行的函数
-->
<!-- 实例 -->
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#hide").hide()
		$("button").click(function(){
			$("#show").hide(3000);
			$("#hide").show(3000)
		})
	});
</script>
</head>

<body>
	<h2>This is a heading</h2>
	<p id="hide">This is a paragraph.</p>
	<p id="show">This is another paragraph.</p>
	<button type="button">Click me</button>
</body>
</html> 
```

##### jQuery toggle()

通过 jQuery，您可以使用 toggle() 方法来切换 hide() 和 show() 方法。

显示被隐藏的元素，并隐藏已显示的元素：

```html
<!--
语法：
$(selector).toggle(speed,callback);
-->

<!--实例-->
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#hide").hide();
		$("#show").show();
		$("button").click(function(){
			$("p").toggle();
		})
	});
</script>
</head>

<body>
	<h2>This is a heading</h2>
	<p id="hide">This is a paragraph.</p>
	<p id="show">This is another paragraph.</p>
	<button type="button">Click me</button>
</body>
</html> 

```

#### 淡入淡出

jQuery有四种fade方法：

- fadeIn() ：用于淡入已隐藏的应用

- fadeOut()：用于淡出可见元素

- fadeToggle()：在fadeIn和fadeOut间进行切换

  ```html
  <!--
  语法：
  $(selector).fade*(speed,callback);
  speed规定效果的时长，有“slow”，“fast”，和毫秒三种。callback为完成后执行的函数
  -->
  <!--小案例-->
  <html>
  <head>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#hide").hide()
  		$("button").click(function(){
  			$("#hide").fadeIn("fast");
  			$("#show").fadeOut("slow");
  		})
  	});
  </script>
  </head>
  
  <body>
  	<h2>This is a heading</h2>
  	<p id="hide">This is a paragraph.</p>
  	<p id="show">This is another paragraph.</p>
  	<button type="button">Click me</button>
  </body>
  </html> 
  ```

- fadeTo()：渐变为给定的不透明度（值介于 0 与 1 之间）

  ```html
  <!--
  语法：
  $(selector).fadeTo(speed,opacity,callback);
  必需的 speed 参数规定效果的时长。它可以取以下值："slow"、"fast" 或毫秒。
  
  fadeTo() 方法中必需的 opacity 参数将淡入淡出效果设置为给定的不透明度（值介于 0 与 1 之间）。
  
  可选的 callback 参数是该函数完成后所执行的函数名称。
  -->
  <!--小案例-->
  <html>
  <head>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#hide").show()
  		$("#show").hide()
  		$("button").click(function(){
  			$("#hide").fadeTo("slow",0.5);
  			$("#show").fadeTo("slow",0.5);
  		});
  	});
  </script>
  </head>
  
  <body>
  	<h2>This is a heading</h2>
  	<p id="hide">This is a paragraph.</p>
  	<p id="show">This is another paragraph.</p>
  	<button type="button">Click me</button>
  </body>
  </html> 
  ```

#### 滑动

三种滑动方法：

- slideDown()：用于向下滑动元素。
- slideUp()：用于向上滑动元素。
- slideToggle()：jQuery slideToggle() 方法可以在 slideDown() 与 slideUp() 方法之间进行切换。

```html
<!--
语法：
$(selector).slide*(speed,callback);
-->
<!--小案例-->
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#down").click(function(){
			$("#slide").slideToggle();
		});
	});
</script>
<style type="text/css">
	#slide,#down{
		margin: 0;
		padding: 0;
		width:200px;
		height: 100px;
		background: greenyellow;
		text-align: center;
	}
	#down{
		height:50px;
		background: #03A9F4;
	}
</style>
</head>
<body>
	<h2>This is a heading</h2>
	<div id="slide">
		hello <br>
		hello <br>
	</div>
	<p id="down">slide</p>
</body>
</html> 
```

#### 动画

jQuery animate() 方法用于创建自定义动画。

```javascript
<!--
语法：
$(selector).animate({params},speed,callback);
必需的 params 参数定义形成动画的 CSS 属性。

可选的 speed 参数规定效果的时长。它可以取以下值："slow"、"fast" 或毫秒。

可选的 callback 参数是动画完成后所执行的函数名称。
-->

<!------------操作多个属性------------>
$("button").click(function(){
  $("div").animate({
    left:'250px',
    opacity:'0.5',
    height:'150px',
    width:'150px'
  });
}); 

<!--提示：可以用 animate() 方法来操作所有 CSS 属性吗？

是的，几乎可以！不过，需要记住一件重要的事情：当使用 animate() 时，必须使用 Camel 标记法书写所有的属性名，比如，必须使用 paddingLeft 而不是 padding-left，使用 marginRight 而不是 margin-right，等等。

同时，色彩动画并不包含在核心 jQuery 库中。

如果需要生成颜色动画，您需要从 jQuery.com 下载 Color Animations 插件。-->

<!------------使用相对值------------>
$("button").click(function(){
  $("div").animate({
    left:'250px',
    height:'+=150px',
    width:'+=150px'
  });
});
<!------------使用预定值------------>
可以把属性的动画值设置为 "show"、"hide" 或 "toggle"：
$("button").click(function(){
  $("div").animate({
    height:'toggle'
  });
});
<!------------使用队列功能------------>
<!--默认地，jQuery 提供针对动画的队列功能。

这意味着如果您在彼此之后编写多个 animate() 调用，jQuery 会创建包含这些方法调用的“内部”队列。然后逐一运行这些 animate 调用。-->

<!--实例1-->

$("button").click(function(){
  var div=$("div");
  div.animate({height:'300px',opacity:'0.4'},"slow");
  div.animate({width:'300px',opacity:'0.8'},"slow");
  div.animate({height:'100px',opacity:'0.4'},"slow");
  div.animate({width:'100px',opacity:'0.8'},"slow");
});

<!--实例2--：下面的例子把 <div> 元素移动到右边，然后增加文本的字号-->
$("button").click(function(){
  var div=$("div");
  div.animate({left:'100px'},"slow");
  div.animate({fontSize:'3em'},"slow");
});
```

**提示：**默认地，所有 HTML 元素都有一个静态位置，且无法移动。

如需对位置进行操作，要记得首先把元素的 CSS position 属性设置为 relative、fixed 或 absolute！

```html
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").click(function(){
			$("#mov").animate(
			{
				marginLeft:'300px',
				opactiy:'0.5',
				height:'toggle',
				width:'toggle'
			})
		});
	});
</script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	#mov{
		margin: 0;
		padding: 0;
		width:100px;
		height:100px;
		background: #212121;
		position: flex;
	}

</style>
</head>

<body>
	<div id="mov"></div>
	<button type="button">Change</button>
</body>
</html> 
```

#### 停止动画

jQuery stop() 方法用于在动画或效果完成前对它们进行停止。

stop() 方法适用于所有 jQuery 效果函数，包括滑动、淡入淡出和自定义动画。

```html
<!--
语法：
$(selector).stop(stopAll,goToEnd);
可选的 stopAll 参数规定是否应该清除动画队列。默认是 false，即仅停止活动的动画，允许任何排入队列的动画向后执行。

可选的 goToEnd 参数规定是否立即完成当前动画。默认是 false。

因此，默认地，stop() 会清除在被选元素上指定的当前动画。
-->
<!--小实例-->
<!DOCTYPE html>
<html>
<head>
<script src="/jquery/jquery-1.11.1.min.js"></script>
<script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideDown(5000);
  });
  $("#stop").click(function(){
    $("#panel").stop();
  });
});
</script>
 
<style type="text/css"> 
#panel,#flip
{
padding:5px;
text-align:center;
background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#panel
{
padding:50px;
display:none;
}
</style>
</head>

<body>
 
<button id="stop">停止滑动</button>
<div id="flip">点击这里，向下滑动面板</div>
<div id="panel">Hello world!</div>

</body>
</html>
```

#### Callback

由于 JavaScript 语句（指令）是逐一执行的 - 按照次序，动画之后的语句可能会产生错误或页面冲突，因为动画还没有完成。

为了避免这个情况，您可以以参数的形式添加 Callback 函数。

当动画 100% 完成后，即调用 Callback 函数。

```html
<!--
$(selector).hide(speed,callback)
callback 参数是一个在 hide 操作完成后被执行的函数。
-->
<!--小案例-->
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").click(function(){
			$("p").hide("slow",function(){
				alert("Content hide success!")
			});
		});
	});
</script>
<style type="text/css">

</style>
</head>

<body>
	<p>Hide content...</p>
	<button type="button">Start</button>
</body>
</html> 
```

#### Chaining

通过 jQuery，您可以把动作/方法链接起来。

Chaining 允许我们在一条语句中允许多个 jQuery 方法（在相同的元素上）

jQuery方法链接

直到现在，我们都是一次写一条 jQuery 语句（一条接着另一条）。

不过，有一种名为链接（chaining）的技术，允许我们在相同的元素上运行多条 jQuery 命令，一条接着另一条。

**提示：**这样的话，浏览器就不必多次查找相同的元素。

如需链接一个动作，您只需简单地把该动作追加到之前的动作上。

```
<!--
语法一：下面的例子把 css(), slideUp(), and slideDown() 链接在一起。"p1" 元素首先会变为红色，然后向上滑动，然后向下滑动：
$("#p1").css("color","red").slideUp(2000).slideDown(2000);

语法二：
 $("#p1").css("color","red")
      .slideUp(2000)
      .slideDown(2000);
-->
```

### jQuery 操作HTML元素

#### jQuery获取

jQuery 拥有可操作 HTML 元素和属性的强大方法。

jQuery 中非常重要的部分，就是操作 DOM 的能力。

jQuery 提供一系列与 DOM 相关的方法，这使访问和操作元素和属性变得很容易。

**提示：**DOM = Document Object Model（文档对象模型）

DOM 定义访问 HTML 和 XML 文档的标准：

“W3C 文档对象模型独立于平台和语言的界面，允许程序和脚本动态访问和更新文档的内容、结构以及样式。”

##### 获得内容 - text()、html() 以及 val()

三个简单实用的用于 DOM 操作的 jQuery 方法：

- text() - 设置或返回所选元素的文本内容
- html() - 设置或返回所选元素的内容（包括 HTML 标记）
- val() - 设置或返回表单字段的值

```html
<!--小案例-->
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#text").click(function(){
			alert($("p").text())
		});
		$("#html").click(function(){
			alert($("p").html())
		})
		$("#show").click(function(){
			alert($("input").val())
		})
	});
</script>
<style type="text/css">

</style>
</head>

<body>
	<p>显示<b>粗体</b>文本</p>
	<button type="button" id="text">显示文本</button>
	<button type="button" id="html">显示html</button>
	<input type="text"/>
	<button type="button" id="show">显示输入的值</button>
</body>
</html> 
```

##### 获取属性 - attr()

jQuery attr() 方法用于获取属性值。

```html
<!--小案例-->
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#show").click(function(){
			alert($("input").attr("type"))
		})
	});
</script>
<style type="text/css">
</style>
</head>

<body>
	<input type="text"/>
	<button type="button" id="show">显示属性</button>
</body>
</html> 
```

##### 设置属性 - attr()

attr() 方法也允许您同时设置多个属性。

```html
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#show").click(function(){
			$("input").attr({
				"type":"password",
				"value":"*",
			})
		})
	});
</script>
<style type="text/css">

</style>
</head>

<body>
	<input type="text" value="account" />
	<button type="button" id="show">Click Me</button>
</body>
</html> 

```

##### attr() 的回调函数

jQuery 方法 attr()，也提供回调函数。回调函数由两个参数：被选元素列表中当前元素的下标，以及原始（旧的）值。然后以函数新值返回您希望使用的字符串。

```html
<!DOCTYPE html>
<html>
<head>
<script src="/jquery/jquery-1.11.1.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
    $("#w3s").attr("href", function(i,origValue){
      return origValue + "/jquery"; 
    });
  }); 
});
</script>
</head>
<body>
<p><a href="http://www.w3school.com.cn" id="w3s">w3school.com.cn</a></p>
<button>改变 href 值</button>
<p>请把鼠标指针移动到链接上，或者点击该链接，来查看已经改变的 href 值。</p>
</body>
</html>

```

#### jQuery添加

- append() - 在被选元素的结尾插入内容
- prepend() - 在被选元素的开头插入内容
- after() - 在被选元素之后插入内容
- before() - 在被选元素之前插入内容

```html

```

