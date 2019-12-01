## django-ckeditor富文本编辑器的使用

- ### 安装

  ```shell
  pip install django-ckeditor
  ```

- ### 注册

  ```python
  # 将ckeditor添加到主项目文件夹下的settinges.py中的INSTALLD_APPS中
  # settings.py
  ...
  # Application definition
  
  INSTALLED_APPS = [
      'django.contrib.admin',
      'django.contrib.auth',
      'django.contrib.contenttypes',
      'django.contrib.sessions',
      'django.contrib.messages',
      'django.contrib.staticfiles',
      'blog',
      # 将 django-ckeditor 注册到该列表中
      'ckeditor',
  ]
  ```

- ### 创建模型

  在models.py中导入RichTextField类

  ```python
  # blog/models.py
  from django.db import models
  from ckeditor.fields import RichTextField
  # Create your models here.
  
  # 博客模型
  class Blog(models.Model):
      title = models.CharField(max_length=50,verbose_name="标题")
      content = RichTextField(blank=True, null=True, verbose_name="内容")
  
      def __str__(self):
          return self.title
  ```

- ### 数据库迁移

  ```shell
  python manage.py makemigrations
  python manage.py migrate
  ```

- ### 注册模型在后台显示

  ```python
  from django.contrib import admin
  from .models import Blog
  # Register your models here.
  
  # 注册Blog的管理模型
  @admin.register(Blog)
  class BlogAdmin(admin.ModelAdmin):
      # 列表显示字段
      list_display = ['title','body']
  ```







