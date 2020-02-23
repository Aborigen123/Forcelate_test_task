Forcelate test task
=====================

Використано
-----------------------------------
Java 8, Spring Boot, Spring Data, Maven, H2-db

Щоб запустити
-----------------------------------
* клонувати проект ``` git clone https://github.com/Aborigen123/Forcelate_test_task.git ```
* підтягнути залежності
* Run as -> Spring Boot App
* Unit Test runner: JUnit 4

Postman Сollection
-----------------------------------
* ***/Forcelate.postman_collection.json***
* Щоб отримати **TOKEN** ```http://localhost:8080/registration```
* Jwt token повинен передаватися в наступному вигляді

|**Key**          |    **Value** |
|:---------------: | :---------------: | 
Authorization   |    Bearer_**YOURTOKEN**
