package lab11

import akka.actor.{ActorSystem, Actor, ActorRef, Props}

case class Init(liczbaPracownikow: Int)
case class Wykonaj(napis:List[String])
case class Zlecenie(tekst: List[String])
case class Wynik(liczbaSlowZnapisu:Int)

class Pracownik extends Actor {
  def receive: Receive = {
    case Wykonaj(napis) =>
    {
      context.parent ! Wynik(napis.map(w=>w.split(" ").toList.map(w=>w.filter(x=>x.isLetter==true)).filter(w=>w.isEmpty==false).length).sum)
      //println(napis.map(w=>w.split(" ").toList.map(w=>w.filter(x=>x.isLetter==true)).filter(w=>w.isEmpty==false).length).sum)
    } 
  }
}

class Nadzorca extends Actor {
  def receive: Receive = 
  {
    case Init(liczbaPracownikow) =>
    {
      val listaPracownikow=for (i <- 0 to liczbaPracownikow-1) yield context.actorOf(Props[Pracownik],"pracownik_"+i)
      //println(listaPracownikow.toList)//.map(w=>w.path.name).toList
      context.become(przyjmujZlecenia1(listaPracownikow.toList,0,0))
    }
  }
  def przyjmujZlecenia1(listaPracownikow:List[ActorRef],licznikSlow:Int,numerOstatniegoPracownika:Int): Receive =
  {
    case Zlecenie(tekst)=>
    {
      if(listaPracownikow.length<=tekst.length)
      {
        for (i <- 0 to tekst.grouped(tekst.length/listaPracownikow.length+1).toList.length-1) listaPracownikow(i) ! Wykonaj(tekst.grouped(tekst.length/listaPracownikow.length+1).toList(i))//(tekst.length.toDouble/listaPracownikow.length.toDouble).round.toInt+1
        
      }
      else
      {
        for (i <- 0 to tekst.length-1) listaPracownikow(i) ! Wykonaj(tekst.grouped(1).toList(i))
      }
      //println(licznikSlow)
    }
    case Wynik(liczbaSlowZnapisu)=>
    {
      if(numerOstatniegoPracownika!=listaPracownikow.length-1)
      {
        context.become(przyjmujZlecenia2(listaPracownikow,licznikSlow+liczbaSlowZnapisu,numerOstatniegoPracownika+1))
      }
      else
      {
        println(licznikSlow+liczbaSlowZnapisu)
        context.become(przyjmujZlecenia2(listaPracownikow,0,listaPracownikow.length-1))
      }
      
    }
  }
  def przyjmujZlecenia2(listaPracownikow:List[ActorRef],licznikSlow:Int,numerOstatniegoPracownika:Int): Receive =
  {
    case Wynik(liczbaSlowZnapisu)=>
    {
      if(numerOstatniegoPracownika!=listaPracownikow.length-1)
      {
        context.become(przyjmujZlecenia2(listaPracownikow,licznikSlow+liczbaSlowZnapisu,numerOstatniegoPracownika+1))
      }
      else
      {
        println(licznikSlow+liczbaSlowZnapisu)
        context.become(przyjmujZlecenia1(listaPracownikow,0,0))
      }
    }
  }
}

object Main {

  def dane(): List[String] = {
    scala.io.Source.fromResource("ogniem_i_mieczem.txt").getLines().toList
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HaloAkka")
      val nadzorca = system.actorOf(Props[Nadzorca], "Nadzorca")
      nadzorca ! Init(200)
      nadzorca ! Zlecenie(dane())
      //println("dane legnth")
      //println(dane().length)
      //println(dane().grouped(dane().length/3).toList)//dzieli na 3 listy po 1/3 elementow poczatkowego tekstu
      //println(dane().splitAt(dane().length/3)._1.length)//bierze ok 1/3 linijek w pierwszej liscie, a w drugiej 2/3
      //nadzorca ! Zlecenie(dane())
      //println(dane()(0).split(" ").toList.map(w=>w.filter(x=>x.isLetter==true)).filter(w=>w.isEmpty==false).length)
    //val danee=dane()
    //println(danee(1))
  }

}
