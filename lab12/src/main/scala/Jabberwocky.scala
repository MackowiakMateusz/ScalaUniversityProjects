import akka.actor.{ActorSystem, Actor, Props}
import scala.concurrent.duration._
/*
  W konfiguracji projektu wykorzystana została wtyczka
  sbt-revolver. W związku z tym uruchamiamy program poleceniem

    reStart

  a zatrzymujemy pisząc (mimo przesuwających się komunikatów)

     reStop

  i naciskając klawisz ENTER. Jeśli czynności powyższe
  już wykonywaliśmy to możemy też przywołać poprzednie
  polecenia używając strzałek góra/dół na klawiaturze.
*/

// Przykład wykorzystania Planisty (Scheduler)
object Jabberwocky {

  object TickActor {
    val Tick = "tick"
  }
  class TickActor extends Actor {
    import TickActor._
    def receive = {
      case Tick => println("Tick")
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("system")
    import system.dispatcher

    val tickActor = system.actorOf(Props[TickActor](), "defender")

    val ticker = system.scheduler.scheduleWithFixedDelay(
      Duration.Zero,
      50.milliseconds,
      tickActor,
      TickActor.Tick
    )

    // system.terminate()

  }
}
