### Application Infrastructure Patterns

|대분류|소분류|패턴|스킬|비고|
|-|-|-|-|-|
|Cross-cutting concerns|-|Externalized configuration|Spring Cloud Config, RabbitMQ, GitHub|Spring 2.4 이전과 이후에 Profile 기법을 혼합하여 사용, 원격저장소, 중요데이터 암호화 및 개별서비스 복호화 적용|
|Security|-|Access Token|JWT|Request Header(Bearer Auth) 및 Gateway Filter 를 통하여 구현|
|Communication patterns|Communication style|Remote Procedure Invocation|Http Client Binder|Feign Client 를 사용하여 Command, Query시 추가적으로 필요한 데이터 통신(GET Method)|
|Reliability|-|Circuit Breaker|Resilience4j|해당 구현체를 사용하여 Feign Client 실패시 회로차단|
