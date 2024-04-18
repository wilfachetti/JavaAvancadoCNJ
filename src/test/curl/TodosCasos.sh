#!/bin/bash
#200 O 1º método retorna uma lista o 2º um item da lista.

URL=${URL:-http://localhost:8081}

curl --user admin:123 \
     --write-out "\nResposta HTTP: %{http_code}\n" \
     --header "Accept: application/json" \
     ${URL}/api/casos

curl --user admin:123 \
     --write-out "\nResposta HTTP: %{http_code}\n" \
     ${URL}/api/casos/3