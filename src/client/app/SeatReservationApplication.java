/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.app;

import client.remote.SeatReservationClient;
import client.utils.AppConstants;
import client.ui.windows.EventsWindow;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import server.remote.ServerRemote;
import server.domain.Event;

/**
 *
 * @author luisburgos
 */
public class SeatReservationApplication {
    
    private SeatReservationClient mClient;
    public static ServerRemote mServer;
    
    private EventsWindow eventsWindow;
    
    public SeatReservationApplication() throws RemoteException, NotBoundException{
        
        mClient = SeatReservationClient.getInstance();
        Registry registry = LocateRegistry.getRegistry(AppConstants.REGISTRY_IP);

        mServer = (ServerRemote) registry.lookup(AppConstants.LOOKUP_SERVER_REMOTE);
        mServer.registerClient(mClient);
        
        ArrayList<Event> events = mServer.getAllEvents();
        
        eventsWindow = new EventsWindow(events);
    }
    
    public static ServerRemote getRemoteRef(){
        return mServer;
    }
    
    private void start() {
        eventsWindow.setVisible(true);
    }
    
    public static void main(String[] args) {      
        try {
            new SeatReservationApplication().start();       
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }        
    }

   
    
}
