# tutorial

## single project
* tutorial-single

## multi-project
* tutorial-web
* tutorial-domain
* tutorial-env
* tutorial-initdb
* tutorial-selenium
## resttemplate 

```xml
<bean id="restTemplate" class="org.springframework.web.client.RestTemplate">
    <constructor-arg ref="clientHttpRequestFactory" /> <!-- (2) -->
    <property name="messageConverters">
        <list>
            <bean id="formConverter" class="org.springframework.http.converter.FormHttpMessageConverter" />
            <bean id="stringConverter" class="org.springframework.http.converter.StringHttpMessageConverter" />
            <bean id="jsonConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" >
                <property name="supportedMediaTypes">
                <list>
                    <!--  <value>text/html</value>-->
                    <value>application/json</value>
                </list>
            </property>
            </bean>
        </list>
      </property>
      <property name="interceptors"><!-- (2) -->
        <list>
            <ref bean="loggingInterceptor" />
        </list>
    </property>
</bean>
```
