import scala.annotation.tailrec

object Main extends App {
//Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
def indices[A](seq: Seq[A], el: A): Set[Int] =
{
  seq.toList.zipWithIndex.filter(_._1==el).map(_._2).toSet
}
println(indices(Seq(1, 2, 1, 1, 5),1))
//która zwróci wszystkie indeksy w ciągu seq, na których znajduje się element el.
//Przykład:
//Dla: seq = Seq(1, 2, 1, 1, 5), el = 1, funkcja powinna zwrócić: Set(0, 2, 3).
//Dla: seq = Seq(1, 2, 1, 1, 5), el = 7, funkcja powinna zwrócić: Set().

}