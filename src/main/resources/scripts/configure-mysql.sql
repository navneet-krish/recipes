## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE ptl_dev;
CREATE DATABASE ptl_prod;

#Create database service accounts
CREATE USER 'ptl_dev_user'@'localhost' IDENTIFIED BY 'navneet';
CREATE USER 'ptl_prod_user'@'localhost' IDENTIFIED BY 'navneet';
CREATE USER 'ptl_dev_user'@'%' IDENTIFIED BY 'navneet';
CREATE USER 'ptl_prod_user'@'%' IDENTIFIED BY 'navneet';

#Database grants
GRANT SELECT ON ptl_dev.* to 'ptl_dev_user'@'localhost';
GRANT INSERT ON ptl_dev.* to 'ptl_dev_user'@'localhost';
GRANT DELETE ON ptl_dev.* to 'ptl_dev_user'@'localhost';
GRANT UPDATE ON ptl_dev.* to 'ptl_dev_user'@'localhost';
GRANT SELECT ON ptl_prod.* to 'ptl_prod_user'@'localhost';
GRANT INSERT ON ptl_prod.* to 'ptl_prod_user'@'localhost';
GRANT DELETE ON ptl_prod.* to 'ptl_prod_user'@'localhost';
GRANT UPDATE ON ptl_prod.* to 'ptl_prod_user'@'localhost';
GRANT SELECT ON ptl_dev.* to 'ptl_dev_user'@'%';
GRANT INSERT ON ptl_dev.* to 'ptl_dev_user'@'%';
GRANT DELETE ON ptl_dev.* to 'ptl_dev_user'@'%';
GRANT UPDATE ON ptl_dev.* to 'ptl_dev_user'@'%';
GRANT SELECT ON ptl_prod.* to 'ptl_prod_user'@'%';
GRANT INSERT ON ptl_prod.* to 'ptl_prod_user'@'%';
GRANT DELETE ON ptl_prod.* to 'ptl_prod_user'@'%';
GRANT UPDATE ON ptl_prod.* to 'ptl_prod_user'@'%';