1. HibernateUtil Class :
The HibernateUtil class is a utility for configuring and managing the SessionFactory, which is a crucial component in Hibernate for creating sessions to interact with the database. It follows the singleton pattern to ensure only one instance of SessionFactory is created.
buildSessionFactory(): Creates the SessionFactory from the Hibernate configuration file (hibernate.cfg.xml). If an error occurs during configuration, it throws an exception.
getSessionFactory(): Provides access to the single SessionFactory instance.
shutdown(): Shuts down the SessionFactory, releasing resources.


2. Transactional Annotation :
The @Transactional annotation is a custom annotation used to mark methods that should be executed within a transaction.
@Retention(RetentionPolicy.RUNTIME): This means the annotation is available at runtime.
@Target(ElementType.METHOD): The annotation can only be applied to methods.


3. SessionManager Class :
The SessionManager class handles the lifecycle of Hibernate sessions and transactions.
getSession(): Opens a new session or returns the current session for the thread.
closeSession(): Closes the current session to free up resources.
executeTransaction(): Manages a transaction by starting it, executing the given action, and committing or rolling back the transaction depending on whether an exception occurs.
The TransactionAction interface allows executing custom code within a transactional context.


4. TransactionInterceptor Class : 
The TransactionInterceptor class uses reflection to check if a method is annotated with @Transactional. If it is, it wraps the execution within a transaction managed by SessionManager. Otherwise, it executes the method normally.
execute(): Checks for the @Transactional annotation and manages the execution flow accordingly. It invokes the method with the provided arguments and handles any exceptions that may arise.


5. Hibernate Configuration (hibernate.cfg.xml) : 
This file contains the configuration settings required by Hibernate to connect to a MySQL database.
Connection properties: Define the database driver, URL, username, password, and dialect.
Hibernate properties: Configure Hibernate behavior, such as hibernate.hbm2ddl.auto, which controls the database schema generation strategy, and hibernate.show_sql, which displays SQL statements in the console.
Mappings: Specify the classes that Hibernate should map to database tables (Utilisateur and Patient).
