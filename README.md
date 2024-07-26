# Star Wars Web Application

## How to Run

1. Build the application:
   ```sh
   ./gradlew build
    ```

2. Build the Docker image:
   ```sh
   docker build -t star-wars-app .
    ```

3. Run the Docker container:
   ```sh
   docker run -p 6969:6969 star-wars-app
    ```

4. Access the application.
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