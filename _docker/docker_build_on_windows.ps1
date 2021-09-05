### 조건사항
# 빌드시 다음 설정으로 호스트 config-api 실행이 필요합니다.
# - http://host.docker.internal:9000
# - spring.cloud.config.fail-fast=true

#build
Set-Location ..
docker build -t 'putstack/api-gateway:latest'   --build-arg APP='api-gateway'                -f './_docker/Dockerfile' .
docker build -t 'putstack/config-store:latest'  --build-arg APP='service-mesh/config-store'  -f './_docker/Dockerfile' .
docker build -t 'putstack/discovery:latest'     --build-arg APP='service-mesh/discovery'     -f './_docker/Dockerfile' .
docker build -t 'putstack/order-command:latest' --build-arg APP='microservice/order/command' -f './_docker/Dockerfile' .
docker build -t 'putstack/order-query:latest'   --build-arg APP='microservice/order/query'   -f './_docker/Dockerfile' .