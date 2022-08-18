# Social Media 

## Project Description

This project is basically created for implementing Java concepts. This project is based on java console. As the name of this project gives us idea, that this project is something related to facebook or any other social media. Yeah, its correct, in this console based application users can register, and log in. After login they can make posts, delete those posts, update , all CRUD operations. They can make changes in their profile. At last they can logout and starting console of this app will be comes out.

## Technologies Used

* Java
* JDBC
* MySQL
* JUnit
* Maven

## Features

List of features ready and TODOs for future development
* User can register their account.
* User can log in after registration.
* After logged in, users can perform below operations:
  - View Profile 	
  - Update Profile 	
  - Delete Profile
  - Create Post 	
  - View All Posts 	
  - See timeline
  - Search Profile by name 	
  - Logout


To-do list:
* We can add function for like and dislike a post.
* User can be able to share someone's post to their timeline.

## Getting Started
   
Use this command to clone this project : `https://github.com/gadekarmd/SocialMedia.git`

To run this project, your system must have JDK installed. You can refer [this document](https://www.oracle.com/java/technologies/downloads/#jdk18-windows) for installation of JDK.

For creating database, we have used MySQL workbench. [Here](https://dev.mysql.com/downloads/workbench/) you can find the installation guide for installation of same.

I will strongly recommend you to [install eclipse IDE](https://www.eclipse.org/downloads/packages/installer)


- First of all, we have to create a database which contains two tables viz. one for storing user information and another for storing posts information.
- For this just open MySQL workbench and put this command in script `CREATE DATABASE facebook;`.
- Now, just follow this commands: 
- - ```
    USE facebook;
    
    CREATE TABLE user (
    first_name varchar(20) DEFAULT NULL,
    last_name varchar(20) DEFAULT NULL,
    email varchar(40) NOT NULL,
    password varchar(20) DEFAULT NULL,
    mo_no varchar(15) DEFAULT NULL,
    PRIMARY KEY (email));

    CREATE TABLE post (
    post_id int NOT NULL AUTO_INCREMENT,
    user_post varchar(50) DEFAULT NULL,
    user_email varchar(40) DEFAULT NULL,
    postTime varchar(40) DEFAULT NULL,
    PRIMARY KEY (post_id),
    FOREIGN KEY (user_email) REFERENCES user (email) ON DELETE CASCADE ON UPDATE CASCADE);
    ```
- ![Screenshot (318)](https://user-images.githubusercontent.com/67138334/184426131-4a69a7ef-431e-42e5-a988-e296f162ff3e.png)

## Usage

> Go to directory, facebook -> src/main/java -> com.project.facebook.util -> ConnectionUtil.java <br>
> In this java class on line 15, replace username and password by your credentials of database. <br>
> For ex. username = "root" and password = "123456" <br>
> Now, just run this project in eclipse.
> Or, if you want to run this project through command, then paste the below commands in command prompt(in case of Windows os) or terminal(in case of Linux os)

> `javac App.java`
> `java App`
  
- After running this project, you will see the console like this:

![Screenshot (319)](https://user-images.githubusercontent.com/67138334/184428765-88a903c6-a793-4b69-9601-075e61b04e29.png)

