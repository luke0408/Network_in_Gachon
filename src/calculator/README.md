# Calculator Project

## Description

> This is a simple calculator project in java with a thread.

### Requirements

1. Cilent와 Server 통신을 위한 Socket 프로그래밍
2. Client에서 Server로 연산 요청을 보내고, Server에서 연산 결과를 Client로 보내는 프로그램
3. 통신 규칙을 적용할 것
4. 통신에 필요한 데이터는 server_info.dat 파일을 이용할 것
5. 연산은 Thread를 이용하여 처리할 것
6. 4번의 과정이 실패하면 default 값을 이용할 것

### Sequence Diagram

- 일반 통신
```mermaid
sequenceDiagram
    participant Client
    participant Server
    loop 연결 요청
        Client->>Server: 연결 요청 (ex. 10 + 20)
        Server->>Client: 연산 결과 (ex. 30)
    end
```

- 요청 문제 발생
```mermaid
sequenceDiagram
    participant Client
    participant Server
    alt 일반 통신
        Client->>Server: request (10 + 20)
        Server->>Client: response (30)
    else 요청 파라미터
        Client->>Server: request (10 + 20 + 30)
        Server->>Client: response ("Invalid Input")
    else 연결 해제 요청
        Client->>Server: request (exit)
        Server->>Client: response (exit)
    end
    
```