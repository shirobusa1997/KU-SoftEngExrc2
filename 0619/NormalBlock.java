public class NormalBlock extends Block{
    //クラスフィールド宣言
    public int hitPoint;

    public NormalBlock(int hP){
        hitPoint = hP;
    }

    @Override
    public boolean isLive(){
        if (hitPoint > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void  hit(){
        if(isLive()){ hitPoint--; }
        return;
    }
}