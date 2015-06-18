Представляет собой шаблон для разработки одностраничного web приложения
с использованием *spring-boot* в качестве сервеной части и *angularjs* + *bootstrap* 
в качестве клиентской части.

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

#### Использование https
Сертификат создается командой:

```sh
	$ keytool -genkey -alias bookmarks -keyalg RSA -keystore src/main/resources/tomcat.keystore
```

#### Сборка и запуск
В pom.xml настроены различные профили. По умолчанию используется профиль с встроенной базой данных с использованием http.
Сначала использовались несколько профилей в pom.xml, которые определяли некоторые свойства, подставляемые при парсенге
application.properties. Но это не оправдало себя, т.к. для работы такой схемы необходимо отключить включение ресурсов в 
развертывание плагином spring-boot-maven-plugin (spring-boot:run). Такое включение позволяет разрабатывать клиентскую часть
не пересобирая все приложение - на лету. Для того чтобы не упускать такую возможность решено было использовать различные
переменные среды для переключения между файлами свойств приложения. Таким образом имеется три файла свойств:
* **app-dev.properties** - используется для разработки (встроенная база, логи и т.д.)
* **app-prod.properties** - используется для выпуска (база oracle)
* **application-https.properties** - добавляет работу по https, активируется переменной среды _SPRING_PROFILES_ACTIVE_=https

В IDE можно добавить свои действия:
* **run** - запуск приложения по умолчанию

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-dev.properties mvn spring-boot:run
	```

* **run-prod** - запуск приложения в production с использование СУБД oracle

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-prod.properties mvn -Poracledb spring-boot:run
	```

* **run-https** - запуск приложения с использованием встроенной базы данных и https

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-dev.properties SPRING_PROFILES_ACTIVE=https mvn spring-boot:run
	```

* **run-https-prod** - запуск приложения с использование СУБД oracle и https

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-prod.properties SPRING_PROFILES_ACTIVE=https mvn -Poracledb spring-boot:run
	```

* **dev-package** - сборка с использованием встроенной базы данных

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-dev.properties mvn package
	```

* **dev-https-package** - сборка с использованием встроенной базы данных и https

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-dev.properties SPRING_PROFILES_ACTIVE=https mvn package
	```

* **prod-package** - сборка с использованием СУБД oracle

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-prod.properties mvn -Poracledb package
	```

* **prod-https-package** - сборка с использованием СУБД oracle и https

	```sh
		$ SPRING_CONFIG_LOCATION=classpath:/app-prod.properties SPRING_PROFILES_ACTIVE=https mvn -Poracledb package
	```

В NetBeans переменные среды выставляются для каждого действия в окне _Свойства_, например, _Env.SPRING_CONFIG_LOCATION=classpath:/app-prod.properties_.