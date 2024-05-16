# PostService

PostService is a microservice responsible for managing the storage of messages between users. The service utilizes MongoDB as the database for storing messages.


### Running with Docker
To run PostService using Docker with the updated image "cybertobbe/postservice2" and build the services, follow these steps:

1. Pull the latest image from the Docker Hub:
    ```bash
    docker pull cybertobbe/postservice2
    ```

2. Build and run the services using Docker Compose:
    ```bash
    docker-compose up --build postapp1 postapp2 mongodb -d
    ```


These commands will pull the updated image "cybertobbe/postservice2" and build the services postapp1, postapp2, and mongodb.

### Using PostService

PostService exposes the following endpoints:

- **POST /api/message**: Saves a message to the database. Use JSON format to include the message in the request body.
- **GET /api/message**: Retrieves all saved messages from the database.
- **GET /api/message/sender/{senderUsername}**: Retrieves all messages sent by a specific sender.


To interact with PostService, use an appropriate HTTP client capable of sending requests to the above endpoints.

### Configuration

PostService uses MongoDB as the database. Make sure your MongoDB instance is configured according to the provided URI: `mongodb://root:secret@mongodb:27017/mydatabase`.


