#!/bin/bash

read -p "Enter your name : " inputDir

BASE_PATH=$PWD

echo $BASE_PATH

#git status

#git add

for f in "$BASE_PATH"/*
do
    echo $f
done