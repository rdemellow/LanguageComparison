import Math._
import Array._

object SieveScala {
  def main(args: Array[String]) {
    var max = Integer.parseInt(args(0));

    var primes = tabulate[Boolean](max)((i) => i > 1);

    //Faze out all invalid primes.
    var foundPrimes = max - 2;
    var sqrtMax = Math.ceil(Math.sqrt(max)).toInt;
    for(i <- 0 to sqrtMax-1)
    {
        if(primes(i))
        {
            var mult = i*2;
            while(mult < max)
            {
                if(primes(mult)) {
                    foundPrimes -= 1;
                    primes(mult) = false;
                }
                mult += i;
            }
        }
    }
    println("Num Primes: " + foundPrimes);
  }
}
