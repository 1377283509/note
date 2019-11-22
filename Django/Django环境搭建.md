## Ubuntu下安装虚拟环境



```shell
# 安装
sudo apt-get install virtualenv  # 安装virtualenv包
sudo apt-get install virtualenvwrapper  # 安装virtualenvwrapper包
# 运行virtualenvwrapper.sh
source /usr/share/virtualenvwrapper/virtualenvwrapper.sh

# 验证
mkvirtualenv --python=[python路径] [虚拟环境名称] # 创建虚拟环境
workon [虚拟环境名称] # 应用虚拟环境
workon # 查看所有的虚拟环境

# 其它命令
deactivate [虚拟环境名称]   # 退出当前虚拟环境
rmvirtualenv [虚拟环境名称] # 删除当前虚拟环境
lsvirtualenv [虚拟环境名称] # 列出所有虚拟环境
```



------



## 虚拟环境下搭建Django项目环境

1. 创建虚拟环境

   ```shell
   mkvirtualenv --python=[python路径]  [虚拟环境名称] # 创建对应python版本的虚拟环境
   ```

2. 安装Django包

   ```shell
   pip install Django==2.1.7  # ==号后面为django版本号，2.2.3的版本不支持pymysql5以上的版本
   ```

3. 新建项目

   ```shell
   django-admin startproject [项目名称]
   ```

4. 进入项目文件夹，有四个文件

   ```shell
   [项目名称]
     -__init__.py
     -settings.py
     -urls.py
     -wsgi.py
   -manage.py
   ```

5. 启动服务

   ```shell
   python manage.py runserver 0.0.0.0:8000
   # 0.0.0.0表示允许所有主机访问
   # virtualbox 需设置端口转发 
   # 设置方法：控制->设置->网络->高级->端口转发->添加->将主机端口和子系统端口设置成为8000
   ```













