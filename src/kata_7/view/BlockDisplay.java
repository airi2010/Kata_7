package kata_7.view;


public interface BlockDisplay {
    
    public void paintBlock(int x, int y);
    void on(Moved moved);
    public interface Moved{
        void to (int x, int y);
    }
}
