# needs to sperate from mylibrary -api

FROM ubuntu:trusty
MAINTAINER Venkata Santhosh Piduri <santhosh.piduri@gmail.com>

# Prevent dpkg errors
ENV TERM=xterm-256color

# Sed mirror command is used to point to local

RUN apt-get update && \
    apt-get install -y \
    -o APT::Install-Recommend=false -o APT::Install-Suggests=false && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean


ADD scripts/entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh
ENTRYPOINT ["entrypoint.sh"]


#docker build -t coconut/mylibrary-base .