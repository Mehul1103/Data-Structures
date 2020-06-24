package app;

public class QueueDemo<X> {
	private X[] data;
	private int front;
	private int end;
	
	public QueueDemo() {
		this(1000);
	}
	
	public QueueDemo(int size) {
		data = (X[]) new Object[size];
		front = -1;
		end = -1;
	}
	
	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		}
		return end - front + 1;
	}
	
	public void enQueue(X item) {
		if(end + 1%data.length == front) {
			throw new IllegalStateException("Queue is fall");
		}else if(size() == 0){
			front++;
			end++;
			data[end] = item;
		}else {
			data[end++] = item;
		}
	}
	
	public X deQueue() {
		X item = null;
		if(size() == 0) {
			throw new IllegalStateException("Queue is empty!");
		}
		else if (front == end) {
			item = data[front];
			front = -1;
			end = -1;
		}else {
			item = data[front];
			front++;
		}
		return item;
	}
	
	public boolean contains(X item) {
		boolean found = false;
		
		if(size()==0) {
			return found;
		}
		
		for(int i=0;i<end;i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public X access(int position) {
		if(size() == 0 || position>size()) {
			throw new IllegalArgumentException("Queue is empty or position is greater than size of queue");
		}
		
		int trueIndex = 0;
		for(int i = front; i<end; i++) {
			if(trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}
		
		throw new IllegalArgumentException("Could not get item position");
	}
}
