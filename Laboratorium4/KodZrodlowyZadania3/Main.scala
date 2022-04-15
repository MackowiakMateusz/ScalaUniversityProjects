import scala.annotation.tailrec

object Main extends App {
def usun[A](l1: List[A], el: A): List[A] = {
  @tailrec
  def helper[A](l1: List[A], el: A,listaWynik: List[A]): List[A] = {
    (l1,listaWynik) match{
      case (List(),List())=>return listaWynik.reverse
      case (List(),lwh::lwt)=>return listaWynik.reverse
      case (l1h::l1t,List())=>{
        if(l1h==el)
        {
          return helper(l1t,el,listaWynik)
        }
        else
        {
        return helper(l1t,el,l1h::listaWynik)
        }
      }
      case (l1h::l1t,lwh::lwt)=>{
        if(l1h==el)
        {
          return helper(l1t,el,listaWynik)
        }
        else
        {
          return helper(l1t,el,l1h::listaWynik)
        }
        
      }
    }
  }
  return helper(l1,el,List[A]())
}
println(usun(List(2, 1, 4, 1, 3, 3, 1, 2), 1))
}