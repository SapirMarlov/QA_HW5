package Selleniun_start_projects.Selleniun_start_projects;

public class TriangleUtils {

  
    public static boolean isIsosceles(int a, int b, int c) {
        // Check if the sides satisfy the triangle inequality
        if (a + b > c && b + c > a && a + c > b) {
            // Check if at least two sides are equal
            return a == b || b == c || a == c;
        }
        // Not a valid triangle
        return false;
    }
}
