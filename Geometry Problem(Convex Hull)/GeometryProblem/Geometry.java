package GeometryProblem;

import java.util.Arrays;

public class Geometry {

    public static double cross(Point O, Point A, Point B){
        return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
    }

    public static boolean ccw(Point p, Point q, Point r){
        return cross(p, q, r) > 0;
    }

    public static Point[] convexHull(Point[] P){
        if(P.length > 2){
            int n = P.length, upperLength = 0, lowerLength = 0;
            Point[] lowerhull = new Point[n];
            Point[] upperHull = new Point[n];

            Arrays.sort(P);

            lowerhull[0] = P[0];
            lowerhull[1] = P[1];
            lowerLength = 2;
            for(int i = 2; i < n; i++){
                while(lowerLength >= 2 && !ccw(lowerhull[lowerLength - 2], lowerhull[lowerLength - 1], P[i])){
                    lowerLength--;
                }
                lowerhull[lowerLength] = P[i];
                lowerLength++;
            }
            upperHull[0] = P[n-1];
            upperHull[1] = P[n-2];
            upperLength = 2;
            for(int i = n - 3; i >= 0; i--){
                while(upperLength >= 2 && !ccw(upperHull[upperLength - 2], upperHull[upperLength - 1], P[i])){
                    upperLength--;
                }
                upperHull[upperLength] = P[i];
                upperLength++;
            }
            Point[] result = new Point[2 * n];
            int t = 0;
            for(int i = 0; i < lowerLength - 1; i++){
                result[t] = lowerhull[i];
                t++;
            }
            for(int i = 0; i < upperLength - 1; i++){
                result[t] = upperHull[i];
                t++;
            }

            if(t > 1)
                result = Arrays.copyOfRange(result, 0, t);
            return result;
        }
        else if(P.length <= 2)
            return P.clone();
        else  
            return null;
    }

    public static double distance(Point A, Point B){
        return Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
    }

    public static void getConvexHullArea(double X[], double Y[]){
        double area = 0.0; int n = X.length; int i = 0; int j = n - 1;

        while(i != n){
            area += (X[j] + X[i]) * (Y[j] - Y[i]);
            j = i;
            i++; 
        }
      
        double result =  Math.abs(area / 2.0);
        System.out.println("Area of Given Convex Hull is : " + result + "\n");
    }

    public static void getConvexHullLength(Point[] P){
        
        double perimeter = 0; int i = 0; 
        
        while(i != P.length - 1){
            perimeter += distance(P[i], P[i + 1]);
            i++;
        }
      
        perimeter += distance(P[0], P[P.length - 1]);
      
        System.out.println("Perimeter / Length of Given Convex hull is: " + perimeter + "\n");
    }
}
