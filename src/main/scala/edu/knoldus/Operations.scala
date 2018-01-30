import java.io.File

import org.apache.log4j.Logger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Operations {

  def findFiles (directoryList: String): Future[List[File]] = Future {

    def getAllFiles (directoryList: List[File], fileList: List[File]): List[File] = {

      if (directoryList.isEmpty) {
        fileList
      }

      else {
        val listOfDirectory = directoryList.head.listFiles ().toList

        val listOfFiles = fileList ::: listOfDirectory.filter (_.isFile)

        val listDir = directoryList.tail ::: listOfDirectory.filter (_.isDirectory)
        getAllFiles(listDir,listOfFiles)
      }
    }

    val file = new File (directoryList)
    val directory = List (file)

    getAllFiles(directory, Nil)
  }
}

object Application extends App {

  val log = Logger.getLogger(this.getClass)
  val obj1 = new Operations
  val path = "/home/knoldus/Folder1"
  val result = obj1.findFiles(path)
  for (iteration <- result)
    log.debug(iteration)
  val sleepTimer  = 1000
  Thread.sleep (sleepTimer)
}
