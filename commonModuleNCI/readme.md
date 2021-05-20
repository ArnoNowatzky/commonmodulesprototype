This project provides an example runtime to handle the common commonModules locally in the pharmacy.


# Handling the database 
Call ```docker-compose up``` in current directory to start the database server.
The common modules database is accessable via adminer from http://localhost:8080 with the following settings: 
- Database System: Postgres
- Server: postgresql
- User: cm
- Passwort: cm
- Database: cm

For any service a separate database is created. The database files can be found in `build/example/postgres_db`.
