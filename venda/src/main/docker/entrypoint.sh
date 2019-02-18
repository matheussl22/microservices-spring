#!/bin/sh
if [ ! -z "${CONFIG_SERVICE}" ]; then
  echo "Checking if config service is up. Timeout in 60s"
  curl --retry 20 --connect-timeout 3 -s "${CONFIG_SERVICE}"
  if [ 0 != $? ]; then
    exit 1;
  fi;
fi;
exec "$@"
