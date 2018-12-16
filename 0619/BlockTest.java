public class BlockTest {
	public static void main(String[] args) {
		int i;
		Block[] blocks = new Block[] { new Block()
				, new NormalBlock(1)
				, new NormalBlock(3) };
		for (i = 0 ; i < 3; i++) {
			for (Block b: blocks) {
				b.hit();
				System.out.print(b.isLive());
				System.out.print(", ");
			}
			System.out.println();
		}
	}
}