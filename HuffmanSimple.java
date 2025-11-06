import java.util.*;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char c, int f) {
        ch = c;
        freq = f;
    }
    Node(int f, Node l, Node r) {
        freq = f;
        left = l;
        right = r;
    }
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
}
public class HuffmanSimple {

    static void printCodes(Node root, String code) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.println(root.ch + " : " + code);

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text (a-z only): ");
        String s = sc.nextLine();

        int[] freq = new int[26]; // for a–z

        // frequency count
        for (char c : s.toCharArray())
            if (c >= 'a' && c <= 'z')
                freq[c - 'a']++;

        // min heap
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // create nodes only for non-zero freq
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.add(new Node((char) ('a' + i), freq[i]));
        }

        // greedy merging
        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            pq.add(new Node(a.freq + b.freq, a, b));
        }

        System.out.println("\nHuffman Codes:");
        printCodes(pq.peek(), "");
    }
}