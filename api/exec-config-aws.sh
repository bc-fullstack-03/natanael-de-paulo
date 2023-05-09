#!/bin/bash

# Configura o perfil default do AWS CLI
aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID
aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
aws configure set default.region $AWS_DEFAULT_REGION
aws configure set default.output $AWS_DEFAULT_OUTPUT
aws s3 mb s3://demo-bucket --endpoint-url $LOCALSTACK_ENDPOINT