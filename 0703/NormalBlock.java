public class NormalBlock extends Block{
    private int hitPoint;

    public NormalBlock(int hP){
        hitPoint = hP;
    }

    @Override
    public boolean isLive(){
        return hitPoint > 0;
    }

    @Override
    public void  hit(){
        if(isLive()){ hitPoint--; }
        return;
    }
}