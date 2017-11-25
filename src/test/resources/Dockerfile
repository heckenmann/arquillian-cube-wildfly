FROM jboss/wildfly:11.0.0.Final
MAINTAINER heckenmann.de

RUN /opt/jboss/wildfly/bin/add-user.sh testuser testpw --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]