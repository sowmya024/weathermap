

help : 

Step-1 : Compile java server code :

mvn clean package

How to Run :

go to target folder (cd target)

java -jar weather-server-1.0.jar

Settings:

There will be application.properties
-------------------------------------

	server.port=8081
	api.baseUrl=http://api.openweathermap.org/data/2.5
	api.key=2ab99a4d1005b6c418d3e6b4d4e5dd82

Please Signup and login openweathermap.org and get the apiKey and put it on application.properties (api.key)
No changes in base url

API
----

	http://localhost:8081/weather?location=desmoines

	http://localhost:8081/forecast?location=desmoines

---------------------------------------------------------------------------------------

Angular UI :
------------

Configure : 

1. npm i -g @angular/cli

2. npm install (for very first time)

How to Run : 

3. ng serve --open

Settings :

There will be config.json in src/assets folder

ie:

{
    "apiBaseUrl": "http://localhost:8081"
}


apiBaseUrl is the java server URL.