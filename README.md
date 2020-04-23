# SpringCloud（2020新版）Hoxton版 + SpringCloud alibaba
# 简介

教程重点讲解了SpringCloud各种组件停止更新进入维护阶段后，后续技术组件的升级和替换策略及方案选型，既有传统Eureka、Ribbon、OpenFeign、Hystrix、Config等技术的升级讲解，又有Consul、Gateway、Bus、Stream、Sleuth、zipkin和阿里巴巴最新的Nacos、Sentinel、Seata等技术，分享了服务降级、服务熔断、服务限流、hotkey控制、分布式统一配置管理、分布式全局事务控制、RabbitMQ与Stream整合、Nacos和Nginx配置高可用集群等技术，干货满满！



# 一、微服务架构零基础理论入门（小白必看）

## 1、微服务概述

微服务：强调的是服务的大小，它关注的是某一个点，是具体解决某一个问题/提供落地对应服务的一个服务应用,狭意的看,可以看作Eclipse里面的一个个微服务工程/或者Module。

微服务架构：是⼀种架构模式或者说是一种架构风格，它提倡将单⼀应⽤程序划分成⼀组⼩的服务，每个服务运行在其独立的自己的进程中，服务之间互相协调、互相配合，为⽤户提供最终价值。服务间采⽤轻量级的通信机制互相协作（通常是基于HTTP协议的RESTful API）。每个服务都围绕着具体业务进⾏构建，并且能够被独⽴的部署到⽣产环境、类⽣产环境等。另外，应当尽量避免统⼀的、集中式的服务管理机制，对具体的⼀个服务⽽⾔，应根据业务上下⽂，选择合适的语⾔、⼯具对其进⾏构建。可以有一个非常轻量级的集中式管理来协调这些服务，可以使用不同的语言来编写服务，也可以使用不同的数据存储。

技术维度理解：微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合,每一个微服务提供单个业务功能的服务，一个服务做一件事，从技术角度看就是一种小而独立的处理过程，类似进程概念，能够自行单独启动或销毁，拥有自己独立的数据库。

微服务优缺点

优点：

-    每个服务足够内聚，足够小，代码容易理解这样能聚焦一个指定的业务功能或业务需求；
-   开发简单、开发效率提高，一个服务可能就是专一的只干一件事；
-   微服务能够被小团队单独开发，这个小团队是2到5人的开发人员组成；
-   微服务是松耦合的，是有功能意义的服务，无论是在开发阶段或部署阶段都是独立的；
-   微服务能使用不同的语言开发；
-   易于和第三方集成，微服务允许容易且灵活的方式集成自动部署，通过持续集成工具，如Jenkins,Hudson,bamboo；
-   微服务易于被一个开发人员理解，修改和维护，这样小团队能够更关注自己的工资成果。无需通过合作才能体现价值；
-   微服务允许你利用融合最新技术；
-   微服务只是业务逻辑的代码，不会和HTML,CSS或其他界面组件混合；
-   每个微服务都有自己的存储能力，可以有自己的数据库。也可以有统一的数据库。

缺点：

-   开发人员要处理分布式系统的复杂性；
-   多服务运维难度，随着服务的增加，运维的压力也在增大；
-   系统部署依赖；
-   服务间通信成本；
-   数据一致性；
-   系统集成测试；
-   性能监控。

微服务技术栈： 多种技术的集合体。

![img](img/73adfcb6-dd50-4125-a7ab-854296ffb35e.jpg)



## 2、SpringCloud入门

![img](img/ca773d2e-8cd9-45d4-8eb1-15807d34e46e.jpg)

为什么选择SpringCloud作为微服务架构？选型依据：

- ​    整体解决方案和框架成熟度
- ​    社区热度
- ​    可维护性
- ​    学习曲线

SpringCloud：基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务全家桶。SpringCloud利用SpringBoot的开发便利性巧妙地简化了分布式系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等,它们都可以用SpringBoot的开发风格做到一键启动和部署。

 

SpringBoot并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

SpringCloud和SpringBoot是什么关系：

- SpringBoot专注于快速方便的开发单个个体微服务。SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务

-  SpringBoot可以离开SpringCloud独立使用开发项目，但是SpringCloud离不开SpringBoot，属于依赖的关系。
-  SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。

互联网大厂微服务架构案例：

![img](img/f4dbfa81-846c-415f-81c2-5e35261f6831.jpg)

![img](img/38e54e06-7751-4e79-9ab1-1277f4aa3e17.jpg)

![img](img/c29ecfb8-562c-415c-834f-6aa2ee88a087.jpg)



# 二、从SpringBoot 2.2.x和SpringCloud H版本开始说起

## 1、版本选择

通过SpringBoot和SpringCloud官网，可以看到当前的最新稳定版本。但不是最新的版本就是最好的，SpringBoot和SpringCloud存在版本依赖。

SpringBoot官网：[https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot#learn)

SpringCloud官网：https://spring.io/projects/spring-cloud

SpringCloud中文文档：https://www.bookstack.cn/read/spring-cloud-docs/docs-index.md

版本依赖可以查看SpringCloud官网：https://spring.io/projects/spring-cloud#overview

![img](img/456acc34-767e-489c-b5fe-5736bb220100.png)

还可以通过：https://start.spring.io/actuator/info查看对应的版本依赖关系

![img](img/b866e427-b9f7-4854-a26c-4085a9f7d786.png)



## 2、当前项目选择的最终版本

![img](img/f3cc3749-09d0-4abf-8387-644101d2e52b.jpg)





# 三、关于Cloud各种组件的停更/升级/替换

之前SpringCloud各个组件选型如下：

![img](img/07771df4-f694-40e3-969d-c42ef6198e60.jpg)

在Netflix对各个组件采取停更不停用的措施后，SpringCloud家族出现了很多种可以替代的新组件，如下：

![img](img/34e57b96-c46f-4502-8570-291186d9bb92.jpg)



# 四、微服务架构编码构建

约定 > 配置 > 编码

## 1、IDEA新建Project工作空间

### （1）微服务cloud整体聚合父工程Project

#### ① 新建空的Maven项目即可，不勾选Create from archetype

![img](img/44619280-ebbc-4bce-b8ac-94a0705b5327.png)                                              

#### ② 聚合总父工程名字

 

```
     <groupId>com.atguigu.springcloud</groupId>
     <artifactId>cloud2020</artifactId>
```

#### ③ Maven选版本3.5及以上

![img](img/ec0022f2-eeac-40aa-8138-d286538d57f0.png)

#### ④ 字符编码设为UTF-8

![img](img/870d56c6-3ed5-4f22-8eaa-c3d2e067946a.png)

#### ⑤ 注解生效激活

![img](img/08a59851-f12a-4cce-9980-391f97572976.png)

#### ⑥ java编译版本选8

![img](img/f8813c44-8e0f-4120-bb39-830f6d60ae04.png)

#### ⑦ File Type过滤*.idea和*.iml

![img](img/5f5f9fee-11e1-42ea-b4e9-ca66c20d8fec.png)

### （2）父工程pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.atguigu.springcloud</groupId>
    <artifactId>cloud2020</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <!-- 统一管理Jar包版本 -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>4.12</junit.version>
        <log4j.version>1.2.17</log4j.version>
        <lombok.version>1.16.18</lombok.version>
        <mysql.version>5.1.47</mysql.version>
        <druid.version>1.1.16</druid.version>
        <mybatis.spring.boot.version>1.3.0</mybatis.spring.boot.version>
    </properties>
    <!-- 子模块继承之后，提供作用：锁定版本+子Module不用谢groupId和version -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.2.2.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2.1.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j.version}</version>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis.spring.boot.version}</version>
            </dependency>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok.version}</version>
                <optional>true</optional>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork>
                    <addResources>true</addResources>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### （3）Maven中的DependencyManagement和Dependencies

Maven使用dependencyManagement 元素来提供了一种管理依赖版本号的方式。通常会在一个组织或者项目的最顶层的父POM中看到dependencyManagement 元素。

使用pom.xm 中的dependencyManagement 元素能让所有在子项目中引用一个依赖而不用显示的列出版本号。

Maven 会沿着父子层次向上走，直到找到一个拥有dependencyManagement 元素的项目，然后它就会使用这个dependencyManagement 元素中指定的版本号。

dependencyManagement 元素中指定的版本号，例如在父项目里：

```xml
 <dependencyManagement>
        <dependencies>
             <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.47</version>
            </dependency>
        </dependencies>
</dependencyManagement>     
```

然后再子项目里就可以添加mysql-connector-java时不指定版本号，例如：

```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
</dependencies>
```

这样做的好处就是：如果有多个子项目都引用同一依赖，则可以避免在每个使用的子项目里都声明一个版本号，这样当想升级或切换到另一个版本时，只需要在顶层父容器里更新，而不需要一个一个子项目的修改；另外如果某个子项目需要另外的一个版本，只需要声明version就可。

注意：

- dependencyManagement 里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖；
- 如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承该项并且version和scope都读取自父pom；
-  如果子项目中指定了版本号，那么会使用子项目中指定 jar版本。  

### （4）Maven跳过单元测试

![img](img/40f8afe7-0790-4e42-acdf-1bb516d5d5b5.png)

### （5）父工程创建完成执行mvn:install将父工程发布到仓库方便子工程继承



## 2、Rest微服务工程构建

建Module ---》改pom ---》写yml ---》主启动类 ---》业务类 

### （1）cloud-provider-payment8001微服务提供者支付Module模块

#### ① 新建空的子Module，命名为cloud-provider-payment8001

#### ② 修改cloud-provider-payment8001的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-provider-payment8001</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

#### ③ 新建application.yml

```yaml
server:
  port: 8001
spring:
  application:
    name: cloud-payment-service
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource # 当前数据源操作类型
    driver-class-name: org.gjt.mm.mysql.Driver # mysql驱动包
    url: jdbc:mysql://localhost:3306/cloud2020?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: 123456
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.atguigu.springcloud.entities # 所有Entity别名类所在包
```

#### ④ 新建PaymentMain8001主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
```

#### ⑤ 新建业务相关类

##### 创建表payment

```sql
CREATE TABLE `payment`(
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`serial` varchar(200) DEFAULT '',
PRIMARY KEY(`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
```

##### 新建实体类Payment和通用返回结果集实体类CommonResult

```java
package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
/**
 * 支付表 实体类
 *
 * @author 王柳
 * @date 2020/4/2 14:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
```

```java
package com.atguigu.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 通用返回结果集
 *
 * @author 王柳
 * @date 2020/4/2 14:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
```

##### 新建dao和对应xml文件

```java
package com.atguigu.springcloud.dao;
import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author 王柳
 * @date 2020/4/2 14:34
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.springcloud.dao.PaymentDao">
    <resultMap id="BaseResultMap" type="com.atguigu.springcloud.entities.Payment">
        <id column="id" property="id" jdbcType="BIGINT"/>
        <result column="serial" property="serial" jdbcType="VARCHAR"/>
    </resultMap>
    <insert id="create" parameterType="com.atguigu.springcloud.entities.Payment" useGeneratedKeys="true" keyProperty="id">
        insert into payment(serial) values(#{serial});
    </insert>
    <select id="getPaymentById" parameterType="java.lang.Long" resultMap="BaseResultMap">
        select * from payment where id=#{id}
    </select>
</mapper>
```

##### 新建service和对应实现类

```java
package com.atguigu.springcloud.service;
import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
/**
 * @author 王柳
 * @date 2020/4/2 14:41
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
```

```java
package com.atguigu.springcloud.service.impl;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @author 王柳
 * @date 2020/4/2 14:41
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
```

##### 新建controller类

```java
package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author 王柳
 * @date 2020/4/2 14:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败");
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id);
        }
    }
}
```

#### ⑥ 测试

![img](img/bcbf504b-7fbe-43ff-9b5c-a42ed8a26186.jpg)

![img](img/a5d861c8-3a92-45c7-8e45-dfc5f4ad17b2.jpg)

### （2）热部署Devtools

只能开发阶段使用

#### ① Adding devtools to your project

![img](img/b486cfb2-c10d-486a-8712-5bb6c66ed7e7.jpg)

#### ② Adding plugin to your pom.xml

![img](img/67bda614-4b9b-47de-b01c-06e3e25aea7e.png)

#### ③ Enabling automatic build

![img](img/b6288148-c32f-4ed1-8b37-aca967eb473e.jpg)

#### ④ Update the value of

![img](img/22fe0930-5034-48da-841c-9ad89fee52a9.jpg)

#### ⑤ 重启IDEA

### （3）cloud-consumer-order80微服务消费者订单Module模块

#### ① 新建空的子Module，命名为cloud-consumer-order80

#### ② 修改cloud-consumer-order80的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-consumer-order80</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

#### ③ 新建application.yml

```yaml
server:
  port: 80
```

#### ④ 新建OrderMain80主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author 王柳
 * @date 2020/4/2 15:03
 */
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
```

#### ⑤ 新建业务相关类

##### 新建实体类Payment和通用返回结果集实体类CommonResult

（同cloud-provider-payment8001一致）

##### 新建ApplicationContextConfig配置类

```java
package com.atguigu.springcloud.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

##### 新建OrderController类

```java
package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:12
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
```

#### ⑥ RestTemplate

##### 是什么

​      RestTemplate提供了多种便捷访问远程Http服务的方法， 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集。

##### 官网及使用

​     官网地址：https://docs.spring.io/spring-framework/docs/4.3.7.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html

​     使用：使用restTemplate访问restful接口非常的简单粗暴无脑。(url, requestMap, ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。



#### ⑦ 测试

![img](img/c22e51f6-984b-4888-9c84-c1b69c16e0e3.png)

![img](img/9ff2a8c0-ac24-493b-a940-aa3e25d59836.png)

### （4）工程重构

#### ① 问题：系统中有重复部分，需要重构

#### ② 新建cloud-api-commons

#### ③ 修改cloud-api-commons的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-api-commons</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.1.0</version>
        </dependency>
    </dependencies>
</project>
```

#### ④ 新建entities

将订单80和支付8001中的实体类Payment和CommonResult移到该模块

#### ⑤ maven命令 clean install

#### ⑥ 订单80和支付8001分别改造

将订单80和支付8001中的entities包删除，pom文件引入cloud-api-commons

```xml
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
```

![img](img/7605d2f2-8ab4-4b90-b383-65a14a4aad9b.png)



# 五、Eureka服务注册与发现

## 1、Eureka基础知识

### （1） Eureka是什么

Eureka是Netflix的一个子模块，也是核心模块之一。Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。Netflix在设计Eureka时遵守的就是AP原则。服务注册与发现对于微服务架构来说是非常重要的，有了服务发现与注册，只需要使用服务的标识符，就可以访问到服务，而不需要修改服务调用的配置文件了。功能类似于dubbo的注册中心，比如Zookeeper。

### （2） 什么是服务治理

Spring Cloud 封装了 Netflix 公司开发的 Eureka 模块来实现服务治理。

在传统的rpc远程调用框架中，管理每个服务与服务之间依赖关系比较复杂，管理比较复杂，所以需要使用服务治理，管理服务于服务之间依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册。

### （3） 什么是服务注册与发现

Eureka 采用了 C-S 的设计架构。Eureka Server 作为服务注册功能的服务器，它是服务注册中心。而系统中的其他微服务，使用 Eureka 的客户端连接到 Eureka Server并维持心跳连接。这样系统的维护人员就可以通过 Eureka Server 来监控系统中各个微服务是否正常运行。SpringCloud 的一些其他模块（比如Zuul）就可以通过 Eureka Server 来发现系统中的其他微服务，并执行相关的逻辑。

在服务注册与发现中，有一个注册中心。当服务器启动的时候，会把当前自己服务器的信息，比如服务地址、通讯地址等以别名方式注册到注册中心上。另一方（消费者|服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地RPC远程调用框架。核心设计思想在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系（服务治理概念）。在任何rpc远程框架中，都会有一个注册中心（存放服务地址相关信息（接口地址））。

Eureka 和Dubbo的架构对比：

![img](img/31f40d44-80d8-43a2-ae97-dade08bf1dce.jpg)![img](img/98639013-b79b-4811-a640-d48e4f6c8f2e.jpg)

### （4） Eureka两组件

Eureka Server：提供服务注册服务。各个微服务节点通过配置启动后，会在EurekaServer中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到。

Eureka Client：通过注册中心进行访问。是一个Java客户端，用于简化Eureka Server的交互，客户端同时也具备一个内置的、使用轮询(round-robin)负载算法的负载均衡器。在应用启动后，将会向Eureka Server发送心跳(默认周期为30秒)。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，EurekaServer将会从服务注册表中把这个服务节点移除（默认90秒）。

## 2、单机Eureka构建步骤

### （1） 新建eurekaServer端cloud-eureka-server7001服务注册中心

修改cloud-eureka-server7001的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-eureka-server7001</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
    </dependencies>
</project>
```

新增application.yml文件

```yaml
server:
  port: 7001
eureka:
  instance:
    hostname: localhost #eureka服务端的实例名称
  client:
    #false表示不向注册中心注册自己。
    register-with-eureka: false
    #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    fetch-registry: false
    service-url:
      #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```

新建主启动类EurekaMain7001

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author 王柳
 * @date 2020/4/3 15:21
 */
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
```

测试

![img](img/ac3dfc47-c90e-4cff-81ca-521a52b1aaad.jpg)

### （2） eurekaClient端cloud-provider-payment8001注册进eurekaServer成为服务提供者

修改cloud-provider-payment8001的pom.xml文件，添加如下配置：

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```

修改application.yml文件，添加如下配置：

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:7001/eureka
```

修改主启动类PaymentMain8001，添加如下注解@EnableEurekaClient：

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
```

测试，依次启动7001和8001，http://localhost:7001/访问如下：

![img](img/ecbac2ad-a448-40e2-a778-a79756f7b156.jpg)

### （3） eurekaClient端cloud-consumer-order80注册进eurekaServer成为服务消费者

修改cloud-consumer-order80的pom.xml文件，添加如下配置：

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```

修改application.yml，添加如下配置：

```yaml
spring:
  application:
    name: cloud-order-service
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:7001/eureka
```

修改主启动类OrderMain80，添加如下注解@EnableEurekaClient：

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 王柳
 * @date 2020/4/2 15:03
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
```

测试，先启动7001，再依次启动8001和80，http://localhost:7001/访问如下：

![img](img/18dc8d3e-4dfc-4df0-81fc-dfd1a355d191.jpg)

## 3、集群Eureka构建步骤

### （1） Eureka集群原理说明

![img](img/ff11d837-b80b-496d-ba98-2385b7bbbc60.jpg)

问题：微服务RPC远程服务调用最核心的是什么？

高可用。试想你的注册中心只有一个Only one，它出故障了会导致整个服务环境不可用。

解决办法：搭建Eureka注册中心集群，实现负载均衡 + 故障容错。

### （2）**EurekaServer集群环境构建**

参考cloud-eureka-server7001新建cloud-eureka-server7002。

修改7002的pom.xml文件的依赖同7001一样。

修改hosts映射配置：

![img](img/f8d12f47-4f68-4d4c-823f-c83b4a87eecb.jpg)

修改7001的application.yml配置如下：

```yaml
server:
  port: 7001
eureka:
  instance:
    hostname: eureka7001.com #eureka服务端的实例名称
  client:
    #false表示不向注册中心注册自己。
    register-with-eureka: false
    #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    fetch-registry: false
    service-url:
      #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。
      defaultZone: http://eureka7002.com:7002/eureka/
```

修改7002的application.yml配置如下：

```yaml
server:
  port: 7002
eureka:
  instance:
    hostname: eureka7002.com #eureka服务端的实例名称
  client:
    #false表示不向注册中心注册自己。
    register-with-eureka: false
    #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    fetch-registry: false
    service-url:
      #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。
      defaultZone: http://eureka7001.com:7001/eureka/
```

新建7002的主启动类EurekaMain7002：

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author 王柳
 * @date 2020/4/3 15:21
 */
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
```

**（3）将支付服务8001发布到2台Eureka集群配置中**

修改cloud-provider-payment8001的application.yml文件eureka配置如下：

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
```

### （4）将订单服务80发布到2台Eureka集群配置中

修改cloud-consumer-order80的application.yml文件eureka配置如下：

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
```

### （5）支付服务提供者8001集群环境构建

参考cloud-provider-payment8001新建cloud-provider-payment8002。

修改8002的pom.xml文件的依赖同8001一样。

新建8002的application.yml配置同8001。

新建8002的主启动类PaymentMain8002同8001。

将8001的业务类复制一份到8002中。

修改8001/8002的Controller，添加如下serverPort，并在日志打印：

```java
/**
 * @author 王柳
 * @date 2020/4/2 14:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果****：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，服务端口：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败，服务端口：" + serverPort);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果****：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：，服务端口：" + serverPort + id);
        }
    }
}
```

### （6）负载均衡

修改订单服务80访问支付服务的地址：

```java
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
...
}
```

使用@LoadBalanced注解赋予RestTemplate负载均衡的能力

```java
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

### （7）测试

 依次启动7001/7002、8001/8002、80，访问如下：

![img](img/ffb72aae-0e1e-4efa-a0b3-5584c9f44eb5.png)

![img](img/6b2ac20a-2f24-4841-a4b4-55e5ea47e4a1.png)

​                          

## 4、actuator微服务信息完善

### （1）主机名称:服务名称修改

当前问题：含有主机名称。

![img](img/bce96b6a-53ec-4817-af55-bd76a3321fac.png)

修改cloud-provider-payment8001的application.yml配置如下，cloud-provider-payment8002和cloud-consumer-order80相似的：

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
  instance:
    instance-id: payment8001
```

（2）访问信息有IP信息提示

![img](img/a5289d96-e0f0-4bd3-8e69-b24beff5bbfd.png)

修改cloud-provider-payment8001的application.yml配置如下，cloud-provider-payment8002和cloud-consumer-order80相似的：

```yaml
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
  instance:
    instance-id: payment8001
    prefer-ip-address: true     #访问路径可以显示IP地址
```

## 5、服务发现Discovery

对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息。

修改cloud-provider-payment8001的Controller：

```java
import org.springframework.cloud.client.discovery.DiscoveryClient;
    @Resource
    private DiscoveryClient discoveryClient;
    
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        log.info("************" + list);
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
http://localhost:8001/payment/discovery
```

修改cloud-provider-payment8001的主启动类PaymentMain8001，添加注解@EnableDiscoveryClient：

```java
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
```

![img](img/aad6f4e2-e946-486e-a698-3c11db2ab5ce.png)

## 6、eureka自我保护

### （1）故障现象

![img](img/e8158e4d-4246-4105-89ff-5c4ed43d59b3.jpg)

### （2）导致原因

- 一句话：某时刻某一个微服务不可用了，eureka不会立刻清理，依旧会对该微服务的信息进行保存。
- 属于CAP里面的AP分支。

### （3）怎么禁止自我保护

#### ① 为什么会产生Eureka自我保护机制

![img](img/97a09ddf-d866-4faa-bfdb-7e2a4d267638.jpg)

#### ② 什么是自我保护模式

默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。但是当网络分区故障发生时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是健康的，此时本不应该注销这个微服务。Eureka通过“自我保护模式”来解决这个问题——当EurekaServer节点在短时间内丢失过多客户端时（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。当网络故障恢复后，该Eureka Server节点会自动退出自我保护模式。

在自我保护模式中，Eureka Server会保护服务注册表中的信息，不再注销任何服务实例。当它收到的心跳数重新恢复到阈值以上时，该Eureka Server节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。

一句话讲解：好死不如赖活着。

综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka集群更加的健壮、稳定。

#### ③ 如何禁止自我保护

Eureka服务端通过eureka.server.enable-self-preservation = false 禁用自我保护模式。

服务端cloud-eureka-server7001修改application.yml设置如下配置：

```yaml
eureka:
  server:
    #关闭自我保护机制，保证不可用服务被及时剔除
    enable-self-preservation: false
    eviction-interval-timer-in-ms: 2000
```

客户端cloud-provider-payment8001修改application.yml设置如下配置：

```yaml
eureka:
  instance:
    #Eureka客户端向服务端发送心跳的时间间隔，单位为秒（默认是30秒）
    lease-renewal-interval-in-seconds: 1
    #Eureka服务端在收到最后一次心跳后等待时间上线，单位为秒（默认是90秒），超时将剔除服务
    lease-expiration-duration-in-seconds: 2
```

## 7、Eureka开启Security登录校验

Eureka服务端中导入相关依赖

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-security</artifactId>
        </dependency>
```

修改application.yml配置文件，客户端注册进服务中心，配置文件中eureka.service-url.defaultZone也必须添加用户名和密码：

```yaml
eureka:
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      #url中添加用户名和密码
      defaultZone: http://admin:123456@eureka7001.com:7001/eureka/,http://admin:123456@eureka7002.com:7002/eureka/
spring:
  security:
    user:
      name: admin  #用户名
      password: 123456 #密码
```

新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，要在eureka服务端配置security的csrf检验为false，否则eureka 客户端无法注册到eureka

配置WebSecurityConfig

```java
/**
 * 新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false
 *
 * @author 王柳
 * @date 2019/11/7 11:16
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭csrf
                .authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
```

![img](img/4f59fe97-aec4-45aa-9131-582b0bb0ea29.png)

# 六、Zookeeper服务注册与发现

## 1、注册中心Zookeeper

![img](img/b1d75d28-9ed1-4bce-9909-11c7be7f6a53.jpg)

Zookeeper服务节点是临时性的。

**作为服务注册中心，Eureka比Zookeeper好在哪里：**

![img](img/b6f8be03-cd3b-4653-bf1c-aef682d878a0.jpg)

著名的CAP理论指出，一个分布式系统不可能同时满足C（一致性）、A（可用性）和P（分区容错性）。由于分区容错性P是分布式系统中必须要保证的，因此我们只能在A和C之间进行权衡。

Eureka遵守AP原则，Zookeeper遵守CP原则。

Zookeeper：当向注册中心查询服务列表时，我们可以容忍注册中心返回的是几分钟以前的注册信息，但不能接受服务之间down掉不可用。也就是说，服务注册功能对可用性的要求要高于一致性。但是Zookeeper会出现这样一种情况，但master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行leader选举。问题在于，选举leader的实际太长，30~120s，且选举期间整个Zookeeper集群都是不可用的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因网络问题使得Zookeeper集群失去master节点是较大概率会发生的事，虽然服务能够最终恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。

Eureka：Eureka看明白了这一点，因此在设计时就优先保证可用性。Eureka各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余的节点依然可以提供注册和查询服务。而Eureka的客户端在向某个Eureka注册时如果发现连接失败，则会自动切换至其他节点，只要有一台Eureka还在，就能保证注册服务可用（保证可用性），只不过查到的信息可能不是最新的（不保证强一致性）。除此之外，Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就任务客户端与注册中心出现了网络故障，此时会出现以下几种情况：

（1）、Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务

（2）、Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其他节点上（即保证当前节点依然可用）

（3）、当网络稳定时，当前实例新的注册信息会被同步到其他节点中

因此，Eureka可用很好的应对因网络故障导致部分节点失去联系的情况，而不会像Zookeeper那样使整个注册服务瘫痪。

Zookeeper安装请参考：[centos7上安装zookeeper](wiz://open_document?guid=009ed256-4aa1-48a4-a818-231d3094f4ce&kbguid=&private_kbguid=9e15e816-792d-4528-9d21-a849cc4117d5)

## 2、服务提供者

### （1）新建cloud-provider-payment8004

### （2）修改cloud-provider-payment8004的pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-provider-payment8004</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <!--   SpringBoot整合Zookeeper客户端     -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml文件

```yaml
#8004表示注册到Zookeeper服务器的支付服务提供者端口号
server:
  port: 8004
spring:
  application:
    #服务别名---注册Zookeeper到注册中心名称
    name: cloud-payment-service
  cloud:
    zookeeper:
      # Zookeeper安装所在服务器地址和Zookeeper配置的端口
      connect-string: 192.168.253.129:2181
```

### （4）新建主启动类PaymentMain8004

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableDiscoveryClient //  该注解用于向使用consul或者Zookeeper作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
```

### （5）新建Controller类

```java
package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
/**
 * @author 王柳
 * @date 2020/4/2 14:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/zk")
    public String paymentZk() {
        return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
```

### （6）启动8004注册进zookeeper

启动报如下错误，提示是Zookeeper版本jar包冲突，需要修改pom.xml文件排除依赖：

![img](img/11b0bb22-ed1b-4e6c-aded-5912f9b4a8f2.png)

 

```xml
        <!--   SpringBoot整合Zookeeper客户端     -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
            <!--     先排除自带的Zookeeper3.5.3       -->
            <exclusions>
                <exclusion>
                    <groupId>org.apache.zookeeper</groupId>
                    <artifactId>zookeeper</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--    添加我们安装的Zookeeper对应的版本    -->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.14</version>
             <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
```

![img](img/a86d1447-2e2a-4c60-a0ca-db83817f00ed.png)

![img](img/609366ca-6890-4933-80a7-c429b9cf1912.png)

## 3、服务消费者

### （1）新建cloud-consumerzk-order80

### （2）修改cloud-consumerzk-order80的pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-consumerzk-order80</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <!--   SpringBoot整合Zookeeper客户端     -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
            <!--     先排除自带的Zookeeper3.5.3       -->
            <exclusions>
                <exclusion>
                    <groupId>org.apache.zookeeper</groupId>
                    <artifactId>zookeeper</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--    添加我们安装的Zookeeper对应的版本    -->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.14</version>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml文件

```yaml
#8004表示注册到Zookeeper服务器的支付服务提供者端口号
server:
  port: 80
spring:
  application:
    #服务别名---注册Zookeeper到注册中心名称
    name: cloud-order-service
  cloud:
    zookeeper:
      # Zookeeper安装所在服务器地址和Zookeeper配置的端口
      connect-string: 192.168.253.129:2181
```

### （4）新建主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableDiscoveryClient //  该注解用于向使用consul或者Zookeeper作为注册中心时注册服务
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
```

### （5）新建业务类

```java
package com.atguigu.springcloud.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

 

```java
package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:12
 */
@RestController
@Slf4j
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
```

### （6）启动80注册进Zookeeper

![img](img/4e865708-ec55-4940-8053-18f0e2909112.png)

![img](img/5ea7d092-e3ea-4ceb-b2d5-a8c4073765bc.png)

# 七、Consul服务注册与发现

## 1、Consul简介

### （1）是什么

官网：https://www.consul.io/intro/index.html

https://learn.hashicorp.com/consul

![img](img/0a9a02ce-06be-462b-a154-f555b8f8dd2f.jpg)

### （2）能干嘛

![img](img/bef38941-1490-44b9-b2c4-0e7cd5b9d11b.jpg)

### （3）去哪下

https://www.consul.io/downloads.html

### （4）怎么玩

https://www.springcloud.cc/spring-cloud-consul.html

![img](img/9e92c498-f037-4500-a5c9-c50e38587157.png)

## 2、安装并运行Consul

### （1）官网安装说明

https://learn.hashicorp.com/consul/getting-started/install.html

### （2）下载完成双击运行

![img](img/9e11140f-ed00-459a-a692-7fa5b53ded71.jpg)

### （3) 使用开发模式启动

cmd到安装目录下，使用如下命令启动：

```shell
consul agent -dev
```

通过以下地址访问Consul的首页：

http://localhost:8005

![img](img/2e9d2c36-0ba9-4ffc-8d5d-1a26479f00fa.jpg)

## 3、服务提供者

### （1）新建Module支付服务cloud-providerconsul-payment8006

### （2）修改cloud-providerconsul-payment8006的pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-providerconsul-payment8006</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-consul-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml文件

 

```
#consul服务端口号
server:
  port: 8006
spring:
  application:
    name: consul-provider-payment
  cloud: 
    consul:
      host: localhost
      port: 8500
      discovery:
        service-name: ${spring.application.name}
```

### （4）新建主启动类Payment8006

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableDiscoveryClient //  该注解用于向使用consul或者Zookeeper作为注册中心时注册服务
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
```

### （5）新建业务类Controller

```java
package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
/**
 * @author 王柳
 * @date 2020/4/2 14:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
```

### （6）测试

![img](img/5b6844df-ba7a-4f23-9644-8bc90eca230c.jpg)

![img](img/38045f6d-d6ab-4967-a69d-0fb4fc19ecdf.jpg)

## 4、服务消费者

### （1）新建Module消费服务cloud-consumerconsul-order80

### （2）修改cloud-consumerconsul-order80的pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-consumerconsul-order80</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-consul-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml文件

```yaml
#consul服务端口号
server:
  port: 80
spring:
  application:
    name: consul-consumer-order
  cloud:
    consul:
      host: localhost
      port: 8500
      discovery:
        service-name: ${spring.application.name}
```

### （4）新建主启动类OrderConsulMain80

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/2 14:17
 */
@SpringBootApplication
@EnableDiscoveryClient //  该注解用于向使用consul或者Zookeeper作为注册中心时注册服务
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}
```

### （5）新建业务类Controller

```java
package com.atguigu.springcloud.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

 

```java
package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:12
 */
@RestController
@Slf4j
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
```

### （6）测试

![img](img/6a864d7d-5701-4ab0-b647-e54f269955ab.jpg)

## 5、三个注册中心异同点

### （1）Eureka、Consul、Zookeeper异同

![img](img/f2b6ce70-138e-4a3e-9603-672982d9252e.jpg)

### （2）CAP理论

![img](img/9a99ed87-84db-4e56-accc-6e3f58bed27a.jpg)

![img](img/ceab4966-b68a-49a3-b72f-52f8f7e33ab4.jpg)

![img](img/8b2c4c2f-dd79-4af0-9f24-cfb198b4843c.jpg)

### （3）AP（Eureka）

![img](img/897f54a5-3f3a-4a33-979c-965b62283b44.jpg)

![img](img/58d437c7-5f55-46dd-baf2-e722cf9bd9d9.jpg)

### （4）CP（Zookeeper/Consul）

![img](img/7c1c9eae-ff45-48b0-9e65-c460e4b535ad.jpg)

![img](img/953932a4-136b-4b02-aaf9-41701fb1602d.jpg)

# 八、Ribbon负载均衡服务调用

## 1、概述

### （1）是什么

Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。

简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法，将Netflix的中间层服务连接在一起。Ribbon客户端组件提供一系列完善的配置项如连接超时，重试等。简单的说，就是在配置文件中列出Load Balancer（简称LB）后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随机连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。

### （2）官网资料

官网资料：https://github.com/Netflix/ribbon/wiki/Getting-Started

Ribbon目前也进入维护模式，未来替换方案如下：

![img](img/63dcab72-bcdb-4eec-b1ec-eb3ba6410f2a.jpg)

### （3）能干吗

LB（负载均衡）：LB，即负载均衡(Load Balance)，在微服务或分布式集群中经常用的一种应用。负载均衡简单的说就是将用户的请求平摊的分配到多个服务上，从而达到系统的HA（高可用）。常见的负载均衡有软件Nginx，LVS，硬件 F5等。相应的在中间件，例如：dubbo和SpringCloud中均给我们提供了负载均衡，SpringCloud的负载均衡算法可以自定义。 

![img](img/254157b5-26f5-4202-9d50-49351726fa6f.jpg)

集中式LB：即在服务的消费方和提供方之间使用独立的LB设施(可以是硬件，如F5, 也可以是软件，如nginx), 由该设施负责把访问请求通过某种策略转发至服务的提供方。

进程内LB：将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的服务器。Ribbon就属于进程内LB，它只是一个类库，集成于消费方进程，消费方通过它来获取到服务提供方的地址。

## 2、Ribbon负载均衡演示

### （1）架构说明

![img](img/bf23f998-90ae-49ac-9c2a-e8e990edc63a.png)

![img](img/4dbcc332-36d5-4a9a-bdd2-b33a9a830ad5.jpg)

Ribbon在工作时分成两步：

- 第一步先选择 EurekaServer ,它优先选择在同一个区域内负载较少的server；
- 第二步再根据用户指定的策略，在从server取到的服务注册列表中选择一个地址。

其中Ribbon提供了多种策略：比如轮询、随机和根据响应时间加权。

### （2）POM

![img](img/b2f96b45-5a6e-40f2-b98e-e586b35ec8f7.jpg)

### （3）RestTemplate的使用

#### ① 官网

![img](img/b447a110-addf-48c5-b6fc-78b6881b09f1.jpg)

#### ② getForObject方法/getForEntity方法

![img](img/59e47db8-6e85-412b-8249-b0769cdfc640.jpg)

#### ③ postForObject/postForEntity

#### ④ Get请求方法

#### ⑤ Post请求方法

## 3、Ribbon核心组件IRule

### （1）IRule

#### ① 定义

根据特定算法中从服务列表中选取一个要访问的服务。

![img](img/58f94a41-b954-4071-9ddd-9a329206f631.jpg)

#### ② 7种IRule规则

- RoundRobinRule：轮询；
- RandomRule：随机；
- AvailabilityFilteringRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阀值的服务，然后对剩余的服务列表按照轮询策略进行访问；
- WeightedResponseTimeRule：根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule；
- RetryRule：先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务；
- BestAvailableRule：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务；
- ZoneAvoidanceRule：默认规则，复合判断server所在区域的性能和server的可用性选择服务器。

### （2）如何替换

#### ① 修改cloud-consumer-order80

#### ② 注意配置细节

官方文档明确给出了警告：这个自定义配置类（MySelfRule）不能放在@ComponentScan所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说我们达不到特殊化定制的目的了。

#### ③ 新建package

com.atguigu.myrule

#### ④ 新建MySelfRule规则类

```java
package com.atguigu.myrule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author 王柳
 * @date 2020/4/4 16:49
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 达到的目的，用我们重新选择的随机算法替代默认的轮询
        return new RandomRule();
    }
}
```

#### ⑤ 主启动类添加@RibbonClient

```java
package com.atguigu.springcloud;
import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
/**
 * @author 王柳
 * @date 2020/4/2 15:03
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
```

#### ⑥ 测试，多次刷新

![img](img/1cf47007-fa18-4d79-8fcb-17fa37d316a7.jpg)

## 4、Ribbon负载均衡算法

### （1）原理

![img](img/7a939bfe-c4d7-41c9-85e2-3273cbdb3750.jpg)

**（2）源码**

https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java

### （3）自定义负载均衡算法

#### ① 7001、7002集群启动

#### ② 8001、8002微服务改造

PaymentController类添加如下：

```java
    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }
```

#### ③ 80微服务改造

##### ApplicationContextConfig去掉@LoadBalanced注解

```java
package com.atguigu.springcloud.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

##### LoadBalancer接口

```java
package com.atguigu.springcloud.lb;
import org.springframework.cloud.client.ServiceInstance;
import java.util.List;
/**
 * @author 王柳
 * @date 2020/4/4 17:26
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
```

##### MyLB实现类

```java
package com.atguigu.springcloud.lb;
import org.springframework.cloud.client.ServiceInstance;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author 王柳
 * @date 2020/4/4 17:27
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****next: " + next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
```

##### OrderController

```java
package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
/**
 * @author 王柳
 * @date 2020/4/2 15:12
 */
@RestController
@Slf4j
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD_PAYMENT_SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
```

##### 测试

http://localhost/consumer/payment/lb

![img](img/e00446b3-22cd-4943-9447-a388b5f249d7.png)

# 九、OpenFeign服务接口调用

##  1、概述

### （1）OpenFeign是什么

官网解释：https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.2.2.RELEASE/reference/html/

Feign是一个声明式WebService客户端。使用Feign能让编写Web Service客户端更加简单。它的使用方法是定义一个服务接口，然后在上面添加注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。

Feign是一个声明式的Web服务客户端，使得编写Web服务客户端变得非常容易，只需要创建一个接口，然后在上面添加注解即可。

参考官网：https://github.com/spring-cloud/spring-cloud-openfeign

### （2）能干嘛

Feign能干什么：

Feign旨在使编写Java Http客户端变得更容易。

前面在使用Ribbon+RestTemplate时，利用RestTemplate对http请求的封装处理，形成了一套模版化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。所以，Feign在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义。在Feign的实现下，我们只需创建一个接口并使用注解的方式来配置它(以前是Dao接口上面标注Mapper注解,现在是一个微服务接口上面标注一个Feign注解即可)，即可完成对服务提供方的接口绑定，简化了使用Spring cloud Ribbon时，自动封装服务调用客户端的开发量。

Feign集成了Ribbon：

利用Ribbon维护了MicroServiceCloud-Dept的服务列表信息，并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，通过feign只需要定义服务绑定接口且以声明式的方法，优雅而简单的实现了服务调用。

### （3）Fegin和OpenFegin两者区别

![img](img/7e005974-d129-4eca-a252-15fc4adc8637.jpg)

## 2、OpenFegin使用步骤

### （1）新建cloud-consumer-fegin-order80

**Fegin在消费端使用**

### （2）修改cloud-consumer-fegin-order80的pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-consumer-fegin-order80</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml文件

```yaml
server:
  port: 80
eureka:
  client: 
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
```

### （4）新建主启动类，添加注解@EnableFeignClients

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author 王柳
 * @date 2020/4/2 15:03
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
```

### （5）新建业务类

业务逻辑接口+@FeginClient配置调用provider服务

新建PaymentFeginService接口并新增注解@FeginClient

```java
package com.atguigu.springcloud.service;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @author 王柳
 * @date 2020/4/5 12:42
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeginService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
```

控制层Controller

```java
package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * @author 王柳
 * @date 2020/4/5 12:44
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeginService paymentFeginService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeginService.getPaymentById(id);
    }
}
```

### （6）测试

**Fegin自带负载均衡配置项。**

先启动2个Eureka集群7001/7002；

再启动2个微服务8001/8002；

启动OrderFeign80；

![img](img/26871a58-932e-4d21-aa30-a75bd4858046.png)

### （7）总结

![img](img/57921559-1e93-4fc3-b54a-8131b2d17126.jpg)

## 3、OpenFeign超时控制

### （1）超时设置，故意设置超时演示出错情况

#### ① 服务提供方8001添加超时方法PaymentController

```java
    @GetMapping("/payment/fegin/timeout")
    public String paymentFeginTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
```

#### ② 服务方80添加超时方法PaymentFeginService 

```java
    @GetMapping("/payment/fegin/timeout")
    String paymentFeginTimeout();
```

#### ③ 服务方80添加超时方法OrderController

```java
    @GetMapping("/consumer/payment/fegin/timeout")
    public String paymentFeginTimeout(){
        return paymentFeginService.paymentFeginTimeout();
    }
```

#### ④ 测试

![img](img/2d58afe5-4672-43c2-844e-91ba95290ff6.png)

### （2）OpenFeign默认等待1秒钟，超过后报错

### （3）是什么

OpenFeign默认支持Ribbon

![img](img/a3da87ec-fd85-47ab-8a32-c78305078620.jpg)

### （4）YML文件需要开启OpenFeign客户端超时控制

```yaml
server:
  port: 80
eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
# 设置fegin客户端超时时间（OpenFeign默认支持Ribbon）
ribbon:
  #指的是建立连接后从服务器读取到可用资源所用时间
  ReadTimeout: 5000 # 5秒
  #指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间
  ConnectTimeout: 5000
```

![img](img/f441e631-6928-4d56-bddc-a44ab0ff1b2b.jpg)

## 4、OpenFeign日志打印功能

### （1）是什么

![img](img/9862ea3d-95a9-42e7-8c39-94a836659af4.jpg)

### （2）日志级别

![img](img/679a81ab-5cfa-4486-a98c-a9f5cf034440.jpg)

### （3）配置日志Bean

```java
package com.atguigu.springcloud.config;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author 王柳
 * @date 2020/4/5 13:04
 */
@Configuration
public class FeginConfig {
    @Bean
    public Logger.Level feginLoggerLevel() {
        return Logger.Level.FULL;
    }
}
```

### （4）YML文件需要开启日志的Fegin客户端

```yaml
server:
  port: 80
eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/
# 设置fegin客户端超时时间（OpenFeign默认支持Ribbon）
ribbon:
  #指的是建立连接后从服务器读取到可用资源所用时间
  ReadTimeout: 5000 # 5秒
  #指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间
  ConnectTimeout: 5000
logging:
  level: 
    com.atguigu.springcloud.service.PaymentFeginService: debug
```

### （5）后台日志查看

![img](img/7cf0ff31-6863-4d5d-91b2-451c1dc3c77d.jpg)

# 十、Hystrix断路器

## 1、概述

### （1）分布式系统面临的问题

#### ① 分布式系统面临的问题

复杂分布式体系结构中的应用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免地失败。

![img](img/b512cc53-4d0e-4f7d-a41b-b30a25c9f5d1.jpg)

#### ② 服务雪崩

多个微服务之间调用的时候，假设微服务A调用微服务B和微服务C，微服务B和微服务C又调用其它的微服务，这就是所谓的“扇出”。如果扇出的链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的系统资源，进而引起系统崩溃，所谓的“雪崩效应”.

 对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，以便单个依赖关系的失败，不能取消整个应用程序或系统。

![img](img/cfd4d871-b055-4c36-a966-56d1d62d6184.jpg)

### （2）是什么

**Hystrix**是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。

“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个符合预期的、可处理的备选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。

### （3）能干嘛

- 服务降级
- 服务熔断
- 服务限流
- 接近实时的监控

### （4）官网资料

https://github.com/Netflix/Hystrix/wiki/How-To-Use

### （5）Hystrix官宣，停更进维

## 2、Hystrix重要概念

### （1）服务降级

![img](img/0a04ca38-da29-4621-8759-e0754cf3344d.jpg)

![img](img/035595bd-79ff-4ee8-a054-6cc4a8d3b06a.jpg)

### （2）服务熔断

![img](img/3a0a4769-059c-40e4-b63f-7b1987f32d99.jpg)

![img](img/e4529c0d-bfda-475f-8233-2ceaecf9106a.jpg)

### （3）服务限流

![img](img/5c2133d1-dcee-42a3-b3d9-4eaf83b7f7f4.jpg)

## 3、Hystrix案例

### （1）构建Hystrix案例

#### ① 新建cloud-provider-hystrix-payment8001

#### ② 修改pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-provider-hystrix-payment8001</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

#### ③ 新建application.yml

```yaml
server:
  port: 8001

spring:
  application:
    name: cloud-payment-hystrix-service


eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
```

#### ④ 新建主启动类PaymentHystrixMain8001

```java
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 王柳
 * @date 2020/4/13 16:23
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
```

#### ⑤ 新建业务类

```java
package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 王柳
 * @date 2020/4/13 16:24
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    public String paymentInfo_TimeOut(Integer id) {
        Integer tumeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(tumeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时: " + tumeNumber + "秒钟";
    }
}

```

 

```java
package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王柳
 * @date 2020/4/13 16:25
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value(("${server.port}"))
    private String serverPort;

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("********result: " + result);
        return result;
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("********result: " + result);
        return result;
    }
}

```

#### ⑥ 正常测试

![img](img/6dd768a6-8415-4faf-b94d-ed57fb1ddc7b.jpg)

### （2）高并发测试

#### ① Jmeter压测测试

Jmeter下载：https://downloads.apache.org/jmeter/binaries/

开启Jmeter，来20000个并发压死8001,20000个请求都去访问paymentInfo_TimeOut

![img](img/e613ea4b-dbe2-41d7-9c65-6f57ef21d19e.jpg)

![img](img/42c814a0-d8b2-4a39-bfba-06e5a93c8710.jpg)

再来一个访问：http://localhost:8001/payment/hystrix/ok/31

演示结果：两个都在自己转圈圈

![img](img/1d8e7a21-29ad-406e-bc1c-290eddb63935.jpg)

#### ② Jmeter压测结论

![img](img/ddcc3e1e-da98-4d3e-bd00-d2c1d93857c6.jpg)

#### ③ 新建cloud-consumer-fegin-hystrix-order80

修改pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-consumer-fegin-hystrix-order80</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>

```

新建application.yml

```yaml
server:
  port: 80

eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/

```

新建主启动类

```java
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 王柳
 * @date 2020/4/2 15:03
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}

```

新建业务类

```java
package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 王柳
 * @date 2020/4/5 12:42
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}

```

 

```java
package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王柳
 * @date 2020/4/13 16:25
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value(("${server.port}"))
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
}

```

正常测试：

![img](img/cd2eea12-4559-4914-9bfc-80899525b240.png)

高并发测试：

![img](img/7976a248-e9df-4e0c-9a01-b43f27d6e2e3.jpg)

![img](img/68355de9-60f1-4d6b-abf1-a22801ea4c13.jpg)

### （3）故障现象和导致原因

![img](img/e80c5e94-f9ac-40c8-885f-b534c5289b84.jpg)

![img](img/98370669-09e3-47ae-985c-75d5bc17a6fc.jpg)

### （4）如何解决？解决的要求

![img](img/1d402c08-dbb5-4d91-ab05-bb06cc5ef7a8.jpg)

**解决**：

- 对方服务（8001）超时了，调用者（80）不能一直卡死等待，必须有服务降级；
- 对方服务（8001）down机了，调用者（80）不能一直卡死等待，必须有服务降级；
- 对方服务（8001）OK，调用者（80）自己出故障或有自我要求（自己的等待时间小于服务提供者），自己处理降级；

### （5）服务降级

降级配置：**@HystrixCommand**

#### ① 8001先从自身找问题

![img](img/a263d2a4-e2e4-4c4f-b12b-78ba86e150d0.jpg)

#### ② 8001fallback

##### 业务类启用**@HystrixCommand**

```java
@Service
public class PaymentService {
    ...
        
    /**
     * 超时放，演示降级
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMulliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        Integer tumeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(tumeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时: " + tumeNumber + "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "/(ToT)/调用支付接口超时或异常：\t" + "\t当前线程池名字：" + Thread.currentThread().getName();
    }
}
```

##### 主启动类激活@EnableCircuitBreaker

```java
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 王柳
 * @date 2020/4/13 16:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
```

##### @HystrixCommand报异常如何处理

![img](img/1cae5f42-9718-47fe-ab16-cbb395ce377e.jpg)

![img](img/49a7ab7d-0576-46b4-a36b-ccd97a1cd799.jpg)

![img](img/a5190f9a-8edd-4e84-8b3d-4e295e0a50b8.jpg)

#### ③ 80fallback

![img](img/fa9052a3-6c97-425b-a767-bbe911fe0bc1.jpg)

![img](img/77779354-92b6-4f5c-9125-257e6e7c468c.jpg)

##### 修改application.yml，添加降级配置feign

```yaml
server:
  port: 80

eureka:
  client:
    register-with-eureka: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/

feign:
  hystrix:
    enabled: true
```

##### 修改主启动类，@EnableHystrix

```java
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}

```

##### 修改业务类OrderHystrixController

```java
@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    ...
        
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，w(ﾟДﾟ)w";
    }
}

```

![img](img/0fbc3377-3c5b-4541-bc49-e2070eeb93e7.png) 

#### ④ 目前问题

![img](img/36ae0379-174a-4165-8ca1-d831566d68d2.jpg)

#### ⑤ 解决问题

##### 定义全局fallback方法

![img](img/f0cba301-321f-4a13-8cb7-0b3933286984.jpg)

![img](img/448bc575-6804-46e2-b315-162caa947310.jpg)

```java
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;
    
    ...

//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
////    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，w(ﾟДﾟ)w";
    }

    /**
     * 全局fallback方法
     *
     * @return
     */
    public String payment_Global_FallBackMethod() {
        return "Global异常处理信息，请稍后再试，~~~~(>_<)~~~~";
    }
}

```

![img](img/e8b5b6a0-4bc4-4c87-b1d0-dbeb467f7a54.png)

##### fegin接口系列降级配置

![img](img/1e1c597a-18f9-4af4-9293-dcce3a52ad9b.jpg)

![img](img/02c774a3-a055-45d7-98e0-ab5d395ad212.jpg)

![img](img/3c9badd3-5f4c-471f-9a2c-a7433bafa451.jpg)

新建PaymentFallBackService

```java
package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 王柳
 * @date 2020/4/13 17:59
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallBackService fall back-paymentInfo_OK,O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallBackService fall back-paymentInfo_TimeOut,~~~~(>_<)~~~~";
    }
}

```

修改application.yml

![img](img/5c5c58d8-92d7-4a33-a774-0c4e45b1482f.jpg)

修改PaymentHystrixService

```java
package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 王柳
 * @date 2020/4/5 12:42
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}

```

测试：

![img](img/925bc1fa-b57f-4e51-bf0b-7dfada047a64.jpg)

![img](img/e52ae9bc-564f-4750-b194-5459892ab564.jpg)

![img](img/c377f953-1a76-44f9-8e1a-edf987bee243.png)

### （6）服务熔断

#### ① 断路器

一句话就是家里的保险丝。

#### ② 熔断是什么

![img](img/af36ba2a-aa6f-451a-9565-7c16a0e127e4.jpg)

#### ③ 实操

##### 修改cloud-provider-hystrix-payment8001

##### 修改PaymentService

```java
    @HystrixCommand(fallbackMethod = "paymentCircuitBreadker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreadker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreadker_fallback(Integer id) {
        return "id 不能为负数,请稍后再试，~~~~(>_<)~~~~ id:  " + id;
    }
```

![img](img/f0004493-1fed-4bbe-8e9e-b692a8007fab.jpg)

**修改PaymentController**

```java
    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentIpaymentCircuitBreadkernfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreadker(id);
        log.info("********result: " + result);
        return result;
    }
```

##### 测试

![img](img/74d96be2-f9d5-4414-af21-0900aff78bfa.jpg)

#### ④ 原理（小总结）

##### 大神结论

![img](img/443d1a85-1790-4b9b-8252-2c1911712994.jpg)

##### 熔断类型

![img](img/c6111062-5223-48f3-9c15-c39576c91cf9.jpg)

##### 官网断路器流程图

![img](img/1f4d87ad-a3c6-476e-9052-6196979b5cc6.jpg)

##### 官网步骤

![img](img/4e91aeee-e39d-4943-8fc6-1248e86f3a30.jpg)

##### 断路器在什么情况下开始起作用

![img](img/69cef2d1-8622-4616-9932-8ed0f04560db.jpg)

##### 断路器开启或关闭的条件

![img](img/e7f810d9-81ef-457c-a28c-14812bd6d75c.jpg)

![img](img/d9ac1e99-3073-498b-bc07-bed9d57518df.jpg)

##### All配置

所有配置均可在HystrixPropertiesManager中找到：

```java
/**
 * This class provides methods to set hystrix properties.
 */
public final class HystrixPropertiesManager {
    ...
}
```

![img](img/4c4d057e-8b5b-4f3a-85b0-1b3ac07b9f7c.jpg)

![img](img/52bf6101-21f7-49b4-bdb4-10049d6ce5a7.jpg)

![img](img/3f7d0839-6dd7-4381-a978-12dbdc034ada.jpg)

![img](img/a3dbf55a-12e5-4384-a6ae-42d9ddc94159.jpg)

![img](img/8095c24c-fd07-4a33-91a5-232dff5a7455.jpg)

### （7）服务限流

后面Alibaba的Sentinel说明。

## 4、Hystrix工作流程

官网资料：https://github.com/Netflix/Hystrix/wiki/How-To-Use

![img](img/738eda7a-97ab-4a1a-ab2b-ffa1affce97a.jpg)

### 

![img](img/31fb36c8-da45-4a37-9b77-8285d29a629d.jpg)

## 5、服务监控HystrixDashboard

### （1）概述

![img](img/b1ff29cf-e429-4a59-9ef5-2cc0da6fc274.jpg)

### （2）仪表盘9001

#### ① 新建cloud-consumer-hystrix-dashboard9001

#### ② 修改pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloud-consumer-hystrix-dashboard9001</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>

```

#### ③ 新建application.yml

```yaml
server:
  port: 9001
```

#### ④ 新建主启动类HystrixDashboardMain9001

```java
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 王柳
 * @date 2020/4/13 18:44
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}

```

#### ⑤监控依赖配置

所有Provider微服务提供类（8001/8002/...)都需要监控依赖配置

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```

#### ⑥ 测试

启动cloud-consumer-hystrix-dashboard9001，该微服务后续将监控微服务8001

http://localhost:9001/hystrix

![img](img/f12dc974-436a-48bd-872d-625bcc9e34b4.png)

### （3）断路器演示

#### ① 修改cloud-provider-hystrix-payment8001

注意：新版本Hystrix需要在主启动类PaymentHystrixMain8001中指定监控路径：

```java
package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 王柳
 * @date 2020/4/13 16:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，SpringCloud升级后的坑
     * ServletRegistrationBean因为SpringBoot的默认路径不是“/hystrix.stream”，
     * 只要在自己的项目里配置上下面的servlet就可以了
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}

```

#### ②监控测试

启动1个Eureka或几个Eureka集群均可，观察监控窗口。

#### ③ 9001监控8001

![img](img/d1c68ed9-90c6-4d25-a34d-07eff2b143fe.jpg)

#### ④ 测试地址

http://localhost:8001/payment/hystrix/timeout/31

[http://localhost:8001/payment/hystrix/timeout/-31](http://localhost:8001/payment/hystrix/timeout/31)

先访问正确地址，再访问错误地址，再正确地址，会发现图示断路器都是慢慢放开的。

请求成功：

![img](img/c5866dbc-73be-472b-932a-01b7aa6ed576.jpg)

请求失败：

![img](img/2353597e-4742-4163-9553-9f561dc8fd75.jpg)

#### ⑤ 如何看

##### 7色

##### 1圈

实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，它的健康度从绿色<黄色<橙色<红色递减。

该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，就可以在大量的实例中快速的发现故障实例和高压力实例。

##### 1线

曲线：用来记录2分钟内流量的相对变化，可以通过它来观察到流量的上升和下降趋势。

##### 整图说明

![img](img/6f270d98-9b1c-4c32-950d-267bfc322e0a.jpg)

![img](img/b7d5e2af-7025-4961-9dfb-510a748e519c.jpg)

#### ⑥ 搞懂一个才能看懂复杂的

![img](img/4b5c57dc-d442-432a-bdd3-fccde0c23fdf.jpg)

# 十一、Zuul路由网关

参考[SpringCloud实战学习](wiz://open_document?guid=a6a8e6ec-bf20-4a66-9d7b-4fbd37fb1d26&kbguid=&private_kbguid=9e15e816-792d-4528-9d21-a849cc4117d5)中的Zuul章节。

GitHub地址： [https://github.com/wangliu1102/SpringCloudStudy-Practical](https://github.com/wangliu1102/SpringCloudStudy-Practical.git)

## 1、Zuul简介说明

Zuul包含了对请求的路由和过滤两个最主要的功能：

其中路由功能负责将外部请求转发到具体的微服务实例上，是实现外部访问统一入口的基础。而过滤器功能则负责对请求的处理过程进行干预，是实现请求校验、服务聚合等功能的基础。Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获得其他微服务的消息，也即以后的访问微服务都是通过Zuul跳转后获得。

注意：Zuul服务最终还是会注册进Eureka。

 **提供=代理+路由+过滤三大功能**

## 2、如何使用

### （1）导入相关依赖

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
```

### （2）开启注解

```java
@EnableZuulProxy
```

![img](img/11df6556-5dfe-4c1d-ac86-b1c3a8147492.png)

### （3）修改application.yml配置文件

zuul也需要注册进注册中心，所以也需要添加Eureka客户端相关配置

```yaml
server:
  port: 9527
spring:
  application:
    name: gateway
#prefix表示访问前缀，ignored-services忽略所有请求，不包括zuul.routes指定的路径,
#zuul:
#  prefix: /abc
#  ignored-services: "*"
# routes to serviceId 这里边是通过serviceId来绑定地址，当在路径后添加/api-a/   则是访问service-A对应的服务。
# ** 表示多层级，*表示单层级
zuul:
  routes:
    defalutApi:
      path: /api/**
      serviceId: student
    apiB:
      path: /admin/**
      serviceId: course
    oa:
      path: /oa/**
      serviceId: oa
    member:
      path: /member/**
      serviceId: member
      sensitiveHeaders: "*"
    auth:
      path: /auth/**
      serviceId: oauth2
      sensitiveHeaders: "*"
  retryable: false
  ignored-services: "*"
  ribbon:
    eager-load:
      enabled: true
  host:
    connect-timeout-millis: 3000
    socket-timeout-millis: 3000
  add-proxy-headers: true
# Zuul超时
# 对于通过serviceId路由的服务,需要设置两个参数：ribbon.ReadTimeout 和ribbon.SocketTimeout
# 对于通过url路由的服务,需要设置两个参数：zuul.host.socket-timeout-millis或zuul.host.connect-timeout-millis
ribbon:
      ReadTimeout: 3000  # 单位毫秒数
  SocketTimeout: 3000
  MaxAutoRetries: 1
  MaxAutoRetriesNextServer: 2
  eureka:
    enabled: true
hystrix:
  command:
    default:
      execution:
        timeout:
          enabled: true
        isolation:
          thread:
            timeoutInMilliseconds: 24000
eureka:
  client:
    service-url:
      defaultZone: http://admin:123456@eureka7001.com:7001/eureka,http://admin:123456@eureka7002.com:7002/eureka
  instance:
      instance-id: gateway9527 #自定义服务名称信息
      prefer-ip-address: true #访问路径可以显示IP地址
info:
  app.name: springcloud-server
  company.name: www.wangliu.com
  build.artifactId: '@project.artifactId@'
  build.version: '@project.version@'
```

### （4）解决客户端调用跨域问题

可以在代码中添加相关配置信息

```java
/**
 * @Description 解决客户端调用跨域问题
 * @Author 王柳
 * @Date 2019/10/11 8:54
 */
@Component
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(18000L);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
```

### （5）Zuul还有过滤器的功能

可以自定义路由过滤器，添加自定义过滤规则

```java
/**
 * @Description 自定义路由过滤器
 * @Author 王柳
 * @Date 2019/10/11 8:55
 */
@Slf4j
@Component
public class WebFilter extends ZuulFilter {
    /**
     * 该函数需要返回一个字符串来代表过滤器的类型，而这个类型就是在http请求过程中定义的各个阶段
     * pre: 可以在请求被路由之前被调用
     * routing: 在路由请求时被调用
     * post: 在routing和error 过滤器之后被调用
     * error: 处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 通过int的值来定义过滤器的执行顺序，数值越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 返回一个boolean值来判断该过滤器是否要执行，我们可以通过此方法指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }
    /**
     * 过滤器的具体逻辑，在该函数中，我们可以实现自定义的过滤器逻辑，来确定是否要拦截当前请求，不对其进行后续的路由，
     * 或是在请求路由返回结果之后对处理的结果进行一些加工等
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //todo...自定义过滤规则
        return null;
    }
}
```

# 十二、Gateway新一代网关

## 1、概述简介

### （1）官网

上一代zuul1.X：https://github.com/Netflix/zuul/wiki

当前Gateway：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.2.RELEASE/reference/html/

### （2）是什么

#### ① 是什么

![img](img/ce6d41f9-68d0-483a-b7c4-6e64886deaa2.jpg)

![img](img/9b4993b9-9070-45e9-b07c-bf207e7067c4.jpg)

#### ② 概述

![img](img/c0af03e3-3ef6-4c9d-a700-69afd49c54c4.jpg)

![img](img/a210f269-46b0-43c6-b03c-0e3b20f1ef48.jpg)

#### ③ 一句话

![img](img/abac9607-1e14-49bf-a81a-2514d26f5685.jpg)

#### ④ 源码架构

![img](img/7794ca92-e6ff-4295-af84-40c675747e54.jpg)

### （3）能干嘛

![img](img/f2e9099f-070e-4804-9f93-fc4cc19f0949.jpg)

### （4）微服务架构中网关在哪里

![img](img/675060d9-5edd-4236-a82f-00c85ab0936a.jpg)

### （5）有Zuul了怎么又出来了Gateway

#### ① 为什么选择Gateway

- ##### Netflix不太靠谱，zuul2.0一直跳票，迟迟不发布

![img](img/c3c0c22c-f155-4005-9970-2d7ae4a83e6b.jpg)

- ##### SpringCloud Gateway具有如下特性

![img](img/5439f9b0-2855-4a8b-9c14-14868bf6fd7f.jpg)

- ##### SpringCloud Gateway与Zuul的区别

![img](img/c458a222-cb6f-48ea-bb12-969991daa034.jpg)

#### ② Zuul1.x模型

![img](img/746d01ed-4a78-476d-b5ea-d53c15805259.jpg)

![img](img/3bd3ca96-0ae8-4b0a-a988-1d72e0891d54.jpg)

#### ③ Gateway模型

WebFlux官网资料：https://docs.spring.io/spring/docs/5.2.5.RELEASE/spring-framework-reference/web-reactive.html#spring-webflux

![img](img/49958a46-a74c-4be6-abca-20a05e0d57dd.jpg)

![img](img/ce22d10a-e198-41e5-a389-3904e559ddc0.jpg)

## 2、三大核心概念

### （1）Route(路由)

![img](img/125316d7-5f74-470e-ad2f-22519953f748.png)

### （2）Predicate(断言)

![img](img/fc029e7d-2998-4a63-9180-8a51652b7b89.jpg)

### （3）Filter(过滤)

![img](img/09a0256c-809f-4cf5-9dd2-50e785a61dec.png)

### （4）总体

![img](img/550b07ff-236c-45ca-9995-9426fabd2d04.jpg)

## 3、Gateway工作流程

### （1）官网总结

![img](img/4352ccb4-83f8-4533-8df5-0c909f15f03f.png)

![img](img/f21a4706-4a1d-45ef-9b5b-bda63e35629b.jpg)

### （2）核心逻辑

**路由转发 + 执行过滤器链**

## 4、入门配置

### （1）新建cloud-gateway-gateway9527

### （2）修改pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-gateway-gateway9527</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId> 
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml

```yaml
server:
  port: 9527
spring:
  application:
    name: cloud-gateway
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
  instance:
    hostname: cloud-gateway-service
```

### （4）新建主启动类GatewayMain9527

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 王柳
 * @date 2020/4/15 15:12
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
```

### （5）9527网关做路由映射

![img](img/7f5a7ed8-36db-4927-bdb7-043a04dcdc9f.jpg)

### （6）application.yml新增网关配置

```yaml
server:
  port: 9527
spring:
  application:
    name: cloud-gateway
  cloud:
    gateway:
      routes:
        - id: payment_routh #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:8001 #匹配后提供的路由地址
          predicates:
            - Path=/payment/get/** #断言，路径相匹配的进行路由
          
        - id: payment_routh2 #路由的ID，没有固定规则但要求唯一，建议配合服务名
          uri: http://localhost:8001 #匹配后提供的路由地址
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
  instance:
    hostname: cloud-gateway-service
```

### （7）测试

启动7001、7002、8001和9527

![img](img/deb500ba-4d07-476a-8c7c-33eda6b59704.jpg)

![img](img/de5742cf-8451-4a5a-bbd3-e25510053356.jpg)

### （8）Gateway路由的两种方式

#### ① 在配置文件yml中配置

#### ② 代码中注入RouteLocator的Bean

```java
package com.atguigu.springcloud.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author 王柳
 * @date 2020/4/15 15:24
 */
@Configuration
public class GatewayConfig {
    /**
     * 配置了一个id为path_route_atguigu的路由规则，
     * 当访问地址http://localhost:9527/guonei时会自动转发到地址http://news.baidu.com/guonei
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
```

## 5、通过微服务名实现动态路由

![img](img/ec1a42ac-4267-4635-ab52-261a5e18d4c2.jpg)

修改cloud-gateway-gateway9527下的application.yml:

```yaml
server:
  port: 9527
spring:
  application:
    name: cloud-gateway
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true #开启从注册中心动态创建路由的功能，利用微服务名进行路由
      routes:
        - id: payment_routh #路由的ID，没有固定规则但要求唯一，建议配合服务名
#          uri: http://localhost:8001 #匹配后提供的路由地址
          uri: lb://cloud-payment-service #匹配后提供服务的路由地址
          predicates:
            - Path=/payment/get/** #断言，路径相匹配的进行路由
        - id: payment_routh2 #路由的ID，没有固定规则但要求唯一，建议配合服务名
#          uri: http://localhost:8001 #匹配后提供的路由地址
          uri: lb://cloud-payment-service #匹配后提供服务的路由地
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
eureka:
  client: #客户端注册进eureka服务列表内
    #表示是否将自己注册进EurekaServer默认为true
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetch-registry: true
    service-url:
      #defaultZone: http://localhost:7001/eureka
      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/ #集群版
  instance:
    hostname: cloud-gateway-service
```

![img](img/7eff4c6b-a8ea-4419-94f4-c07b448c94af.jpg)

## 6、Predicate(断言)的使用

### （1）是什么

![img](img/e80e730f-b561-44ac-aaa0-656ada9c0482.jpg)

### （2）Route Predicate Factorices

![img](img/39a23516-d451-4764-9bf5-b04b6fb597ca.jpg)

![img](img/7b6914fc-b07a-4129-96d8-102e19f57581.jpg)

### （3）常用的Route Predicate

#### ① After Route Predicate

![img](img/ed9a87cb-3594-4823-8457-48aed40321f9.jpg)

![img](img/6e2b08c9-a800-451a-ac76-325dafcc470e.jpg)

```java
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        // 2020-04-15T16:42:02.866+08:00[Asia/Shanghai]
    }
```

 

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
```

#### ② Before Route Predicate 

类似于After Route Predicate

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
```

#### ③ Between Route Predicate 

类似于After Route Predicate，范围用，隔开

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
            - Between=2020-04-15T16:42:02.866+08:00[Asia/Shanghai],2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
```

#### ④ Cookie Route Predicate 

![img](img/19d19c42-d1ec-480e-8c3e-ec2b97fa93c7.jpg)

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
#            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
#            - Between=2020-04-15T16:42:02.866+08:00[Asia/Shanghai],2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
            - Cookie=username,wangliu
```

##### 不带cookies访问

![img](img/ff62ade6-95cc-41ff-914c-c6becea46af9.jpg)

##### 带cookies访问

![img](img/1aacec90-1dad-437d-ad86-1b54f48bb2ea.jpg)

#### ⑤ Header Route Predicate 

![img](img/7d072cb5-6422-4e98-8f3e-349aec9c8e44.jpg)

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
#            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
#            - Between=2020-04-15T16:42:02.866+08:00[Asia/Shanghai],2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Cookie=username,wangliu
            - Header=X-Request-Id,\d+ # 请求头要有X-Request-Id属性并且值为整数的正则表达式
```

![img](img/2c3de927-e658-4f5a-89ac-038300fd5288.jpg)

#### ⑥ Host Route Predicate 

![img](img/48b8ee15-8a22-4077-8a9f-d540cdb12730.jpg)

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
#            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
#            - Between=2020-04-15T16:42:02.866+08:00[Asia/Shanghai],2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Cookie=username,wangliu
#            - Header=X-Request-Id,\d+ # 请求头要有X-Request-Id属性并且值为整数的正则表达式
            - Host=**.atguigu.com
```

![img](img/f72edd2b-80f4-494a-9e4b-39e1e920cc5d.jpg)

#### ⑦ Method Route Predicate 

![img](img/584937e1-46d0-4e52-a8fe-58a45c8993da.jpg)

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
#            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
#            - Between=2020-04-15T16:42:02.866+08:00[Asia/Shanghai],2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Cookie=username,wangliu
#            - Header=X-Request-Id,\d+ # 请求头要有X-Request-Id属性并且值为整数的正则表达式
#            - Host=**.atguigu.com
            - Method=GET
```

#### ⑧ Path Route Predicate 

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
```

#### ⑨ Query Route Predicate 

![img](img/83dba2a1-1a5a-443a-ac50-52c6074fea1d.jpg)

```yaml
          predicates:
            - Path=/payment/lb/** #断言，路径相匹配的进行路由
#            - After=2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Before=2020-04-15T15:42:02.866+08:00[Asia/Shanghai]
#            - Between=2020-04-15T16:42:02.866+08:00[Asia/Shanghai],2020-04-15T17:42:02.866+08:00[Asia/Shanghai]
#            - Cookie=username,wangliu
#            - Header=X-Request-Id,\d+ # 请求头要有X-Request-Id属性并且值为整数的正则表达式
#            - Host=**.atguigu.com
#            - Method=GET
            - Query=username,\d+ #要有参数名username并且值还有是整数的才能路由
```

![img](img/05be2b71-13e2-4057-8106-89438ed6180d.jpg)

#### ⑩ 小总结

![img](img/1248dda3-8e68-4a5a-947e-ff5a8477b994.png)

## 7、Filter(过滤)的使用

### （1）是什么

![img](img/dad9102f-dd77-4787-a358-759ab7015e9b.jpg)

### （2）SpringCloud Gateway的Filter

![img](img/0f9081ba-2713-4a10-8d5a-1c0053be3279.jpg)

gatewayfilter：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.2.RELEASE/reference/html/#gatewayfilter-factories

global-filters：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.2.RELEASE/reference/html/#global-filters

### （3）常用的GatewayFilter

![img](img/4f5725d4-bd19-4a31-a75c-b6a458bc5dce.jpg)

### （4）自定义过滤器

![img](img/4c3dd082-c8e2-48bf-a888-9b3dbf9f16d8.jpg)

```java
package com.atguigu.springcloud.filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.Date;
/**
 * @author 王柳
 * @date 2020/4/15 17:22
 */
@Slf4j
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***************come in MyLogGatewayFilter: " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("username");
        if (uname == null) {
            log.info("***************用户名为null，非法用户，~~~~(>_<)~~~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
        }
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
```

正确：http://localhost:9527/payment/lb?username=23

错误：http://localhost:9527/payment/lb?username

# 十三、SpringCloud Config分布式配置中心

参考[SpringCloud实战学习](wiz://open_document?guid=a6a8e6ec-bf20-4a66-9d7b-4fbd37fb1d26&kbguid=&private_kbguid=9e15e816-792d-4528-9d21-a849cc4117d5)中的SpringCloud Config章节-----》**配置到本地存储。**

GitHub地址： [https://github.com/wangliu1102/SpringCloudStudy-Practical](https://github.com/wangliu1102/SpringCloudStudy-Practical.git)

**这里我们讲的是配置到Git服务器上存储**。

## 1、概述

### （1）分布式系统面临的---配置问题

微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，因此系统中会出现大量的服务。由于每个服务都需要必要的配置信息才能运行，所以一套集中式的、动态的配置管理设施是必可不少的。SpringCloud提供了ConfigServer来解决这个问题，我们每一个微服务自己带着一个application.yml，上百个配置文件的管理。

### （2）是什么

![img](img/6b148a6e-f7a5-4bb5-b74a-bb6af4cf8997.jpg)

SpringCloud Config为微服务架构中的微服务提供集中化的外部配置支持，配置服务器为各个不同微服务应用的所有环境提供了一个中心化的外部配置。

**怎么玩：**

SpringCloud Config分为服务端和客户端两部分。

服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置服务器并为客户端提供获取配置信息，加密/解密信息等访问接口。

客户端则是通过指定的配置中心来管理应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息，配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便的管理和访问配置内容。

### （3）能干嘛

- 集中管理配置文件；
- 不同环境不同配置，动态化的配置更新，分环境部署比如dev/test/prod/beta/release；
- 运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息；
- 当配置发生变动时，服务不需要重启即可感知到配置的变化并应用新的配置；
- 将配置信息以REST接口的形式暴露。

### （4）与GitHub整合配置

![img](img/1d5845a5-0c27-4221-a9a3-6319ac667235.png)

### （5）官网

https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.2.2.RELEASE/reference/html/

## 2、Config服务端配置与测试

### （1）配置Git仓库

**这里必须使用Git仓库来管理配置文件**：

Git仓库地址：https://github.com/wangliu1102/microservicecloud-config

![img](img/5cb36982-0981-4d09-b9bd-916a23726296.png)

### （2）新建cloud-config-center-3344

### （3）修改pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-config-center-3344</artifactId>
    <dependencies>
        <!--配置中心-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （4）新建application.yml

```yaml
server:
  port: 3344
spring:
  application:
    name: cloud-config-center
  # 配置中心
  cloud:
    config:
      server:
        git:
#          uri: git@github.com:wangliu1102/microservicecloud-config.git
#          search-paths:
#            - microservicecloud-config/cloud2020
          uri: https://github.com/wangliu1102/microservicecloud-config
          search-paths: /cloud2020 #git仓库地址下的相对地址 多个用逗号","分割
#          force-pull: true #强制拉入Git存储库
          # 访问git仓库的用户密码 如果Git仓库为公开仓库，可以不填写用户名和密码，如果是私有仓库需要填写
#          username: ******
#          password: ******
          ### 读取分支
      label: master
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
```

### （5）新建主启动类ConfigCenterMain3344

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * @author 王柳
 * @date 2020/4/17 9:14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
```

### （6）windows下修改hosts文件，增加映射

```
127.0.0.1 config-3344.com
```

### （7）测试

http://config-3344.com:3344/master/config-dev.yml

![img](img/24da1252-3abc-47e5-aece-0ae6d8e3cd1c.png)

### （8）配置读取规则

![img](img/354c8564-4ffd-42e6-b5ee-6ae25a8f231f.jpg)

```
/{application}-{profile}.yml
http://config-3344.com:3344/application-dev.yml
http://config-3344.com:3344/application-test.yml
http://config-3344.com:3344/application-xxx.yml(不存在的配置)
/{application}/{profile}[/{label}]
http://config-3344.com:3344/application/dev/master
http://config-3344.com:3344/application/test/master
http://config-3344.com:3344/application/xxx/master
/{label}/{application}-{profile}.yml
http://config-3344.com:3344/master/application-dev.yml
http://config-3344.com:3344/master/application-test.yml
http://config-3344.com:3344/master/application-xxx.yml
```

![img](img/0a400b59-81a1-486c-8aa9-b0a153478a5e.jpg)

## 3、Config客户端配置与测试

### （1）新建cloud-config-client-3355

### （2）修改pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-config-client-3355</artifactId>
    <dependencies>
        <!--配置中心客户端-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建bootstrap.yml

```yaml
server:
  port: 3355
spring:
  application:
    name: config-client
  # 配置中心
  cloud:
    config:
      fail-fast: true  #是否启动快速失败功能，功能开启则优先判断config server是否正常
      name: config # 配置文件名称
      profile: ${spring.profiles.active} #读取后缀名称
#      discovery: #配置服务发现
#        enabled: true #是否启动服务发现
#        service-id: cloud-config-center #服务发现(eureka)中，配置中心(config server)的服务名
      uri: http://localhost:3344 # 配置中心地址，不用这个可以使用上面的服务名配置服务发现
      label: master #获取配置文件的分支，默认是master。如果是是本地获取的话，则无用
  profiles:
    active: dev
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
```

### 

#### application.yml和bootstrap.yml

> > ![img](img/37686f97-1d42-47da-b393-6253b5386a4a.jpg)

### （4）新建主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 王柳
 * @date 2020/4/17 9:14
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCientMain3355.class, args);
    }
}
```

### （5）新建业务类

```java
package com.atguigu.springcloud.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 王柳
 * @date 2020/4/17 9:47
 */
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
```

### （6）测试

http://localhost:3355/configInfo

![img](img/d0882984-922f-4ec9-8305-77bfe06ae0c7.png)

## 4、Config客户端之动态刷新

![img](img/e47d11a7-dd46-497e-9287-31e71fe62b77.png)

### （1）修改3355模块的pom.xml文件，引入actuator

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```

### （2）修改3355模块的YML文件，暴露监控端点

```yaml
# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

### （3）@RefreshScope业务类Controller修改

```java
@RestController
@RefreshScope
public class ConfigClientController {
    ...
}
```

### （4）修改配置后，发送Post请求刷新配置 

修改3344在GitHub上的config-dev配置，version改为2

```yaml
config:
  info: master branch,springcloud-config/config-prod.yml,version=2
```

发送Post请求刷新：http://localhost:3355/actuator/refresh

![img](img/24685e77-1784-43f8-89af-f11f6f9a7d5c.png)

### （5）测试

http://localhost:3355/configInfo

![img](img/ac1d765e-9397-45e2-ac0f-1ce09c3183df.png)

![img](img/40c4253c-76e4-4fe7-8917-708f044504c7.png)

# 十四、SpringCloud Bus 消息总线

参考[SpringCloud实战学习](wiz://open_document?guid=a6a8e6ec-bf20-4a66-9d7b-4fbd37fb1d26&kbguid=&private_kbguid=9e15e816-792d-4528-9d21-a849cc4117d5)中的SpringCloud Bus章节。

GitHub地址： [https://github.com/wangliu1102/SpringCloudStudy-Practical](https://github.com/wangliu1102/SpringCloudStudy-Practical.git)

## 1、概述

### （1）是什么

Spring Cloud Bus 支持两种消息代理：**RabbitMQ和Kafka**。

![img](img/663bdb0e-24ba-47d0-bb1a-4a8ba38d455e.jpg)

### （2）能干嘛

![img](img/f9e48b63-8810-4930-a56f-a8cb309dd634.jpg)

### （3）为何被称为总线

![img](img/e9a70c04-4292-4dc1-957a-b7eecd7867b9.jpg)

## 2、RabbitMQ环境配置

笔记-》RabbitMQ 的安装教程：[RabbitMQ的环境安装及配置(Windows)](wiz://open_document?guid=bf8960fb-e5b7-4ad4-9888-f6655824caa9&kbguid=&private_kbguid=9e15e816-792d-4528-9d21-a849cc4117d5)。

GitHub-》[https://github.com/wangliu1102/SpringCloudStudy-Practical/blob/master/RabbitMQ%E7%9A%84%E7%8E%AF%E5%A2%83%E5%AE%89%E8%A3%85%E5%8F%8A%E9%85%8D%E7%BD%AE(Windows).md](https://github.com/wangliu1102/SpringCloudStudy-Practical/blob/master/RabbitMQ的环境安装及配置(Windows).md)

## 3、SpringCloud Bus动态刷新全局广播

### （1）设计思想

#### ① 利用消息总线触发一个客户端/bus/refresh,而刷新所有客户端的配置

![img](img/5c22e4d2-9636-48d3-9acf-8bf5c9235085.jpg)

![img](img/89582a3d-b525-41f3-84bf-924dd9cd29bb.jpg)

#### ② 利用消息总线触发一个服务端ConfigServer的/bus/refresh端点,而刷新所有客户端的配置

![img](img/d7c907cd-8663-4d64-a878-49af4252edb0.jpg)

![img](img/e8061149-9d52-424f-a7bc-d6d97ae70ef2.jpg)

#### ③ 第二种架构显然更适合，第一种不适合原因如下

![img](img/33f50683-354e-40cf-8e3d-61cf2622508d.png)

### （2）以3355位模板，新建3366

业务类Controller如下：

```java
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort: " + serverPort + "\t\n\n configInfo: " + configInfo;
    }
}
```

### （3）cloud-config-center-3344配置中心服务端添加消息总线支持

修改POM，添加如下：

```xml
    <!--添加消息总线RabbitMQ支持-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
```

修改YML：

```yaml
server:
  port: 3344
spring:
  application:
    name: cloud-config-center
  # 配置中心
  cloud:
    config:
      server:
        git:
#          uri: git@github.com:wangliu1102/microservicecloud-config.git
#          search-paths:
#            - microservicecloud-config/cloud2020
          uri: https://github.com/wangliu1102/microservicecloud-config
          search-paths: /cloud2020 #git仓库地址下的相对地址 多个用逗号","分割
#          force-pull: true #强制拉入Git存储库
          # 访问git仓库的用户密码 如果Git仓库为公开仓库，可以不填写用户名和密码，如果是私有仓库需要填写
#          username: ******
#          password: ******
          ### 读取分支
      label: master
    bus:
      enabled: true #是否启用springcloud config bus
      trace:
        enabled: true # 开启跟踪总线事件
    #rabbitmq配置
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
### rabbitmq相关配置，暴露bus刷新配置的端点
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

### （4）cloud-config-client-3355配置中心客户端添加消息总线支持

修改POM，添加如下：

```xml
    <!--添加消息总线RabbitMQ支持-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
```

修改YML：

```yaml
server:
  port: 3355
spring:
  application:
    name: config-client
  # 配置中心
  cloud:
    config:
      fail-fast: true  #是否启动快速失败功能，功能开启则优先判断config server是否正常
      name: config # 配置文件名称
      profile: ${spring.profiles.active} #读取后缀名称
#      discovery: #配置服务发现
#        enabled: true #是否启动服务发现
#        service-id: cloud-config-center #服务发现(eureka)中，配置中心(config server)的服务名
      uri: http://localhost:3344 # 配置中心地址，不用这个可以使用上面的服务名配置服务发现
      label: master #获取配置文件的分支，默认是master。如果是是本地获取的话，则无用
  profiles:
    active: dev
    #rabbitmq配置
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

### （5）cloud-config-client-3366配置中心客户端添加消息总线支持

修改POM，添加如下：

```xml
    <!--添加消息总线RabbitMQ支持-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-bus-amqp</artifactId>
    </dependency>
```

修改YML：

```yaml
server:
  port: 3366
spring:
  application:
    name: config-client
  # 配置中心
  cloud:
    config:
      fail-fast: true  #是否启动快速失败功能，功能开启则优先判断config server是否正常
      name: config # 配置文件名称
      profile: ${spring.profiles.active} #读取后缀名称
#      discovery: #配置服务发现
#        enabled: true #是否启动服务发现
#        service-id: cloud-config-center #服务发现(eureka)中，配置中心(config server)的服务名
      uri: http://localhost:3344 # 配置中心地址，不用这个可以使用上面的服务名配置服务发现
      label: master #获取配置文件的分支，默认是master。如果是是本地获取的话，则无用
  profiles:
    active: dev
    #rabbitmq配置
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
# 暴露监控端点
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

### （6）测试

修改GitHub配置中心上的的config-dev配置，version改为5。

发送Post如下请求：http://localhost:3344/actuator/bus-refresh

![img](img/2d562697-ff84-45eb-a833-49f2663a445f.jpg)

http://localhost:3355/configInfo

http://localhost:3366/configInfo

![img](img/551f0069-ef7d-480b-9b92-a3ca2881699a.png)

## 4、SpringCloud Bus动态刷新定点通知

![img](img/9aa1e0e0-e049-4bf9-9b38-bbe6442f88b3.png)

修改GitHub配置中心上的的config-dev配置，version改为10。

这里我们只通知3355，不通知3366。microservicecloud-config-atguigu-dev是服务名，因为GitHub上的配置中心有个application-dev.yml，配置了应用名为microservicecloud-config-atguigu-dev。

发送Post如下请求：http://localhost:3344/actuator/bus-refresh/microservicecloud-config-atguigu-dev:3355

![img](img/4c9b8bef-6415-4d71-82b3-3c1af437dc91.png)

## 5、总结

![img](img/04920e5b-cc12-4d51-8488-d1a23d32bf59.jpg)

## 6、刷新Druid数据源

如果数据源采用的是Druid，目前更新 GitHub 中的数据源配置，只有重启服务才能获取新配置，不然获取不到。

### （1）自定义Druid配置类

```java
//一定不要在此类加@RefreshScope，不然报错
@Configuration //不要少了
public class DruidConfig {
  @RefreshScope //刷新数据源
  @ConfigurationProperties(prefix = "spring.datasource") //绑定数据源配置
  @Bean
  public DataSource druid() {
    return new DruidDataSource();
 }
}
```

### （2）测试

更新GitHub上的数据库名，发送post请求刷新后，服务器不用重启，新的数据源就会生效。



# 十五、SpringCloud Stream 消息驱动

## 1、消息驱动概述

### （1）是什么

![img](img/31ecaa4a-763a-4979-928a-f2af5142a11c.png)

![img](img/06d799b7-bc4a-4ad2-b1c0-46aec0c066ab.jpg)

### （2）设计思想

#### ① 标准MQ

![img](img/80dc6125-998f-4c70-8893-1ef0b2f956b7.jpg)

![img](img/c9e7d3cd-7954-45bc-a9f8-f98bfb288c44.png)

![img](img/dffa53ec-f3a7-48e9-b2ac-bc78d0d80d10.png)

#### ② 为什么用CLoud Stream

![img](img/38cdc073-a65e-4a3e-9963-9d7a2834b2e5.jpg)

![img](img/1e18f9b6-30af-4aa7-b885-4f9bbb828ae2.jpg)

#### Stream凭什么可以统一底层差异

![img](img/678dd4b9-4965-4bb3-bb62-9cecad7d1011.jpg)

#### Binder

![img](img/4200c860-9cf3-4621-b783-3b2e5e0d1f55.png)

![img](img/3667b992-9202-40ac-8514-7f50cbbd06c9.jpg)

![img](img/5b6fbd13-9bef-47f1-b603-f625d03e4d7f.jpg)

#### ③ Stream中的消息通信方式遵循了发布-订阅模式

![img](img/68bf0e40-8315-4dd3-a55b-9c7e85cffc4d.png)

### （3）SpringCloud Stream标准流程套路

![img](img/61b54533-4959-4c12-95b5-b93be8692557.jpg)

![img](img/3eb1f082-e54e-4c00-9f1d-3c777e075f3c.png)

#### ① Binder绑定器

![img](img/23b8570e-5de1-4d7a-9920-74510fdbe9b6.png)

#### ② Channel消息通道

通道：![img](img/9addbe9a-eeeb-4a74-9bf3-b7db782930ff.png)

#### ③ Source和Sink

![img](img/3f950457-6d7e-4165-8191-637ef0282b7a.png)

### （4）编码API和常用注解

![img](img/e4a4c201-8f46-43d1-b052-6caf8f3dd8a8.jpg)

## 2、案例说明

首先，安装配置RabbitMQ。

![img](img/1ab79290-035b-42d1-b392-d3bdea3f139b.png)

## 3、消息驱动之生产者

### （1）新建cloud-stream-rabbitmq-provider8801

### （2）修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-stream-rabbitmq-provider8801</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rabbit</artifactId> 
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml

```yaml
server:
  port: 8801
spring:
  application:
    name: cloud-stream-provider
  cloud:
    stream:
      binders: # 在此处配置要绑定的rabbitmq的服务信息
        defaultRabbit:  # 表示定义的名称，用于binding整合
          type: rabbit # 消息组件类型
          enviroment: #设置rabbitmq的相关环境配置
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
      bindings: # 服务的整合处理
        output: # 这个名字是一个通道的名称
          destination: studyExchange #表示要使用的Exchange名称定义
          content-type: application/json  # 设置消息类型，本次为json，文本则设置“text/plain”
          binder: defaultRabbit #设置要绑定的消息服务的具体设置
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    lease-renewal-interval-in-seconds: 2 #设置心跳的时间间隔（默认是30秒）
    lease-expiration-duration-in-seconds: 5 # Eureka服务端在收到最后一次心跳后等待时间上限，单位为秒（默认是90秒），超时将剔除服务
    instance-id: send-8801.com # 在信息列表中显示主机名称
    prefer-ip-address: true # 访问的路径变为IP地址
```

### （4）新建主启动类StreamMqMain8801

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author 王柳
 * @date 2020/4/17 9:14
 */
@SpringBootApplication
public class StreamMqMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class, args);
    }
}
```

### （5）业务类

#### ① 发送消息接口

```java
package com.atguigu.springcloud.service;
/**
 * @author 王柳
 * @date 2020/4/17 16:18
 */
public interface IMessageProvider {
    String send();
}
```

#### **② 发送消息接口实现**

```java
package com.atguigu.springcloud.service.impl;
import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;
/**
 * @author 王柳
 * @date 2020/4/17 16:18
 */
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("********serial: " + serial);
        return serial;
    }
}
```

#### ③ Controller 

```java
package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * @author 王柳
 * @date 2020/4/17 16:24
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
```

### （6）测试

![img](img/520ce284-ba0f-4e69-a9c9-592db04247ef.png)

![img](img/2260fe24-5449-4698-89d5-982aacc7c029.png)

![img](img/4ef39376-af8d-49bd-8a91-a6b4ae70e3a9.png)

## 4、消息驱动之消费者

### （1）新建cloud-stream-rabbitmq-consumer8802

### （2）修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloud-stream-rabbitmq-consumer8802</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### （3）新建application.yml

```yaml
server:
  port: 8802
spring:
  application:
    name: cloud-stream-consumer
  cloud:
    stream:
      binders: # 在此处配置要绑定的rabbitmq的服务信息
        defaultRabbit:  # 表示定义的名称，用于binding整合
          type: rabbit # 消息组件类型
          enviroment: #设置rabbitmq的相关环境配置
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
      bindings: # 服务的整合处理
        input: # 这个名字是一个通道的名称
          destination: studyExchange #表示要使用的Exchange名称定义
          content-type: application/json  # 设置消息类型，本次为json，文本则设置“text/plain”
          binder: defaultRabbit #设置要绑定的消息服务的具体设置
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    lease-renewal-interval-in-seconds: 2 #设置心跳的时间间隔（默认是30秒）
    lease-expiration-duration-in-seconds: 5 # Eureka服务端在收到最后一次心跳后等待时间上限，单位为秒（默认是90秒），超时将剔除服务
    instance-id: receive-8802.com # 在信息列表中显示主机名称
    prefer-ip-address: true # 访问的路径变为IP地址
```

### （4）新建主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author 王柳
 * @date 2020/4/17 9:14
 */
@SpringBootApplication
public class StreamMqMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8802.class, args);
    }
}
```

### （5）业务类

```java
package com.atguigu.springcloud.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
/**
 * @author 王柳
 * @date 2020/4/17 16:24
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号，---->接收到的消息： " + message.getPayload() + "\t port: " + serverPort);
    }
}
```

### （6）测试

测试8801发送8802接收消息

http://localhost:8801/sendMessage

![img](img/34818ecb-1796-4398-b08c-892399c7b8bb.png)

![img](img/a50a9bf7-688b-485f-a89c-19c32170d4b4.png)

## 5、分组消费与持久化

### （1）依照8002，新建8003，并启动

### （2）运行后有两个问题

​      ![img](img/b2d035d8-c0d8-44d3-a5bd-0599a279f17b.png)

### （3）消费

#### ① 重复消费问题

![img](img/17f565ca-3118-497b-a19b-d040e900602e.png)

#### ② 如何解决

![img](img/7dfb7709-d9d1-432f-aff3-32d48c9f911f.jpg)

#### 

#### ③ 生产实际案例

![img](img/322328c3-65d1-4f61-94ee-2279dca451f6.jpg)

![img](img/d084677d-61aa-4321-8386-076c8cfcd0e2.jpg)

### （4）分组

![img](img/c960e291-fd56-4e6e-8d24-3ad270fd4315.jpg)

#### ① 原理

![img](img/03d475b3-22cd-4fed-8a60-df7ea6ddfd62.png)

#### ② 8802、8803设置为不同组，group两个不同

8002修改YML，设置group为atguiguA：

```yaml
server:
  port: 8802
spring:
  application:
    name: cloud-stream-consumer
  cloud:
    stream:
      binders: # 在此处配置要绑定的rabbitmq的服务信息
        defaultRabbit:  # 表示定义的名称，用于binding整合
          type: rabbit # 消息组件类型
          enviroment: #设置rabbitmq的相关环境配置
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
      bindings: # 服务的整合处理
        input: # 这个名字是一个通道的名称
          destination: studyExchange #表示要使用的Exchange名称定义
          content-type: application/json  # 设置消息类型，本次为json，文本则设置“text/plain”
          binder: defaultRabbit #设置要绑定的消息服务的具体设置
          group: atguiguA
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    lease-renewal-interval-in-seconds: 2 #设置心跳的时间间隔（默认是30秒）
    lease-expiration-duration-in-seconds: 5 # Eureka服务端在收到最后一次心跳后等待时间上限，单位为秒（默认是90秒），超时将剔除服务
    instance-id: receive-8802.com # 在信息列表中显示主机名称
    prefer-ip-address: true # 访问的路径变为IP地址
```

8003修改YML，设置group为atguiguB：

```yaml
server:
  port: 8803
spring:
  application:
    name: cloud-stream-consumer
  cloud:
    stream:
      binders: # 在此处配置要绑定的rabbitmq的服务信息
        defaultRabbit:  # 表示定义的名称，用于binding整合
          type: rabbit # 消息组件类型
          enviroment: #设置rabbitmq的相关环境配置
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
      bindings: # 服务的整合处理
        input: # 这个名字是一个通道的名称
          destination: studyExchange #表示要使用的Exchange名称定义
          content-type: application/json  # 设置消息类型，本次为json，文本则设置“text/plain”
          binder: defaultRabbit #设置要绑定的消息服务的具体设置
          group: atguiguB
eureka:
  client:
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
  instance:
    lease-renewal-interval-in-seconds: 2 #设置心跳的时间间隔（默认是30秒）
    lease-expiration-duration-in-seconds: 5 # Eureka服务端在收到最后一次心跳后等待时间上限，单位为秒（默认是90秒），超时将剔除服务
    instance-id: receive-8803.com # 在信息列表中显示主机名称
    prefer-ip-address: true # 访问的路径变为IP地址
```

![img](img/e4184419-3467-434c-a98a-d95cebf6bee4.jpg)

#### ③ 8802、8803设置为相同组，group两个相同

![img](img/0fa708b3-78bc-49cb-8533-fb4ec5afbf9b.png)

8802、8803都设置group为atguiguA

### （5）持久化

![img](img/0f0b57eb-6ee7-4356-bf33-3b6e8e21b1af.jpg)

# 十六、SpringCloud Sleuth分布式请求链路跟踪

## 1、概述

### （1）为什么出现这个技术

![img](img/65e6d1f6-c36a-4bc5-84fa-9409598f5c9b.jpg)

### （2）是什么

![img](img/05ce0fdf-f4d5-4906-a8a6-9f732cdf0867.png)

### （3）解决

![img](img/8b3488cb-1f58-4f00-9d4b-070ec9463456.jpg)

## 2、搭建链路监控步骤

### （1）zipkin

#### ① 下载

https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/

![img](img/190d9ed3-f6f0-4418-9b12-de81b9dabe3f.png)

#### ② 运行jar

![img](img/b0362df3-d158-4c60-b216-764e945cc52c.jpg)

#### **③ 运行控制台**

http://localhost:9411/zipkin/

##### 完整的调用链路

![img](img/60c623c1-6341-42d2-980f-c81634a9e385.jpg)



##### 上图简化

![img](img/33453498-c4f2-43c5-947d-2d25e933aa2d.jpg)

##### 名词解释

![img](img/cc7a4f3f-72a7-4d29-a2d1-a7884347c25a.png)

### （2）服务提供者

#### ① 修改cloud-provider-payment8001

#### ② 修改POM

添加如下：

```xml
        <!--   包含了sleuth + zipkin     -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
```

#### ③ 修改application.yml

添加如下：

```yaml
spring:
  application:
    name: cloud-payment-service
  zipkin:
    base-url: http://localhost:9411
  sleuth:
    sampler:
      # 采样率值介于0到1之间，1则表示全部采集
      probability: 1
```

#### ④ 修改业务Controller

添加如下：

```java
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "Hi,I'am paymentZipkin server fall back,welcome to atguigu,O(∩_∩)O哈哈~";
    }
```

### （3）服务消费者(调用方)

#### ① 修改cloud-consumer-order80

#### ② 修改POM

添加如下：

```xml
        <!--   包含了sleuth + zipkin     -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
```

#### ③ 修改application.yml

添加如下：

```yaml
spring:
  application:
    name: cloud-order-service
  zipkin:
    base-url: http://localhost:9411
  sleuth:
    sampler:
      # 采样率值介于0到1之间，1则表示全部采集
      probability: 1
```

#### ④ 修改业务Controller

添加如下：

```java
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }
```

**（4）测试**

依次启动7001、7002、8001、80。

80调用8001几次测试下。

打开浏览器访问：http://localhost:9411/zipkin/

![img](img/4f35b426-c7bb-49e0-9abd-fe20bc6fe32c.jpg)

![img](img/946bab4a-f0d9-4ab0-8114-7d6e36f9c09d.jpg)

![img](img/2922a5d8-ca87-4a52-810e-0b09cda56b93.png)

# 十七、SpringCloud Alibaba入门简介

## 1、为什么会出现SpringCloud Alibaba

![img](img/28e25672-43f3-4650-b6be-20fa252d417c.png)

## 2、SpringCloud Alibaba带来了什么

### （1）是什么

![img](img/41ffa632-4a45-4e77-ba97-f9107e517654.jpg)

### （2）能干嘛

![img](img/9fa9037e-938f-44d7-90b5-7f055dd6dddf.jpg)

### （3）在哪下

https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md

### （4）怎么玩

![img](img/100f9393-e15b-4cdf-95f0-48214c5bc59c.jpg)

## 3、SpringCloud Alibaba学习资料获取

### （1）官网

https://spring.io/projects/spring-cloud-alibaba#overview

![img](img/e164b9f4-a349-450f-9165-10838f7519f4.jpg)

### （2）英文

https://github.com/alibaba/spring-cloud-alibaba

https://spring-cloud-alibaba-group.github.io/github-pages/greenwich/spring-cloud-alibaba.html

### （3）中文

https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md

# 十八、SpringCloud Alibaba Nacos服务注册和配置中心

## 1、Nacos简介

### （1）为什么叫Nacos

![img](img/4d7fcbfa-4c65-437a-ab02-73114f321c84.png)

### （2）是什么

![img](img/df3948de-eb18-4ff6-94ee-bec8c791dac1.png)

### （3）能干嘛

![img](img/44c43211-00e6-4f1c-8020-9243b1b34b25.png)

### （5）去哪下

https://github.com/alibaba/nacos

官网文档：

https://nacos.io/zh-cn/

https://spring-cloud-alibaba-group.github.io/github-pages/greenwich/spring-cloud-alibaba.html

### （6）各个注册中心比较

![img](img/8372de63-a543-403c-ade9-a2dc712fde41.jpg)

## 2、安装并运行Nacos

![img](img/3c3b0801-f301-4fe9-825d-b7dfe6043ba1.png)

**默认账号密码都是nacos**

![img](img/c8e55ac9-87fb-4e1a-a6ae-5904b40e038d.jpg)

## 3、Nacos作为服务注册中心演示

### （1）基于Nacos的服务提供者

#### ① 新建cloudalibaba-provider-payment9001

#### ② 修改POM

父POM：

```xml
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Hoxton.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2.1.0.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

本模块POM：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloudalibaba-provider-payment9001</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

#### ③ 新建application.yml

```yaml
server:
  port: 9001
spring:
  application:
    name: nacos-payment-provider
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 # 配置Nacos地址
management:
  endpoints:
    web:
      exposure:
        include: '*'
```

#### ④ 新建主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/21 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class,args);
    }
}
```

#### ⑤ 新建业务类

```java
package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 王柳
 * @date 2020/4/21 11:48
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos register,serverPort: " + serverPort + "\t id: " + id;
    }
}
```

#### ⑥ 测试

![img](img/8339b086-cabb-46b2-beea-bd9e95b9ee99.png)

![img](img/7fc71256-1f6a-42be-949d-92de43176138.jpg)

#### ⑦ 参照9001新建9002

### （2）基于Nacos的服务消费者

#### ① 新建cloudalibaba-consumer-nacos-order83

#### ② 修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloudalibaba-consumer-nacos-order83</artifactId>
    
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

#### ③ 新建application.yml

```yaml
server:
  port: 83
spring:
  application:
    name: nacos-order-consumer
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 # 配置Nacos地址
#消费者将要去访问的微服务名称（注册成功进nacos的微服务提供者）
service-url:
  nacos-user-service: http://nacos-payment-provider
```

#### ④ 新建主启动类

```java
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/21 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain83.class,args);
    }
}
```

#### ⑤ 新建业务类

```java
package com.atguigu.springcloud.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
```

 

```java
package com.atguigu.springcloud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
/**
 * @author 王柳
 * @date 2020/4/21 11:48
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
    }
}
```

#### ⑥ 测试

http://localhost:83/consumer/payment/nacos/1

#### ⑦ nacos支持负载均衡

![img](img/74fc621a-f68c-46fe-a51f-bc3c789ce10a.jpg)

### （3）服务注册中心对比

#### ① Nacos全景图

![img](img/6dc61b65-f7ec-4839-940b-86a4077be69e.jpg)

![img](img/6607fe9a-ffb8-4c47-8754-375a5a64c904.jpg)

#### ② Nacos和CAP

![img](img/9295d34a-2b66-48bf-a248-2d0a83804106.jpg)

![img](img/2383d2a8-5703-46bc-addf-2a88d6ce922f.jpg)

#### ③ Nacos支持AP和CP模式的切换

![img](img/3646374d-f315-4cb7-aeaf-ccb4f0d6d930.jpg)

## 4、Nacos作为服务配置中心演示

### （1）基础配置

#### ① 新建cloudalibaba-config-nacos-client3377

#### ② 修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>cloudalibaba-config-nacos-client3377</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

#### ③ 新建application.yml和bootstrap.yml

##### 为什么配置两个

![img](img/7f4d8652-1e70-48bf-a5d0-ccac7d5c125e.jpg)

##### bootstrap.yml

```yaml
server:
  port: 3377
spring:
  application:
    name: nacos-config-client
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 # Nacos服务注册中心地址
      config:
        server-addr: localhost:8848 # Nacos作为配置中心地址
        file-extension: yml # 指定yaml格式的配置
# ${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
```

##### application.yml

```yaml
spring:
  profiles:
    active: dev #表示开发环境
```

#### ④ 新建主启动类

```yaml
package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author 王柳
 * @date 2020/4/21 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class,args);
    }
}
```

#### ⑤ 新建业务类

```java
package com.atguigu.springcloud.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 王柳
 * @date 2020/4/21 14:22
 */
@RestController
@RefreshScope // 支持Nacos的动态刷新功能
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
```

#### ⑥ 在nacos中添加配置信息：匹配规则

##### 理论

https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html

![img](img/91a1360c-8d20-49d9-8cfc-5c113483e66b.jpg)

##### 实操

![img](img/3529e46c-7281-4332-968a-b2af6cabfb67.jpg)

![img](img/f654f22a-3325-439c-a940-7f4e6ff3c9f5.jpg)

![img](img/f832b64c-dfae-46cc-98d2-da3d2591d6d3.png)

![img](img/77a8092b-bf3a-44d8-914c-8ff29ffdadc7.jpg)

#### ⑦ 测试

http://localhost:3377/config/info

![img](img/0e8294f2-6c3f-40d3-b1c6-b39ccdfaaa9e.png)

#### ⑧ 自带动态刷新

![img](img/d3e58a5a-bf97-4386-99c0-536891e1adf2.png)

### （2）分类配置

#### ① 问题：多环境多项目管理

![img](img/0d524d74-53eb-4fa7-8287-c7af40778d37.jpg)

#### ② Nacos的图形化管理界面

![img](img/ef7dc003-fca2-45a9-84e3-821df307d298.jpg)

![img](img/d11a5f1f-c232-4182-b6f8-99ea4b4d6279.jpg)

#### ③ Namespace + Group + Data ID

![img](img/a094e75a-fa94-4cfd-b59b-358c6bbf1751.jpg)

![img](img/768486d4-164b-4d31-8605-6e118294bc44.jpg)

![img](img/d023dfa4-4a0f-41f8-9ae3-db56ad1c78a7.jpg)

#### ④三种配置方案

##### DataID方案

![img](img/4d1dfb1f-bdda-4d73-a0be-bcc6fda4973e.png)

![img](img/66463d6d-1c28-4746-801e-69486032f602.png)

![img](img/0241105c-3d07-4e77-9126-ff97ed55f4f9.jpg)

![img](img/94cbab7c-2f06-4311-8c44-ab655f1e4d08.png)

##### Group方案

![img](img/019402e6-12fa-4913-8729-55c0e00d2065.png)

![img](img/fa710efc-352c-4791-87d3-b548b2efe944.jpg)

![img](img/edb00e4a-40e3-4ff2-bdc8-db4cbf3f5c2e.jpg)

![img](img/ff4e6e94-baae-4443-bfae-4668ee8f275b.jpg)

![img](img/d3dafdd2-94b1-458f-acde-c8d720a54170.jpg)

![img](img/c4b51906-f119-4556-a8d8-509bce413e66.png)

##### Namespace方案

![img](img/a780d773-2880-4031-9ca9-39d8bf67b411.jpg)

![img](img/55ac7b47-66c4-42d7-9e93-7d58af9fa3bb.jpg)

![img](img/702723c7-27d5-4bd7-9234-3adc5af53d6b.jpg)

![img](img/7fda7a84-4fba-4fcc-b8b9-fc603b1449cb.jpg)

![img](img/fa9ea70e-54af-496b-aa24-6ddaf74e3b9f.jpg)

![img](img/42e23a41-7608-4cca-8318-315cbd0687b0.png)

## 5、Nacos集群和持久化配置(重要)

### （1）官网说明

https://nacos.io/zh-cn/docs/cluster-mode-quick-start.html

![img](img/c6083a72-209f-4c9e-b4de-f87f92df242b.jpg)

![img](img/d980aec4-dd40-4fe8-a11d-256e41ed9a40.png)

![img](img/3615907d-4243-43c2-9354-709533132928.jpg)

​    ![img](img/599beb38-5b6d-44c1-b359-ff2e201a0708.jpg)

https://nacos.io/zh-cn/docs/deployment.html

### （2）Nacos持久化配置解释

#### ① Nacos默认自带的是嵌入式数据库derby

https://github.com/alibaba/nacos/blob/develop/config/pom.xml

#### ② derby到mysql切换配置步骤

![img](img/8541a594-2954-4d16-8818-7bcbb55ef9e0.png)

![img](img/1356eadd-e5ed-4e59-9fe8-e1b0595db2c9.png)

```yaml
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=root
db.password=123456
```

#### ③ 启动Nacos，可以看到的是个全新的空记录界面，以前是记录进derby

### （3）Linux版Nacos + MySQL生产环境配置

#### ① 预计需要，1个Nginx + 3个nacos注册中心 + 1个mysql

#### ② Nacos下载Linux版

![img](img/94c21b75-c2bb-4071-b27b-3d7541d515bb.jpg)

![img](img/78c54491-efd1-4035-ad77-131c24520684.png)

#### ③ 集群配置步骤(重点)

##### 1、Linux服务器上mysql数据库配置

![img](img/db49c8c4-876b-4a32-8f69-77edde2735b9.png)

![img](img/67c5d1b3-aa7f-4875-8eca-23aedc47fd77.jpg)

![img](img/9b17a8df-2589-482c-86ed-6ab4f7447795.jpg)

##### 2、application.properties配置

![img](img/ed2da0ee-151f-4c4e-9f32-d6ef794499d4.jpg)

![img](img/e665f9da-fd63-41bd-8f36-85105c193339.jpg)

##### 3、Linux服务器上nacos父集群配置cluster.conf

![img](img/949141fd-f943-4b68-ab5d-c59c5e530710.png)

![img](img/553c5309-04f4-45cc-bb7d-248c5dc7b11b.jpg)

![img](img/dec33455-c192-4889-b702-413850eb5e78.png)

![img](img/b5145607-6a39-435a-a8a8-775d1199ab16.png)

##### 4、编辑Nacos的启动脚本startup.sh，使它能够接受不同的启动端口

![img](img/28dba801-69fe-4094-b546-1f03199ba952.png)

![img](img/26db1fcd-b440-4e45-839e-b0634b537d31.jpg)

![img](img/5bdeb29f-61b9-4025-90ee-166a076a86a6.jpg)

![img](img/3bf8ef3f-9765-4a25-9dcc-b9e264c24811.jpg)

![img](img/113bace6-c27e-4da3-aa94-80ce6ee7d905.jpg)

##### 5、Ngnix的配置，由它作为负载均衡器

![img](img/a0dc6b7d-5799-4a6f-9b60-793b4d23209f.jpg)

![img](img/e44f41bb-5e2a-4b2d-a4f0-8ced3741b800.png)

![img](img/d09a1674-66b8-4eb4-82e9-9495d4806f66.jpg)

![img](img/e5889c9b-07c5-48c9-87a4-a7de86657d59.jpg)

![img](img/328ac2e5-e90b-4ff0-bc97-49229170f8c4.jpg)

##### 6、截止到此处，1个Nginx + 3个nacos注册中心 + 1个mysql

![img](img/07e011d9-1934-4ff1-b505-cdcdfe5f7fdc.png)

#### ④ 测试

![img](img/af751dc0-e3f9-4ab2-9f66-ae13964863b3.png)

![img](img/09efd14d-6d8b-4b81-ae8a-956f2c08ffa3.jpg)

#### ⑤ 高可用小总结

![img](img/e9d38416-55b6-4698-8cb2-8bd894dd395d.jpg)

# 十九、SpringCloud Alibaba Sentinel实现熔断与限流

## 1、Sentinel

### （1）官网

https://github.com/alibaba/Sentinel

中文：[https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D](https://github.com/alibaba/Sentinel/wiki/介绍)

### （2）是什么

![img](img/73d77932-f872-4eb7-8ded-422e68902a24.png)

![img](img/ef0eb422-9fe8-4e2e-919b-6b55950f3f4b.jpg)

### （3）去哪下

https://github.com/alibaba/Sentinel/releases

### （4）能干嘛

![img](img/c4d95bcc-6907-4185-a73a-82b17d221179.jpg)

### （5）怎么玩

https://spring-cloud-alibaba-group.github.io/github-pages/greenwich/spring-cloud-alibaba.html#_spring_cloud_alibaba_sentinel

![img](img/0a600ab2-e4d5-4d53-ae71-ee040647ded8.png)

## 2、安装Sentinel控制台

### （1）sentinel组件由两部分构成

后台 + 前台8080

![img](img/186df267-e60e-4955-ab21-5402cb485d23.jpg)

### （2）安装步骤

#### ① 下载

![img](img/ad51b169-be99-494d-b306-7df0ef55b497.png)

#### ② 运行命令

![img](img/73c075f0-554e-4eee-9e8e-4b1e6710168e.png)

```
java -jar sentinel-dashboard-1.7.2.jar
```

#### ③ 访问sentinel管理界面

![img](img/8f84588f-8776-4987-a04c-9afb185ab00b.png)

![img](img/5fd001fc-1a89-416d-bbd5-7e001f9f14d7.jpg)

## 3、初始化演示工程

### （1）启动Nacos8848成功

### （2）Module8401

#### ① 新建cloudalibaba-sentinel-service8401

#### ② 修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloudalibaba-sentinel-service8401</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
        <!--   后续做持久化     -->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-nacos</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>

```

#### ③ 新建application.yml

```yaml
server:
  port: 8401
  
spring:
  application:
    name: cloudalibaba-sentinel-service
  cloud:
    nacos:
      discovery:
        # Nacos服务注册中心地址
        server-addr: localhost:8848
    sentinel:
      transport:
        # 配置Sentinel dashboard地址
        dashboard: localhost:8080
        # 默认8791端口，假如被占用会自动从8791开始依次+1扫描，直到找到未被占用的端口
        port: 8719
management:
  endpoints:
    web:
      exposure:
        include: '*'

```

#### ④ 新建主启动类

```java
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王柳
 * @date 2020/4/22 10:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8401 {

    public static void main(String[] args) {
        SpringApplication.run(MainApp8401.class,args);
    }
}

```

#### ⑤ 新建业务类

```java
package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王柳
 * @date 2020/4/22 10:18
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------------testB";
    }

}

```

### （3）启动Sentinel8080

```
java -jar sentinel-dashboard-1.7.2.jar
```

### （4）启动微服务8041

### （5）查看sentinel控制台

刚进来什么都没有。因为Sentinel采用的懒加载：执行一次访问即可http://localhost:8401/testA

![img](img/d332a8f5-c13f-412c-92a8-4e4763675e00.png)

## 4、流控规则

### （1）基本介绍

![img](img/38e7977c-5636-47ec-ad79-0eeb6053a4fd.jpg)

![img](img/e6871378-518f-4889-8977-be9a71fa8627.png)

![img](img/89e1819e-12c5-4326-bfae-16f313580062.png)

### （2）流控模式

#### ① 直接(默认)

![img](img/3c52d8b5-d9ba-4f0b-b953-77f4f57bcc7a.png)

![img](img/96898c90-da52-474d-9db8-99603657d1a4.png)

#### ② 关联

##### 是什么

![img](img/7380922c-febb-46a3-9315-cec0d294ec52.png)

##### 配置A

![img](img/633cee92-4d04-4ab7-82d8-e1a950320afa.jpg)

##### postman模拟并发密集访问testB

![img](img/4785517d-ae10-4305-a45a-7ec9bfdd1960.jpg)

![img](img/f63cb95e-106e-42ca-a5b4-c8e9ede82177.jpg)

![img](img/d127f7c8-dda3-4345-9bd9-f1dda6ff0985.png)

![img](img/359c487c-da80-47c3-89c3-2adf0522cc44.png)

![img](img/05cedd95-9391-4e11-954a-333840f0fe60.jpg)

![img](img/8ac1bda2-b8f2-4b38-891e-b2d1e14c4adb.png)

##### 运行后发现testA挂了

![img](img/97e5e6c4-8bf5-46b6-ab21-90975935290e.png)

#### ③ 链路

![img](img/0f808774-e0ae-4922-b7d4-feffcba567d4.png)

### （3）流控效果

#### ① 直接->快速失败(默认的流控处理)

![img](img/6948d55e-4fac-41f7-94ef-d9aebc9d5c37.png)

#### ② 预热

##### 说明

![img](img/850ca38b-7c83-470f-a396-e8529e4eb988.png)

##### 官网

![img](img/9d1e0d06-d676-437b-8498-43f3e5f6c54b.jpg)

![img](img/6f73539f-5a53-4438-bd40-ff79219b8425.jpg)

默认 `coldFactor` 为 3，即请求 QPS 从 `threshold / 3` 开始，经预热时长逐渐升至设定的 QPS 阈值。

[https://github.com/alibaba/Sentinel/wiki/%E9%99%90%E6%B5%81---%E5%86%B7%E5%90%AF%E5%8A%A8](https://github.com/alibaba/Sentinel/wiki/限流---冷启动)

##### 源码

![img](img/195194f1-a1ff-4317-a3cb-50c576a01cc9.jpg)

##### WarmUp 配置

![img](img/582040a7-405c-4d07-80c9-1b5189e64ede.jpg)

##### 测试

![img](img/f10893f3-7f21-4340-90c3-310bde3bb7c0.png)

![img](img/2759383b-6565-4d4e-9a51-7ae8b43c0e95.png)

##### 应用场景

![img](img/d14fe3ac-d904-4b43-a98b-de521ac348bb.jpg)

#### ③ 排队等待

##### 说明

![img](img/0d2147ee-df79-487d-8b25-0187ffe1bb24.jpg)

##### 官网

![img](img/014fcd66-d871-470e-9286-a6edab72f6c3.jpg)

![img](img/ce9387ff-2f25-4383-b4a7-77594df6d000.jpg)

##### 测试

```java
    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------------testB";
    }
```

![img](img/428edd41-022b-4215-83c1-6b2f4f9e7995.jpg)

## 5、降级规则

### （1）官网

[https://github.com/alibaba/Sentinel/wiki/%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7](https://github.com/alibaba/Sentinel/wiki/熔断降级)

### （2）基本介绍

![img](img/95b0b6bf-25f6-4d54-b923-30d125d633b8.jpg)

![img](img/6320f9bb-c461-4561-9e7c-f603fcf37bc3.jpg)

![img](img/47d4584d-83cc-43f0-8e6d-bc89fed14234.jpg)

![img](img/a236c378-5f9e-4ed9-bd3d-478c87c1aa0e.png)

### （3）降级策略实战

#### ① RT

##### 是什么

![img](img/248657f3-f625-4402-a27b-61b7087cf8d4.jpg)

![img](img/a11e5bd8-9edf-409c-a0e1-5dc311d5d64f.jpg)

##### 测试

```java
    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------------testD";
    }
```

![img](img/17952a4d-42c4-4b14-8e7b-5f875f871214.png)

![img](img/338a1c89-0691-4407-a410-6b86a9d00ab6.jpg)

![img](img/4151f039-7a64-49a9-96b0-3e7d4c370b7a.jpg)

#### ② 异常比例

##### 是什么

![img](img/5609ba09-665c-403f-987d-6d24188ea8a0.jpg)

![img](img/e5f87b0d-96c2-4ae4-a3aa-51225a3939e8.jpg)

##### 测试

```java
    @GetMapping("/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        
        log.info("testD 测试异常比例");
        int age = 10/0;
        return "------------testD";
    }
```

![img](img/a35e065f-3b09-46b8-b365-2ba3a62d2dac.png)

![img](img/2c41acfd-a88f-42be-bbaa-00f860731ab2.jpg)

![img](img/fb1c437f-6779-4728-a59d-673b5e44c091.jpg)

#### ③ 异常数

##### 是什么

![img](img/274763d3-addf-484e-b4a9-072836dcd58b.jpg)

![img](img/ed4e4ab0-4139-4326-99b5-5c699e46e8e3.jpg)

##### 测试

```java
    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------------testE";
    }
```

![img](img/487f8997-8e9b-4a38-96f1-343de4080922.png)

## 6、热点key限流

### （1）基本介绍

![img](img/af7de974-9397-4ace-a2fc-1b19bdbd0f34.png)

![img](img/d2c6a304-0165-48f2-ad0b-fa099ae48013.jpg)

### （2）官网

[https://github.com/alibaba/Sentinel/wiki/%E7%83%AD%E7%82%B9%E5%8F%82%E6%95%B0%E9%99%90%E6%B5%81](https://github.com/alibaba/Sentinel/wiki/热点参数限流)

### （3）承上启下复习

![img](img/84da059b-ba6c-4a01-888f-cbc337ee1a7f.jpg)

### （4）代码

源码：![img](img/c2d14cb2-63a8-444f-a29b-ba2821508ba7.png)

```java
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "---------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----------deal_testHotKey,~~~~(>_<)~~~~";
    }
```

**（5）配置**

![img](img/d68b57e6-5783-42d8-903a-94dec8e58218.jpg)

![img](img/417e11a5-ba74-4cdd-a0cc-cd5322a515f8.jpg)

![img](img/8d413202-a997-47e6-a693-237fed2ead73.jpg)

### （6）测试

快速点击：

![img](img/454164a6-0ff1-4940-a544-ae0f12c04e7e.jpg)

### （7）参数例外项

![img](img/3b8a5299-525f-4f28-a59a-2519933a182c.png)

#### ① 特例情况

![img](img/ebe89e58-abe3-421e-bb2a-2cb456b17505.png)

#### ② 配置

![img](img/8c8a29d5-a36b-4948-af79-b963dc703a7b.jpg)

#### ③ 测试

![img](img/35c95ffb-d82e-44bf-824b-04c6a999eb14.png)

#### ④ 前提条件

![img](img/94f1dc86-d2dc-4505-9b64-2427c3895055.png)

### （8）其他

![img](img/917a4d65-3a9e-4b50-a4c1-de32049f9243.png)

```java
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        int age =10/0;
        return "---------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----------deal_testHotKey,~~~~(>_<)~~~~";
    }
```

![img](img/576a999a-bff4-4282-b6af-098e788244f0.png)

![img](img/826bb5e3-f317-4227-8cd6-d243c48e1c79.jpg)

## 7、系统规则

### （1）是什么

![img](img/1242ba42-8aab-4227-bbe9-0b3ca5fb59a6.png)

[https://github.com/alibaba/Sentinel/wiki/%E7%B3%BB%E7%BB%9F%E8%87%AA%E9%80%82%E5%BA%94%E9%99%90%E6%B5%81](https://github.com/alibaba/Sentinel/wiki/系统自适应限流)

### （2）各项配置参数说明

![img](img/18e76387-4c7f-4820-a56d-954a65820c0e.jpg)

### （3）配置全局QPS

![img](img/56388cde-9b27-4a9f-b3ac-c118e58db3fd.png)

多次点击：http://localhost:8401/testA

![img](img/ea7cf476-857c-47e4-8a57-3a628323f573.png)

## 8、@SentinelResource

### （1）按资源名称限流 + 后续处理

#### ① 启动Nacos和Sentinel成功

#### ② 修改cloudalibaba-sentinel-service8401

修改POM，添加如下：

```xml
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
```

新增业务类RateLimitController：

```java
package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王柳
 * @date 2020/4/22 14:52
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }
}

```

**③ 配置流控规则**

![img](img/43b7611e-0e50-455c-b679-677070117950.jpg)

![img](img/4a739828-5cb9-4197-a5e9-0968a4254eb0.png)

#### ④ 测试

![img](img/0ca5b93e-81f1-40cc-8f3c-48ec91743c5b.png)

![img](img/90cb2ecd-0df4-4afc-9c42-b1d220d4b890.png)

#### ⑤ 额外问题

![img](img/f69ccec3-dfca-4516-bb1b-491809dbf50c.jpg)

### （2）按Url地址限流 + 后续处理

![img](img/580dd53d-8a0b-4b61-9dce-f13f1d2556e9.png)

```java
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按Url限流OK", new Payment(2020L, "serial002"));
    }

```

![img](img/b9415713-29e6-4905-b330-1a36ac98c28b.png)

![img](img/3b88844c-4d57-4902-8f59-56c8e23144bb.jpg)

### （3）上面兜底方案面临的问题

![img](img/88c40f66-63d3-4a86-8746-0205af2260c8.jpg)

### （4）客户自定义限流处理逻辑

#### ① 创建CustomerBlockHandler类用于自定义限流处理逻辑

#### ② 自定义限流处理类

```java
package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author 王柳
 * @date 2020/4/22 15:17
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义限流,global handlerException-----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义限流,global handlerException-----2");
    }
}

```

#### ③ RateLimitController

```java
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流OK", new Payment(2020L, "serial003"));
    }
```

#### ④ 启动微服务后先调用一次

http://localhost:8401/rateLimit/customerBlockHandler

#### ⑤ Sentinel控制台配置

![img](img/e2e8a661-3d9b-4091-b529-6d3957a1755c.png)

#### ⑥ 测试

多次点击：

![img](img/6353c692-0eef-4c45-82d6-09ba9f0fc4b8.png)

#### ⑦ 进一步说明

![img](img/49db58b4-9219-4670-a14e-33251db8cbea.jpg)

### （5）更多注解属性说明

[https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81](https://github.com/alibaba/Sentinel/wiki/注解支持)

![img](img/99a17600-346a-4801-aa55-cbb41d7d772e.png)

![img](img/bd391d29-2863-468b-93f4-1030a7dbd8cc.jpg)

![img](img/19a18cb2-d446-4aaf-a393-2bf3a6cc2cfa.png)

## 9、服务熔断功能

### （1）Ribbon系列

#### ① 启动nacos和Sentinel成功

#### ② 提供者9003/9005

##### 新建cloudalibaba-provider-payment9003

cloudalibaba-provider-payment9005一样

##### 修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloudalibaba-provider-payment9003</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>

```

##### 新建application.yml

```yaml
server:
  port: 9003

spring:
  application:
    name: nacos-payment-provider
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 # 配置Nacos地址
management:
  endpoints:
    web:
      exposure:
        include: '*'

```

##### 新建主启动类

```java
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王柳
 * @date 2020/4/22 15:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9003.class,args);
    }
}

```

##### 新建业务类

```java
package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 王柳
 * @date 2020/4/21 11:48
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "aj891jdj819jcj8290kdffk03i3rnf"));
        hashMap.put(2L, new Payment(2L, "fhj991n9jdjnsidu9sdjdjns9od9sj"));
        hashMap.put(3L, new Payment(3L, "h99jnjdois9od903mds9du39jdsoi9"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}

```

**测试地址**

http://localhost:9003/paymentSQL/1

#### ③ 消费者84

##### 新建cloudalibaba-consumer-nacos-order84

##### 修改POM

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>cloud2020</artifactId>
        <groupId>com.atguigu.springcloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>cloudalibaba-consumer-nacos-order84</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>com.atguigu.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>

```

##### 新建application.yml

```yaml
server:
  port: 84

spring:
  application:
    name: nacos-order-consumer
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 # 配置Nacos地址
    sentinel:
      transport:
        # 配置Sentinel dashboard地址
        dashboard: localhost:8080
        # 默认8791端口，假如被占用会自动从8791开始依次+1扫描，直到找到未被占用的端口
        port: 8719
#消费者将要去访问的微服务名称（注册成功进nacos的微服务提供者）
service-url:
  nacos-user-service: http://nacos-payment-provider

```

##### 新建主启动类

```java
package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王柳
 * @date 2020/4/21 11:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class,args);
    }
}

```

##### 新建业务类

```java
package springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 王柳
 * @date 2020/4/2 15:11
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

```

 

```java
package springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 王柳
 * @date 2020/4/21 11:48
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")//没有配置
//    @SentinelResource(value = "fallback", fallback = "handleFallback")//fallback只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockHandler只负责Sentinel控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handleFallback", blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }
    
    public CommonResult<Payment> handleFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底异常handleFallback，exception内容：" + e.getMessage(), payment);
    }
    
    public CommonResult<Payment> blockHandler(Long id, BlockException exception) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "blockHandler-sentinel限流，无此流水：exception   " + exception.getMessage(), payment);

    }
}

```

![img](img/8ed84725-1385-4150-82b1-d5eb3ed92ba4.png)

![img](img/73c74497-0387-4ecd-9af7-37efaf6cbb76.png)

![img](img/3aa3a96d-4693-4dd3-a66b-f3b37a337d59.png)

![img](img/335fafe8-1d59-4614-82ea-d659a11be0e3.png)

![img](img/1116dcbf-f0ff-41df-8095-4179688a755e.jpg)

![img](img/eece9abb-4e3c-4416-b1da-ca2a88b7805c.jpg)

##### 忽略属性exceptionsToIgnore

![img](img/b6d02d00-a1d8-468a-86ea-cb0fe96f4dfb.jpg)

### （2）Feign系列

#### ① 修改84模块

![img](img/06481f4b-aff6-4beb-95f4-4b9a06f689e3.png)

#### ② 修改POM

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
```

#### ③ 修改application.yml

```xml
feign:
  sentinel:
    enabled: true
```

#### ③ 修改新建业务类

```java
package springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 王柳
 * @date 2020/4/22 16:58
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}

```

 

```java
package springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 王柳
 * @date 2020/4/22 17:01
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444,"服务降级返回----》PaymentFallbackService",new Payment(id,"error serial"));
    }
}

```

修改CircleBreakerController，添加如下：

```java
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/openFegin/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
```

#### **④ 修改主启动**

```java
@EnableFeignClients
```

#### ⑤ 测试

![img](img/fcaed5d4-ef62-458a-a817-d0d49d917844.png)

### （3）熔断框架比较

![img](img/9943e853-5a0c-4a8d-8601-0e4cd0ba406c.jpg)

![img](img/d3087d70-6b40-40e2-b25b-6a422d51d12e.jpg)

## 10、规则持久化

### （1）是什么

![img](img/e3407556-5101-431b-854e-19c33a22f194.png)

### （2）怎么玩

![img](img/5f2957cc-1a54-4d1e-966c-e86bd796769f.png)

### （3）步骤

#### ① 修改cloudalibaba-sentinel-service8401

#### ② 修改POM

```xml
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-nacos</artifactId>
        </dependency>
```

#### ③ 修改application.yml

添加datasource

```yaml
spring:
  application:
    name: cloudalibaba-sentinel-service
  cloud:
    nacos:
      discovery:
        # Nacos服务注册中心地址
        server-addr: localhost:8848
    sentinel:
      transport:
        # 配置Sentinel dashboard地址
        dashboard: localhost:8080
        # 默认8791端口，假如被占用会自动从8791开始依次+1扫描，直到找到未被占用的端口
        port: 8719
      datasource:
        ds1:
          nacos:
            server-addr: localhost:8848
            dataId: ${spring.application.name}
            groupId: DEFAULT_GROUP
            data-type: json
            rule-type: flow
```

#### ④ 添加Nacos业务规则配置

![img](img/db9203a9-0b1a-4870-afb9-6d06089305eb.jpg)

```json
[
    {
        "resource":"/rateLimit/byUrl",
        "limitApp":"default",
        "grade":1,
        "count":1,
        "strategy":0,
        "controlBehavior":0,
        "clusterMode":false
    }
]
```

![img](img/bfea7134-0f47-407e-a1b0-a275dadad795.jpg)

#### ⑤ 启动8401后刷新Sentinel发现业务规则有了

![img](img/86fe2b7a-6179-4db2-a9c4-406d00d9bd1b.jpg)

#### ⑥ 快速访问测试接口

![img](img/d4e3661a-d963-4dda-9057-5921765a7853.png)

#### ⑦ 停止8401再看Sentinel

![img](img/925b6272-1d50-4169-94ef-01213576eb3a.jpg)

#### ⑧ 重新启动8401再看sentinel

![img](img/1229d796-8943-485d-be4c-b9da0f4dae7a.png)

# 二十、SpringCloud Alibaba Seata处理分布式事务



# 二十一、TX-LCN分布式事务



# 二十二、SpringBoot Admin监控中心

参考[SpringCloud实战学习](wiz://open_document?guid=a6a8e6ec-bf20-4a66-9d7b-4fbd37fb1d26&kbguid=&private_kbguid=9e15e816-792d-4528-9d21-a849cc4117d5)中的SpringBoot Admin章节。

GitHub地址： [https://github.com/wangliu1102/SpringCloudStudy-Practical](https://github.com/wangliu1102/SpringCloudStudy-Practical.git)

## 1、导入相关依赖，导入security是为了登录验证

邮件服务可以配置admin在监控服务up或down的时候发送邮件！！！

```xml
<properties>
        <spring-boot-admin.version>2.1.6</spring-boot-admin.version>
    </properties>
    <dependencies>
        <!--Tomcat: java.lang.IllegalStateException: Calling [asyncError()] is not valid for a request with Async state [MUST_DISPATCH]-->
        <!-- 使用jetty来替换Tomcat解决上述错误-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <!--监控服务端-->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-server</artifactId>
            <version>${spring-boot-admin.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-security</artifactId>
        </dependency>
        
        <!--邮件服务，都用的话可以放在父POM文件中-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
    </dependencies>
```

## 2、修改配置文件application.yml

```yml
server:
  port: 8769
spring:
  application:
    name: admin-monitor
  #登录SpringBoot Admin后台监控的用户名和密码
  security:
    user:
      name: admin
      password: admin
  #集成邮件通知，当监控的微服务down掉或up起来了，都会发送邮件通知
  mail:
    host: smtp.qq.com
    username: wangliu.ah@qq.com
    password: ydiekcpezegmjicc
  boot:
    admin:
      notify:
        mail:
          to: wangliu.ah@qq.com
          from: wangliu.ah@qq.com
#哪个客户端要监控所有端点，就添加下面代码，否则只监控到很少的信息，例如oauth2服务
management: #暴露actuator的所有端点
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint: #health endpoint是否必须显示全部细节。默认情况下, /actuator/health 是公开的，并且不显示细节
    health:
      show-details: always
eureka:
  client:
    registry-fetch-interval-seconds: 5  #表示eureka client间隔多久去拉取服务注册信息，默认为30秒
    service-url:
      defaultZone: http://admin:123456@eureka7001.com:7001/eureka,http://admin:123456@eureka7002.com:7002/eureka
  instance:
    lease-renewal-interval-in-seconds: 10  #表示eureka client发送心跳给server端的频率
    health-check-url-path: /actuator/health  #健康检查页面的URL路径
    instance-id: admin-monitor8769 #自定义服务名称信息
    prefer-ip-address: true #访问路径可以显示IP地址
      #注册给eureka时告诉eureka自己的密码，否则报错
    metadata-map:
      user.name: ${spring.security.user.name}
      user.password: ${spring.security.user.password}
info:
  app.name: springcloud-server
  company.name: www.wangliu.com
  build.artifactId: '@project.artifactId@'
  build.version: '@project.version@'
```

## （3）开启注解

```java
@EnableAdminServer
```

![img](img/5d42b9c5-053b-4f31-9245-b5e99d8e41aa.png)

## （4）增加Security相关配置

```java
/**
 * @author 王柳
 * @date 2019/11/7 15:22
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
    private final String adminContextPath;
    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/monitor");
        http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                .logout().logoutUrl(adminContextPath + "/logout").and()
                .httpBasic().and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(
                        adminContextPath + "/instances",
                        adminContextPath + "/actuator/**"
                );
    }
}
```

## **（5）测试**

**注意：SpringBoot Admin 注册进Eureka后，也可以监控到注册进Eureka的其他微服务**。

访问：http://项目实际地址:端口号

![img](img/27a81a73-5e1e-4dc9-85e0-75d41fce3c5d.png)