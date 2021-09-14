### Infrastructure Patterns

|대분류|소분류|패턴|스킬|비고|
|-|-|-|-|-|
|Deployment|Service deployment platform|Service per Container, Multiple Services per host|Docker Compose, Docker Hub|Docker(OCI) Compose를 Orchestration 사용|
|Communication patterns|Discovery|Service Registry, Self registration|Spring Cloud Netflix Eureka|Eureka Embeded LB(Round Robbin) 를 사용하여 Feign Client 의 Client side LB 적용|
|Communication patterns|External API|API Gateway|Spring Cloud Gateway|Filter, Router 적용 및 Eureka Embeded LB 를 사용하여 Service side LB 적용|
