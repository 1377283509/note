[TOC]



### MySQL安装

```shell
   sudo apt install mysql-client
   sudo apt install mysql-server
   sudo mysql #进入数据库
   use mysql; # 进入mysql库
   update user set plugin="mysql_native_password"; 
   update user set authentication_string=PASSWORD("密码") where User='root'; # 更改密码
   flush privileges; #更新所有操作权限
   quit;  # 退出
   service mysql restart # 重新启动服务
   mysql -uroot -p # 输入密码后进入数据库
```

###    MySQL创建管理员账号

```shell
# 创建一个管理员用户账号
CREATE USER 'USER_NAME'@'%'IDENTIFIED BY 'PASSWORD';
# 给这个用户所有远程访问的权限，用户管理整个数据库，创建，管理，备份等操作
GRANT ALL ON *.* TO 'USER_NAME'@'%';
# 是授权立即生效
FLUSH PRIVILEGES；
# 给用户user添加database中所有表的所有权限
```

### 远程连接MySQL拒绝访问的解决办法

```shell
sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
# 执行上述命令，将bind-adress = 127.0.0.1注释掉，开放所有链接
sudo service mysql restart
# 重启数据库服务
```

### ssh服务安装

```shell
sudo apt-get install openssh-server
sudo vim /etc/ssh/sshd_config
# 将PermitRootLogin 设置为yes
sudo service ssh restart
```

### 数据库连接失败（拒绝连接）

```shell
vim /etc/mysql/mysql.conf.d/mysqld.cnf
# 将bind-address = 127.0.0.1 注释掉
```

