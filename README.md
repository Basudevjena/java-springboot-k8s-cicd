# ☑️ Java Spring Boot TODO App — Docker | GitHub Actions | Kubernetes 🚀

Welcome to the **Java Spring Boot TODO App** — a complete end-to-end project demonstrating modern DevOps practices using:
- ✅ Java + Spring Boot (RESTful API)
- 🐳 Docker for containerization
- ⚙️ GitHub Actions for CI/CD
- ☸️ Kubernetes manifests for production-like deployments (Minikube/EKS/GKE)

---

## 📦 Project Structure

```
java-springboot-k8s-cicd/
├── .github/workflows/ci-cd.yml        # GitHub Actions CI/CD Pipeline
├── Dockerfile                         # Docker container build
├── pom.xml                            # Maven config for Spring Boot
├── src/main/java/...                  # Java source code
├── k8s/
│   ├── deployment.yaml                # Kubernetes deployment
│   └── service.yaml                   # Kubernetes service
└── README.md
```

---

## 🔧 Tech Stack Used

| Tool/Tech         | Purpose                            |
|-------------------|------------------------------------|
| Java 17           | Backend language                   |
| Spring Boot       | REST API framework                 |
| Maven             | Build tool                         |
| Docker            | Containerization                   |
| GitHub Actions    | CI/CD automation                   |
| Kubernetes        | Container orchestration            |
| Minikube/EKS/GKE  | Cluster deployment options         |

---

## 🚀 Features

- ✅ Create and retrieve TODOs via REST API
- ✅ Containerized using Docker
- ✅ Automated CI/CD with GitHub Actions
- ✅ Auto-deploy to Kubernetes cluster
- ✅ Ready for Minikube, AWS EKS, or GKE

---

## 📥 Prerequisites

- Java 17+
- Maven
- Docker
- GitHub account
- Kubernetes cluster (Minikube, EKS, or GKE)
- `kubectl` CLI configured

---

## 🛠️ Setup Instructions

### 🔨 1. Clone & Build

```bash
git clone https://github.com/BharathKumarReddy2103/java-springboot-k8s-cicd.git
cd java-springboot-k8s-cicd
mvn clean package
```

---

### 🐳 2. Build & Push Docker Image

```bash
docker build -t <your-dockerhub-username>/todo-app:latest .
docker push <your-dockerhub-username>/todo-app:latest
```

---

### ☸️ 3. Deploy to Kubernetes

```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

Check service:
```bash
kubectl get svc
```

---

### ⚙️ 4. GitHub Actions CI/CD Setup

1. Go to your GitHub repo → Settings → Secrets → Actions
2. Add the following repository secrets:

| Name               | Description                          |
|--------------------|--------------------------------------|
| `DOCKER_USERNAME`  | Your Docker Hub username             |
| `DOCKER_PASSWORD`  | Your Docker Hub password or PAT      |

> GitHub Actions will now build, test, push image, and deploy to K8s on every push to `main`.

---

## 🔗 API Endpoints

- `GET /api/todos` → View all TODOs
- `POST /api/todos` → Add a new TODO

---

## 📚 Learnings & Highlights

- Set up end-to-end CI/CD from scratch using GitHub Actions
- Dockerized a Java Spring Boot app
- Used `kubectl` to deploy onto Kubernetes
- Managed pipeline secrets and automated builds

---

## 🧠 Future Improvements

- Use Helm charts instead of raw YAML
- Add MongoDB or MySQL backend
- Add authentication using Spring Security
- Add Ingress controller + TLS certs

---

## 🤝 Contribute

Feel free to fork, try the setup, and raise PRs to improve the app or CI/CD flow.

---

## 🙋‍♂️ Author

**Bharath Kumar Reddy**  
Senior DevOps & Cloud Engineer  
[LinkedIn](https://www.linkedin.com/in/bharath-kumar-reddy2103/) | [GitHub](https://github.com/BharathKumarReddy2103)

---

## ⭐ Show Your Support

If you liked this project, don’t forget to ⭐ star the repo and share it on LinkedIn.
