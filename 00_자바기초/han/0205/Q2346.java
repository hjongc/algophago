import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2346 {
	public static void main(String[] args) throws IOException{
        // 기본 IO설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // // 입력받고 스택 생성
		int test_case = Integer.parseInt(br.readLine());
		DoubleLinkedList deque = new DoubleLinkedList();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int cnt = 1;
        for (int i = 0; i<test_case; i++){
            int paper = Integer.parseInt(st.nextToken());
            deque.insertNode(new set(cnt++, paper));
        }
        
        int next = deque.head.pair.value;
        deque.popNode(new set(1,0));
        ListNode tmp = deque.head;
        sb.append("1 ");
        while (!(deque.head.next.equals(deque.head))){
            if (next > 1){
                next--;
                tmp = tmp.next;
            }
            else if (next < 0){
                next++;
                tmp = tmp.last;
            }
            else {
                next = tmp.pair.value;
                int key = tmp.pair.key;
                sb.append(deque.popNode(new set(key, next))).append(" ");
            }
            System.out.println("sb : "+sb);
        }
        System.out.println("sb : "+sb);
	}
}
// 두 개의 int를 인자로 받는 class
class set {
    public int key;
    public int value;
    public set(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class ListNode{
    public set pair;
    public ListNode last;
    public ListNode next;

    public ListNode(){};

    public ListNode(set pair){
        this.pair = pair;
        this.last = null;
        this.next = this;
    }

    public void setNext(ListNode presentNode){
        this.next = presentNode;
    }


    
}

class DoubleLinkedList {
    public ListNode head;

    public DoubleLinkedList(){
        head = null;
    }

    public void insertNode(set data){
        ListNode newNode = new ListNode(data);
        if (head == null) this.head = newNode;
        else {
            
            ListNode tmpNode = head;
            System.out.println(tmpNode.next == null);
            while (tmpNode.next.pair.key != head.pair.key){
                tmpNode = tmpNode.next;
            }
            tmpNode.next = newNode;
            newNode.last = tmpNode;
            newNode.next = head;
            head.last = newNode;
        }
    }

    public int popNode(set data){
        ListNode preNode = head;
        ListNode tmpNode = head.next;

        if (data.key == head.pair.key) {
            head = preNode.next;
            if ( head == null ) return data.key;
            head.last = preNode.last;
            return data.key;
        }
        else {
            while (tmpNode != null){
                if (data.key == tmpNode.pair.key){
                    if (tmpNode.next.pair.key == head.pair.key) {
                        tmpNode.last.next = head;
                        head.last = tmpNode.last;
                        return data.key;
                    } else {
                        preNode.next = tmpNode.next;
                        tmpNode.next.last = preNode;
                        return data.key;
                    }
                } else {
                    preNode = tmpNode;
                    tmpNode = tmpNode.next;
                }
            }
            return -1;
        }
    }
    
}
