package veriyapilarivize;

public class Uygulama {
		
	static Node head= null;
	static Node tail = null;
	static Node temp = null;
	public static void balonPozisyonuBul(int m, int n) {
		for (int i=1;i<=n;i++) {
			
			if (head == null) {//liste oluşmamışsa
				Node newNode = new Node(i);
				head = newNode;
				tail = newNode;
				continue;
			}
			if(head!=null && head.next==null) {//bir eleman varsa
				Node newNode = new Node(i);
				head.next = newNode;
				tail = newNode;
				continue;
			}
			else {
				Node newNode = new Node(i);
				tail.next =newNode;
				tail=newNode;
				
			}
		}
		tail.next=head;//liste oluştuktan sonra son elemanı head'e bağlar
		
		//listeyi yazdırma
		Node iter =head;
		System.out.println("liste:\n"+iter.data);
		iter=iter.next;
		while(iter!=head) {
			System.out.println(iter.data);
			iter=iter.next;
		}
		
		iter=head;
		temp=head;
		while(iter.next!=null) {
			for(int i =0;i<m-1;i++) {//iter'i m-1 kadar haraket ettirir
				temp=iter;
				iter=iter.next;
				
			}
			if(iter==tail) {//kuyruğun silinme durumu
				if(head.next==iter) {//eğer son 2 eleman kaldıysa 
					iter=head;
					iter.next=null;
				}else {
				temp.next=iter.next;
				tail = temp;
				iter=temp.next;
				}
				
			}else {
				if(iter==head) {//head'in silinme durumu
					temp.next=iter.next;
					iter=iter.next;
					head=iter;
				}
				else {
					temp.next =iter.next;
					iter = temp.next;
				}
			}
		}
		System.out.println("son kalan: "+iter.data);
	}
}
