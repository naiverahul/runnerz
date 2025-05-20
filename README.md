# UBuzz-Chat-App

UBuzz-Chat-App is a real-time chat application built with Java, Spring Boot, and Maven. It supports text messaging and file sharing.

## Features

- Real-time messaging using WebSockets
- File upload and download functionality
- User-friendly interface with Bootstrap
- Can be easily integrated into any Spring-Boot web application for Real-time customer support 

## Technologies Used

- Java
- Spring Boot
- Maven
- WebSockets
- SockJS and STOMP
- Bootstrap

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/naiverahul/runnerz
    cd runnerz
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

4. Open your browser and navigate to `http://localhost:8080/chat` to access the chat application.

## Usage

- Enter your name in the "Your name..." input field.
- Type a message in the "Type a message..." input field and click "Send" to send a message.
- To upload a file, select a file using the "Choose file" button and click "Upload File".

## Project Structure

- `src/main/java/dev/rahulagar/runnerz/run/ChatController.java`: Handles chat-related endpoints and WebSocket messages.
- `src/main/java/dev/rahulagar/runnerz/run/manage_files/FileService.java`: Interface for file upload and download services.
- `src/main/resources/templates/chat.html`: HTML template for the chat application interface.

