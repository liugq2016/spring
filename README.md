# spring
学习spring框架
# 杂谈：
    1. 不熟悉gradle导致引入jar出现了问题，要注意学习日常使用工具的使用，又是被架构帮了忙。20200103
    2. Spring中Resource类中也有无用的内容，或许需要自定义，例如：AbstractResource类中的exists()方法中的 if (isFile())中的内容永远不会被执行。20200109
    3. Spring真牛皮，尽量的兼容了各种日志log4j或slf4j的日志输出方式，但是不知道为什么即使知道log4j更好用，在使用log4j-to-slf4j bridge还是会选择使用log4j，jcl包还是没写完。20210109
# 按包分类
## springg-jcl:注解的公共包
    1. 今天学习了[org.apache.commons.logging.LogAdapter](获取log4j、slf4j及java默认logger对象)。
## spring-core:spring读取各类文件主要发生在这