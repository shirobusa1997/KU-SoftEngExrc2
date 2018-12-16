public class BlockTest2 {
    public static void main(String[] args) {
       int i;
       NormalBlock b = new NormalBlock(1);
       for (i = 0 ; i < 3; i++) {
          b.hit();
      b.hitPoint += 10 ;   // この行
         System.out.print(b.isLive());
          System.out.println();
       }
    }
 }