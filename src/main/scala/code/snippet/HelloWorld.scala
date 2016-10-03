package code 
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import java.util.zip.{ZipInputStream, ZipEntry}
import sys.process._
import java.net.URL
import java.io.File
import code.lib._
import Helpers._


class HelloWorld {

  val url = new URL("https://snap.stanford.edu/data/web-Stanford.txt.gz") #> new File("dataSet.txt.gz") !!

  val iterator = GzFileIterator(new java.io.File("dataSet.txt.gz"), "UTF-8")
  val nodesArray : Array[String] = iterator.drop(3).toArray

  println(nodesArray)

  //original code
  // lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  //def howdy = "#time *" #> date.map(_.toString)

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */

}

