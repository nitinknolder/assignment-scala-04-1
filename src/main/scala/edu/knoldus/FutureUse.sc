
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
//
//val future1 = Future(3)
//val future2 = Future(5)
//val future3 = Future(6)
//
//
//val result1: Future[Future[Int]] =
//  val value1 = future1 flatMap{ val1 => future2 map (_ * val1)}
//val value2 = value1 flatMap{ val2 => future3 map (_ * val2)}
//val res= Future[Future[value2]]
//res.value
/**************************/
val listOfFuture: List[Future[Int]] = List(Future(2 * 2),Future(20  *  3),Future(2 * 347))
val combinedFuture: Future[List[Int]] = Future.sequence(listOfFuture)
/******************************/
import scala.concurrent.Await
import scala.concurrent.duration._

