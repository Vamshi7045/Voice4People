FROM tomcat:10.1-jdk21-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY src/main/webapp /tmp/webapp
COPY src/main/java /tmp/java

RUN mkdir -p /tmp/classes

RUN find /tmp/java -name "*.java" > /tmp/sources.txt && \
    javac -cp "/usr/local/tomcat/lib/servlet-api.jar" \
    -d /tmp/classes \
    @/tmp/sources.txt

RUN mkdir -p /usr/local/tomcat/webapps/ROOT && \
    cp -r /tmp/webapp/* /usr/local/tomcat/webapps/ROOT/ && \
    mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes && \
    cp -r /tmp/classes/* /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/ && \
    cp -r /tmp/webapp/WEB-INF/lib /usr/local/tomcat/webapps/ROOT/WEB-INF/

EXPOSE 8080

CMD ["catalina.sh", "run"]