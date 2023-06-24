#!usr/bin/env bash

export IMAGE = $1
docker-compose -f docker-compose.yaml up --detach
echo "success"
export TEST=testvalue 

# execute both cmds by running the shell script in jenkinsfile13