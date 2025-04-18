# ☑️ Java Spring Boot TODO App with CI/CD and Kubernetes 🚀

This is a simple Spring Boot TODO API deployed using GitHub Actions CI/CD pipeline, Docker, and Kubernetes.

## 🧩 Features
- REST API with Spring Boot
- Docker containerization
- CI/CD using GitHub Actions
- Auto deploy to Kubernetes cluster (Minikube/EKS/GKE)

## 📁 Project Structure
- `src/` - Java source code
- `Dockerfile` - Container spec
- `.github/workflows/ci-cd.yml` - CI/CD pipeline
- `k8s/` - Kubernetes deployment & service YAMLs

## 🚀 How to Run Locally
```bash
mvn spring-boot:run

