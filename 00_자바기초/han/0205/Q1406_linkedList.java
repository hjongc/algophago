import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1406_linkedList {
	public static void main(String[] args) throws IOException{
        // 기본 IO설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        // 링크드 리스트 선언
        char[] str = br.readLine().toCharArray();
		int test_case = Integer.parseInt(br.readLine());
        hanLinkedList lkdList = new hanLinkedList();
        
        // 값 넣기
        for(int i = 0; i<str.length; i++){
            lkdList.insertNode(str[i]);
        }

        // 맨 마지막에 커서 만들기
        lkdList.insertNode(';');
        ListNode cursor = lkdList.head;
        while(cursor.next != null) {
            cursor = cursor.next;
        }

        // 명령 받기
        for(int i = 0; i<test_case; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken(); // command : 명령

            // 만약 L(커서 한칸 왼쪽으로)
            // 커서를 pop하고
            // 커서 왼쪽 객체가 있으면 커서를 잠시 객체로 옮김
            // 객체왼쪽에 커서를 만듦
            // 객체 왼쪽에 커서를 만들었으므로 다시 커서를 객체 왼쪽으로 조절
            if (command.equals("L")) {
                if (cursor.last != null) {
                    lkdList.popNode(cursor);
                    cursor=cursor.last;
                    
                    lkdList.insertBeforeNode(cursor, ';');
                    cursor=cursor.last;
                }
                else continue;
            }
            // D는 그 반대
            else if (command.equals("D")) {
                if (cursor.next != null) {
                    lkdList.popNode(cursor);
                    cursor = cursor.next;
                    lkdList.insertNode(cursor,';');
                    cursor = cursor.next;
                }
                else continue;
            }
            // B : 글자 삭제 
            else if (command.equals("B")) {
                if (cursor.last == null) continue;
                lkdList.popNode(cursor.last);
                
            } 
            // 나머지 -> 글자 추가이므로, 커서 왼쪽에 글자를 추가
            else {
                char newChar = st.nextToken().charAt(0);
                lkdList.insertBeforeNode(cursor, newChar);
                    
            }
        }
        // 커서가 남아있으므로 pop
        lkdList.popNode(cursor);

        // 정답 출력
        ListNode answer = lkdList.head;
        while(answer != null){
            sb.append(answer.data);
            answer = answer.next;
        }
        System.out.println(sb);
    }
}

// LinkedList를 만들기 위한 Node 정의
class ListNode {
    public char data;
    public ListNode last;
    public ListNode next;

    // 생성자
    public ListNode(){};

    public ListNode(char data){
        this.data = data;
        this.last = null;
        this.next = null;
    }
}

// 나의 LinkedList
class hanLinkedList {
    public ListNode head;

    // 생성자 ( 맨 처음은 비어있으므로 head = null )
    public hanLinkedList(){
        head = null;
    }

    // node를 마지막에 삽입 
    public void insertNode(char data){
        // 새 노드 생성
        ListNode newNode = new ListNode(data);

        // 만약 head = null이라면 (즉, 비어있는 linkedList라면)
        // head를 새 노드로 선언
        if (head == null) this.head = newNode;

        // 비어있는 linkedList가 아니라면
        else {
            ListNode tmpNode = head;
            // 맨 마지막 Node를 찾고 삽입
            while(tmpNode.next != null) tmpNode = tmpNode.next;
            tmpNode.next = newNode;
            newNode.last = tmpNode;
        }
    }

    // node를 preNode 뒤에 삽입
    public void insertNode(ListNode preNode, char data){
        // 새 노드 생성
        ListNode newNode = new ListNode(data);
        
        // head = null ( 비어있는 linked List라면)
        // head를 새 노드로
        if (head == null) this.head = newNode;

        // preNode = null 이면 (맨 앞에 삽입이면)
        // 새 노드를 머리로 선언
        else if (preNode == null) {
            newNode.next = head;
            head.last = newNode;
            head = newNode;

        //  마지막 삽입이면
        // 새 노드는 마지막으로
        } else if (preNode.next == null) {
            preNode.next = newNode;
            newNode.last = preNode;

        // 나머지 경우 (앞과 뒤 노드가 있으면)
        } else {
            newNode.next = preNode.next;
            newNode.last = preNode;
            preNode.next.last = newNode;
            preNode.next = newNode;
            
        }
    }

    // 노드를 nextNode 앞에 삽입
    public void insertBeforeNode(ListNode nextNode, char data){
        ListNode newNode = new ListNode(data);
        if (head == null) head = newNode;
        else if (nextNode == null) {
            insertNode(data);
        } else if (nextNode.last == null) {
            head = newNode;
            newNode.next = nextNode;
            nextNode.last = newNode;
        } else {
            newNode.next = nextNode;
            newNode.last = nextNode.last;
            
            nextNode.last.next = newNode;
            nextNode.last = newNode;
        }
    }

    // 노드 삭제
    public void popNode(ListNode deleteNode){
        if (deleteNode.next == null && deleteNode.last == null) {
            head = null;
        } else if (deleteNode.last == null) {
            deleteNode.next.last = null;
            head = deleteNode.next;
        } else if (deleteNode.next == null) {
            deleteNode.last.next = null;
        } else {
            deleteNode.last.next = deleteNode.next;
            deleteNode.next.last = deleteNode.last;
        }
    }
}
// 얘는 시간초과