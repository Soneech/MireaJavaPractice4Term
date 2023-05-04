# MireaJavaPractice4Term

## [Practice 1](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice1)
Имплементировать интерфейс Comparator, сравнивающий две строки по сумме всех чисел, представленных в строке.

## [Practice 2](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice2)
В ходе выполнения практической работы должно быть реализовано:
- класс Human (int age, String firstName, String lastName, LocalDate birthDate, int weight);
- приложение, которое создает список из объектов класса Human, а затем производит действия в соответствии с вариантом индивидуального задания (список после каждого этапа должен выводиться в консоль).

Все действия должны производиться только с использованием Stream API.
Задание варианта: Сортировка по возрасту в обратном порядке, фильтрация по имени «начинается с А», сортировка по дате рождения, расчет среднего веса.

## [Practice 3](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice3)
Создать свои потокобезопасные имплементации интерфейсов в соответствии с вариантом индивидуального задания.
Задание варианта: Set с использованием Semaphore, List с использованием ключевого слова synchronized.

## [Practice 4](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice4)
Реализовать собственную имплементацию ExecutorService с единственным параметром конструктора – количеством потоков.

## [Practice 5](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice5)
Реализовать паттерн Singleton как минимум 3-мя способами.

## [Practice 6](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice6)
Написать реализацию паттернов «Фабричный метод», «Абстрактная фабрика», «Строитель», «Прототип».

## [Practice 7](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice7)
Написать реализацию паттерна в соответствии с вариантом индивидуального задания:  Фасад, Легковес.

## [Practice 8](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practices1-8/src/main/java/org/soneech/practice8)
Написать реализацию паттерна в соответствии с вариантом индивидуального задания: Снимок, Наблюдатель.

## [Practice 9](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice9)
Создать приложение, которое выводит какое-то сообщение в консоль. Создать Gradle Task, который создает jar-файл приложения, переносит его в отдельную папку, в которой хранится Dockerfile для jar, а затем создает Docker контейнер из данного jar-файла и запускает его.

## [Practice 10](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice10)
Создать приложение, в котором создается ApplicationContext и из него берётся бин с названием, переданным в качестве аргумента к приложению, и вызывается метод интерфейса, который он имплементирует. Нужно создать по одному бину для каждого класса, определить им название. Проверить, что вызывается при вводе названия каждого из бинов. Классы и интерфейс определяются в соответствии с вариантом индивидуального задания. 

Задание варианта: Интерфейс Musician с методом doMusic(), его имплементации: Drummer, Guitarist, Trombonist.

## [Practice 11](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice11)
Создать приложение с использованием Spring Boot Starter Initializr (https://start.spring.io/) с такими зависимостями:
– Spring Web;
– Lombok;
– Validation;
– Spring boot Actuator.

Запустить приложение и удостовериться, что не появилось никаких ошибок. Добавить все эндпоинты в Actuator, сделать HTTP-запрос на проверку состояния приложения. Собрать jar-файл приложения, запустить и проверить состояние при помощи REST-запроса.

## [Practice 12](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice12)
Создать приложение, которое при запуске берет данные из одного файла, хеширует, а при остановке приложения удаляет исходный файл, оставляя только файл с захешированными данными. Названия первого и второго файла передаются в качестве аргументов при запуске (я сделаль немношк по-другому, ибо почему бы и нет). При отсутствии первого файла создает второй файл и записывает в него строку null. Реализовать с использованием аннотаций PostConstruct, PreDestroy.

## [Practice 13](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice13)
Создать файл application.yml в папке resources, добавить в него такие свойства:
- student.name – имя студента;
- student.last_name – фамилия студента;
- student.group – название группы студента.
При запуске приложения выведите данные свойства в консоль при помощи интерфейса Environment или аннотации Value.

## [Practice 14](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice14)
Создать простой html-документ, который будет содержать вашу фамилию, имя, номер группы, номер варианта. Создать контроллер, который будет возвращать данный статический документ при переходе на url «/home». Выполнить задание в зависимости с вариантом индивидуального задания.

Задание варианта: 

Создать класс Game с полями name, creationDate. Создать класс GameAuthor с полями nickname, birthDate. Создать классы-контроллеры для создания, удаления объектов и получения всех объектов каждого типа. Сами объекты хранить в памяти.

## [Practice 15](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice15)
Подключение PostgreSQL, работа с Hibernate

## [Practice 16](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice16)
Создать связь один-ко-многим между сущностями из предыдущего задания и проверить работу lazy loading.

## [Practice 17](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice17)
Добавить возможность фильтрации по всем полям всех классов с использованием Criteria API в Hibernate для программы из предыдущего задания.

## [Practice 18](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice18)
Переписать код предыдущего задания с использованием сервисов и отделения логики контроллера от логики сервиса и репозитория. В программе всё взаимодействие с базой данных должно быть реализовано через репозитории Spring Data Jpa.

## [Practice 19](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice19)
Создать файл logback.xml, добавить логирование во все методы классовсервисов.

## [Practice 20](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice20)
Для приложения из предыдущего задания добавить логирование
времени выполнения каждого метода сервиса с использованием Spring AOP.

## [Practice 21](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice21)
Для приложения из предыдущего задания пометить все классы
сервисов, в которых происходит взаимодействие с базой данных, как
Transactional. Добавить отправку информации о сохранении каждого объекта
по электронной почте, создав отдельный класс EmailService с асинхронными
методами отправки сообщений. Для асинхронности методов используйте
аннотацию Async.

## [Practice 22](https://github.com/Soneech/MireaJavaPractice4Term/tree/master/Practice22)
Для приложения из предыдущего задания создать класс-сервис с
методом, который будет вызываться каждые 30 минут и очищать
определённую директорию, а затем создавать по файлу для каждой из
сущностей и загружать туда все данные из базы данных. Также добавить
возможность вызывать данный метод с использованием Java Management
Extensions (JMX).

## [Practice 23](https://github.com/Soneech/Pizzeria/tree/363f6b12930757bffe86309b932d1b3a0e07ecde)
В приложении из предыдущего задания добавить возможность
регистрации и авторизации пользователей.

P.S. Было реализовано в курсаче, отдельно делать было уже лень)

## [Practice 24](https://github.com/Soneech/Pizzeria/tree/java-practice24)
Написать модульное тестирование для всех классов сервисов
приложения из предыдущего задания.

P.S. Также делалось по курсачу (в отдельной ветке)
