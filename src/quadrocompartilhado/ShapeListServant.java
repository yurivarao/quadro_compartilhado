package quadrocompartilhado;
import java.rmi.RemoteException;
import java.util.Vector;

public class ShapeListServant implements ShapeList{
    private Vector theList;
    private int version;

    public ShapeListServant()throws RemoteException{
        theList = new Vector();
        version = 0;
    }

    //@Override
    public Shape newShape(GraphicalObject g) throws RemoteException{
        version++;
        Shape s = new ShapeServant( g, version);
        theList.addElement(s);
        return s;
    }

    //@Override
    public Vector allShapes()throws RemoteException{
        return theList;
    }

    //@Override
    public int getVersion() throws RemoteException{
        return version;
    }
}