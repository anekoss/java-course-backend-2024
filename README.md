![Bot](https://github.com/anekoss/java-course-2024-backend/actions/workflows/bot.yml/badge.svg)
![Scrapper](https://github.com/anekoss/java-course-2024-backend/actions/workflows/scrapper.yml/badge.svg)

# Link Tracker

ФИО: Чернова Анна Ивановна

Приложение для отслеживания обновлений контента по ссылкам.
При появлении новых событий отправляется уведомление в Telegram.

Проект написан на `Java 21` с использованием `Spring Boot 3`.

Проект состоит из 2-х приложений:
* Bot
* Scrapper

Для работы требуется БД `PostgreSQL`. Присутствует опциональная зависимость на `Kafka`.
