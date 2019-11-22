## 管理站点

#### 创建一个管理员用户

`python manage.py createsuperuser，按提示输入用户名、邮箱、密码`

启动服务器，通过“127.0.0.1:8000/admin”访问，输入上面创建的用户名、密码完成登录

进入管理站点，默认可以对groups、users进行管理

#### 管理界面本地化

编辑`settings.py`文件，设置编码、时区

```
LANGUAGE_CODE = 'zh-Hans'
TIME_ZONE = 'Asia/Shanghai'
```

#### 向`admin`注册模型

```
#----------admin.py---------
from django.contrib import admin
# Register your models here.
from .models import Department,Student,Course

admin.site.register(Department)
admin.site.register(Student)
admin.site.register(Course)
```

刷新管理页面，可以对数据表中数据进行增删改查操作

#### 自定义管理页面

`Django`提供了`admin.ModelAdmin`类

通过定义`ModelAdmin`的子类，来定义模型在`Admin`界面的显示方式

###### 列表页属性

`list_display`：显示字段，可以点击列头进行排序

`list_filter`：过滤字段，过滤框会出现在右侧

`search_fields`：搜索字段，搜索框会出现在上侧

`list_per_page`：分页，分页框会出现在下侧

###### 添加、修改页属性

`fields`：属性的先后顺序

`fieldsets`：属性分组

注意：上面两个属性，二者选一。

###### 例子

```
#-----models.py------
class Department(models.Model):
    d_id = models.AutoField(primary_key=True)
    d_name = models.CharField(max_length=30)
    def __str__(self):
        return 'Department<d_id=%s,d_name=%s>'%(
            self.d_id,self.d_name
        )

class Student(models.Model):
    s_id = models.AutoField(primary_key=True)
    s_name = models.CharField(max_length=30)
    department = models.ForeignKey('Department')
    course = models.ManyToManyField('Course')
    def __str__(self):
        return 'Student<s_id=%s,s_name=%s>'%(
            self.s_id,self.s_name
        )


class Course(models.Model):
    c_id = models.AutoField(primary_key=True)
    c_name = models.CharField(max_length=30)
    def __str__(self):
        return 'Course<c_id=%s,c_name=%s>'%(
            self.c_id,self.c_name
        )
```

```
# -----------admin.py--------
from django.contrib import admin

# Register your models here.
from .models import Department,Student,Course

class DepartmentAdimin(admin.ModelAdmin):
    list_display = ['d_id','d_name']
    list_display_links = ['d_id','d_name']
    list_filter = ['d_id']
    search_fields = ['d_name']

class StudentAdimin(admin.ModelAdmin):
    list_display = ['s_id','s_name']
    list_display_links = ['s_id','s_name']
    # fields = ['s_name','course','department']
    fieldsets = [
        ('一组',{'fields':['s_name']}),
        ('二组',{'fields':['department','course']})
    ]

class CourseAdmin(admin.ModelAdmin):
    list_display = ['c_id','c_name']
    list_display_links = ['c_id','c_name']
    list_per_page = 5

admin.site.register(Department,DepartmentAdimin)
admin.site.register(Student,StudentAdimin)
admin.site.register(Course,CourseAdmin)
```

### `auth`系统

#### `User`用户

##### 创建用户：

```
from django.contrib.auth.models import User
User.objects.create_user(username=username,password=password,email=email)
```

##### 验证用户：

```
from django.contrib.auth import authenticate
user = authenticate(username=username,password=password)
if user is not None:
    # 这个用户存在数据库中
else:
    # 这个用户没有存在这个数据库中
```

##### 登录

```
from django.contrib.auth import authenticate, login

def my_view(request):
    username = request.POST['username']
    password = request.POST['password']
    user = authenticate(username=username, password=password)
    if user is not None:
        if user.is_active:
            login(request, user)
            # 登录成功
        else:
            # 用户没有被激活，不能登录
    else:
        # 用户名或者密码错误
```

##### 注销

```
from django.contrib.auth import logout
  
  def logout_view(request):
      logout(request)
      # 注销这个用户。他的session信息将被清除掉。
```

`login_required`装饰器

```
from django.contrib.auth.decorators import login_required

@login_required
def my_view(request):
    ...
```

如果没有登录成功，会跳转到`settings.LOGIN_URL`指定的URL中。否则，直接执行函数中的内容。

##### `User`模型常用属性和方法

- `username`：用户名。
- `email`：邮箱。
- `groups`：多对多的组。
- `user_permissions`：多对多的用户权限。
- `is_staff`： 是否是`admin`的管理员。
- `is_active`： 是否激活，判断该用户是否可用。
- `is_superuser`: 是否是超级用户。
- `last_login`： 上次登录时间。
- `date_joined`： 注册时间。
- `is_authenticated`： 是否验证通过了。
- `is_anonymous`：是否是匿名用户。
- `set_password(raw_password)`： 设置密码，传原生密码进去。
- `check_password(raw_password)`： 检查密码。
- `has_perm(perm)`： 判断用户是否有某个权限。
- `has_perms(perm_list)`： 判断用户是否有权限列表中的某个列表

















