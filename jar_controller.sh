#!/bin/bash

if [ $# -ne 2 ]; then
  echo "指定された引数の個数が誤っています。"
  echo "例:jar_controller.sh on api"
  exit 200
fi

if [ $2 = "api" ]; then
  TYPE="api"
elif [ $2 = "ui" ]; then
  TYPE="ui"
else
  echo "第二引数にapi / uiを指定してください。"
  exit 203
fi

if [ $1 = on ]; then
  if [ -f "library-$TYPE-0.0.1-SNAPSHOT.lock" ]; then
    echo "既に起動中です。"
    exit 201
  fi
  java -jar "library-$TYPE-0.0.1-SNAPSHOT.jar" &
  echo "library-$TYPE-0.0.1-SNAPSHOT.jarを起動しました。"
  touch library-$TYPE-0.0.1-SNAPSHOT.lock

elif [ $1 = off ]; then
  ps -ef | grep "library-$TYPE-0.0.1-SNAPSHOT.jar" | grep -v "grep" |
  awk '{print $2}' |  xargs kill
  RETURN_CODE=$?
  if [ $RETURN_CODE = 0 ]; then
    rm -f library-$TYPE-0.0.1-SNAPSHOT.lock
    echo "library-$TYPE-0.0.1-SNAPSHOT.jarを停止しました。"
  fi

  else
    echo "第一引数にon / offを指定してください。"
    exit 203
  fi