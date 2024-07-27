# Star Wars Web Application
```markdown
This project offers two build options: Maven and Gradle. It is a web application that consumes the Star Wars API and displays the information on a web page.
```
## How to Run

**Note:** This guide is focused on running the application using the Gradle option and kubernetes for extra points.

1. Build the application:
   ```sh
   ./gradlew build
    ```

2. Build the Docker image:
   ```sh
   docker build -t star-wars-app .
    ```

3. Apply the Kubernetes configuration (You have to have Minikube installed):

   1. Start Minikube:
      ```sh
      minikube start
      ```

   2. Build the Docker image:
      ```sh
      docker build -t star-wars-app:latest .
      ```

   3. Load the Docker image into Minikube:
      ```sh
      minikube image load star-wars-app:latest
      ```

   4. Apply the Kubernetes deployment configuration:
      ```sh
      kubectl apply -f k8s/deployment.yaml
      ```

   5. Apply the Kubernetes service configuration:
      ```sh
      kubectl apply -f k8s/service.yaml
      ```

   6. Access the application:
      ```sh
      minikube service star-wars-service
      ```

4. Run the Docker container and the application (if kubernetes not working):
   ```sh
   docker run -p 6969:6969 star-wars-app
    ```

5. Access the application.
   ```sh
   Posible View endpoints:
   http://localhost:6969/people
   http://localhost:6969/starships
    ```
    ```sh
   Posible Postman (GET) endpoints:
   http://localhost:6969/api/v1/star-wars/people
   http://localhost:6969/api/v1/star-wars/starships
    ```