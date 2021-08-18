# Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name test-mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=secret_pw -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE dev_env;
CREATE DATABASE prod_env;

#Create database service accounts
CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'dev_password';
CREATE USER 'prod_user'@'localhost' IDENTIFIED BY 'prod_password';
CREATE USER 'dev_user'@'%' IDENTIFIED BY 'dev_password';
CREATE USER 'prod_user'@'%' IDENTIFIED BY 'prod_password';

#Database grants
GRANT SELECT ON dev_env.* to 'dev_user'@'localhost';
GRANT INSERT ON dev_env.* to 'dev_user'@'localhost';
GRANT DELETE ON dev_env.* to 'dev_user'@'localhost';
GRANT UPDATE ON dev_env.* to 'dev_user'@'localhost';
GRANT SELECT ON prod_env.* to 'prod_user'@'localhost';
GRANT INSERT ON prod_env.* to 'prod_user'@'localhost';
GRANT DELETE ON prod_env.* to 'prod_user'@'localhost';
GRANT UPDATE ON prod_env.* to 'prod_user'@'localhost';
GRANT SELECT ON dev_env.* to 'dev_user'@'%';
GRANT INSERT ON dev_env.* to 'dev_user'@'%';
GRANT DELETE ON dev_env.* to 'dev_user'@'%';
GRANT UPDATE ON dev_env.* to 'dev_user'@'%';
GRANT SELECT ON prod_env.* to 'prod_user'@'%';
GRANT INSERT ON prod_env.* to 'prod_user'@'%';
GRANT DELETE ON prod_env.* to 'prod_user'@'%';
GRANT UPDATE ON prod_env.* to 'prod_user'@'%';