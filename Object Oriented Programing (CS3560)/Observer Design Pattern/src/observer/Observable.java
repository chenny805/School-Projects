package observer;

public interface Observable {
	// add observer to notification list
	public void addObserver(Observer targetObserver);
	// remove observer to notification list
	public void removeObserver(Observer targetObserver);
	// notify all observers on list
	public void notifyObservers();

}
