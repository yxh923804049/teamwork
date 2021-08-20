#添加JAVA启动的必要镜像
FROM java:8
#创建一个目录存放jar包
RUN mkdir -p /home/docker
#设置开放端口号
EXPOSE  8080
#添加jar包，存放路径以及重命名
ADD  teamwork.jar  /home/docker/teamwork.jar
#添加进入docker容器后的目录
WORKDIR   /home/docker
#修改文件的创建修改时间
RUN bash -c 'touch /home/docker/teamwork.jar'
#启动容器执行命令。 -Djava.security.egd=file:/dev/./urandom 可以缩短tomcat启动时间
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/docker/teamwork.jar"]
