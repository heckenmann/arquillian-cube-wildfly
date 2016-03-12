FROM jboss/wildfly:10.0.0.Final
MAINTAINER heckenmann.de

EXPOSE 9990 8080
RUN /opt/jboss/wildfly/bin/add-user.sh testuser testpw --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]