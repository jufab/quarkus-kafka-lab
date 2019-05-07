#!/usr/bin/env bash
kafka_2.12-2.2.0/bin/zookeeper-server-start.sh kafka_2.12-2.2.0/config/zookeeper.properties > zookeeper.log &
kafka_2.12-2.2.0/bin/kafka-server-start.sh kafka_2.12-2.2.0/config/server.properties > kafka.log &
export ZK_HOSTS="localhost:2181"
kafka-manager/bin/kafka-manager -Dconfig.file=kafka-manager/conf/application.conf -Dhttp.port=9000