### Application Patterns

|대분류|소분류|패턴|스킬|비고|
|-|-|-|-|-|
|Decomposition|-|Self-Containered Service|Spring, Maven, Docker, Git|Mono Repository + Multi Module + Subtree Merge 을 활용하여 기능별로 Package 하여 독립서비스 분할|
|Data patterns|Database architecture|Database per Service|MySQL|Service별로 할당|
|Data patterns|Querying|CQRS|Axon Framework|DDD 에 따른 Request, Response 분류|
|Data patterns|Maintaining data consistency|Saga|Axon Framework, Axon Server|Transaction 구현을 통한 정합성 유지|
|Data patterns|Maintaining data consistency|Event sourcing|Axon Framework, Axon Server|Notification, Snapshot, Segment Mapping 을 고려하여 선택|
