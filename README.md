# 📦 Java Spring Boot Kubernetes CI/CD Pipeline

![CI/CD](https://github.com/BharathKumarReddy2103/java-springboot-k8s-cicd/actions/workflows/ci-cd.yml/badge.svg)

> A complete end-to-end DevOps project demonstrating Java, Docker, Kubernetes, and GitHub Actions CI/CD — built and maintained by [Bharath Kumar Reddy](https://github.com/BharathKumarReddy2103) 🧑‍💻

![Banner](https://github.com/BharathKumarReddy2103/java-springboot-k8s-cicd/blob/main/assets/banner.png)

---

## 🚀 Project Overview

- ✅ Java Spring Boot Application exposing `/api/todos` endpoint
- 🐳 Dockerized and published to Docker Hub
- 🔄 CI/CD pipeline powered by **GitHub Actions**
- ☸️ Deployed to Kubernetes (Minikube)
- 💡 Fully automated build → push → deploy on every `git push`

---

## 📁 Project Structure

```
java-springboot-k8s-cicd/
├── src/main/java/com/example/todo/
│   ├── TodoApplication.java
│   └── controller/TodoController.java
├── k8s/
│   ├── deployment.yaml
│   └── service.yaml
├── .github/workflows/ci-cd.yml
├── Dockerfile
├── pom.xml
└── README.md
```

---

## 🛠️ Tech Stack

- Java 17 + Spring Boot
- Docker
- GitHub Actions
- Kubernetes (Minikube)
- Self-hosted GitHub Actions runner

---

## 🧪 API Endpoints

- `GET /api/todos` – Get all todos
- `POST /api/todos` – Add a new todo (string)

---

## 🔁 CI/CD Workflow

### Trigger:
- On every `push` to the `main` branch

### Pipeline Stages:
1. **Checkout**: Pull latest code from GitHub
2. **Build**: Compile Spring Boot app with Maven
3. **Dockerize**: Build Docker image (no cache)
4. **Push**: Upload image to Docker Hub
5. **Deploy**: Restart Kubernetes deployment via `kubectl`

---

## 📦 Dockerfile

```Dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/todo-app.jar todo-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "todo-app.jar"]
```

---

## ⚙️ Kubernetes Manifests

- **Deployment**: `k8s/deployment.yaml`
  - Uses image: `docker.io/your-username/todo-app:latest`
  - `imagePullPolicy: Always`
- **Service**: `k8s/service.yaml`
  - NodePort service to expose the app via Minikube IP

---

## 🤖 GitHub Actions Workflow

```yaml
on:
  push:
    branches: [ main ]

jobs:
  build-test-deploy:
    runs-on: self-hosted
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - run: mvn clean package
      - run: cp target/*.jar target/todo-app.jar
      - run: docker build --no-cache -t ${{ secrets.DOCKER_USERNAME }}/todo-app:latest .
      - uses: docker/login-action@v2
        with:
          username: ${{ secrets.DOCKER_USERNAME }}
          password: ${{ secrets.DOCKER_PASSWORD }}
      - run: docker push ${{ secrets.DOCKER_USERNAME }}/todo-app:latest
      - run: |
          kubectl rollout restart deployment todo-app
          kubectl rollout status deployment todo-app
```

---

## 🔐 GitHub Secrets Used

| Secret Name         | Description                        |
|---------------------|------------------------------------|
| `DOCKER_USERNAME`   | Your Docker Hub username           |
| `DOCKER_PASSWORD`   | Your Docker Hub password or PAT    |

---

## 🖥️ Minikube Access

To access the deployed app:

```bash
minikube service todo-service
```

Or test with:

```bash
curl http://<minikube-ip>:<node-port>/api/todos
```

---

## 👨‍💻 Author

**Bharath Kumar Reddy**  
Senior DevOps & Cloud Engineer  
🔗 [GitHub](https://github.com/BharathKumarReddy2103)  
🔗 [LinkedIn](https://www.linkedin.com/in/bharath-kumar-reddy2103/)

---

## ⭐️ Show Your Support

If you found this helpful:
- 🌟 Star this repo
- 🍴 Fork and try it yourself
- ✅ Follow me for more DevOps projects
