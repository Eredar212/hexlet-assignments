package exercise;

// BEGIN
public interface Home {
    double getArea();
    default  int compareTo(Home home) {
        return Double.compare(getArea(), home.getArea());
    };
}
// END
