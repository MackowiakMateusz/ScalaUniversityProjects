package Lab10
import akka.actor.{ActorSystem, Actor, ActorRef, Props}

object Zad1 {

  case class Wynik(liczba1: Double, liczba2: Double)
  case object Zmien

  class Pracownik extends Actor { 
    def receive: Receive = {
      case Wynik(a,b)=>{
        context.become(sumuj1(a+b));
        println(a+b)
        }
    }
    def sumuj1(suma:Double): Receive = {
      case Wynik(a,b)=>{context.become(sumuj2(suma+a+b));println(suma+a+b)}
    }
    def sumuj2(suma:Double): Receive = {
      case Wynik(a,b)=>{context.become(sumuj1(suma+a+b));println(suma+a+b)}
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sys")
    val pracownik = system.actorOf(Props[Pracownik], "pracownik")
    pracownik ! Wynik(1,1)
    pracownik ! Wynik(1,1)
    pracownik ! Wynik(1,1)
  }

}
