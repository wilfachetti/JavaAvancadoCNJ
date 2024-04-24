#!/bin/bash
#200 O 1º método retorna uma lista o 2º um item da lista.

HOST=${HOST:-http://localhost:8081}
USER=${USER:-willian}
PASS=${PASS:-123}
TOKEN=${TOKEN:-eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJmcUItY1dQY3VPeVBWRDNDdk53eEFZcTF1SDF3QUNsM19FeEhLQWMtWk40In0.eyJleHAiOjE3MTM1NDk5MTQsImlhdCI6MTcxMzU0OTYxNCwianRpIjoiNTcyYzE0N2ItMDQ0MS00NTMwLWFiNTctZjQzMmM5MjE5NTUxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9SZWFsbVdpbENOSiIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJjNWIyYTcxOS1kOGI5LTRkMjEtOGJmOS04MmE4NzY0YzAwNjYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9qZXRvIiwic2Vzc2lvbl9zdGF0ZSI6ImQzNDU2Y2E3LTIxOTQtNDZhZC05NjU0LTdhMWEzYzYyYzE3YiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo4MDgxIiwiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiZGVmYXVsdC1yb2xlcy1yZWFsbXdpbGNuaiIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJ1c2VyIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIG1pY3JvcHJvZmlsZS1qd3QiLCJzaWQiOiJkMzQ1NmNhNy0yMTk0LTQ2YWQtOTY1NC03YTFhM2M2MmMxN2IiLCJ1cG4iOiJ3aWxsaWFuIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJXaWxsaWFuIEZhY2hldHRpIiwiZ3JvdXBzIjpbImRlZmF1bHQtcm9sZXMtcmVhbG13aWxjbmoiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwidXNlciJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ3aWxsaWFuIiwiZ2l2ZW5fbmFtZSI6IldpbGxpYW4iLCJmYW1pbHlfbmFtZSI6IkZhY2hldHRpIiwiZW1haWwiOiJ3aWxmYWNoZXR0aUBnbWFpbC5jb20ifQ.JDtKkA2ownoxFCVMYF648UC1olliAp5LZKEmv2lW4wy4jJ6zq8F0GYoiMosKxB7gmr9KEwGePfMSu0yepPmsMh-Fsij4hI1-xSkii9TtTx5s-gkSXo-rY7cO4Yxk-MufwCsWuQCdjbevWHnpTFwfe93RhK9Ynm--mSab4FrzewOJSknK07RdGd-4PYwJxOeZf-6BxbwigsEF0oKpiNybRcmEisUY4YTSwZ4i_wcX7CoVwexPzJ-InqOoB9RIpTU0x4b45RLEY3Ir50H2aGQ4-dm6RBWwMfMjqizkU-suJYI5OCPWaV2aFVtlm2fuehKADYe3uRNCMCjHUbMiw4ZaBg}

curl ${HOST}/api/casos \
     --header "Accept: application/json" \
     --user ${USER}:${PASS} \
     --silent \
     --write-out "\nCódigo HTTP: %{http_code}\n"

curl ${HOST}/api/casos/3 \
     --user ${USER}:${PASS} \
     --write-out "\nCódigo HTTP: %{http_code}\n"


read -d '' VERB_POST << HERE
{
    "id":"5",
    "descricao":"Caso 05"
}
HERE

curl --user ${USER}:${PASS} \
     --write-out "\nCódigo HTTP: %{http_code}\n" \
     --header    "Content-Type: application/json" \
     --data      "${VERB_POST}" \
     -X POST \
     ${HOST}/api/casos

curl ${HOST}/api/casos/5 \
     -X DELETE \
     --user ${USER}:${PASS} \
     --write-out "\nCódigo HTTP: %{http_code}\n"

: ' 
exemplo de
comentários em bloco
'

curl http://localhost:8080/realms/RealmWilCNJ/protocol/openid-connect/token \
     --header "Content-Type: application/x-www-form-urlencoded" \
     --data-urlencode client_id=projeto \
     --data-urlencode username=${USER} \
     --data-urlencode password=${PASS} \
     --data-urlencode grant_type=password \
     --write-out "\nCódigo HTTP: %{http_code}\n"

curl ${HOST}/api/casos \
     -H "Authorization: Bearer  ${TOKEN}" \
     --write-out "\nCódigo HTTP: %{http_code}\n"


curl http://localhost:8081/api/casos/55 \
     -X PUT \
     -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJNMzVIUS16VkJkeGwweWlXb0p3TkpqNkkxcXBKb2NId1Z5Z1NEaks2Z0pjIn0.eyJleHAiOjE3MTM5MDczODMsImlhdCI6MTcxMzkwNzA4MywianRpIjoiNGMyNjA4YjktYmVhNC00MzU4LWJkYzktYjcwNWM4NWU1YWY2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9yZWFsbS1jbmoiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiNmNjZjhiNjktZWE2YS00ODUzLThjZjAtZTYxNTUwYzI5YWM2IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoibG9naW4tcHJvamV0by1jbmoiLCJzZXNzaW9uX3N0YXRlIjoiMjI1ZWY4MTEtODgxOC00MzhmLWJjY2ItYmI5OGQyZWVkZjU3IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vbG9jYWxob3N0OjgwODEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1yZWFsbS1jbmoiLCJ1bWFfYXV0aG9yaXphdGlvbiIsInVzZXIiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUgbWljcm9wcm9maWxlLWp3dCIsInNpZCI6IjIyNWVmODExLTg4MTgtNDM4Zi1iY2NiLWJiOThkMmVlZGY1NyIsInVwbiI6IndpbGxpYW4iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IldpbGxpYW4gRmFjaGV0dGkiLCJncm91cHMiOlsib2ZmbGluZV9hY2Nlc3MiLCJkZWZhdWx0LXJvbGVzLXJlYWxtLWNuaiIsInVtYV9hdXRob3JpemF0aW9uIiwidXNlciJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ3aWxsaWFuIiwiZ2l2ZW5fbmFtZSI6IldpbGxpYW4iLCJmYW1pbHlfbmFtZSI6IkZhY2hldHRpIiwiZW1haWwiOiJ3aWxmYWNoZXR0aUBnbWFpbC5jb20ifQ.cmJTkDivr86dDp39j8kNs-NsQBsOQIIReE9GyC3u5MBkwmmXuB5F_FB2B9knNh5i-ECT1yZF91mTQ3WcJDbmsHyPC4lsVqMSiYqHL8UClsjOPXqPhyF8Hj7apQwidkGYe5-7bQLAMVoytcCNTbRn2f29vK_Jd9vsD1RiB21RAJ5wd6RajaIgB8i219-u15eQutSHN1g6qDn8XfZh8kpQNsX2p9Ef1ctjY3W5tcXtWRBEfrvozPk6-o2wt4yyO9wrfGJKp1s4bV-S2DRFI1XscHls7NXjV8GV9LDNgTLjbsRNngabVlQNlnjihnO6foYVqdgR1uufcRAYLswSUAqZrA" \
     -header 'Content-Type: application/json' \
     -d '{"descricao":"caso 55"}'


