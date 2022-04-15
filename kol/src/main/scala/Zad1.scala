import akka.actor._
import scala.math.sqrt
object Zad1 {
  
  case class InitManager(liczbaPracownikow: Int, liczbaIteracji:Int,kumulatorr:ActorRef)
  case class InitPracownik(koordynatX:Float,koordynatY:Float)
  case class ZapytajCzyWewnatrzOkregu(promien:Int)
  case class Zwroc(takczynie:Boolean)
  case class Popros()
  case class Zlecenie(tekst: List[String])
  case class Wynik(stosunek:Float,liczbaIteracji:Float,czyWypisac:Boolean)
  
  class Manager extends Actor {
    def receive: Receive = {
      case InitManager(liczbaN,liczbaIteracji,kumulatorr) =>
      {
        val listaPracownikow=for (i <- 0 to liczbaN-1) yield context.actorOf(Props[Pracownik],"pracownik_"+i)
        //println(listaPracownikow.toList)//.map(w=>w.path.name).toList
        
          
        context.become(agreguj(listaPracownikow.toList,0,0,kumulatorr,liczbaIteracji,0))
        for (i <- 0 to listaPracownikow.length-1) listaPracownikow(i) ! InitPracownik(util.Random.nextFloat.toFloat,util.Random.nextFloat.toFloat)
        context.self ! Popros()
        
        

      }
    }
    def agreguj(listaPracownikow:List[ActorRef],iloscWkolku:Int,numerpracownika:Int,kumulator:ActorRef,liczbaIteracji:Int,aktualnaiteracja:Int): Receive = {
      case Popros() =>
      {
        for (i <- 0 to listaPracownikow.length-1) listaPracownikow(i) ! ZapytajCzyWewnatrzOkregu(1)
      }
      case Zwroc(takczynie) =>
      {
        //println("takczynie "+takczynie)
        if(takczynie==true)
        {
          context.become(agreguj(listaPracownikow,iloscWkolku+1,numerpracownika+1,kumulator,liczbaIteracji,aktualnaiteracja))
        }
        else
        {
          context.become(agreguj(listaPracownikow,iloscWkolku,numerpracownika+1,kumulator,liczbaIteracji,aktualnaiteracja))
        }
        if(numerpracownika==listaPracownikow.length-1)
        {
          kumulator ! Wynik(iloscWkolku.toFloat/listaPracownikow.length.toFloat*4,liczbaIteracji.toFloat,if(liczbaIteracji==aktualnaiteracja){true}else{false})
          if(aktualnaiteracja<liczbaIteracji)
          {
            context.become(agreguj(listaPracownikow,0,0,kumulator,liczbaIteracji,aktualnaiteracja+1))
          for (i <- 0 to listaPracownikow.length-1) listaPracownikow(i) ! InitPracownik(util.Random.nextFloat.toFloat,util.Random.nextFloat.toFloat)
          context.self ! Popros()
          }
          else
          {
            //println("Koniec")
          }
          
          //kumulator ! Wynik(iloscWkolku.toFloat/listaPracownikow.length.toFloat*4)
        }
      }
    }

  }

  class Pracownik extends Actor {
  def receive: Receive = {
    case InitPracownik(koordynatX,koordynatY)=>
    {
      //println("zinicjowany jestem "+koordynatX+" "+koordynatY)
      context.become(zinicjowany(koordynatX,koordynatY))
    }
  }
  def zinicjowany(koordynatX:Float,koordynatY:Float):Receive={
    case ZapytajCzyWewnatrzOkregu(promien) =>
    {
      if(scala.math.sqrt((koordynatX*koordynatX+koordynatY*koordynatY))<=promien)
      {
        context.parent ! Zwroc(true)
      }
      else
      {
        context.parent ! Zwroc(false)
      }
      context.become(receive)
    } 
  }
  
}

  class KumulatorWyniku extends Actor {
    def receive: Receive = {
      case Wynik(stosunek,liczbaIteracji,czyWypisac)=>
      {
        context.become(agreguj(stosunek))
      }
    }
    def agreguj(suma:Float):Receive={
      case Wynik(stosunek,liczbaIteracji,czyWypisac)=>
      {
        if(czyWypisac==true)
        {
        println("średnia z wyników: "+suma/liczbaIteracji)
        }
        context.become(agreguj(suma+stosunek))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val r = util.Random
    val system = ActorSystem("HaloAkka")
    val kumulator = system.actorOf(Props[KumulatorWyniku], "kumulator")
    val manager = system.actorOf(Props[Manager], "Manager")
      manager ! InitManager(100,100,kumulator)
    // r jest „generatorem”, którego należy użyć do generowania wartości
    // losowych różnych typów (i zakresów) np.
    // r.nextInt (zwraca pseudolosową liczbę całkowitą z zakresu od 0 do 1),
    // r.nextInt(100) (zwraca pseudolosową liczbę całkowitą z zakresu od 0 do 99),
    // r.nextFloat (zwraca pseudolosową liczbę zmiennoprzecinkową z zakresu od 0 do 1).

    // wyliczenie pierwiastka z liczby 4: math.sqrt(4)
  }

}
