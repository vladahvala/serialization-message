# Serialization-Message

A mini-project that demonstrates **object serialization** in Java for communication between a **Client** and a **Server** by sending messages.  

## Overview

This project illustrates how Java objects can be serialized and sent over a network socket from a client to a server, and then deserialized on the server side.  

The project contains:

- `Message` – a serializable class representing a message with sender, recipient, text, and timestamp.
- `ClientApp` – sends one or more messages to the server.
- `ServerApp` – listens on a port, receives serialized messages, deserializes them, and displays them.
- `MainApp` – starts the server and client to demonstrate the messaging flow.

## Features

- Serialization of Java objects using `ObjectOutputStream` and `ObjectInputStream`.
- Multiple messages can be sent in a single connection.
- JUnit tests for:
  - `Message` class
  - `ClientApp` (sending messages)
  - `ServerApp` (receiving and displaying messages)
- Follows **Java Code Conventions**.
- Built using **Gradle**.
