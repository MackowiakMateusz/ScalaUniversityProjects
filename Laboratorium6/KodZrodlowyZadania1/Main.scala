import scala.annotation.tailrec

object Main extends App {
//Korzystając z metod drop i take zdefiniuj funkcję:
def subSeq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] =
{
  seq.drop(begIdx).take((endIdx-begIdx))
}
//która zwraca podciąg ciągów sekwencji seq z przedziału od indeksu begIdx do endIdx.
println(subSeq(Seq('a','b','a','c','c','a'),1,5))
}