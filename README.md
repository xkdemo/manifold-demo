---
title: manifold-demo
---

## Versions
- manifold: 2021.1.34
- maven: 3.6.3

## manifold-demo-web
A `Extension Library`, compiled ok;

extend `org.springframework.http.server.reactive.ServerHttpRequest`:
```java
@Extension
public class ServerHttpRequestExt {
  public static void helloWorld(@This ServerHttpRequest thiz) {
    System.out.println("hello world!");
  }
}
```

## manifold-demo-web-2
A `Extension Library`, compiled failed;

based on `manifold-demo-web`

use `ManCharSequenceExt.isNullOrEmpty` in package `manifold.text.extensions.java.lang.CharSequence` of `manifold-text`

in `pom.xml`:

add dependency:
```xml
<dependencies>
    <dependency>
        <groupId>systems.manifold</groupId>
        <artifactId>manifold-text</artifactId>
    </dependency>
</dependencies>
```

and `maven-jar-plugin`:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <configuration>
                <archive>
                    <manifestEntries>
                        <!--class files as source must be available for extension method classes-->
                        <Contains-Sources>java,class</Contains-Sources>
                        <!--JPMS module name-->
                        <Automatic-Module-Name>manifold.demo.web.2</Automatic-Module-Name>
                    </manifestEntries>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## manifold-demo-web-3
A `Extension Library`, compiled failed;

based on `manifold-demo-web-2`

in `pom.xml`

add `maven-compiler-plugin`

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <source>8</source>
                <target>8</target>
                <encoding>UTF-8</encoding>
                <compilerArgs>
                    <!-- Configure manifold plugin -->
                    <arg>-Xplugin:Manifold no-bootstrap</arg>
                </compilerArgs>
                <!-- Add the processor path for the plugin -->
                <annotationProcessorPaths>
                    <path>
                        <groupId>systems.manifold</groupId>
                        <artifactId>manifold-ext</artifactId>
                        <version>${manifold.version}</version>
                    </path>
                    <path>
                        <groupId>systems.manifold</groupId>
                        <artifactId>manifold-text</artifactId>
                        <version>${manifold.version}</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
```

