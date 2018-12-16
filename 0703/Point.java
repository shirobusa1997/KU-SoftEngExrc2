/*
// version 1
public class Point {
  public int x, y;
}
 */

// version 2
public class Point {
    // フィールド(メンバ変数）
    public int x;
    public int y;
  
    // メソッド（メンバ関数）
    public void move(int dx, int dy) {
      x += dx;
      y += dy;
    }
  
    public double distance() {
       return Math.sqrt(x * x + y * y);
    }
  
    public void print() {
      System.out.printf("(%d, %d)", x, y);
    }
  
    public void moveAndPrint(int dx, int dy) {
      print(); move(dx, dy); print();
    }
  
    // コンストラクタ
    public Point(int x0, int y0) {
      x = x0; y = y0;
    }
  }