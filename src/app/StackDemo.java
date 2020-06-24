package app;


public class StackDemo<X> implements StackInterface<X> {

	private X[] data;
	private int stackPointer;
	
	public StackDemo() {
		stackPointer = 0;
		data = (X[]) new Object[1000];
	}

	@Override
	public void push(X newItem) {
		data[stackPointer++] = (X) newItem;
		
	}

	@Override
	public X pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("No more items on the stack");
		}
		
		return data[--stackPointer];
	}

	@Override
	public boolean contains(Object item) {
		boolean found = false;
		
		for(int i=0;i<stackPointer;i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
	}
		return found;
	}

	@Override
	public Object access(Object item) {
		while(stackPointer>0) {
			X tmpItem = (X) pop();
			if(item.equals(tmpItem)) {
				return tmpItem;
			}
		}
		
		throw new IllegalStateException("Could not find the item");
	}

	@Override
	public int size() {
		return stackPointer;
	}
	
}
