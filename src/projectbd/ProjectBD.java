/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd;

import Controllers.UserController;
import windows.LoginInterface;

/**
 *
 * @author federicoponcedeleon
 */
public class ProjectBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBConnection db = DBConnection.Instance();
        db.conectDB();
        
        
        //db.createDataBase();
        
        boolean success = db.createTable("CREATE TABLE IF NOT EXISTS Usuarios(usuid varchar(40) NOT NULL PRIMARY KEY, usunom varchar(100) NOT NULL, usudir varchar(100), usumail varchar(50) NOT NULL, usupass varchar(15) NOT NULL)");
        System.out.println("Usuario " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS Reuniones2(reunionid varchar(255) NOT NULL PRIMARY KEY, fecha TIMESTAMP NOT NULL, lugar varchar(100) NOT NULL, descripcion varchar(255), organizadorid varchar(40) NOT NULL, FOREIGN KEY (organizadorid) REFERENCES Usuarios(usuid), nopagan boolean not null)");
        System.out.println("Reunion " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS ComprasPersonales(compraid varchar(255) NOT NULL PRIMARY KEY, descripcion varchar(255), usuid varchar(40) NOT NULL REFERENCES Usuarios(usuid))");
        System.out.println("CompraPersonal " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ComprasReuniones(compraid varchar(255) NOT NULL PRIMARY KEY, descripcion varchar(255), reunionid varchar(255) NOT NULL REFERENCES Reuniones2(reunionid), costo NUMERIC(8,2) NOT NULL)");
        System.out.println("CompraReunion " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS LineasCompra(lineaid SERIAL NOT NULL, compraid varchar(255) NOT NULL, PRIMARY KEY (lineaid, compraid), nombreProducto varchar(50) NOT NULL, cantidad NUMERIC(6,2) NOT NULL )");
        System.out.println("LineaCompra " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ServiciosPersonales(servicioid varchar(255) NOT NULL PRIMARY KEY, empresa varchar(100), nombre varchar(100), fechaprogramada TIMESTAMP NOT NULL, descripcion varchar(255), usuid varchar(40) NOT NULL REFERENCES Usuarios(usuid))");
        System.out.println("ServicioPersonal " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ServiciosReuniones(servicioid varchar(255) NOT NULL PRIMARY KEY, empresa varchar(100), nombre varchar(100), descripcion varchar(255), costo NUMERIC(8,2), reunionid varchar(255) NOT NULL REFERENCES Reuniones2(reunionid))");
        System.out.println("ServicioReunion " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS Gastos(gastoid varchar(255) NOT NULL PRIMARY KEY, motivo varchar(100), montofinal NUMERIC(8,2) NOT NULL, estapago BOOLEAN NOT NULL, esingreso BOOLEAN NOT NULL, fecha DATE NOT NULL, compraid varchar(255), servicioid varchar(255), FOREIGN KEY (compraid) REFERENCES ComprasPersonales(compraid), FOREIGN KEY (servicioid) REFERENCES ServiciosPersonales(servicioid), usuid varchar(40) NOT NULL, FOREIGN KEY (usuid) REFERENCES Usuarios(usuid), gastoReferencia varchar(40), FOREIGN KEY (gastoReferencia) REFERENCES Gastos(gastoid))");
        System.out.println("Gasto " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS Amigos(usuiduno varchar(40) NOT NULL REFERENCES Usuarios(usuid), usuiddos varchar(40) NOT NULL REFERENCES Usuarios(usuid), PRIMARY KEY (usuiduno, usuiddos))");
        System.out.println("Amigo " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS Invitados(usuid varchar(40) NOT NULL REFERENCES Usuarios(usuid), reunionid varchar(255) NOT NULL REFERENCES Reuniones2(reunionid), PRIMARY KEY (usuid, reunionid), asistio boolean NOT NULL);");
        System.out.println("Invitado " + success);
        
        UserController uc = UserController.getInstanceUser();
        //uc.createUser("fedepon1998", "fpdl", "federico", "sabat pebet", "fm@gmail");
        uc.createUser("maymmiqueiro", "fpdl", "federico", "sabat pebet", "fm@gmail");
        
        LoginInterface login = new LoginInterface();
        login.setVisible(true);
    }
    
}
