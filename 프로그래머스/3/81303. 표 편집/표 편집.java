import java.util.*;
class Solution {
    //커스텀 linkedlist을 위한 클래스
    static class Node {
        Node prev = null;
        Node next = null;
        boolean isDelete = false;
    }
    // 조회에서 O(N)이 아닌 O(1)이 되도록 한다.
    static Node[] arr = arr = new Node[1000001];
    // 삭제용 Queue
    static Deque<Node> delete = new LinkedList<>();
    
    //현재 Node
    static Node now;
    
    public String solution(int n, int k, String[] cmds) {
        
        // linkedlist 세팅
        arr[0] = new Node();
        for(int i = 1 ; i < n ; i++){
            arr[i] = new Node();
            arr[i].prev = arr[i-1];
            arr[i-1].next = arr[i];
        }
        
        now = arr[k];
        
        for(String cmd: cmds){
            char op = cmd.charAt(0);
            switch(op){
                case 'U':
                    selectUp(Integer.parseInt(cmd.substring(2)));
                    break;
                case 'D':
                    selectDown(Integer.parseInt(cmd.substring(2)));
                    break;
                case 'C':
                    delete();
                    break;
                case 'Z':
                    restore();
                    break;
                default:
                    System.out.println(cmd);
            }
        }
        
        // 결과
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(!arr[i].isDelete){
                sb.append('O');
            }else{
                sb.append('X');
            }
        }
        
        return sb.toString();
    }
    public void selectUp(int digit){
        for(int i = 0; i < digit ; i++){
            now = now.prev;
        }
    }
    
    public void selectDown(int digit){
        for(int i = 0; i < digit ; i++){
            now = now.next;
        }
    }
    
    public void delete(){
        delete.addLast(now);
        now.isDelete = true;
        
        //삭제 노드 기준 왼쪽, 오른쪽을 삭제 노드를 건너뛰고 연결해준다.
        Node prev = now.prev;
        Node next = now.next;
        
        if(prev!=null){
            prev.next=next;
        }
        if(next!=null){
            next.prev=prev;
            now=next;
        }
        else{
            now=prev;
        }
    }
    
    public void restore(){
        Node n = delete.pollLast();
        Node prev = n.prev;
        Node next = n.next;
        
        n.isDelete = false;
        if(prev != null)
            prev.next = n;
        if(next != null)
            next.prev = n;
    }
}