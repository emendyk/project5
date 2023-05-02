package edu.guilford;

public abstract class Clothes implements Comparable<Clothes> {
    private String color;
    private int size;
    private String type;
    
    public Clothes(String color, int size, String type) {
        this.color = color;
        this.size = size;
        this.type = type;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getType() {
        return type;
    }
    
    // An inherited method that can be overridden by subclasses
    public void wash() {
        System.out.println("Washing " + getType() + " - " + getColor() + " - " + getSize());
    }
    
    // An abstract method that will be implemented by each subclass
    public abstract String wear();
    
    // A method inherited by each subclass
    public int compareTo(Clothes other) {
        if (this.getSize() > other.getSize()) {
            return 1;
        } else if (this.getSize() < other.getSize()) {
            return -1;
        } else {
            return 0;
        }
    }
}

interface Wearable {
    public String getMaterial();
}

class Shirt extends Clothes implements Wearable {
    private String material;
    
    public Shirt(String color, int size, String material) {
        super(color, size, "Shirt");
        this.material = material;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String wear() {
        return "Wearing shirt made of " + getMaterial();
    }
}

class Jacket extends Clothes implements Wearable {
    private String material;
    
    public Jacket(String color, int size, String material) {
        super(color, size, "Jacket");
        this.material = material;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String wear() {
        return "Wearing jacket made of " + getMaterial();
    }
}

class Shorts extends Clothes implements Wearable {
    private String material;
    
    public Shorts(String color, int size, String material) {
        super(color, size, "Shorts");
        this.material = material;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String wear() {
        return "Wearing shorts made of " + getMaterial();
    }
}

class Pants extends Clothes implements Wearable {
    private String material;
    
    public Pants(String color, int size, String material) {
        super(color, size, "Pants");
        this.material = material;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String wear() {
        return "Wearing pants made of " + getMaterial();
    }
}
