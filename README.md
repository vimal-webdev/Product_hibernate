Product Hibernate

A Java-based Product Management application built using Hibernate ORM and MySQL. This project demonstrates CRUD (Create, Read, Update, Delete) operations using Hibernate for database interaction.

🚀 Features
Add new products
View product details
Update existing products
Delete products
Manage inventory quantities
Perform database operations using Hibernate ORM
🛠️ Technologies Used
Java
Hibernate ORM
MySQL
Maven
JDBC
Eclipse IDE
📂 Project Structure
src/
├── com.dao/
│   ├── InventoryDAO.java
│   └── ProductDAO.java
├── com.main/
│   └── MainApp.java
├── com.model/
│   ├── Inventory.java
│   ├── Product.java
│   └── ProductModel.java
└── hibernate.cfg.xml
⚙️ Prerequisites

Make sure you have the following installed:

JDK 22 or later
MySQL Server
Eclipse IDE
Maven
Git
🔧 Database Configuration

Update the hibernate.cfg.xml file with your database details.

<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/product_db
</property>

<property name="hibernate.connection.username">
    your_username
</property>

<property name="hibernate.connection.password">
    your_password
</property>

Create the database in MySQL:

CREATE DATABASE product_db;
▶️ How to Run the Project
Clone the repository:
git clone https://github.com/vimal-webdev/Product_hibernate.git
Open Eclipse.
Import the project:
File → Import → Existing Maven Projects
Configure the database connection in hibernate.cfg.xml.
Update Maven dependencies:
Right-click project → Maven → Update Project
Run the application:
Run MainApp.java
📸 Sample Operations
Add Product
View Products
Update Product Quantity
Delete Product
🤝 Contributing

Contributions are welcome. Feel free to fork the repository and submit a pull request.

👨‍💻 Author

Vimal Raj

GitHub: https://github.com/vimal-webdev

LinkedIn: Add your LinkedIn profile URL here.

⭐ Support

If you found this project useful, please give it a star on GitHub.
