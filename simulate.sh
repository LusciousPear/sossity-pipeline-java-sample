#!/bin/bash

wget -N https://storage.googleapis.com/build-artifacts-public-eu/sossity/sossity-0.1.0-SNAPSHOT-standalone.jar
java -jar sossity-0.1.0-SNAPSHOT-standalone.jar -c $1 -s --testfile $2

