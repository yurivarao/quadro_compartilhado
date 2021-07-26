package quadrocompartilhado;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ShapeListServer {
    public static void main(String args[]){
        System.setSecurityManager(new RMISecurityManager());
        try{  
            ShapeList aShapelist = new ShapeListServant();
            ShapeList stub = (ShapeList) UnicastRemoteObject.exportObject(aShapelist,0);
            //System.setProperty("java.rmi.server.hostname","192.168.000.000");
            Registry rgsty = LocateRegistry.createRegistry(1099);
            rgsty.rebind("ShapeList", aShapelist);
            //Naming.rebind("ShapeList", aShapelist);       
            System.out.println("ShapeList server ready");
        }catch(Exception e) {
            System.out.println("ShapeList server main " + e.getMessage());
        }
    }
}