## `urls.py`路由用法

```
总结:
把页面展示出去     那么就要有对应的页面(视图函数的)url地址
一个url对应写好的视图函数

一个项目里面有很多的app 应用 
用include进行路由分配
主url 找到各自的分路由地址
在app分路由里面进行确定的某个视图函数的路由

kwarg  
从url里面传特定的参数给视图函数
主路由里面传   所有的app里面url都将参数传给视图     

name  
给url取个名字
我们可以用的在视图进行路由的转换
后面还可以用到模板
```

#### URL概念

```
URL（Uniform Resoure Locator）统一资源定位符是对可以从互联网上得到的资源的位置和访问方法的一种简洁的表示，是互联网上标准资源的地址。互联网上的每个文件都有一个唯一的URL，它包含的信息指出文件的位置以及浏览器应该怎么处理它。
```

#### `URL`格式

```
http://127.0.0.1:8000/hello/
URL解释：
schema://host[:port#]/path/.../[?query-string][#anchor]
schema：指定使用的协议(例如：http, https, ftp)
host：Http服务器的IP地址或者域名
port：端口号，http默认是80端口
path：访问资源的路径
query-string：发送给http服务器的数据
anchor：锚点
```

#### `urls.py`的作用

```
URL配置（URLconf）就像是Django所支撑网站的目录。它的本质是URL模式以及要为该URL模式调用的视图函数之间的映射表。以这样的方式告诉Django，对于那个URL调用那段代码。url的加载就是从配置文件中开始。
```

#### `url`例子

```python
# hello_django/urls.py:
from django.conf.urls import include,path,re_path
from django.contrib import admin
from books import views

urlpatterns = [
    path('admin/', admin.site.urls),
    # path('hello/python/', views.hello_python),
    # path('hello/php/', views.hello_php),
    # re_path(r'^hello/([a-z]+)/$',views.hello_course),
    # re_path(r'^add/(\d+)/(\d+)/$', views.add),
    # re_path(r'^hello/(?P<name>\w+)/(?P<num>\d+)$',views.hello_django),
]
```

```python
# books/views.py
from django.http import HttpResponse

def hello_python(request):
    return HttpResponse('Hello python!')

def hello_php(request):
    return HttpResponse('Hello php!')

def hello_course(request, course):
    return HttpResponse('Hello %s' % course)

def add(request,a,b):
    c = int(a)+int(b)
    return HttpResponse(str(c))

def hello_django(request, name, num):
    return HttpResponse('Hello %s %s' % (name, num))
```

参数捕获：

1、捕获位置参数（可变参数）：在url函数中，第一个正则表达式使用（）括号进行捕获参数.

2、捕获关键字参数：在url函数中，第一个正则表达式使用`（?P<keyword>）`进行捕获。

注意事项：

参数类型是字符串类型，所以，如果使用数字类型，需要使用int函数转换成int类型。

#### `include`的作用

```
方便项目管理：
	一个project有一个总的urls.py，各个app也可以自己建立自己的urls.py，不过都需要使用include()函数在project的urls.py文件进行注册。
```

```python
#hello_django/urls.py     主url文件
from django.conf.urls import include,path
from django.contrib import admin
from .import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('books/',include('books.urls')),
]
```

```python
#books/urls.py    APP books里面的URL文件
from django.conf.urls import path
from . import views

urlpatterns =[
    path('article/', views.article),
```

```python
#book/view.py           APP books里面的view文件
from django.http import HttpResponse
def index(request):
    return HttpResponse('这是首页')
def article(request,):
    return HttpResponse('这是文章的首页')
```

```
Include注意事项：
到达django来的时候，已经有域名和反斜杠了，拿本机地址为例，已经有http://127.0.0.1/这个样子了，所以主url中都不需要以/开头。
子url在匹配的时候，其实就是字符串的匹配，一层套一层的
```

#### `kwargs`的作用

```
传递一个Python 字典作为额外的参数传递给视图函数。django.conf.urls.url() 函数可以接收一个可选的第三个参数，它是一个字典，表示想要传递给视图函数的额外关键字参数。
```

```python
#hello_django/urls.py     主url文件
from django.conf.urls import include,path
from django.contrib import admin
from .import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('books/',include('books.urls'),{'switch':'true'}),
]
```

```python
# book/view.py      APP books里面的view文件
from django.http import HttpResponse
import datetime
def index(request,**arg):
    if arg.get('switch') == 'true':
        print(datetime.datetime.now())
    return HttpResponse('<h1>这是首页</h1>')
```

```
URL传递额外参数：
url函数有一个参数叫做kwargs，这个参数可以传递额外的参数到views中，并且必须为字典类型。这在使用include的时候，需要统一给下面的url一些参数的时候，显得尤其有用。
```

#### `name`的作用

```
给一个匹配的url地址取名字
一般用于模板
也可以使用reverse进行页面重定向
```
```python
# book/url.py    APP books里面的URL文件
from django.conf.urls import path
from . import views

urlpatterns =[
    re_path(r'^$',views.index),
    path('article/', views.article,name='books_article'),
    re_path(r'^(?P<books>\w+)/$',views.book_list,name='books_lists'),
    re_path(r'^article_new/$', views.article_new,name='books_article_new'),
]
```

```python
# book/views.py   APP book里面的view文件
from django.shortcuts import render,reverse,redirect
from django.http import HttpResponse
# Create your views here.

def article(request,**kwargs):
    if kwargs.get('switch') == 'true':
                return redirect(reverse('book_article_new'))
    return HttpResponse('这是文章首页')

def article_new(request,**kwargs):
    return HttpResponse('这是新的文章首页')
```

```
url有一个name的参数，name参数可以给这个url取一个合适的名字。通过给url取名字，以后在view或者模板中使用这个URL，就只需要通过这个名字就可以了。这样做的原因是防止url的规则更改，会导致其他地方用了这个url的地方都需要更改，但是如果取名字了，就不要做任何改动了。
```

# 模板渲染方式

1. 模板路径
2. 渲染方式

setting.py中模板路径配置:

```python
TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [os.path.join(BASE_DIR, 'templates')],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
            ],
        },
    },
]
```

1.直接将`html`字符串硬编码`HttpResponse`中

```python
def index_1(request):
    return HttpResponse('<h1>Hello Django World!</h1>')
```

2.`django.template.loader` 定义了函数以加载模板。

`get_template`（*template_name*，*using = None*）	

该函数使用给定的名称加载模板并返回一个`Template` 对象.`get_template()`尝试获取每个模板直到有一个成功满足。

```python
from django.template.loader import get_template
def index_2(request,bn):
    t = get_template('index.html')
    html = t.render({'books_name':bn})
    return HttpResponse(html)
```

3.使用render进行渲染。

```python
from django.shortcuts import render

def index_3(request,bn):
    return render(request,'index.html',{'booksname':bn})
```



