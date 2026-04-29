# Buddy: Socratic DSA Tutor (Backend) 

The intelligent "Brain" behind Buddy. This Spring Boot application handles problem analysis and generates pedagogical hints using advanced prompt engineering.

## Overview
This repository contains the RESTful API that powers the Buddy Chrome Extension. It leverages Large Language Models to guide coders through coding challenges on LeetCode and GeeksforGeeks.

## Tech Stack
*   **Language:** Java 17
*   **Framework:** Spring Boot 3.5
*   **AI Integration:** Spring AI with Gemini 2.5 Flash
*   **Resilience:** Resilience4j (Rate Limiting)
*   **Infrastructure:** Docker & Render

## Core Architecture
1.  **REST API:** Exposes a POST endpoint at `/api/buddy/hint` to receive problem descriptions.
2.  **Rate Limiter:** Implements a strict rate-limiting policy via Resilience4j to manage API quotas effectively.
3.  **Socratic Engine:** Uses custom prompt templates to ensure the AI provides guidance and hints rather than direct solutions.

## Deployment
The application is containerized using a **multi-stage Docker build** and hosted on **Render**.
*   **Live URL:** `https://buddy-51vj.onrender.com/api/buddy/hint`
*   **Port:** Configured to run on internal port `8765`.

## Local Setup
1.  Clone the repository.
2.  Set the environment variable: `export GEMINI_API_KEY='your_key_here'`.
3.  Run the application: `mvn spring-boot:run`.

---
*Looking for the interface? Visit the [Buddy Frontend Repository](https://github.com/preetibarshadash/buddy-frontend.git).*


## Author
**Preetibarsha Dash**
* Software Engineer
* [LinkedIn](https://www.linkedin.com/in/preetibarsha-dash/)
* [Portfolio](https://preetibarshadash.github.io/portfolio/)
