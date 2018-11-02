/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbd;

import windows.MenuInterface;

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
        /*
        DBConnection db = DBConnection.Instance();
        //db.createDataBase();
        db.conectDB();
        //db.createDataBase();
        boolean success = db.createTable("CREATE TABLE IF NOT EXISTS Usuarios(usuid varchar(40) NOT NULL PRIMARY KEY, usunom varchar(100) NOT NULL, usudir varchar(100), usumail varchar(50) NOT NULL, usupass varchar(15) NOT NULL)");
        System.out.println("Usuario " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS Reunion(reunionid SERIAL NOT NULL PRIMARY KEY, fecha TIMESTAMP NOT NULL, lugar varchar(100) NOT NULL, descripcion varchar(255), organizadorid varchar(40) NOT NULL, FOREIGN KEY (organizadorid) REFERENCES Usuarios(usuid), nopagan)");
        System.out.println("Reunion " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS CompraPersonal(compraid SERIAL NOT NULL PRIMARY KEY, descripcion varchar(255), usuid varchar(40) NOT NULL REFERENCES Usuarios (usuid))");
        System.out.println("CompraPersonal " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS CompraReunion(compraid SERIAL NOT NULL PRIMARY KEY, descripcion varchar(255), reunionid SERIAL NOT NULL REFERENCES Reunion (reunionid), costo NUMERIC(4,3) NOT NULL)");
        System.out.println("CompraReunion " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS LineaCompra(lineaid SERIAL NOT NULL, compraid SERIAL NOT NULL, PRIMARY KEY (lineaid, compraid), nombreProducto varchar(50) NOT NULL, cantidad NUMERIC(4,3) NOT NULL )");
        System.out.println("LineaCompra " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ServicioPersonal(servicioid SERIAL NOT NULL PRIMARY KEY, empresa varchar(100), nombre varchar(100), fechaprogramada TIMESTAMP NOT NULL, descripcion varchar(255), usuid varchar(40) NOT NULL REFERENCES Usuarios (usuid))");
        System.out.println("ServicioPersonal " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS ServicioReunion(servicioid SERIAL NOT NULL PRIMARY KEY, empresa varchar(100), nombre varchar(100), descripcion varchar(255), reunionid SERIAL NOT NULL REFERENCES Reunion (reunionid))");
        System.out.println("ServicioReunion " + success);
        success = db.createTable("CREATE TABLE IF NOT EXISTS Gasto(gastoid SERIAL NOT NULL PRIMARY KEY, motivo varchar(100), montofinal NUMERIC(6,2) NOT NULL , estapago BOOLEAN NOT NULL, esingreso BOOLEAN NOT NULL, fecha DATE NOT NULL, compraid SERIAL, servicioid SERIAL, FOREIGN KEY (compraid) REFERENCES CompraPersonal(compraid), FOREIGN KEY (servicioid) REFERENCES ServicioPersonal(idservicio), usuid varchar(40) NOT NULL, FOREIGN KEY (usuid) REFERENCES Usuarios(usuid), gastoReferencia varchar(40), FOREIGN KEY (gastoReferencia) REFERENCES Gasto (gastoid))");
        System.out.println("Gasto " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS Amigo(usuiduno varchar(40) NOT NULL REFERENCES Usuarios (usuid), usuiddos varchar(40) NOT NULL REFERENCES Usuarios (usuid), PRIMARY KEY (usuiduno, usuiddos))");
        System.out.println("Amigo " + success); 
        success = db.createTable("CREATE TABLE IF NOT EXISTS Invitado(usuid varchar(40) NOT NULL REFERENCES Usuarios (usuid), reunionid SERIAL NOT NULL REFERENCES Reunion (reunionid), PRIMARY KEY (usuid, reunionid), asistio boolean NOT NULL)");
        System.out.println("Invitado " + success);
        db.getTable();*/
        MenuInterface mi = new MenuInterface();
        mi.setVisible(true);
    }
    
}
