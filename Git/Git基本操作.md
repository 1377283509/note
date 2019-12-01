# Git

## 配置用户信息

```shell
# global对当前用户所有仓库有效
git config --global user.name "name" 
git config --global user.email "email_address"
# local只对某个仓库有效
git config --local user.name "name"
git config --local user.email "email_address"
# system对系统所有登录的用户有效
git config --system user.name "name"
git config --system user.email "email_adress"

# 其中local的优先级高于global
```

## 查看config的配置信息

```shell
git config --list # 列出三种配置
git config --list --local
git config --list --global
git congig --list --system
```

## 建Git仓库

两种场景

```shell
# 1. 把已有的项目代码纳入git管理
cd 项目代码所在的文件夹
git init

# 2. 新建的项目直接使用git管理
cd 某个文件夹
git init project_name # 会在当前路径下创建和项目名称同名的文件夹
cd project_dir
```

## Git基本操作

```shell
git add file_name_1 file_name_2 ...  # 将指定文件加入git暂存区
git add -u # 将已经管理的，发生改变的文件提交到暂存区

git commit -m '变更理由' # 将暂存区的内容提交到版本历史

git status # 查看工作目录和暂存区的状态

git rm file_name # 删除暂存区的文件

git reset --hard # 将暂存区的工作目录下的更改撤销

git mv old_filename new_filename # 文件重命名

git log # 查看提交历史信息
git log --oneline # 查看历史列表
git log -n4 # 查看最近的四条记录
git log -n4 --oneline # 命令的组合 
git log '指定分支' # 查看指定分支的历史
git log --all # 查看所有分支的历史
git log --all --graph # 将所有分支的历史图形化展示出来

# 分支管理
git branch -v # 查看本地由多少分支
git checkout '分支名' # 切换分支
```

