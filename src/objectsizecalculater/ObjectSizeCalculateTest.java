package objectsizecalculater;

public class ObjectSizeCalculateTest {

	
	public static void main(String[] args) {
		
		
		long size = ObjectSizeCalculater.getObjectSize(new SimpleObject());
		System.out.println("size == "+size);
	}
}
