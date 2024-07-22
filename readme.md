### 실행

1. [카프카 설치](https://kafka.apache.org/downloads)
    - 여러 다운로드 가능한 파일들 중에서, 꼭 'Binary 파일'로 받을 것!
    - ex) Scala 2.12 or Scala 2.13

2. zookeeper 와 kafka 실행
    - 설치된 디렉토리로 이동하여, zookeeper 와 kafka 를 각각 별개의 터미널에서 실행한다.

    ```bash
    # kafka 가 설치된 폴더 위치로 이동한다.
   
    # 1. zookeeper 실행
    > bin/zookeeper-server-start.sh config/zookeeper.properties
    
    # 2. kafka 실행
    > bin/kafka-server-start.sh config/server.properties
    ```

3. privacy.yml 파일 생성 (application.yml 과 같은 위치)
    - default는
      ```yml
      kafka:
        host: localhost
        port: 9092
      ```
4. SpringBoot 애플리케이션 빌드 및 실행