public class TV implements IVolumn, IChannel, IBrightness{

    private final int _MIN_VOLUMN = 0;
    private final int _MAX_VOLUMN = 10;

    private final float _MIN_CHANNEL = 88.0f;
    private final float _MAX_CHANNEL =  180.0f;

    private final float _MIN_BRIGHTNESS = 0.0f;
    private final float _MAX_BRIGHTNESS = 100.0f;

    private int _volumn = _MIN_VOLUMN;
    private float _channel = _MIN_CHANNEL;
    private float _brightness = _MIN_BRIGHTNESS;

    // Volumn
    public void increaseVolumn(int step){
        if (this._volumn + step <= _MAX_VOLUMN){
            this._volumn += step;
        }
        else {
            this._volumn = _MAX_VOLUMN;
        }
        System.out.printf("TV volumn is %d \n", this._volumn);
    }
    public void decreaseVolumn(int step){
        if (this._volumn - step >= _MIN_VOLUMN){
            this._volumn -= step;
        }
        else {
            this._volumn = _MIN_VOLUMN;
        }
        System.out.printf("TV volumn is %d \n", this._volumn);
    }
    // Channel
    public void selectChannel(float channel){
        if (channel >= _MIN_CHANNEL & channel <= _MAX_CHANNEL){
            this._channel = channel;
        }
        System.out.printf("TV volumn is %d \n", this._volumn);
    }
    public void previousChannel(){
        if (this._volumn < _MAX_CHANNEL){
            this._channel -= 0.25f;
        }
        System.out.printf("TV channel is %.2f \n", this._channel);
    }
    public void nextChannel(){
        if (this._volumn > _MIN_CHANNEL){
            this._channel += 0.25f;
        }
        System.out.printf("TV channel is %.2f \n", this._channel);
    }

    // Brightness
    public void increaseBrightness(float step){
        if (this._brightness + step <= _MAX_BRIGHTNESS){
            this._brightness += step;
        }
        System.out.printf("TV brightness is %.2f \n", this._brightness );
    }
    public void decreaseBrightness(float step){
        if (this._brightness - step >= _MIN_BRIGHTNESS){
            this._brightness -= step;
        }
        System.out.printf("TV brightness is %.2f \n", this._brightness );
    }
}
