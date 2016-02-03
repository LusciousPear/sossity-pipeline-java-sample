#!/bin/bash


wget -N https://s3.amazonaws.com/com.22acacia/releases/sossity/sossity/sossity-0.1.0-SNAPSHOT-standalone.jar
java -jar sossity-0.1.0-SNAPSHOT-standalone.jar -c $1 -s -d
