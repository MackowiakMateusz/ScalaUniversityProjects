import scala.annotation.tailrec

object Main extends App {
/*
//Korzystając z metody foldLeft/foldRight i zdefiniuj generyczną funkcję:
def deStutter[A](seq: Seq[A]): Seq[A] =
{
  if(seq==Seq())
  {
    return seq
  }
  else
  {
    val newSeq: Seq[A]=Seq(seq.head)
    return seq.foldLeft(newSeq)((newSeq, next) => {
    if (newSeq.last != next)
    {
      newSeq :+ next
    } 
    else newSeq
    })
  }
  
}

println(deStutter[Int](Seq(1, 1, 2, 4, 4, 4, 1, 3)))
//która usunie z sekwencji seq wszystkie powtarzające się ciągi.
//Przykład:
//Dla: seq = Seq(1, 1, 2, 4, 4, 4, 1, 3), funkcja powinna zwrócić: Seq(1, 2, 4, 1, 3).
*/


//Korzystając z metod filter, map i zipWithIndex zdefiniuj funkcję:
def remElems[A](seq: Seq[A], k: Int): Seq[A] =
{
  if(seq==Seq())
  {
    return seq
  }
  if(k>seq.length)//gdyby index byl wiekszy niz dlugosc listy
  {
    return seq
  }
  seq.filter(_!=seq(k))
}
//println(Seq(1, 2, 3, 4, 3, 2, 5, 6).zipWithIndex)
println(remElems[Int](Seq(0, 1, 2, 3, 4, 5, 6, 7),2))
//val cos:Seq[Int]=Seq(2,4,5)
//która usunie k-ty element sekwencji seq.
}