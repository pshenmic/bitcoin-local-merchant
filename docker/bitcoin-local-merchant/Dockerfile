FROM maven
ARG BASE_HREF=/
WORKDIR /opt
RUN git clone https://github.com/pshenmic/bitcoin-local-merchant.git
ENV PROJECT_DIR /opt/bitcoin-local-merchant
RUN mvn -Dbase.href=${BASE_HREF} -Pprod clean install -f $PROJECT_DIR/pom.xml
ENV POSTGRES_HOSTNAME hostname
ENV POSTGRES_PORT 5432
ENV POSTGRES_USER user
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB db
ENV BLM_HOSTNAME hostname
ENV ELECTRUM_HOSTNAME hostname
ENV ELECTRUM_RPCUSER rpcuser
ENV ELECTRUM_RPCPASSWORD rpcpassword
CMD java \
-Dspring.datasource.url=jdbc:postgresql://$POSTGRES_HOSTNAME:$POSTGRES_PORT/$POSTGRES_DB \
-Dspring.datasource.username=$POSTGRES_USER \
-Dspring.datasource.password=$POSTGRES_PASSWORD \
-Dblm.hostname=$BLM_HOSTNAME \
-Dblm.electrum.hostname=$ELECTRUM_HOSTNAME \
-Dblm.electrum.rpcuser=$ELECTRUM_RPCUSER \
-Dblm.electrum.rpcpassword=$ELECTRUM_RPCPASSWORD \
-jar $PROJECT_DIR/target/bitcoinlocalmerchant-1.0-SNAPSHOT.jar
