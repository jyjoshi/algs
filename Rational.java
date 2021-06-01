public class Rational {
    private long numerator;
    private long denominator;

    public static void main(String[] args) {

    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Denominator cannot be zero.");
        }
        long divisor = gcd(numerator, denominator);
        if (divisor != 1) {
            numerator /= divisor;
            denominator /= divisor;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational plus(Rational x) {
        assert (this.numerator * x.denominator + this.denominator * x.numerator) <= Long.MAX_VALUE :
                "Added value too large, so not possible to store in Long.";
        Rational result = new Rational(
                this.numerator * x.denominator + this.denominator * x.numerator,
                this.denominator * x.denominator);
        return result;

    }

    public Rational minus(Rational x) {
        Rational result = new Rational(
                this.numerator * x.denominator - this.denominator * x.numerator,
                this.denominator * x.denominator);
        return result;
    }

    public Rational times(Rational x) {
        assert (this.numerator * x.numerator) <= Long.MAX_VALUE :
                "Value too large to be stored in Long.....Overflow";
        Rational result = new Rational(this.numerator * x.numerator,
                                       this.denominator * x.denominator);
        return result;
    }

    public Rational dividedBy(Rational x) {
        Rational result = new Rational(this.numerator * x.denominator,
                                       this.denominator * x.numerator);
        return result;
    }

    public boolean equals(Rational x) {
        if (this.numerator == x.numerator && this.denominator == x.denominator) return true;
        return false;
    }

    public String toString() {
        return this.numerator + " / " + this.denominator;
    }

    public static long gcd(long p, long q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // public void fractionReducer(Rational x) {
    //     long divisor = gcd(x.numerator, x.denominator);
    //     if (divisor != 1) {
    //         x.numerator /= divisor;
    //         x.denominator /= divisor;
    //     }
    // }


}
