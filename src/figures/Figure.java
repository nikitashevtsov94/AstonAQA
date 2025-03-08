package figures;

public class Figure {
    private String borderColor;
    private String innerColor;

    public String getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(String innerColor) {
        this.innerColor = innerColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    protected Figure(String borderColor, String innerColor) {
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }
}
