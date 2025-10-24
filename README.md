# MSA SERVICE PART

- 각 폴더는 해당 서비스에 관한 코드와 도커파일을 포함합니다.

## docker image list
### 도커 이미지 업데이트 후 최신 버전으로 표기할 것
1. user (지민우)
   - [도커허브](https://hub.docker.com/r/jiminu/mp3-service-user) [0.1.3-amd]
2. restarea (지민우)
   - [도커허브](https://hub.docker.com/r/jiminu/mp3-service-restarea) [0.1.1-amd]
3. openapi (장준희)
   - [도커허브](https://hub.docker.com/r/wnsgml/mp3-service-openapi) [0.0.6]
4. gateway (지민우)
   - [도커허브](https://hub.docker.com/r/jiminu/mp3-gateway) [0.2.1-amd]
5. eureka (지민우)
   - [도커허브](https://hub.docker.com/r/jiminu/eureka-serv) [0.1.0-amd]
6. tmapapi (이현진)
   - [도커허브](https://hub.docker.com/repositories/lhj1211) [0.0.4-amd]
7. restarea-unit (food-facility) (조성민)
   - [도커허브](https://hub.docker.com/repository/docker/seongmincho/mp3-service-restarea-unit/tags) [0.1.1-amd]
8. content (favorite-review) (정영호)
   - [도커허브](https://hub.docker.com/repository/docker/startingfindmistake/mp3-service-content/general/) [0.1.0]
9. openai (하지현)
   - [도커허브](https://hub.docker.com/repository/docker/j2hxxxx/mp3-service-openai) [0.3.0-amd]


# port 번호
|port|service|
|--|--|
|8081|user|
|8082|restarea|
|8083|restarea-unit (food-facility)|
|8084|content (favorite-review)|
|8085|openapi|
|8086|tmapapi|
|8087|openai|
|8765|eureka|
|9000|spring gateway|
