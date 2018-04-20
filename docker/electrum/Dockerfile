FROM python
RUN apt-get update
# https://electrum.org/#download
RUN apt-get install -y python3-setuptools python3-pyqt5 python3-pip
RUN pip3 install https://download.electrum.org/3.1.2/Electrum-3.1.2.tar.gz
VOLUME ["/root/.electrum"]
ENV TESTNET 0
ENV RPC_USER user
ENV RPC_PASSWORD password
CMD test $TESTNET = 1  && export ARGS="--testnet" || export ARGS="" && \
electrum $ARGS daemon load_wallet && \
electrum $ARGS setconfig rpcuser $RPC_USER && \
electrum $ARGS setconfig rpcpassword $RPC_PASSWORD && \
electrum $ARGS setconfig rpcport 7777 && \
electrum $ARGS setconfig rpchost 0.0.0.0 && \
electrum $ARGS daemon
