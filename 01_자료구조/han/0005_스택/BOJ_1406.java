import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1406 {
	public static void main(String[] args) throws IOException{
        // 기본 IO설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // // 입력받고 스택 생성
        char[] str = br.readLine().toCharArray();
		int test_case = Integer.parseInt(br.readLine());
        hanLinkedList lkdList = new hanLinkedList();
        
        for(int i = 0; i<str.length; i++){
            lkdList.insertNode(str[i]);
        }
        ListNode cursor = lkdList.head;
        while(cursor.next != null) {
            cursor = cursor.next;
        }
        for(int i = 0; i<test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if (command.equals("L")) {
                if (cursor.last != null) {cursor = cursor.last;}
                else continue;
            }
            else if (command.equals("D")) {
                if (cursor.next != null) {cursor = cursor.next;}
                else continue;
            }
            else if (command.equals("B")) {
                cursor = cursor.last;
                lkdList.popNode(cursor.next);

            } 
            else {
                char newChar = st.nextToken().charAt(0);
                lkdList.insertNode(cursor, newChar);
                cursor = cursor.next;
                
                
            }
        }
        ListNode answer = lkdList.head;
        while(answer != null){
            sb.append(answer.data);
            answer = answer.next;
        }
        System.out.println(sb);
    }
}
class ListNode {
    public char data;
    public ListNode last;
    public ListNode next;

    public ListNode(){};

    public ListNode(char data){
        this.data = data;
        this.last = null;
        this.next = null;
    }

    public void setNext(ListNode presentNode){
        this.next = presentNode;
    }
}
class hanLinkedList {
    public ListNode head;

    public hanLinkedList(){
        head = null;
    }
    public void insertNode(char data){
        ListNode newNode = new ListNode(data);
        if (head == null) this.head = newNode;
        else {
            ListNode tmpNode = head;
            while(tmpNode.next != null) tmpNode = tmpNode.next;
            tmpNode.next = newNode;
            newNode.last = tmpNode;
        }
    }
    public void insertNode(ListNode preNode, char data){
        ListNode newNode = new ListNode(data);
        if (head == null) this.head = newNode;
        else if (preNode == null) {
            newNode.next = head;
            head.last = newNode;
            head = newNode;
        } else if (preNode.next == null) {
            preNode.next = newNode;
            newNode.last = preNode;
        } else {
            newNode.next = preNode.next;
            newNode.last = preNode;
            preNode.next = newNode;
            newNode.next.last = newNode;
        }
    }

    public void popNode(ListNode deleteNode){
        if (deleteNode.next == null && deleteNode.last == null) {
            head = null;
        } else if (deleteNode.last == null) {
            deleteNode.next.last = deleteNode.last;
            head = deleteNode.next;
        } else if (deleteNode.next == null) {
            deleteNode.last.next = deleteNode.next;
        } else {
            deleteNode.last.next = deleteNode.next;
            deleteNode.next.last = deleteNode.last;
        }
    }
}

// 첫 트라이
// 얘는 문제가있는데
// 커서가 맨 앞으로 못감
// 이유는
// 커서를 Node로 선언했기 때문