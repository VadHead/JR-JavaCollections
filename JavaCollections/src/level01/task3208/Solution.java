package level01.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Solution {
	public static Registry registry;
	public static final String UNIC_BINDING_NAME = "server.animal";
	// Pretend we're starting an RMI client as the CLIENT_THREAD thread
	public static Thread CLIENT_THREAD = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				for (String bindingName : registry.list()) {
					Animal service = (Animal) registry.lookup(bindingName);
					service.printName();
					service.speak();
				}
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}
	});
	
	// Pretend we're starting an RMI server as the SERVER_THREAD thread
	public static Thread SERVER_THREAD = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				registry = LocateRegistry.createRegistry(2099);
				
				Cat cat = new Cat("Tom");
				Dog dog = new Dog("Butch");
				
				Remote stubCat = UnicastRemoteObject.exportObject(cat, 0);
				Remote stubDog = UnicastRemoteObject.exportObject(dog, 0);
				
				registry.bind(UNIC_BINDING_NAME, stubCat);
				registry.bind(UNIC_BINDING_NAME, stubDog);
				
			} catch (RemoteException | AlreadyBoundException e) {
				e.printStackTrace();
			}
		}
	});
	
	public static void main(String[] args) throws InterruptedException {
		// Starting an RMI server thread
		SERVER_THREAD.start();
		Thread.sleep(1000);
		// Start the client
		CLIENT_THREAD.start();
	}
}
