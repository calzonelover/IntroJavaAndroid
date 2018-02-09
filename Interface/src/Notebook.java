public class Notebook implements IVolumn,  IBrightness, INetwork {

    private final int _MIN_VOLUMN = 0;
    private final int _MAX_VOLUMN = 10;

    private final float _MIN_BRIGHTNESS = 0.0f;
    private final float _MAX_BRIGHTNESS = 100.0f;

    private final int _MIN_NETWORK = 0;
    private final int _MAX_NETWORK = 1;

    private int _volumn = _MIN_VOLUMN;
    private float _brightness = _MIN_BRIGHTNESS;
    private int _network = _MAX_NETWORK;

    // Volumn
    public void increaseVolumn(int step){
        if (this._volumn + step <= _MAX_VOLUMN){
            this._volumn += step;
        }
        else {
            this._volumn = _MAX_VOLUMN;
        }
        System.out.printf("Notebook volumn is %d \n", this._volumn);
    }
    public void decreaseVolumn(int step){
        if (this._volumn - step >= _MIN_VOLUMN){
            this._volumn -= step;
        }
        else {
            this._volumn = _MIN_VOLUMN;
        }
        System.out.printf("Notebook volumn is %d \n", this._volumn);
    }
    // Brightness
    public void increaseBrightness(float step){
        if (this._brightness + step <= _MAX_BRIGHTNESS){
            this._brightness += step;
        }
        System.out.printf("Notebook brightness is %.2f \n", this._brightness );
    }
    public void decreaseBrightness(float step){
        if (this._brightness - step >= _MIN_BRIGHTNESS){
            this._brightness -= step;
        }
        System.out.printf("Notebook brightness is %.2f \n", this._brightness );
    }

    // Network
    public void connectNetwork(){
        if (this._network != 1){
            this._network = 1;
            System.out.printf("Notebook network is on \n");
        }
        else{
            System.out.printf("Notebook network is already on \n");
        }
    }
    public void disconnectNetwork(){
        if (this._network != 0){
            this._network = 0;
            System.out.printf("Notebook network is off \n");
        }
        else{
            System.out.printf("Notebook network is already off \n");
        }
    }
}
