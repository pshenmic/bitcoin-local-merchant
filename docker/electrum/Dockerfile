FROM python
RUN apt-get update
# https://electrum.org/#download
RUN apt-get install -y python3-setuptools python3-pyqt5 python3-pip
RUN pip3 install https://download.electrum.org/3.1.2/Electrum-3.1.2.tar.gz
RUN electrum --testnet setconfig rpcuser user
RUN electrum --testnet setconfig rpcpassword password
RUN electrum --testnet setconfig rpcport 7777
RUN electrum --testnet setconfig rpchost 0.0.0.0
CMD electrum --testnet daemon start; electrum --testnet daemon load_wallet;tail -f /dev/null