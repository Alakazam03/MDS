FROM ubuntu:latest


RUN \
# Update
apt-get update -y && \
# Install Java
apt-get install default-jre -y


# path to jar file
ADD ./target/MDS-0.0.1-SNAPSHOT.jar mds-controller.jar


# port
EXPOSE 4501

# run the jar
ENTRYPOINT ["java","-jar","mds-controller.jar"]