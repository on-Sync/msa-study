# spring_cloud_microservice
Spring Cloud ( Netflix OSS ) 기반 Microservice


## Architecture

![MSA](resource/images/architecutre.png)

> - Spring Cloud Netflix 프로젝트 대부분이 `Deprecated` 이므로 Spring Cloud 대체 프로젝트를 사용하여 Netflix OSS 를 구성하였다.
>   - [참고 - github.com/spring-cloud/spring-cloud-release/wiki](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2020.0-Release-Notes#breaking-changes)

## MSA Pattern

> - Pattern 기반으로 적용사항을 정리하면 다음과 같다.
>   - [참고 - microservices.io](https://microservices.io/patterns/index.html)

### Application Patterns

|대분류|소분류|패턴|스킬|비고|
|-|-|-|-|-|
|Decomposition|-|Self-Containered Service|Spring, Maven, Docker, Git|Mono Repository + Multi Module + Subtree Merge 을 활용하여 기능별로 Package 하여 독립서비스 분할|
|Data patterns|Database architecture|Database per Service|MySQL|Service별로 할당|
|Data patterns|Querying|CQRS|Axon Framework|DDD 에 따른 Request, Response 분류|
|Data patterns|Maintaining data consistency|Saga|Axon Framework, Axon Server|Transaction 구현을 통한 정합성 유지|
|Data patterns|Maintaining data consistency|Event sourcing|Axon Framework, Axon Server|Notification, Snapshot, Segment Mapping 을 고려하여 선택|

### Application Infrastructure Patterns

|대분류|소분류|패턴|스킬|비고|
|-|-|-|-|-|
|Cross-cutting concerns|-|Externalized configuration|Spring Cloud Config, RabbitMQ, GitHub|Spring 2.4 이전과 이후에 Profile 기법을 혼합하여 사용, 원격저장소, 중요데이터 암호화 및 개별서비스 복호화 적용|
|Security|-|Access Token|JWT|Request Header(Bearer Auth) 및 Gateway Filter 를 통하여 구현|
|Communication patterns|Communication style|Remote Procedure Invocation|Http Client Binder|Feign Client 를 사용하여 Command, Query시 추가적으로 필요한 데이터 통신(GET Method)|
|Reliability|-|Circuit Breaker|Resilience4j|해당 구현체를 사용하여 Feign Client 실패시 회로차단|

### Infrastructure Patterns

|대분류|소분류|패턴|스킬|비고|
|-|-|-|-|-|
|Deployment|Service deployment platform|Service per Container, Multiple Services per host|Docker Compose, Docker Hub|Docker(OCI) Compose를 Orchestration 사용|
|Communication patterns|Discovery|Service Registry, Self registration|Spring Cloud Netflix Eureka|Eureka Embeded LB(Round Robbin) 를 사용하여 Feign Client 의 Client side LB 적용|
|Communication patterns|External API|API Gateway|Spring Cloud Gateway|Filter, Router 적용 및 Eureka Embeded LB 를 사용하여 Service side LB 적용|

## Retrospection

### Thought

> 이번 사이드프로젝트는 Java, Spring, Netflix OSS 을 통한 MSA 생태계를 확인하는 것을 중점으로 진행했다. k8s 와 비교했을 때, Auto scaling, Deployment 분야가 부족했기에 Docker Compose, Dockerize 와 같은 3rd party 가 필요했다. 대신 Service mesh, Gateway 등 Infra 쪽을 Java 로 구현할 수 있다는 장점이 있었다. Polyglot 구현이 필수가 아닌 Java 가 주력인 팀에서 사용하기 좋을 것 같다.
> - [참조 - 서비스 경량화를 위한 MSA 설계 시 고려사항](https://www.samsungsds.com/kr/insights/1239180_4627.html)
> - [참조 - 넷플릭스로 알아보는 MSA](https://www.samsungsds.com/kr/insights/msa_and_netflix.html)

### To Do & To Be

> 현재 템플릿수준으로 프로젝트를 진행했기에 다음과 같은 미비점들이 많이 존재한다.  
>  
> - Request & Response format 적용
> - Docker Deploy Probe 추가
> - API Function 보완
> - Redis caching 구현
> - Data Batch Scheduling 구현

`2021.09.11`
