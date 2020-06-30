FROM maven:3.5.3-jdk-8
ENV PROJECT_PATH /automation
RUN mkdir -p "$PROJECT_PATH"
ADD ./ $PROJECT_PATH/cmd_auto
WORKDIR $PROJECT_PATH/cmd_auto
#CMD chmod +x $PROJECT_PATH/cmd_auto/mvnw
#RUN cd $PROJECT_PATH/cmd_auto; ls -la
RUN ls -la
ENTRYPOINT ["mvn", "test"]
#ENTRYPOINT ["ls", "-la", "/automation/cmd_auto"]
