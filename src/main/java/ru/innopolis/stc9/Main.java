package ru.innopolis.stc9;

import ru.innopolis.stc9.servlets.db.connection.ConnectionManagerJDBCImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        File dbLoginFile = new File("src/main/resources/dbAuthorization.properties");
        Properties property =new Properties();

        if (dbLoginFile.exists()){
            try (FileInputStream input = new FileInputStream(dbLoginFile)){
                property.load(input);
                ConnectionManagerJDBCImpl.DB_HOST=property.getProperty("DB.host");
                ConnectionManagerJDBCImpl.DB_LOGIN=property.getProperty("DB.login");
                ConnectionManagerJDBCImpl.DB_PASSWORD=property.getProperty("DB.password");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            ConnectionManagerJDBCImpl.DB_HOST="jdbc:postgresql://localhost:5432/University";
            ConnectionManagerJDBCImpl.DB_LOGIN="UserName";
            ConnectionManagerJDBCImpl.DB_PASSWORD="Password";
        }

    }
}
