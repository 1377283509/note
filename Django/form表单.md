## `Django`的`form`表单

`django`中的表单不是`html`中的那个表单.**这个表单是用来验证数据的合法性的一个东西**,也可以生成HTML代码.

#### 使用表单

1. 创建一个`forms.py`的文件,放在指定的app当中,然后在里面写表单.
2. 表单是通过类实现的,继承自`forms.Form`,然后在里面定义要验证的字段.
3. 在表单中,创建字段跟模型是一模一样的,但是没有`null=True`或者`blank=True`等这几种参数了,有的参数是`required=True/False`.
4. 使用`is_valid()`方法可以验证用户提交的数据是否合法,而且HTML表单元素的`name`必须和`django`中的表单的`name`保持一致,否则匹配不到.
5. `is_bound`属性:用来表示`form`是否绑定了数据,如果绑定了,则返回`True`,否则返回`False`.
6. `cleaned_data`:这个是在`is_valid()`返回`True`的时候,保存用户提交上来的数据.

#### 例子

```python
#-------------form.py------------
class RegisterForm(forms.Form):
    username = forms.CharField(max_length=8,min_length=6)
    password = forms.CharField(max_length=8,min_length=6,
        widget=forms.PasswordInput(attrs={'placeholder':'请输入密码'}),
                        error_messages={'min_length':'密码长度小于6',
                                        'max_length':'密码长度超过8了'})
    password_repeat = forms.CharField(max_length=8,#min_length=6,
        widget=forms.PasswordInput(attrs={'placeholder':'请再输入密码'}),
                    error_messages = {'min_length': '密码长度小于6'}
                                      )
    email = forms.EmailField()
    
```

###### 字段类型中的一些参数

这些参数会对页面的输入做一些限制条件：

```python
max_length  最大长度
min_length  最小长度
widget  负责渲染网页上HTML 表单的输入元素和提取提交的原始数据
attrs  包含渲染后的Widget 将要设置的HTML 属性
error_messages 报错信息
```

###### 登录注册案例

```python
# form.py
class LoginForm(forms.Form):
    username = forms.CharField(label='用户名')
    password = forms.CharField(label='密码',
    	widget = forms.PasswordInput(attrs={'placeholder': '请输入密码 '}))
  

class RegisterForm(forms.Form):
    username = forms.CharField(max_length=8,min_length=6)
    password = forms.CharField(max_length=8  ,#min_length=6,
        widget=forms.PasswordInput(attrs={'placeholder':'请输入密码'}))
    password_repeat = forms.CharField(max_length=8,#min_length=6,
        widget=forms.PasswordInput(attrs={'placeholder':'请再输入密码'}))
    email = forms.EmailField()
```

```python
# ------urls.py-------
from django.conf.urls import url
from . import views
urlpatterns = [
    path('home/',views.home,name='ts22_home'),
    path('login/',views.login,name='ts22_login'),
    path('logout/',views.logout,name='ts22_logout'),
    path('register/',views.register,name='ts22_register'),
]
```

```html
#---------home.py------
<body>
欢迎  {{ username }} <br>
<a href="{% url 'ts22_login' %}">登录</a>
<a href="{% url 'ts22_register' %}">注册</a>
<a href="{% url 'ts22_logout' %}">退出</a>
</body>

# --------login.html--------
<body>
    <form method="post">
        {% csrf_token %}
        {{userForm.as_p}}
        <input type="submit" value="登录">
    </form>
</body>

# --------register.html------
<body>
<form method="post">
    {%csrf_token%}
    {{ from.as_p }}
    <input type="submit" value="注册">
</form>
</body>

```

```python
# ----------views.py---------------
from django.shortcuts import render,reverse
from django.http import  HttpResponse,HttpResponseRedirect
# Create your views here.
def home(request):
    username = request.session.get('username','未登录')
    return render(request,'ts22/home.html',
                  {'username':username})
                  
from .models import UserModel
from .form import LoginForm,RegisterForm
def login(request):
    if request.method == 'GET':
        userForm = LoginForm()
        return render(request,'ts22/login.html',
                      {'userForm':userForm})
    elif request.method == 'POST':
        username = request.POST.get('username')
        password  = request.POST.get('password')
        userModel = UserModel.objects.filter(username=username,password=password)
        if userModel:
            # response = HttpResponseRedirect(reverse('ts11_home'))
            # response.set_cookie('usename',username)
            request.session['username']=username
            # request.session.set_expiry(180)
            return HttpResponseRedirect(reverse('ts22_home'))
        else:
            return HttpResponseRedirect(reverse('ts22_register'))

def logout(request):
    request.session.flush() 
    return HttpResponseRedirect(reverse('ts22_home'))

def register(request):
    if request.method == 'GET':
        form = RegisterForm()
        return render(request,'ts22/login.html',
                      {'userForm':form})
    elif request.method == 'POST':
        form = RegisterForm(request.POST)
        if form.is_valid():
            username = form.cleaned_data.get('username', None)
            password = form.cleaned_data.get('password', None)
            password_repeat = form.cleaned_data.get('password_repeat', None)
            email = form.cleaned_data.get('email', None)
            if password == password_repeat:
                user = UserModel()
                user.username = username
                user.password = password
                user.email = email
                user.save()
                return HttpResponse('注册成功')
        else:
            return HttpResponse('注册失败')
```

