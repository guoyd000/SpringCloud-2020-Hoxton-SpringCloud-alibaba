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

# 九、OpenFeign服务接口调用

# 十、Hystrix断路器

# 十一、Zuul路由网关

# 十二、Gateway新一代网关

# 十三、SpringCloud Config分布式配置中心

# 十四、SpringCloud Bus 消息总线

 RabbitMQ/Kafka

# 十五、SpringCloud Stream 消息驱动

# 十六、SpringCloud Sleuth分布式请求链路跟踪

# 十七、SpringCloud Alibaba入门简介

# 十八、SpringCloud Alibaba Nacos服务注册和配置中心

# 十九、SpringCloud Alibaba Sentinel实现熔断与限流

# 二十、SpringCloud Alibaba Seata处理分布式事务

# 二十一、TX-LCN分布式事务

# 二十二、SpringBoot Admin监控中心