package com.pluralsight.pattern.observer;

import java.util.Observable;

public class Main {
	
	public class ObservableObject extends java.util.Observable{
		
		private String value = null;
		
		public void setValue(String arg) {
			this.value= arg;
			this.setChanged();
		}
		
	}
	
	public class ObserverObject implements java.util.Observer{
		
		@Override
		public void update(Observable o, Object arg) {
		
			if(arg instanceof NotifyValue) {
				NotifyValue argCast = ((NotifyValue) arg);
				System.out.println("valore arrivato:" +argCast.getValue());
			}
			
		}
		
		
	}
	
	public class NotifyValue{
		public String value;
		public NotifyValue(String string) {
			this.value = string;
		}
		public String getValue() { return value;}
	}
	
	public static void Main(String[] args) {
		
		Main m = new Main();
		ObservableObject o = m.new ObservableObject();
		ObserverObject i = m.new ObserverObject();
		o.addObserver(i);
		
		o.notifyObservers(m.new NotifyValue("cacca"));
	
	}
	

}
