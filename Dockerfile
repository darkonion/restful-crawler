FROM openjdk:8
EXPOSE 8080 8081
WORKDIR /var/restful-crawler
ADD target/restful-crawler-1.0-SNAPSHOT-jar-with-dependencies.jar /var/restful-crawler/restful-crawler-1.0-SNAPSHOT-jar-with-dependencies.jar

RUN wget -q "https://github.com/mozilla/geckodriver/releases/download/v0.27.0/geckodriver-v0.27.0-linux64.tar.gz" -O /tmp/geckodriver.tgz \
    && tar zxf /tmp/geckodriver.tgz -C /usr/bin/ \
    && rm /tmp/geckodriver.tgz

RUN ln -s /usr/bin/geckodriver \
    && chmod 777 /usr/bin/geckodriver

ENTRYPOINT ["java", "-jar", "restful-crawler-1.0-SNAPSHOT-jar-with-dependencies.jar"]