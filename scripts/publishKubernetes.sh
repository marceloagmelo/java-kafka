#!/usr/bin/env bash

echo "Publicando zookeeper no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/zookeeper/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-kafka

echo "Publicando kafka no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/kafka/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-kafka

echo "Publicando mysql no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/mysql/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-kafka

echo "Publicando adminer no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/adminer/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-kafka

echo "Publicando consumer no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/consumer/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-kafka

echo "Publicando producer no kubernetes..."
awk 'FNR==1 {print "---"}{print}' k8s/producer/*.yaml | envsubst > kub-app.yaml
cat kub-app.yaml
kubectl apply -f kub-app.yaml -n java-kafka