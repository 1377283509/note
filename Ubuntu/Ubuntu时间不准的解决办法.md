Ubuntu时间不准的解决办法

- 安装ntpdate工具

```shell
sudo apt-get install ntpdate
```

- 将系统时间与网络同步

```shell
sudo ntpdate cn.pool.ntp.org
```

- 将时间写入硬件

```shell
sudo hwclock --systohc
```

