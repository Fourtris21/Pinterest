Feature: Управление на Постове

  Background: Отваряне на приложението
    Given Приложението е отворено

  Scenario: Преглед на постовете в конкретна папка
    When Потребителят избира папка с име "Здравословни рецепти"
    Then Показва се лист с всички постове в папката "Здравословни рецепти"

  Scenario: Добавяне на нов пост към папка
    When Потребителят избира папка с име "Партита"
    And Потребителят клика на бутона за добавяне на пост
    And Потребителят въвежда повече детайли за поста
    Then Новият пост е добавен към папката "Партита"

  Scenario Outline: Търсене на пост по различни ключови думи
    When Потребителят въвежда <keyword> в полето за търсене
    And Натиска бутона за търсене
    Then Показва се лист от постове, отговарящи на <keyword>
    Examples:
      | keyword      |
      | "Art"        |
      | "Interior"   |

  Scenario: Търсене на постове по ключова дума
    When Потребителят въвежда ключовата дума "Веган" в полето за търсене
    And Натиска бутона за търсене
    Then Показва се лист от постове, отговарящи на ключовата дума "Веган"

  Scenario: Запазване на пост към различна папка
    When Потребителят избира пост "Котка Турски Ван"
    And Потребителят натиска бутона за запазване
    And Потребителят избира папка "Кучета"
    Then Постът "Котка Турски Ван" е запазен в папка "Кучета"

