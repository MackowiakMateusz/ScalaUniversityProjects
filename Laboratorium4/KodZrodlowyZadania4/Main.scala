import scala.annotation.tailrec

object Main extends App {
def divide[A](l: List[A]): (List[A], List[A]) = {
  @tailrec
  def helper[A](l1: List[A],listaWynik1: List[A],listaWynik2: List[A],jedenCzyDwa:Boolean): (List[A], List[A]) = {//jedenCzyDwa->true daje element do listywynik1, false do listywynik2
    (l1,listaWynik1,listaWynik2) match{
      case (List(),_,_)=>return (listaWynik1.reverse, listaWynik2.reverse)
      case (l1h::l1t,_,_)=>{
        if(jedenCzyDwa==true)
        {
          return helper(l1t,l1h::listaWynik1,listaWynik2,false)
        }
        else
        {
          return helper(l1t,listaWynik1,l1h::listaWynik2,true)
        }
      }
    }
  }
  return helper(l,List[A](),List[A](),true)
}
println(divide(List(1, 3, 5, 6, 7)))
}