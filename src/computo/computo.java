package computo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface computo extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}