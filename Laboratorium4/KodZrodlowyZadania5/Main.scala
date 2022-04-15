import scala.annotation.tailrec

object Main extends App {
type Pred[A] = A => Boolean
def and[A](p: Pred[A], q: Pred[A]): Pred[A]=
{
  a:A=>p(a)&&q(a)
}
def or[A](p: Pred[A], q: Pred[A]): Pred[A]=
{
  a:A=>p(a)||q(a)
}

def not[A](p: Pred[A]): Pred[A]=
{
  a:A=>(!p(a))
}
def imp[A](p: Pred[A], q: Pred[A]): Pred[A]=
{
  a:A=>(!(p(a)&&(!(q(a)))))
}
val f1=(a:Double)=>a>2
println(and[Double]((_>2),(_<3))(2))
println(or[Double]((_>2),(_<3))(2))
println(not[Double]((_>2))(2))
println(imp[Double]((_>2),(_<3))(2.5))
//imp[Double]((_>2),(_<3))(2.5)
}