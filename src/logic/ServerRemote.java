package logic;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface ServerRemote extends Remote {
    public void registerClient(ClientRemote client) throws RemoteException;
    public void doSomethingOnClient() throws RemoteException;
}