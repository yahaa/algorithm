public class NK11{

    public double power(double x, int n) {
        long t = n;
        double a = x;
        double result = 1;
        boolean f = (t > 0) ? true : false;
        t = Math.abs(t);
        if (x == 1.0)return 1;
        if (x == -1 && t % 2 == 0)return 1;
        if (x == -1 && t % 2 == 1)return -1;
        if (t >= 63 && !f) return 0;
        while (t > 0) {
            if ((t & 1) > 0) {
                result *= a;
            }
            a *= a;
            t >>= 1;
        }
        if (f) {
            return result;
        } else {
            return 1 / result;
        }
    }

}
