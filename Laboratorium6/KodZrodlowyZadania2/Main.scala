import scala.annotation.tailrec

object Main extends App {

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
}