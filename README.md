# shc-nyancat

## Objective
- SHC Maintenance Contact Management System Web Server
- Assignment Project given by SHC for IPP 2021

## Install
1. Extract `shc-nyancat.war` file as the project directory.
2. To initialize project, you must create `env.properties` file in `WebContent/META-INF/env.properties`.
   ```
   is.development={true or false}
   db.url=jdbc:mariadb://$DB_HOST:$DB_PORT/$DB_NAME
   db.user=$DB_USERNAME
   db.password=$DB_PASSWORD
   ```
3. In Eclipse, go to the project `Properties > Project Facets` and apply `Dynamic Web Module` with version 3.1 with Java 1.7 or higher version.
4. Attach the project to Eclipse Apache Tomcat 8.0 or 8.5 server for temporary deployment test.
