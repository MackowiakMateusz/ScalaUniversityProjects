import scala.annotation.tailrec

object Main extends App {
//Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
def swap[A](seq: Seq[A]): Seq[A] =
{
    if(seq==Seq())
    {
        return Seq()
    }
    seq.grouped(2).toList.map(_.reverse).flatten.toSeq
}
println(swap(Seq(1, 2, 3, 4, 5)))
//która zamieni kolejnością wartości znajdujących się na parzystych i nieparzystych indeksach.
//Przykład:
//Dla: seq = Seq(1, 2, 3, 4, 5), Seq(2, 1, 4, 3, 5).

}