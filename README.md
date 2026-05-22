## This is repo for java exercises

---

### To check your test coverage, open the following file:
```bash
target/site/jacoco/index.html
```

**Dont forget to add the plugin**
```xml

<plugins>
    <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.8.12</version>
        <executions>
            <execution>
                <goals>
                    <goal>prepare-agent</goal>
                </goals>
            </execution>
            <execution>
                <id>report</id>
                <phase>test</phase>
                <goals>
                    <goal>report</goal>
                </goals>
                <configuration>
                    <excludes>
                        <exclude>**/MainMock.class</exclude>
                        <exclude>**/Player.class</exclude>
                    </excludes>
                </configuration>
            </execution>
            <execution>
                <id>jacoco-check</id>
                <goals>
                    <goal>check</goal>
                </goals>
                <configuration>
                    <rules>
                        <rule>
                            <element>PACKAGE</element>
                            <limits>
                                <limit>
                                    <counter>LINE</counter>
                                    <value>COVEREDRATIO</value>
                                    <minimum>0.85</minimum>
                                </limit>
                            </limits>
                        </rule>
                    </rules>
                </configuration>
            </execution>
        </executions>
    </plugin>
</plugins>
```

---

**Resources**

[Unit Test - YouTube](https://youtu.be/mEzoe6KSUu8)

[Unit Test with Mockito - YouTube](https://youtu.be/0VivFIbTZ3c)

---

**JVM Command**
```bash
-ea -XX:+EnableDynamicAgentLoading -Xshare:off
```