#!/usr/bin/env bash

echo "Derrubando containers parcial..."
docker-compose -f docker/docker-composer-parcial.yml down

echo "Subindo congtainers parcial..."
docker-compose -f docker/docker-composer-parcial.yml up -d