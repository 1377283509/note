## 打包apk

1、在终端中输入以下命令，生成key

```shell
keytool -genkey -v -keystore [存贮路径]/[文件名].jks -keyalg RSA -keysize 2048 -validity 10000 -alias [name]
```

【 参数信息 】

-genkey 生成证书

-v 详细输出

-keystore 密钥库名称

-keyalg 密钥算法名称

-keysize 密钥位大小

-validity 有效天数

-alias 要处理的条目的别名

2、输入后，按照提示输入相应的信息。

3、在项目的android/app目录下新建key目录，将生成的证书（.jks）放入该文件夹。

4、在android目录下新建文件key.properties

```shell
# 在文件内写入以下信息
storePassword = [store密码(自己设置的)]
keyPassword = [key密码(自己设置的)]
keyAlias = [别名]
storeFile = key/[文件名].jks
```

5、配置build.gradle。

```shell
# 打开android/app目录下的build.gradle

# 在android{……}前添加以下code
def keyStorePropertieFile = rootProject.file("key.properties")
def keyStoreProperties = new Properties()
keyStoreProperties.load(new FileInputStream(keyStorePropertieFile))

# 在android{……}里面添加以下code
signingConfigs{
        release{
            keyAlias keyStoreProperties["keyAlias"]
            keyPassword keyStoreProperties["keyPassword"]
            storeFile = file(keyStoreProperties["storeFile"])
            storePassword = keyStoreProperties["storePassword"]
        }
    }
  
# 在android{……}里面的buildTypes{……}中修改以下code
release {
		# 将debug改为release
        signingConfig signingConfigs.release
 }
```

