# PostService

PostService is a microservice responsible for managing the storage of messages between users. The service utilizes MongoDB as the database for storing messages.

### API Reference:
port 8090



MongoDB

### Running with Docker
To run PostService using Docker with the updated image "cybertobbe/postservice2" and build the services, follow these steps:

### Step 1: Pull Docker Image
docker pull cybertobbe/postservice2

### Step 2: Create Docker Network
docker network create mynetwork

### Step 3: Run MongoDB
docker run -d --name mongodb --network=mynetwork -p 27017:27017 mongo:latest

### Step 4: Run postapp1 and attach to network
docker run -d --name postapp1 --network=mynetwork -p 8090:8080 --env SPRING_DATA_MONGODB_URI=mongodb://mongodb:27017/mydatabase cybertobbe/postservice2

These commands will pull the updated image "cybertobbe/postservice2" and build the services postapp1 and mongodb.

### Using PostService

PostService exposes the following endpoints:

### POST

**POST https://localhost:8090/api/message**: Saves a message to the database. Use JSON format to include the message in the request body.

Example:

{

"senderUsername": "TYPE THE NAME",

"receiverUsername": "TYPE THE NAME",

"message": "TYPE THE MESSAGE"

}

### GET

**GET https://localhost:8090/api/message**: Retrieves all saved messages from the database.

**GET https://localhost:8090/api/message/sender/{senderUsername}**: Retrieves all messages sent by a specific sender.




### Configuration

PostService uses MongoDB as the database. Make sure your MongoDB instance is configured according to the provided URI: `mongodb://root:secret@mongodb:27017/mydatabase`.


