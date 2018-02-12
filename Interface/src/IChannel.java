public interface IChannel {
    public void previousChannel();
    public void nextChannel();
    public void selectChannel(float channel);
//    public void incress(); // Tips : if we has incress() in other interface, it will choose first interface that class implemented
}
