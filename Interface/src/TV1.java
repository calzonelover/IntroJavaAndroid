// Tricky way to delare class TV

public class TV1 extends Radio implements IBrightness {
    private final float _MIN_BRIGHTNESS = 0.0f;
    private final float _MAX_BRIGHTNESS = 100.0f;

    private float _brightness = _MIN_BRIGHTNESS;

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

