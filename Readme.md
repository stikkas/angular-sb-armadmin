Представляет собой шаблон для разработки одностраничного web приложения
с использованием *spring-boot* в качестве сервеной части и *angularjs* + *bootstrap* 
в качестве клиентской части.

#### Требования:
	* **jdk1.8**

#### Назначение папок:
* **grunt** - система сборки клиентских js и css файлов. Перед испльзованием необходимо
    перейти в папку и выполнить команду:
    
    ```sh                                                                        
       $ npm install                                                             
    ```                                                                          
    подразумевается что на машине установлен *nodejs*.                             
    настроеные задачи:                                                           
    * **vendor** - сборка основных библиотек (*bootstrap* и *angularjs*).                
    * **default** - сборка js и css разрабатываемого приложения.                     
* **bootstrap** - less файлы *bootstrap* для настройки своей темы. Можно вообще отказаться
    от *bootstrap*, для этого достаточно исключить из html файлов включение *boostrap.min.css*,
    а все настройки производить в своих файлах css. 
* **scripts** - различные скрипты установки и запуска приложения

#### Использование https
Сертификат создается командой:

```sh
	$ keytool -genkey -alias bookmarks -keyalg RSA -keystore src/main/resources/tomcat.keystore
```

#### Сборка и запуск
В pom.xml настроены различные профили. По умолчанию используется профиль с встроенной базой данных с использованием http.
Для разработки используются свои файлы настроек приложения вкупе с профилями MAVEN. Нужные файлы передаются параметрами
командной строки, например, _--spring.config.name=appdev --spring.config.location=classpath:/_.
Для сборки jar используется application.properties, в который при парсинге вставляются нужные параметры, в том числе
значения профилей spring-boot.
Пользоваться application.properties с переменными maven на этапе разработки нельзя, т.к. spring-boot-maven-plugin имеет возможность подключать
сырые ресурсы, что позволяет разрабатывать front-end, не пересобирая приложение. Можно отключить такую возможность и 
прикрутить внешний http сервер с пробросом серверных запросов к приложению (по большей части так раньше и поступал), тогда
можно пользовать и при разработке и при пакетировании одним application.properties + нужные spring профили.

В IDE можно добавить свои действия:
* **run** - запуск приложения по умолчанию

	```sh
		$ mvn spring-boot:run
	```

* **run-prod** - запуск приложения в production с использование СУБД oracle

	```sh
		$ mvn -Poracledb spring-boot:run
	```

* **run-https** - запуск приложения с использованием встроенной базы данных и https

	```sh
		$ mvn -Pdevelop,dev_https spring-boot:run
	```

* **run-https-prod** - запуск приложения с использование СУБД oracle и https

	```sh
		$ mvn -Poracledb,oracle_https spring-boot:run
	```

* **dev-package** - сборка с использованием встроенной базы данных

	```sh
		$ mvn package
	```

* **dev-https-package** - сборка с использованием встроенной базы данных и https

	```sh
		$ mvn -Pdevelop,dev_https package
	```

* **prod-package** - сборка с использованием СУБД oracle

	```sh
		$ mvn -Poracledb package
	```

* **prod-https-package** - сборка с использованием СУБД oracle и https

	```sh
		$ mvn -Poracledb,oracle_https package
	```

##### Установка на windows службы.
Для установки приложения в качестве службы на windows машине используется nssm. 
Диструбутив его находтся в папке _scripts_.
Установка службы:
	
	```sh
		nssm install NewServiceName javaw -jar path_to_our_application.jar
	```

Для установки новой версии приложения достаточно остановить сервис средствами Windows,
заменить файл новым и запустить сервис средствами Windows.
Удаление службы:

	```sh
		nssm remove NewServiceName confirm
	```

##### Установка на linux.
TODO: Необходимо создать init скрипты для centos и debian
