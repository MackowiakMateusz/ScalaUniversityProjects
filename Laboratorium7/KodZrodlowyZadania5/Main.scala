import scala.annotation.tailrec

object Main extends App {
//Gra MaterMind polega na odgadnięciu w jakich miejscach zostały umieszczone n ukrytych kul, które są oznaczone powtarzającymi się kolorami. Gracz wygrywa, jeżeli w określonej liczbie ruchów odgadnie w jakich miejscach zostały umieszczone kule. W każdej turze gracz wybiera n kul, po czym zostaje mu wyświetlona informacja czy trafił. Każda prawidłowo odgadnięta kula (kula o właściwym kolorze na właściwym miejscu) sygnalizowana jest czarną kropką. Natomiast jeżeli gracz odgadł kolor kuli, ale nie odgadł jej lokalizacji, jest to sygnalizowane białą kropką. Gracz nie wie, które kule są właściwe, które zaś nie.
//Korzystając z metod oferowanych przez kolekcję zdefiniuj metodę oceniania ruchów dla gry MaterMind, czyli zwraca liczbę białych i czarnych kropek.
//Przykład:
def score(code: Seq[Int])(move: Seq[Int]): (Int, Int)=
{
  //println(code.zipWithIndex.concat(move.zipWithIndex).length-code.zipWithIndex.concat(move.zipWithIndex).distinct.length)
  val biale:Int =code.zipWithIndex.concat(move.zipWithIndex).length-code.zipWithIndex.concat(move.zipWithIndex).distinct.length
  val liczbaWystapien= move.filter(code.contains(_)).distinct.map(w=>(w,code.filter(_==w).length))//liczba wystapien poszczegolnych elementow z move w code

  val czarne:Int=liczbaWystapien.map(w=>w._2).sum-biale
  
  return (biale,czarne)
}
//Przykład:
val code = Seq(1, 3, 2, 2, 4, 5)
val move = Seq(2, 1, 2, 4, 7, 2)
println(score(code)(move))
//Funkcja powinna zwrócić: (1, 3)

}