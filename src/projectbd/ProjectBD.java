/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd;

import Controllers.MainController;
import java.security.NoSuchAlgorithmException;
import windows.MenuInterface;

/**
 *
 * @author federicoponcedeleon
 */
public class ProjectBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        /*
        DBConnection db = DBConnection.Instance();
        //db.createDataBase();
        db.conectDB();
        //db.createDataBase();
        boolean success = db.createTable("CREATE TABLE IF NOT EXISTS Usuarios(usuid varchar(40) NOT NULL PRIMARY KEY, usunom varchar(100) NOT NULL, usudir varchar(100), usumail varchar(50) NOT NULL, usupass varchar(15) NOT NULL)");
        System.out.println("Usuario " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS Reunion(reunionid varchar(255) NOT NULL PRIMARY KEY, fecha TIMESTAMP NOT NULL, lugar varchar(100) NOT NULL, descripcion varchar(255), organizadorid varchar(40) NOT NULL, FOREIGN KEY (organizadorid) REFERENCES Usuarios(usuid), nopagan boolean not null)");
        System.out.println("Reunion " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS CompraPersonal(compraid varchar(255) NOT NULL PRIMARY KEY, descripcion varchar(255), usuid varchar(40) NOT NULL REFERENCES Usuarios (usuid) on update cascade on delete cascade)");
        System.out.println("CompraPersonal " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS CompraReunion(compraid varchar(255) NOT NULL PRIMARY KEY, descripcion varchar(255), reunionid SERIAL NOT NULL REFERENCES Reunion (reunionid), on update cascade on delete cascade, costo NUMERIC(8,2) NOT NULL)");
        System.out.println("CompraReunion " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS LineaCompra(lineaid SERIAL NOT NULL, compraid SERIAL NOT NULL, PRIMARY KEY (lineaid, compraid), nombreProducto varchar(50) NOT NULL, cantidad NUMERIC(6,2) NOT NULL )");
        System.out.println("LineaCompra " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ServicioPersonal(servicioid varchar(255) NOT NULL PRIMARY KEY, empresa varchar(100), nombre varchar(100), fechaprogramada TIMESTAMP NOT NULL, descripcion varchar(255), usuid varchar(40) NOT NULL REFERENCES Usuarios (usuid))");
        System.out.println("ServicioPersonal " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ServicioReunion(servicioid varchar(255) NOT NULL PRIMARY KEY, empresa varchar(100), nombre varchar(100), descripcion varchar(255), costo NUMERIC(8,2), reunionid SERIAL NOT NULL REFERENCES Reunion (reunionid))");
        System.out.println("ServicioReunion " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS Gasto(gastoid varchar(255) NOT NULL PRIMARY KEY, motivo varchar(100), montofinal NUMERIC(8,2) NOT NULL , estapago BOOLEAN NOT NULL, esingreso BOOLEAN NOT NULL, fecha DATE NOT NULL, compraid varchar(255), servicioid varchar(255), FOREIGN KEY (compraid) REFERENCES CompraPersonal(compraid), FOREIGN KEY (servicioid) REFERENCES ServicioPersonal(idservicio), usuid varchar(40) NOT NULL, FOREIGN KEY (usuid) REFERENCES Usuarios(usuid), gastoReferencia varchar(40), FOREIGN KEY (gastoReferencia) REFERENCES Gasto (gastoid))");
        System.out.println("Gasto " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS Amigo(usuiduno varchar(40) NOT NULL REFERENCES Usuarios (usuid), usuiddos varchar(40) NOT NULL REFERENCES Usuarios (usuid), PRIMARY KEY (usuiduno, usuiddos))");
        System.out.println("Amigo " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS Invitado(usuid varchar(40) NOT NULL REFERENCES Usuarios (usuid), reunionid SERIAL NOT NULL REFERENCES Reunion (reunionid), PRIMARY KEY (usuid, reunionid), asistio boolean NOT NULL)");
        System.out.println("Invitado " + success);
        db.getTable();*/
        MainController mc = MainController.instance();
        mc.algo("abcd");
        mc.algo("abcd");
        mc.algo("abc");
        mc.algo("abc");
        //MenuInterface mi = new MenuInterface();
        //mi.setVisible(true);
    }
    
}
