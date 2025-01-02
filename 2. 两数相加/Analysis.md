# 知识点
刚开始不知道怎么从第一个节点往后处理，就用了递归从后往前。
其实可以定义两个节点，如果为null的话，先初始化，让两个节点都指向这个头节点，然后再对其中一个节点的next进行初始化，再将它指向next。
例：  
head = null;  
cur = null;  
head = ListNode(sum);  
cur = head;  
cur.next = ListNode(sum2);  
cur = cur.next;
