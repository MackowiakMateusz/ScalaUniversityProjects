import scala.annotation.tailrec

object Main extends App {
  def compress[A](l: List[A]): List[(A, Int)] = {  
    def helper(l: List[A], acc: List[(A, Int)], acc2: Int): List[(A,Int)] = {
            l match {
                case head :: List() => helper(List(),acc :+ (head,acc2), 0)
                
                case head :: tail => {
                if (head == tail(0)) {
                    helper(tail,acc,acc2 + 1)

                }
                else {
                    helper(tail,acc :+ (head,acc2) , 1)
                }
            }
                
        
                case List() => acc
            }
        }

        helper(l,List(), 1)
    }

println(compress(List('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')))
}