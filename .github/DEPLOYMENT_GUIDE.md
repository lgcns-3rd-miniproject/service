# GitHub Actions CI/CD guide

## requirements

### 1. GitHub Secrets 설정
Repository Settings → Secrets and variables → Actions에서 다음 시크릿 추가:

```
DOCKER_USERNAME       # Docker Hub 사용자명
DOCKER_PASSWORD       # Docker Hub 액세스 토큰
AWS_HOST             # AWS EC2 인스턴스 IP 또는 도메인
AWS_USERNAME         # EC2 SSH 사용자명 (예: ubuntu, ec2-user)
AWS_SSH_KEY          # EC2 접속용 Private Key (전체 내용)
```

### 2. AWS 인스턴스 설정

#### docker-compose.yml 경로 수정
각 워크플로우 파일에서 다음 라인을 실제 경로로 수정:
```yaml
script: |
  cd /path/to/docker-compose  # << 실제 경로로 변경 필요
```

#### docker-compose.yml 예시
```yaml
version: '3.8'

services:
  content-service:
    image: ${DOCKER_USERNAME}/content-service:latest
    container_name: content-service
    ports:
      - "8081:8080"
    restart: unless-stopped

  openai-service:
    image: ${DOCKER_USERNAME}/openai-service:latest
    container_name: openai-service
    ports:
      - "8082:8080"
    restart: unless-stopped

  openapi-service:
    image: ${DOCKER_USERNAME}/openapi-service:latest
    container_name: openapi-service
    ports:
      - "8083:8080"
    restart: unless-stopped

  restarea-service:
    image: ${DOCKER_USERNAME}/restarea-service:latest
    container_name: restarea-service
    ports:
      - "8084:8080"
    restart: unless-stopped

  restarea-unit-service:
    image: ${DOCKER_USERNAME}/restarea-unit-service:latest
    container_name: restarea-unit-service
    ports:
      - "8085:8080"
    restart: unless-stopped

  tmapapi-service:
    image: ${DOCKER_USERNAME}/tmapapi-service:latest
    container_name: tmapapi-service
    ports:
      - "8086:8080"
    restart: unless-stopped

  user-service:
    image: ${DOCKER_USERNAME}/user-service:latest
    container_name: user-service
    ports:
      - "8087:8080"
    restart: unless-stopped
```

## 동작 방식

### 트리거 조건
- `stg` 브랜치에 push
- 각 서비스 폴더 내 파일 변경 감지
- 해당 워크플로우 파일 자체 변경

### 워크플로우 단계
1. **Checkout**: 코드 체크아웃
2. **Docker Buildx**: 멀티 플랫폼 빌드 환경 설정
3. **Docker Login**: Docker Hub 로그인
4. **Build & Push**: 
   - 이미지 빌드
   - `latest` 및 `commit SHA` 태그로 푸시
   - 레이어 캐싱으로 빌드 속도 최적화
5. **Deploy**:
   - SSH로 AWS 인스턴스 접속
   - 최신 이미지 pull
   - 해당 서비스만 재시작
   - 사용하지 않는 이미지 정리

## 워크플로우 파일

```
.github/workflows/
├── deploy-content.yml
├── deploy-openai.yml
├── deploy-openapi.yml
├── deploy-restarea.yml
├── deploy-restarea-unit.yml
├── deploy-tmapapi.yml
└── deploy-user.yml
```

## 모니터링

### GitHub Actions 탭에서 확인
- 각 워크플로우 실행 상태
- 빌드 로그
- 배포 로그

### 로컬에서 확인
```bash
# AWS 인스턴스 접속
ssh -i your-key.pem ubuntu@your-ec2-ip

# 실행 중인 컨테이너 확인
docker ps

# 특정 서비스 로그 확인
docker logs -f content-service

# docker-compose 상태 확인
docker-compose ps
```

## 커스터마이징

### Docker Registry 변경 (Docker Hub → ECR)
```yaml
- name: Log in to Amazon ECR
  uses: aws-actions/amazon-ecr-login@v1

- name: Build and push Docker image
  uses: docker/build-push-action@v5
  with:
    context: ./content
    push: true
    tags: |
      ${{ secrets.AWS_ACCOUNT_ID }}.dkr.ecr.${{ secrets.AWS_REGION }}.amazonaws.com/content-service:latest
```

### 환경별 배포 분리
```yaml
on:
  push:
    branches:
      - main      # production
      - dev       # development
      
jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    steps:
      # ... 빌드 단계 ...
      
      - name: Deploy to Production
        if: github.ref == 'refs/heads/main'
        # production 배포 스크립트
        
      - name: Deploy to Development
        if: github.ref == 'refs/heads/dev'
        # development 배포 스크립트
```

## 트러블슈팅

### SSH 연결 실패
- AWS Security Group에서 GitHub Actions IP 허용 확인
- SSH Key 형식 확인 (BEGIN/END 포함)

### 이미지 pull 실패
- Docker Hub 레지스트리 이름 확인
- 이미지 태그 일치 여부 확인

### 서비스 재시작 실패
- docker-compose.yml 서비스 이름 일치 확인
- 컨테이너 이름 중복 확인
