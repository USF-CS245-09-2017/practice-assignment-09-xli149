public class BinaryHeap{
	//Data memebers
	int []data;
	int size;
	//constructor
	public BinaryHeap(){
		data = new int[10];
		size = 0;
	}
	/**Function for adding items to heap at the the end of the array
	 	and grow the size of the array if it is full.
	 *@param item: element to be added in the array.
	 */ 
	public void add(int item){
		if(size % data.length == 0){
			growArray();
		}
		data[size++] = item;
		int current = size -1;
		int parent = (current - 1)/2;
		while(data[current] < data[parent]){
			swap(data, current, parent);
			current = parent;
			parent = (parent - 1)/2;
		}
	}
	/** Function for removing the top element of the heap from the the array
	 * of index 0. It switch the first element with the last element, decrement
	 * the size of the array and shiftdown the element.
	 */ 
	public int remove(){
		try{
			if(size == 0){
				throw new Exception("Error") ;
			}
			swap(data, 0, size - 1);
			--size;
			if(size > 0){
				shiftdown(0);
			}
		}catch(Exception e){
			System.out.println("Error");
		}	
		return data[size];

	}
	/* Function for grow the length of the array*/
	public void growArray(){
		int temp[] = new int[data.length * 2];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	/** Function for swapping the two elements
	 *@param data: the array that holds the elements
	 *@param current: the index of the child element
	 *@param parent: the index of the parent element
	 */	
	public void swap(int[] data, int current, int parent){
		int temp = data[current];
		data[current] = data[parent];
		data[parent] = temp;
	}
	/** Recurssive function for shift down the elements from the top of
	 * the heap.
	 * @param item: the item to be shift down.
	 */
	public void shiftdown(int item){
		int parent = item;
		int left = parent * 2 + 1;
		int right = parent * 2 + 2;

		if(left >= size || right >= size){

				return;
		}

		if(data[left] < data[right] && data[left] < data[item]){
			swap(data, left, item);
			shiftdown(left);
		}
		else if(data[right] <  data[left] && data[right] < data[item]){
			swap( data, right, item);
			shiftdown(right);
		}
	}
}