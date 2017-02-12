import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AlgEx {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        int vertexNum = scanner.nextInt();
        int edgeNum = scanner.nextInt();
        int u;
        int v;
        Set<Integer>[] vertexes = new Set[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            vertexes[i] = new HashSet<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            vertexes[u - 1].add(v);
            vertexes[v - 1].add(u);
        }
        print(vertexes, vertexNum);
        scanner.close();
    }

    private static void print(Set<Integer>[] vertexes, int size) throws Exception {
        FileWriter writer = new FileWriter("output.txt");
        Iterator<Integer> iter;
        for (int i = 0; i < size; i++) {
            writer.write(vertexes[i].size() + "");
            if (vertexes[i].size() != 0) {
                writer.write(" ");
            }
            iter = vertexes[i].iterator();
            while (iter.hasNext()) {
                writer.write(iter.next() + "");
                if (iter.hasNext()) {
                    writer.write(" ");
                }
            }
            writer.write("\n");
            writer.flush();
        }
        writer.close();
    }
}
