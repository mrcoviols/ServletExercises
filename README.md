##Servlet Exercises
This repository consists of exercises and simple examples on Servlets, the handy Java EE tool for web programming.
These projects were made during the *Web Technologies (2019/2020)* course held at Politecnico di Milano.

####Environment

The exercises were made on the following environment:
* **IDE** - Eclipse IDE for Enterprise Java developers v.4.14.0
* **Web Server** - Tomcat Catalina v.9.0
* **Database** - MariaDB 10.4.12-1 (newest available at the time)
* **Other Resources** - The tomcat-mySQL-connector jar was introduced between the libraries of Tomcat to make the connection to a database feasible.

I tried to manage the above dependencies via Maven (as you can see in the repository), and it *seems to* work

As obvious, the above environment is the one set up by me for the course: Another environment may turn out to be as good or better, but for the purpose of the course this one was good enough.

####Exercises

Every exercise is encapsulated in its own java package (it.polimi.tiw.*exercise-name*).
Each mapping on the web server is available in the annotation `@WebServlet(urlPatterns = { mapping })` of the servlet class (do not forget the Context Path "/ServletExercises/" before it!).

The exercises/homeworks available are:

* **UnsafeCounter** - Servlet to test parameters and their initialization in `init()`.
* **HiddenForm** - Servlet to test hidden form attributes in HTML and use them as session identifiers

