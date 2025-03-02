#!/usr/bin/env bash

echo "Removendo deployments e statefulsets no kubernetes..."
kubectl -n java-kafka delete deployment zookeeper kafka kafka-ui adminer consumer producer
kubectl -n java-kafka delete statefulset mysql

echo "Removendo services no kubernetes..."
kubectl -n java-kafka delete svc zookeeper-service kafka-service kafka-ui-service adminer-service consumer-service producer-service

echo "Removendo ingress no kubernetes..."
kubectl -n java-kafka delete ingress adminer-ingress producer-ingress kafka-ui-ingress