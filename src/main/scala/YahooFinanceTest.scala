/**
  * Created by kalit_000 on 19/03/2017.
  */


import scala.concurrent.duration.Duration
import openquant.yahoofinance.{YahooFinance, Quote, Fundamentals}
import akka.actor.ActorSystem
import java.time.ZonedDateTime
import scala.concurrent.Await

object YahooFinanceTest {

  def main(args: Array[String]) {

    implicit val system = ActorSystem()

    val yahooFinance = new YahooFinance()
    val quotes: IndexedSeq[Quote] = Await.result(yahooFinance.quotes("MSFT", Some(ZonedDateTime.now().minusDays(0))), Duration.Inf)
    // Quote(2016-04-01T00:00-04:00[America/New_York],55.049999,55.57,55.610001,54.57,24298600,55.57)
    val fundamentals: IndexedSeq[Fundamentals] = Await.result(yahooFinance.fundamentals("IBM"), Duration.Inf)
    // fundamentals: IndexedSeq[openquant.yahoofinance.Fundamentals] = Vector(Fundamentals(true,IBM,International Business Machines))

    quotes.foreach(println)



  }





}
