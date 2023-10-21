package GeometryProblem;

public class Point implements Comparable<Point>{
    
    double x, y;

    public Point(){
        y = 0.0;
        x = 0.0;
    }

    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }

    public int compareTo(Point other) {
        double EPS = 1e-9;
        double tmp;

        if(Math.abs(x - other.x) > EPS){
            tmp = x - other.x;
            if(tmp > EPS) 
                return 1;
            else
                return -1;
        }
        else if(Math.abs(y - other.y) > EPS){
            tmp = y - other.y;
            if(tmp > EPS)
                return 1;
            else   
                return -1;
        }
        else{
            return 0;
        }
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

}
