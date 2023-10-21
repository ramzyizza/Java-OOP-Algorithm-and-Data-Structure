package DisjointSet;

public class Main {
    public static void main(String[] args){
        
        DisjointSet ds = new DisjointSet(5);
        System.out.println("Make Set (unmodified set) : ");
        ds.printParent();
        System.out.println();
        ds.printRank();
        ds.totalSet();
        ds.totalElement();

        ds.unionByRank(3, 4);
        System.out.println("\n\nAfter Union 3 and 4: ");
        ds.printParent();
        System.out.println();
        ds.printRank();
        ds.totalSet();
        ds.totalElement();
    }
}
