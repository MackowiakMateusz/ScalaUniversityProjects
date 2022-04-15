import scala.annotation.tailrec

object Main extends App {
  def freq[A](seq: Seq[A]): Set[(A, Int)] = 
  {
        seq.groupBy(e => e).map(e => (e._1, e._2.length)).toSet
  }
  
  println(freq(Seq('a','b','a','c','c','a')))
}