package lesson4;


public class Triangle {
    public int  a;
    public int  b;
    public int  c;

    public Triangle(int  a, int  b, int  c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Boolean existTriangle() {
        if ((a + b) > c && (a + c) > b && (b + c) > a) {
            return true;
        } else {
            return false;
        }
    }

    public double squareTriangle() {
        if (existTriangle()) {
            double  p = ( (double) a + (double)b + (double)c) / 2;
            System.out.println(p);
            double result = Math.sqrt(p * (p - (double) a) * (p - (double) b) * (p - (double) c));
            return result;
        }
        else {
            System.out.println("Треугольник с такими сторонами не существует");
            return 0.0;
        }
    }
}
