import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayDemo {

	/**
	 * 数组下标从0开始是为了寻址cpu少做一次减法运算
	 * a[k]_address = base_address + k * type_size
	 * 二维数组寻址：
	 * 对于 m * n 的数组，a [ i ][ j ] (i < m,j < n)的地址为：
	 * address = base_address + ( i * n + j) * type_size	
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BeginTime" + new Date());
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<100000;i++) {
			list.add(1);
		}
		System.out.println("EndTime" + new Date());
		
		System.out.println("BeginTime2" + new Date());
		List<Integer> list2 = new ArrayList<>(100000);
		for(int i = 0;i<100000;i++) {
			list2.add(1);
		}
		System.out.println("EndTime2" + new Date());
	}
}


/**
 * 数组
 * @author 17122783
 *
 */
class Array{
	//存放int的数组
	private int data[];
	//数组长度
	private int n;
	//保存的数据个数
	private int count;
	
	//构造方法
	public Array(int capacity) {
		// TODO Auto-generated constructor stub
		this.data = new int[] {1,2,3,4,5};
		this.n = capacity;
		this.count = capacity;
	}
	
	/**
	 * 根据下标查数据
	 * @param index
	 * @return
	 */
	public int find(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>count-1) {
			return -1;
		}else {
			return data[index];
		}
	}
	
	/**
	 * 删除指定下标的数据
	 * @param index
	 * @return
	 */
	public int delete(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>count-1) {
			return -1;
		}
		int ret = data[index];
		for(int i = index;i<count-1;i++) {
			data[i+1] = data[i];
		}
		--count;
		return ret;
	}
	
	/**
	 * 在指定位置插入数据
	 * @param index
	 * @param value
	 */
	public boolean insert(int index,int value) {
		// TODO Auto-generated method stub
		if(index<0||index>n-1) {
			return false;
		}
		if(count == n) {
			return false;
		}
		int temp[] = new int[count+1];
		for(int i = 0 ;i<index;i++) {
			temp[i] = data[i];
		}
		temp[index] = value;
		for(int x = index+1;x<count+1;x++) {
			temp[x] = data[x-1];
		}
		data = temp;
		count++;
		return true;
	}
}
