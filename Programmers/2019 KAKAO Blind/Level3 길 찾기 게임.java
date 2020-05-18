import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class Solution {
    class BinaryTreeNode implements Comparable<BinaryTreeNode>
    {
        int x, y, order;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int parentX = -1;
        int xHigh = Integer.MAX_VALUE;
        int xLow = Integer.MIN_VALUE;
        public boolean isLeftChild;
        public boolean isRightChild;
        public BinaryTreeNode(int x, int y, int order)
        {
            this.x = x;
            this.y = y;
            this.order = order;
        }
        @Override
        public int compareTo(BinaryTreeNode o)
        {
            if(o.y > this.y) return 1;
            else if(o.y < this.y) return -1;
            else
            {
                if(this.x > o.x) return 1;
                else if(this.x < o.x) return -1;
                else return 0;
            }
        }
    }
    
    PriorityQueue<BinaryTreeNode> pQueue;
    List<Integer> preOrderList;
    List<Integer> postOrderList;
    
    public int[][] solution(int[][] nodeinfo) {
        pQueue = new PriorityQueue<>();
        for(int i=0; i<nodeinfo.length; i++)
        {
            pQueue.add(new BinaryTreeNode(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        BinaryTreeNode root = pQueue.poll();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            BinaryTreeNode parent = queue.poll();

            if(parent.isLeftChild)
            {
                if(pQueue.isEmpty()) break;
                if(pQueue.peek().x < parent.x && pQueue.peek().x > parent.xLow)
                {
                    parent.leftChild = pQueue.poll();
                    parent.leftChild.xHigh = parent.x;
                    parent.leftChild.xLow = parent.xLow;
                    parent.leftChild.isLeftChild = true;
                    queue.offer(parent.leftChild);
                }
                if(pQueue.isEmpty()) break;
                if(pQueue.peek().x > parent.x && pQueue.peek().x < parent.xHigh)
                {
                    parent.rightChild = pQueue.poll();
                    parent.rightChild.xHigh = parent.xHigh;
                    parent.rightChild.xLow = parent.x;
                    parent.rightChild.isRightChild = true;
                    queue.offer(parent.rightChild);
                }
                continue;
            }
            if(parent.isRightChild)
            {
                if(pQueue.isEmpty()) break;
                if(pQueue.peek().x < parent.x && pQueue.peek().x > parent.xLow)
                {
                    parent.leftChild = pQueue.poll();
                    parent.leftChild.xHigh = parent.x;
                    parent.leftChild.xLow = parent.xLow;
                    parent.leftChild.isLeftChild = true;
                    queue.offer(parent.leftChild);
                }
                if(pQueue.isEmpty()) break;
                if(pQueue.peek().x > parent.x && pQueue.peek().x < parent.xHigh)
                {
                    parent.rightChild = pQueue.poll();
                    parent.rightChild.xLow = parent.x;
                    parent.rightChild.xHigh = parent.xHigh;
                    parent.rightChild.isRightChild = true;
                    queue.offer(parent.rightChild);
                }
                continue;
            }
            if(pQueue.isEmpty()) break;
            if(pQueue.peek().x < parent.x)
            {
                parent.leftChild = pQueue.poll();
                parent.leftChild.xHigh = parent.x;
                parent.leftChild.isLeftChild = true;
                queue.offer(parent.leftChild);
            }
            if(pQueue.isEmpty()) break;
            if(pQueue.peek().x > parent.x)
            {
                parent.rightChild = pQueue.poll();
                parent.rightChild.xLow = parent.x;
                parent.rightChild.isRightChild = true;
                queue.offer(parent.rightChild);
            }
        }
        preOrderList = new LinkedList<>();
        postOrderList = new LinkedList<>();
        preOrder(root);
        postOrder(root);
        int[][] result = new int[2][nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++)
        {
            result[0][i] = preOrderList.get(i);
            result[1][i] = postOrderList.get(i);
        }
        return result;
    }
    
    public void preOrder(BinaryTreeNode root)
    {
        preOrderList.add(root.order);
        if(root.leftChild != null) preOrder(root.leftChild);
        if(root.rightChild != null) preOrder(root.rightChild);
    }
    
    public void postOrder(BinaryTreeNode root)
    {
        if(root.leftChild != null) postOrder(root.leftChild);
        if(root.rightChild != null) postOrder(root.rightChild);
        postOrderList.add(root.order);
    }
}