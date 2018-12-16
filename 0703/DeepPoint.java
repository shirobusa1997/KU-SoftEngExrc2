public class DeepPoint extends Point {
    private int depth;

    public DeepPoint(int x, int y, int d) {
        super(x, y);
        setDepth(depth);
    }

    public void setDepth(int d) {
        if(d > 10) depth = 10;
        else if(d < 1) depth = 1;
        else depth = d;

        return;
    }

    /*
    public int getDepth(){
        return depth;
    }
    */

    @Override
    public void print() {
        int i;
        for (i = 0; i < depth; i++) {
            System.out.print("(");
        }
        System.out.printf("%d, %d", x, y);
        for (i = 0; i < depth; i++) {
            System.out.print(")");
        }
    }
}