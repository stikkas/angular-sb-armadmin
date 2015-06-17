Представляет собой шаблон для разработки одностраничного web приложения
с использованием *spring-boot* в качестве сервеной части и *angularjs* + *bootstrap* 
в качестве клиентской части.

Приложение следует использовать как самодостаточное для запуска сервисом.
Используется встроенная база *h2*. Для production следует использовать одну из
СУБД уровня энтерпрайз, для чего нужно внести соответсвующие изменения в файл
*application.properties.

Назначение папок:
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

### Использование https.
Для запуска приложения по https используется файл настроек application-https.properties.
Приложение запускается командой:

```sh
	$ SPRING_PROFILES_ACTIVE=https mvn spring-boot:run
```

Сертификат создается командой:

```sh
	$ keytool -genkey -alias bookmarks -keyalg RSA -keystore src/main/resources/tomcat.keystore
```

## Сборка и запуск
В pom.xml настроены различные профили. По умолчанию используется профиль с встроенной базой данных с использованием http.
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
		$ mvn -Pdevelop,https_dev spring-boot:run
	```

* **run-https-prod** - запуск приложения с использование СУБД oracle и https

	```sh
		$ mvn -Poracledb,https_oracle spring-boot:run
	```

* **dev-package** - сборка с использованием встроенной базы данных

	```sh
		$ mvn package
	```

* **dev-https-package** - сборка с использованием встроенной базы данных и https

	```sh
		$ mvn -Pdevelop,https_dev package
	```

* **prod-package** - сборка с использованием СУБД oracle

	```sh
		$ mvn -Poracledb package
	```

* **prod-https-package** - сборка с использованием СУБД oracle и https

	```sh
		$ mvn -Poracledb,https_oracle package
	```
