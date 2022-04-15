import scala.annotation.tailrec

object Main extends App {
val strefy: Seq[String] = java.util.TimeZone.getAvailableIDs.toSeq
//println(strefy)
val strefyWEuropie: Seq[String] = 
strefy.filter(_.split("/")(0)=="Europe").map(_.split("/")(1)).sorted.sortWith(_.length < _.length)
println(strefyWEuropie);
//strefy w Europie to wyszukane strefy znajdujące się w Europie, posortowane rosnąco według długości ich nazw.
//Strefy, których nazwy mają taką samą długość są posortowane w kolejności alfabetycznej. 
}