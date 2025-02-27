#!/usr/bin/env bash

echo "Derrubando containers parcial..."
docker-compose -f docker/docker-composer-parcial.yml down
