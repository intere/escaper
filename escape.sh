#!/bin/bash


FLAG=$1;
INPUT=$2;
OUTPUT=$3;

#echo mvn exec:java -Dexec.args="$FLAG $INPUT $OUTPUT"

mvn exec:java -Dexec.args="$FLAG $INPUT $OUTPUT"


