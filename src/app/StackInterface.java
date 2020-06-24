package app;

public interface StackInterface<X> {
	
	void  push(X newItem);
	X pop();
	boolean contains(X item);
	X access(X item);
	int size();
	
}
