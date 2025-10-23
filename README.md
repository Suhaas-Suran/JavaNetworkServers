# Java Network Servers

This repository contains three Java projects demonstrating **network programming and concurrency**. Each project builds upon the previous, showing a progression from simple single-threaded networking to scalable multi-threaded server architectures.

---

## Projects Overview

### 1. SingleThreaded
- **Description:** A basic client-server application using blocking sockets.
- **Behavior:** The server handles **one client at a time**. Additional clients must wait until the current client disconnects.
- **Key Learning Points:**
  - TCP/IP networking in Java (`ServerSocket` & `Socket`)
  - Sending and receiving messages using streams (`PrintWriter`, `BufferedReader`)
  - Understanding blocking I/O and sequential request handling

### 2. MultiThreaded
- **Description:** Handles multiple clients concurrently by creating a **new thread for each client**.
- **Behavior:** Each incoming client connection is handled independently, allowing simultaneous communication with multiple clients.
- **Key Learning Points:**
  - Creating and managing threads in Java
  - Concurrent client handling
  - Thread safety and resource management
  - Basic understanding of scalability limitations with thread-per-client model

### 3. ThreadPool
- **Description:** A scalable multi-threaded server using a **fixed-size thread pool**.
- **Behavior:** Client requests are handled by threads from a **thread pool**, avoiding the overhead of creating unlimited threads.
- **Key Learning Points:**
  - Using `ExecutorService` and fixed thread pools
  - Efficient resource management for high concurrency
  - Try-with-resources for automatic closing of sockets and streams
  - Understanding scalability in high-load server applications

---

## Getting Started

### Requirements
- Java JDK 8 or above
- IDE (Optional: IntelliJ, VSCode) or command line terminal

### Running a Project
1.  Navigate to the project folder (e.g., `SingleThreaded/src/SingleThreaded`)
2.  Compile the Java files:
    ```bash
    javac Server.java Client.java
    ```
3.  Start the server (in one terminal):
    ```bash
    java Server
    ```
4.  Start one or more client instances (in separate terminals):
    ```bash
    java Client
    ```
**Note:** Ensure the server and client use the same port. For multi-threaded or thread pool servers, multiple clients can run simultaneously. Use JMeter if want to test your server's limits :)

---

## Key Concepts Learned
- TCP/IP Networking (`ServerSocket` & `Socket`)
- Blocking vs. Concurrent Server Handling
- Multi-threading and Thread Pools (`ExecutorService`)
- Resource Management and Exception Handling
- Scalability and concurrency considerations

---
