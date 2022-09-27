# Apache-Kafka-Java-Entegration

First, run zookeper by typing "zkserver" on the command line.


Open another command line and go to the path where kafka is installed and click "kafka-server-start.bat ..\..\config\server.properties" and run it.


Finally, open one more command line and go to the place where kafka is installed again and click "kafka-topics.bat --list --zookeeper localhost:2181" and you can see the topics.

By writing "kafka-topics.bat --create --zookeper localhost:2181 --partitions 3 --replication-factor 1 --topic apachekafka" you can create a new topic.
