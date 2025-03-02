#!/usr/bin/env bash

echo "Derrubando containers..."
docker-compose -f docker/docker-composer.yml down

echo "Subindo containers..."
docker-compose -f docker/docker-composer.yml up -d
