import scala.annotation.tailrec

object Main extends App {
def compose[A, B, C](f: A => B)(g: B => C): A => C =
{
  a:A=>g(f(a))
}
def prod[A, B, C, D](f: A => C, g: B => D): (A, B) => (C, D) =
{
  (a:A,b:B)=>(f(a),g(b))
}
def lift[A, B, T](op: (T,T) => T)(f: A => T, g: B => T): (A,B) => T =
{
(a:A,b:B)=>op(f(a),g(b))
}
type MSet[A] = A => Int
val a:MSet[Int] = (n: Int) => n match {
 case 1 => 2
 case 3 => 1
 case _ => 0
}
val b:MSet[Int] = (n: Int) => n match {
 case 1 => 3
 case 2 => 3
 case 3 => 5
 case _ => 0
}
def sum[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
{
(a:A)=> s1(a)+s2(a)
}
def diff[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
{
(a:A)=>s1(a)-s2(a)
}
def mult[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
{
(a:A)=>s1(a)*s2(a)
}
//println(compose[Double,Int,String](_.toInt)(_.toString)(1.0))
//println(prod[Double,Char,Int,String]( _.toInt, _.toString )(2.1,1))
//println(lift[Double,Float,Int](_+_)(_.toInt,_.toInt)(2.1,1))

println(sum(a,b)(compose[Int,String,Int](_.toString)(_.toInt)(1)))
println(diff(a,b)(lift[Double,Float,Int](_+_)(_.toInt,_.toInt)(2.1,1)))
println(mult(a,b)(compose[Int,String,Int](_.toString)(_.toInt)(1)))
}