[![Build Status](https://travis-ci.org/heckenmann/arquillian-cube-wildfly.svg?branch=master)](https://travis-ci.org/heckenmann/arquillian-cube-wildfly)
[![Quality Gate](https://sonarqube.com/api/badges/gate?key=de.heckenmann:arquillianCubeTest)](https://sonarqube.com/dashboard/index/de.heckenmann:arquillianCubeTest)
[![Technical debt ratio](https://sonarqube.com/api/badges/measure?key=de.heckenmann:arquillianCubeTest&metric=sqale_debt_ratio)](https://sonarqube.com/dashboard/index/de.heckenmann:arquillianCubeTest)

# TestNG mithilfe von Arquillian auf Wildfly im Docker-Container
Arquillian hat eine Erweiterung erhalten, mit der es möglich ist, aus einem (Maven-) Projekt heraus Docker-Container zu bauen und zu steuern: Arquillian Cube. So können die Tests abgeschottet in eigenen Container laufen. Nach den Tests werden die Container auf Wunsch gelöscht und beim nächsten Durchlauf wieder automatisch erstellt.

In diesem Beispiel wird TestNG als Testframework verwendet, um eine EJB auf einer Wildfly-Installation zu testen, die sich in einem Docker-Container befindet.
Dieses Projekt wurde in folgender Umgebung erstellt:

- Ubuntu 16.04
- Docker Version 1.12.3
- Wildfly 10
- Java 1.8.0_74

Voraussetzung für die Durchführung ist ein gestarteter Docker-Service. Damit Arquillian Cube auf den Docker-Dienst zugreifen kann, muss die Docker-Konfiguration erweitert werden. In der Datei

```
/etc/default/docker
```
bzw.
```
/lib/systemd/system/docker.service
```

wird bei den DOCKER_OPTS folgendes ergänzt:
```
DOCKER_OPTS="-H tcp://127.0.0.1:2375 -H unix:///var/run/docker.sock"
```

Falls die Maschine, auf der Docker läuft, eine andere ist, als die, auf der das Projekt gebaut wird, muss bei der IP 0.0.0.0 eingetragen werden. Nach der Konfiguration startet man Docker neu.

Wenn die Maschine, auf der Docker läuft, dieselbe ist, kann das Projekt geklont werden und ohne weitere Anpassungen gebaut werden. Falls nicht, muss die Datei
```
/src/test/resources/arquillian.xml
```
angepasst werden.
In diesem Ordner liegt auch das Dockerfile, das das Docker-Image definiert.

Der Test befindet sich im Ordner
```
/src/test/java/meinetests
```


Oder direkt mit
```
git clone https://github.com/heckenmann/arquillian-cube-wildfly
mvn clean install
```
klonen und bauen.



Quellen:

- https://github.com/arquillian/arquillian-cube
- https://github.com/arquillian/arquillian-cube/blob/1.0.0.Alpha6/README.adoc
- https://docs.jboss.org/arquillian/reference/1.0.0.Alpha1/en-US/html_single/
- https://hub.docker.com/r/jboss/wildfly/
