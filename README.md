TP2 TEST DE VALIDATION DES ACQUIS
=================

Outils de developpement
-----------------
 * Maven 3
 * Java 8 (spring boot version 2.0 (Spring Framework 5))
 * Mysql 5.6

Compilation et execution du projet
-----------------

* Installer java (jdk 8)

* Installer Maven 3 ( >3.2)

* Installer Mysql 5.6
    * Creer une DB : games_db
    * Creer un utilsateur avec des access complets sur cette DB 
   
    <b>user </b>: admin
    <br/>
    <b>pass </b> :sorelus50 
    <br/>
    Vous pouvez configurer les access DB à utiliser par l'application depuis le fichier : <i>sorelTP2/src/main/resources/application.properties</i> 
    
    
* Compilation
	* cd sorelTP2
	* mvn clean package

* Executer
	* java -jar target/sorel.tp2-0.0.3.war
	* Ouvrez le navigateur et entrez http://localhost:8080
